package com.example.eva.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by Eva on 16/11/2017.
 */

public class Preferencies extends PreferenceFragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencies);
    }
}
