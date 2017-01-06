package com.techno.matrimonial;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.techno.matrimonial.Global.Global;

/**
 * Created by arbaz on 2/7/16.
 */
public class MatrimonialApplication extends Application {
    Global global;

    public static SharedPreferences sharedPref;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
    }
}
