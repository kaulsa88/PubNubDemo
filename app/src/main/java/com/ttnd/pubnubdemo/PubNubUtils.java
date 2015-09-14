package com.ttnd.pubnubdemo;

import android.content.Context;
import android.util.Log;

import com.pubnub.api.Callback;
import com.pubnub.api.Pubnub;
import com.pubnub.api.PubnubError;

/**
 * Created by Salil Kaul on 14/9/15.
 */
public class PubNubUtils {
    private static Pubnub pubnub;

    public static Pubnub getPubnub(Context context) {
        String publish_key = context.getString(R.string.publish_key);
        String subscribe_key = context.getString(R.string.subscribe_key);
        pubnub = new Pubnub(publish_key, subscribe_key);
        return pubnub;

    }


    public static void associateChannel(String channelName, String token) {
        pubnub.enablePushNotificationsOnChannel(channelName, token, new Callback() {
            @Override
            public void successCallback(String channel, Object message, String timetoken) {
                super.successCallback(channel, message, timetoken);
                Log.i("successCallback", "successCallback");
            }


            @Override
            public void errorCallback(String channel, PubnubError error) {
                super.errorCallback(channel, error);
                Log.i("errorCallback", "errorCallback" + error.getErrorString());
            }
        });
    }
}


