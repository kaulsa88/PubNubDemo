package com.ttnd.pubnubdemo.async;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.android.gms.gcm.GcmPubSub;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.ttnd.pubnubdemo.R;
import com.ttnd.pubnubdemo.activity.MainActivity;
import com.ttnd.pubnubdemo.preference.QuickstartPreferences;
import com.ttnd.pubnubdemo.utils.PubNubUtils;

import java.io.IOException;

/**
 * Created by Salil Kaul on 16/9/15.
 */
public class GetGCMToken extends AsyncTask<Void, Void, String> {
    MainActivity.GCMRegistrationCallback gcmRegistrationCallback;
    Context context;
    private static final String TAG = "GetGCMToken";
    private final String[] TOPICS = {"global"};

    public GetGCMToken(Context context, MainActivity.GCMRegistrationCallback gcmRegistrationCallback1) {
        this.context = context;
        this.gcmRegistrationCallback = gcmRegistrationCallback1;

    }


    @Override
    protected String doInBackground(Void... params) {
        String registerationToken = "";
        if (context != null) {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            try {
                InstanceID instanceID = InstanceID.getInstance(context);
                registerationToken = instanceID.getToken(context.getString(R.string.gcm_defaultSenderId),
                        GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
                Log.i(TAG, "GCM Registration Token: " + registerationToken);
                sharedPreferences.edit().putBoolean(QuickstartPreferences.SENT_TOKEN_TO_SERVER, true).apply();
            } catch (Exception ex) {
                sharedPreferences.edit().putBoolean(QuickstartPreferences.SENT_TOKEN_TO_SERVER, false).apply();
                Log.i(TAG, "complete token refresh", ex);

            }

        }
        return registerationToken;
    }

    @Override
    protected void onPostExecute(String token) {
        if (gcmRegistrationCallback != null) {
            gcmRegistrationCallback.gcmIdReceived();
        }
        if (token != null && !token.equals("")) {
            PubNubUtils.associateChannel(context, "test_channel", token);
        } else {
            Log.i(TAG, "Illegal value received as token");
        }
        try {
            subscribeTopics(token);
        } catch (Exception ex) {
            Log.i(TAG, "Issue in subscribint to topic");
        }

    }


    private void subscribeTopics(String token) throws IOException {
        GcmPubSub pubSub = GcmPubSub.getInstance(context);
        for (String topic : TOPICS) {
            pubSub.subscribe(token, "/topics/" + topic, null);
        }
    }

}
