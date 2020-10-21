package com.mobilehealth.m_aidapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.StJoseph.aidapp.BookHelperClass;
import com.StJoseph.aidapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BookAppointment extends AppCompatActivity {
TextView aid, book;
EditText full, idNo, mobile, mailE, boxP;
Button booking;
FirebaseDatabase rootNode;
DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        aid=findViewById(R.id.text12);
        book=findViewById(R.id.text13);
        full=findViewById(R.id.editName14);
        idNo=findViewById(R.id.editId);
        mobile=findViewById(R.id.editMobile);
        mailE=findViewById(R.id.editEmail0);
        boxP=findViewById(R.id.editBox);
        booking=findViewById(R.id.btnBook9);

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");


                //Get all the values
                String name = full.getText().toString().trim();
                String id = idNo.getText().toString().trim();
                String no = mobile.getText().toString().trim();
                String mail = mailE.getText().toString().trim();
                String date = boxP.getText().toString().trim();

                BookHelperClass helperClass = new BookHelperClass(name, id, no, mail, date);

                reference.child(id).setValue(helperClass);
            }
        });

        getSupportActionBar().hide();

    }
}
