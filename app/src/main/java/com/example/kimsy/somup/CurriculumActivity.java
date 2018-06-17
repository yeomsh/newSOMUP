package com.example.kimsy.somup;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CurriculumActivity extends AppCompatActivity {
    String id;
    ArrayList<String> arr;
    String click;

    @Override

    public void onCreate(Bundle savedInstanceState)
    {
            super.onCreate(savedInstanceState);
            arr = new ArrayList<>();
            setContentView(R.layout.activity_curriculum);
            Intent intent = getIntent();
            id = intent.getStringExtra("ID");
        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            Button btn;
            @Override
            public void onClick(View view) {
                btn=findViewById(view.getId());
                click=btn.getText().toString();
                GoToSpecific(view);
            }
        } ;
        Button button15 = (Button) findViewById(R.id.button15) ;
        button15.setOnClickListener(onClickListener) ;



    }


    public void GoToSpecific(View v){
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("sw/students");

        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data:dataSnapshot.getChildren()){
                    if(data.getKey().equals(id)){
                        Student st=data.getValue(Student.class);
                        arr=st.getSubject();
                        Intent intent = new Intent(getApplicationContext(),SearchActivity.class);
                        //버튼 내용
                        intent.putExtra("btn_text",click);
//                        boolean check=false;
//                        intent.putExtra("pre",check);
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
//                        String text="C프로그래밍";
//                        //버튼 텍스트 넣기
                          intent.putExtra("btn_text","null");
//                        boolean check=false;
//                        intent.putExtra("pre",check);
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
