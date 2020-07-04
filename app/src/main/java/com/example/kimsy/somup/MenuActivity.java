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
    public EditText name;
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
        name=findViewById(R.id.name);


        Student items = new Student(id.getText().toString(), pw.getText().toString(),"염상희",00000000);

        Intent intent=new Intent(this, Menu2Activity.class);
        intent.putExtra("id", id.getText().toString());
        intent.putExtra("password", pw.getText().toString());
        intent.putExtra("name", name.getText().toString());
        intent.putExtra("num", num.getText().toString());

        startActivity(intent);
        finish();
    }

}
