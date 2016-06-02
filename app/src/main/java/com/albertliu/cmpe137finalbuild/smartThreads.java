package com.albertliu.cmpe137finalbuild;

import com.firebase.client.Firebase;

/**
 * Created by Albert on 5/18/2016.
 */
public class smartThreads extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
