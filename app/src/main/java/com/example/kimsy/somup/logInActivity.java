package com.example.kimsy.somup;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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

import java.util.Iterator;

public class logInActivity extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        DatabaseReference mDatabase;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference table = database.getReference("sw/students");
        table.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Log.v("students", data.getKey() + " : " + data.getValue());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 111) {
                    //111 메세지 처리
                    //Log.v("test", check);
                    //Toast.makeText(getApplicationContext(),check, Toast.LENGTH_LONG).show();
                }
            }
        };
    }

    String LOGID;

    String check;
    public void onButton1Clicked(View v){
        //로그인 화면 -> 생각해보니깐 시작화면이 없네 ^^ㅠ
        //로그인 버튼 눌렀을 때
        //db랑 연동해서 로그인 확인!
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference("sw");
        DatabaseReference rDatabase = mDatabase.child("students");
        EditText idText=findViewById(R.id.idText);
        LOGID = idText.getText().toString();

        String path="students/"+idText.getText().toString();
        rDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> child = dataSnapshot.getChildren().iterator();
                for(DataSnapshot data : dataSnapshot.getChildren()){
                    Log.v("Students", data.getKey()+":"+data.getValue());
                    if(LOGID.equals(data.getKey()))
                    {
                        //id가 있을 경우
                        Student temp= data.getValue(Student.class);
                        EditText pwText = findViewById(R.id.pwText);
                        String password = pwText.getText().toString();
                        if(temp.get_password().equals(password)){
                            //아이디-비밀번호가 같은 경우
                            Intent intent= new Intent(getApplicationContext(), StartSelectActivity.class);
                            intent.putExtra("ID",LOGID);
                            startActivity(intent);

                        }else{
                            //비밀번호가 다를 경우
                            Toast.makeText(getApplicationContext(), "비밀번호를 확인하십시오.", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        //아이디가 없을 경우
                        Toast.makeText(getApplicationContext(), "아이디를 확인하십시오.", Toast.LENGTH_SHORT).show();

                    }
                }
                //        handler.sendEmptyMessage(111);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }
}
