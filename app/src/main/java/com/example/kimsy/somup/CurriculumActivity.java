package com.example.kimsy.somup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CurriculumActivity extends AppCompatActivity {
    String id;
    ArrayList<String> arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arr=new ArrayList<>();
        setContentView(R.layout.activity_curriculum);
        Intent intent = getIntent();
        id=intent.getStringExtra("ID");
    }

    public void GoToSpecific(View v){
        Intent intent=new Intent(this, SpecificActivity.class);
        startActivity(intent);
    }

    public void GoToSearch(View v){
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("sw/students");

        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data:dataSnapshot.getChildren()){
                    if(data.getKey().equals(id)){
                        Student st=data.getValue(Student.class);
                        arr=st.getSubject();
                        Intent intent = new Intent(getApplicationContext(),SearchActivity.class);
                        intent.putExtra("sub",arr);
                        startActivity(intent);
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
