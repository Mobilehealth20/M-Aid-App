package com.mobilehealth.m_aidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.StJoseph.aidapp.R;

public class BonesMuscles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bones_muscles);

        getSupportActionBar().hide();
    }
}