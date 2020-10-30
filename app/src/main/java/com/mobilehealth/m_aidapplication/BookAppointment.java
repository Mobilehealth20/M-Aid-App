package com.mobilehealth.m_aidapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.mobilehealth.m_aidapplication.BookHelperClass;
import com.mobilehealth.m_aidapplication.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BookAppointment extends AppCompatActivity {
TextView aid, book;
EditText full, idNo, mobile, mailE, boxP;
Button booking;
ProgressBar progress2;
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
        progress2 = findViewById(R.id.progress);


        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Booking Appointments");


                //Get all the values
                String name = full.getText().toString().trim();
                String id = idNo.getText().toString().trim();
                String no = mobile.getText().toString().trim();
                String mail = mailE.getText().toString().trim();
                String date = boxP.getText().toString().trim();

                BookHelperClass helperClass = new BookHelperClass(name, id, no, mail, date);

                progress2.setVisibility(View.VISIBLE);

                reference.child(name).setValue(helperClass).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(BookAppointment.this, "Successfully uploaded",Toast.LENGTH_SHORT).show();
                        progress2.setVisibility(View.GONE);
                    }

                });





            }
        });




    }
}
