package com.sarm.konnex.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.sarm.konnex.KConstants;

public class KPref {
    private static SharedPreferences.Editor getEditor(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                KConstants.PACKAGE_NAME, Context.MODE_PRIVATE
        );
        return sharedPreferences.edit();
    }

    private static SharedPreferences getSharedPref(Context context) {
        return context.getSharedPreferences(
                KConstants.PACKAGE_NAME, Context.MODE_PRIVATE
        );
    }

    public static void storeUserInstance(Context context){
        getEditor(context).putString(KConstants.PREF_USER_INST_KEY, "y").apply();
    }

    public static boolean getUserInstance(Context context){
        String inst = getSharedPref(context).getString(KConstants.PREF_USER_INST_KEY, "n");
        return inst.equals("y");
    }
}
