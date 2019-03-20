package com.easternts.flowerworld.util;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.easternts.flowerworld.MainActivity;

/**
 * Created by Ranjit_Lepi on 18-Jul-16.
 */
public class MyExceptionHandler implements Thread.UncaughtExceptionHandler {
    private Context context;
    private Crashlytics mCrashlytics;

    public MyExceptionHandler(Context context, Crashlytics crashlytics) {
        this.context = context;
        this.mCrashlytics = crashlytics;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        Crashlytics.logException(ex);
        Log.e("uncaughtException", "" + ex);
        finishApplication();
    }


    public void finishApplication() {
//        finish();
//        System.exit(0);
        Intent mStartActivity = new Intent(context, MainActivity.class);
        int mPendingIntentId = 123456;
        PendingIntent mPendingIntent = PendingIntent.getActivity(context, mPendingIntentId,mStartActivity, PendingIntent.FLAG_ONE_SHOT);
        AlarmManager mgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
        System.exit(0);
//         Intent mStartActivity = new Intent(context, MainActivity.class);
//        context.startActivity(mStartActivity);
    }
}