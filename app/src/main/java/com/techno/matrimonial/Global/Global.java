package com.techno.matrimonial.Global;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.techno.matrimonial.MatrimonialApplication;
import com.techno.matrimonial.Model.LoginDetails;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by arbaz on 19/7/16.
 */
public class Global {
    private final Context context;

    public Global(Context context) {
        this.context = context;

    }
   ;

    /* For storePreference*/
    public static void storePreference(HashMap<String, String> parameters) {
        SharedPreferences.Editor editor = MatrimonialApplication.sharedPref.edit();
        Iterator<Map.Entry<String, String>> it = parameters.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pairs = it.next();
            editor.putString((String) pairs.getKey(), (String) pairs.getValue());
        }
        editor.commit();
    }

    public static void storePreference(String key, String value) {
        SharedPreferences.Editor editor = MatrimonialApplication.sharedPref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void storePreference(String key, int value) {
        SharedPreferences.Editor editor = MatrimonialApplication.sharedPref.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static void storePreference(String key, long value) {
        SharedPreferences.Editor editor = MatrimonialApplication.sharedPref.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public static boolean storePreference(String key, Boolean value) {
        SharedPreferences.Editor editor = MatrimonialApplication.sharedPref.edit();
        editor.putBoolean(key, value);
        editor.commit();
        return false;
    }



/*
*
* Editor prefsEditor = mPrefs.edit();
Gson gson = new Gson();
String json = gson.toJson(myObject); // myObject - instance of MyObject
prefsEditor.putString("MyObject", json);
prefsEditor.commit();
*
* */

    /*For getPreference*/
    public static HashMap<String, String> getPreference(String[] keys) {
        HashMap<String, String> parameters = new HashMap<String, String>();
        for (String key : keys) {
            parameters.put(key, MatrimonialApplication.sharedPref.getString(key, null));
        }
        return parameters;
    }


    public static String getPreference(String key, String defValue) {
        return MatrimonialApplication.sharedPref.getString(key, defValue);
    }

    public static long getPreference(String key, long defValue) {
        return MatrimonialApplication.sharedPref.getLong(key, defValue);
    }

    public static int getPreference(String key, int defValue) {
        return MatrimonialApplication.sharedPref.getInt(key, defValue);
    }

    public static Boolean getPreference(String key, Boolean defValue) {
        return MatrimonialApplication.sharedPref.getBoolean(key, defValue);
    }

    public static void clearPrefernces() {
        SharedPreferences.Editor editor = MatrimonialApplication.
                sharedPref.edit();
        editor.clear();
        editor.commit();
    }


}
