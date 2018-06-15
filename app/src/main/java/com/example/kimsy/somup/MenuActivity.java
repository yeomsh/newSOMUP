/***회원가입 화면***/
package com.example.kimsy.somup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;


public class MenuActivity extends AppCompatActivity {

    public EditText id;
    public EditText pw;
    public EditText num;
    public EditText subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void onBackClicked(View v){
        //fireBase로 데이터 저장하기
        id=findViewById(R.id.id);
        pw=findViewById(R.id.pw);
        num=findViewById(R.id.std_id);
      //  DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("sw/students");
       // DatabaseReference rDatabase = mDatabase.child("students");
        //객체 생성후 삽입하기
       // rDatabase.child(id.getText().toString()).setValue(items);
        //rDatabase 는 sw/students까지
        //리스너를 통해 아이디를 찾은 후 삽입

//        rDatabase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String id2 = id.getText().toString();
//                Iterator<DataSnapshot> child = dataSnapshot.getChildren().iterator();
//                for(DataSnapshot data : dataSnapshot.getChildren()){
//                    Log.v("Students", data.getKey()+":"+data.getValue());
//                    if(id2.equals(data.getKey()))
//                    {
//                        //id가 있을 경우
//                        Student temp= data.getValue(Student.class);
//                        temp.subject.add(num.getText().toString());
//
//                    }else{
//                        //아이디가 없(getApplicationContext(), "아이디를 확인하십시오.", Toast.LENGTH_SHORT).show();
//
//                    }
//                }
//                //        handler.sendEmptyMessage(111);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });


        Student items = new Student(id.getText().toString(), pw.getText().toString(),"염상희",00000000);

        Intent intent=new Intent(this, Menu2Activity.class);
        intent.putExtra("id", id.getText().toString());
        intent.putExtra("password", pw.getText().toString());
        intent.putExtra("name", "염상희");
        intent.putExtra("num", num.getText().toString());

        startActivity(intent);
        finish();
    }

}
