package com.bs.clothesroom.controller;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
    
    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;
    
    private static Preferences mPreferences;
    
    private Preferences(Context context) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        mEditor = mPrefs.edit();
    }
    
    public static Preferences getInstance(Context context) {
        Context c = context.getApplicationContext();
        if (mPreferences == null) {
            mPreferences = new Preferences(c);
        }
        return mPreferences;
    }
    
    public void saveUsername(String username) {
        mEditor.putString("username", username);
        mEditor.commit();
    }
    
    public String getUsername() {
        String name = mPrefs.getString("username", "");
        return name;
    }
}
