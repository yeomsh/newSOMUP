package com.example.kimsy.somup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StartSelectActivity extends AppCompatActivity {
    String string;
    ArrayList<String> arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_select);
        Intent intent = getIntent();
        string=intent.getStringExtra("ID");
        Toast.makeText(getApplicationContext(), string,Toast.LENGTH_SHORT).show();
        arr=new ArrayList<>();
    }

    public void onButton6Clicked(View view) {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("sw/students");

        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data:dataSnapshot.getChildren()){
                    if(data.getKey().equals(string)){
                        Student st=data.getValue(Student.class);
                        arr=st.getSubject();

                        break;
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        Intent intent=new Intent(this, CurriculumActivity.class);
        startActivity(intent);

    }
}
