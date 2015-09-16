/**
 * Copyright 2015 Google Inc. All Rights Reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ttnd.pubnubdemo.service;

import android.util.Log;

import com.google.android.gms.iid.InstanceIDListenerService;
import com.ttnd.pubnubdemo.activity.MainActivity;
import com.ttnd.pubnubdemo.async.GetGCMToken;

public class MyInstanceIDListenerService extends InstanceIDListenerService {

    private static final String TAG = "MyInstanceIDLS";

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. This call is initiated by the
     * InstanceID provider.
     */
    // [START refresh_token]
    @Override
    public void onTokenRefresh() {
        // Fetch updated Instance ID token and notify our app's server of any changes (if applicable).
        //Intent intent = new Intent(this, RegistrationIntentService.class);
        //startService(intent);
        MainActivity.GCMRegistrationCallback gcmRegistrationCallback = new MainActivity.GCMRegistrationCallback() {
            @Override
            public void gcmIdReceived() {
                Log.i("instance  refreshed", "instance  refreshed");
            }
        };
        new GetGCMToken(this, gcmRegistrationCallback).execute();
    }
    // [END refresh_token]
}
