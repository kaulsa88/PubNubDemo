package com.ttnd.pubnubdemo.utils;

import android.content.Context;
import android.util.Log;

import com.pubnub.api.Callback;
import com.pubnub.api.Pubnub;
import com.pubnub.api.PubnubError;
import com.ttnd.pubnubdemo.R;

/**
 * Created by Salil Kaul on 14/9/15.
 */
public class PubNubUtils {
    private static Pubnub pubnub;

    public static Pubnub getPubnub(Context context) {

        if (pubnub == null) {
            String publish_key = context.getString(R.string.publish_key);
            String subscribe_key = context.getString(R.string.subscribe_key);
            pubnub = new Pubnub(publish_key, subscribe_key);
            Callback callback = new Callback() {
                public void successCallback(String channel, Object response) {
                    Log.i("Time Success<<<<<<<<<<>>>>>>>>>>>", response.toString());
                }

                public void errorCallback(String channel, PubnubError error) {
                    Log.i("Time Error<<<<<<<<<<>>>>>>>>>>>", "" + error.toString());
                }
            };
            pubnub.time(callback);
        }
        return pubnub;

    }


    public static void associateChannel(Context context, String channelName, String token) {
        getPubnub(context).enablePushNotificationsOnChannel(channelName, token, new Callback() {
            @Override
            public void successCallback(String channel, Object message) {
                super.successCallback(channel, message);
                Log.i("successCallback><<<<<<<<<<<<<<<", "successCallback><<<<<<<<<<<<<<<");
                Log.i("gcmAddChannel", "successCallback " + channel + " : " + message);
            }

            @Override
            public void connectCallback(String channel, Object message) {
                super.connectCallback(channel, message);
                Log.i("connectCallback><<<<<<<<<<<<<<<", "connectCallback><<<<<<<<<<<<<<<");
                Log.i("gcmAddChannel", "connectCallback" + channel + " : " + message);
            }

            @Override
            public void reconnectCallback(String channel, Object message) {
                super.reconnectCallback(channel, message);
                Log.i("reconnectCallback><<<<<<<<<<<<<<<", "reconnectCallback><<<<<<<<<<<<<<<");
                Log.i("gcmAddChannel", "reconnectCallback" + channel + " : " + message);
            }

            @Override
            public void disconnectCallback(String channel, Object message) {
                super.disconnectCallback(channel, message);
                Log.i("disconnectCallback><<<<<<<<<<<<<<<", "disconnectCallback><<<<<<<<<<<<<<<");
                Log.i("gcmAddChannel", "disconnectCallback" + channel + " : " + message);
            }

            @Override
            public void errorCallback(String channel, PubnubError error) {
                super.errorCallback(channel, error);
                Log.i("errorCallback><<<<<<<<<<<<<<<", "errorCallback><<<<<<<<<<<<<<<");
                Log.i("gcmAddChannel", "errorCallback" + channel + " : " + error);
            }
        });


    }
}


