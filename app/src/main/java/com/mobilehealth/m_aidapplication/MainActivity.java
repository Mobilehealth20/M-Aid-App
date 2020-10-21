package com.mobilehealth.m_aidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.StJoseph.aidapp.Poisoning;
import com.StJoseph.aidapp.R;
import com.StJoseph.aidapp.Resuscitation;
import com.StJoseph.aidapp.Seizure;
import com.StJoseph.aidapp.Stroke;
import com.google.firebase.auth.FirebaseAuth;
import com.mobilehealth.m_aidapplication.Asthma;
import com.mobilehealth.m_aidapplication.Bleeding;
import com.mobilehealth.m_aidapplication.BonesMuscles;
import com.mobilehealth.m_aidapplication.Burns;
import com.mobilehealth.m_aidapplication.ChestPain;
import com.mobilehealth.m_aidapplication.Choking;
import com.mobilehealth.m_aidapplication.Drowning;
import com.mobilehealth.m_aidapplication.HeadInjury;

public class MainActivity extends AppCompatActivity {
TextView resus, seizure, stroke, asthma, poisoning, head, drowning, choking, chest, bleeding, burns, bones;
Button btn, maps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resus = findViewById(R.id.textResuscitation);
        resus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f = new Intent(MainActivity.this, Resuscitation.class);
                startActivity(f);
            }
        });

        seizure = findViewById(R.id.textSeizure);
        seizure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, Seizure.class);
                startActivity(a);
            }
        });

        stroke = findViewById(R.id.textStroke);
        stroke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(MainActivity.this, Stroke.class);
                startActivity(b);
            }
        });

        asthma = findViewById(R.id.textAsthma);
        asthma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(MainActivity.this, Asthma.class);
                startActivity(c);
            }
        });

        poisoning = findViewById(R.id.textPoisoning);
        poisoning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(MainActivity.this, Poisoning.class);
                startActivity(e);
            }
        });

        head = findViewById(R.id.textHead);
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g = new Intent(MainActivity.this, HeadInjury.class);
                startActivity(g);
            }
        });

        drowning = findViewById(R.id.textDrowning);
        drowning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent h = new Intent(MainActivity.this, Drowning.class);
                startActivity(h);
            }
        });

        choking = findViewById(R.id.textChoking);
        choking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Choking.class);
                startActivity(i);
            }
        });

        chest = findViewById(R.id.textChest);
        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this, ChestPain.class);
                startActivity(j);
            }
        });

        bleeding = findViewById(R.id.textBleeding);
        bleeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(MainActivity.this, Bleeding.class);
                startActivity(k);
            }
        });

        burns = findViewById(R.id.textBurns);
        burns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(MainActivity.this, Burns.class);
                startActivity(l);
            }
        });

        bones = findViewById(R.id.textBones);
        bones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(MainActivity.this, BonesMuscles.class);
                startActivity(m);
            }
        });

        maps=findViewById(R.id.textMaps);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent(MainActivity.this,MapsActivity2.class);
                startActivity(n);
            }
        });

        btn=findViewById(R.id.btnPoint);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent z=new Intent(MainActivity.this,BookAppointment.class);
                startActivity(z);
            }
        });

        getSupportActionBar().hide();


    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }
    }
}