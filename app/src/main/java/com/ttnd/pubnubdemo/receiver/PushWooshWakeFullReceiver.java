package com.ttnd.pubnubdemo.receiver;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import com.ttnd.pubnubdemo.gcm.MyGcmListenerService;

public class PushWooshWakeFullReceiver extends WakefulBroadcastReceiver {
    public PushWooshWakeFullReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.i("Getting called", "Getting called to do launch Intent Service which will build notification");
        ComponentName comp = new ComponentName(context.getPackageName(),
                MyGcmListenerService.class.getName());
        // Start the service, keeping the device awake while it is launching.
        startWakefulService(context, (intent.setComponent(comp)));
        setResultCode(Activity.RESULT_OK);
    }
}
