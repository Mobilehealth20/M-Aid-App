package com.mobilehealth.m_aidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.StJoseph.aidapp.R;

public class HeadInjury extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_injury);

        getSupportActionBar().hide();
    }
}