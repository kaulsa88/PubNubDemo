package com.ttnd.pubnubdemo.service;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by Salil Kaul on 11/9/15.
 */
public class PushWooshIntentService extends IntentService {

    public PushWooshIntentService() {
        super("PushWooshIntentService ");
    }

    @Override
    protected void onHandleIntent(Intent intentParameter) {
        Log.i("PushWooshIntentService", "Inside PushWooshIntentService");
//        final Bitmap bitmapLargeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
//        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        Bundle bundle = intentParameter.getExtras();
//        if (bundle != null) {
//            Log.i("Bundle value", "bundle value" + bundle.toString());
//        }
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.putExtras(bundle);
//        //intent.putExtra(AppConstants.EXTRA_FROM, AppConstants.FROM_NOTIFICATION);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
//        NotificationCompat.Builder mBuilder =
//                new NotificationCompat.Builder(this)
//                        .setSmallIcon(R.drawable.notification_icon)
//                        .setLargeIcon(bitmapLargeIcon)
//                        .setContentTitle(getString(R.string.app_name))
//                        .setStyle(new NotificationCompat.BigTextStyle().bigText("Hello"))
//                        .setDefaults(Notification.DEFAULT_ALL)
//                        .setAutoCancel(true)
//                        .setContentText("Hello");
//        mBuilder.setContentIntent(contentIntent);
//        int notificationId = SharedPreference.getInt(this, "id");
//        mNotificationManager.notify(1, mBuilder.build());
//        SharedPreference.setInt(this, "id", notificationId + 1);
//        PushWooshWakeFullReceiver.completeWakefulIntent(intent);
    }
}
