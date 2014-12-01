package com.dillavouws.motoxearpiece;

/**
 * Created by Anthony on 11/21/2014.
 */


import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;


public class BootCompletedReceiver extends BroadcastReceiver {

    final static String TAG = "BootCompletedReceiver";

    public void onReceive(Context context, Intent arg1) {
        Intent serviceIntent = new Intent(context, SpeakerFix.class);
        context.startService(serviceIntent);
    }
}
