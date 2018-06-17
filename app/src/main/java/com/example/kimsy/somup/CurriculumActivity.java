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
        Button button1 = (Button) findViewById(R.id.sbutton1) ;
        button1.setOnClickListener(onClickListener) ;
        Button button2 = (Button) findViewById(R.id.sbutton2) ;
        button2.setOnClickListener(onClickListener) ;
        Button button3 = (Button) findViewById(R.id.sbutton3) ;
        button3.setOnClickListener(onClickListener) ;
        Button button4 = (Button) findViewById(R.id.sbutton4) ;
        button4.setOnClickListener(onClickListener) ;
        Button button5 = (Button) findViewById(R.id.sbutton5) ;
        button5.setOnClickListener(onClickListener) ;
        Button button6 = (Button) findViewById(R.id.sbutton6) ;
        button6.setOnClickListener(onClickListener) ;
        Button button7 = (Button) findViewById(R.id.sbutton7) ;
        button7.setOnClickListener(onClickListener) ;
        Button button8 = (Button) findViewById(R.id.sbutton8) ;
        button8.setOnClickListener(onClickListener) ;
        Button button9 = (Button) findViewById(R.id.sbutton9) ;
        button9.setOnClickListener(onClickListener) ;
        Button button10 = (Button) findViewById(R.id.sbutton10) ;
        button10.setOnClickListener(onClickListener) ;
        Button button11= (Button) findViewById(R.id.sbutton11) ;
        button11.setOnClickListener(onClickListener) ;
        Button button12 = (Button) findViewById(R.id.sbutton12) ;
        button12.setOnClickListener(onClickListener) ;
        Button button13 = (Button) findViewById(R.id.sbutton13) ;
        button13.setOnClickListener(onClickListener) ;
        Button button14 = (Button) findViewById(R.id.sbutton14) ;
        button14.setOnClickListener(onClickListener) ;
        Button button15 = (Button) findViewById(R.id.sbutton15) ;
        button15.setOnClickListener(onClickListener) ;
        Button button16= (Button) findViewById(R.id.sbutton16) ;
        button16.setOnClickListener(onClickListener) ;
        Button button17 = (Button) findViewById(R.id.sbutton17) ;
        button17.setOnClickListener(onClickListener) ;
        Button button18 = (Button) findViewById(R.id.sbutton18) ;
        button18.setOnClickListener(onClickListener) ;
        Button button19 = (Button) findViewById(R.id.sbutton19) ;
        button19.setOnClickListener(onClickListener) ;
        Button button20 = (Button) findViewById(R.id.sbutton20) ;
        button20.setOnClickListener(onClickListener) ;
        Button button21= (Button) findViewById(R.id.sbutton21) ;
        button21.setOnClickListener(onClickListener) ;
        Button button22 = (Button) findViewById(R.id.sbutton22) ;
        button22.setOnClickListener(onClickListener) ;
        Button button23 = (Button) findViewById(R.id.sbutton23) ;
        button23.setOnClickListener(onClickListener) ;
        Button button24 = (Button) findViewById(R.id.sbutton24) ;
        button24.setOnClickListener(onClickListener) ;
        Button button25 = (Button) findViewById(R.id.sbutton25) ;
        button25.setOnClickListener(onClickListener) ;
        Button button26= (Button) findViewById(R.id.sbutton26) ;
        button26.setOnClickListener(onClickListener) ;
        Button button27 = (Button) findViewById(R.id.sbutton27) ;
        button27.setOnClickListener(onClickListener) ;
        Button button28 = (Button) findViewById(R.id.sbutton28) ;
        button28.setOnClickListener(onClickListener) ;
        Button button29 = (Button) findViewById(R.id.sbutton29) ;
        button29.setOnClickListener(onClickListener) ;
        Button button30 = (Button) findViewById(R.id.sbutton30) ;
        button30.setOnClickListener(onClickListener) ;
        Button button31= (Button) findViewById(R.id.sbutton31) ;
        button31.setOnClickListener(onClickListener) ;
        Button button32 = (Button) findViewById(R.id.sbutton32) ;
        button32.setOnClickListener(onClickListener) ;
        Button button33 = (Button) findViewById(R.id.sbutton33) ;
        button33.setOnClickListener(onClickListener) ;
        Button button34 = (Button) findViewById(R.id.sbutton34) ;
        button34.setOnClickListener(onClickListener) ;
        Button button35 = (Button) findViewById(R.id.sbutton35) ;
        button35.setOnClickListener(onClickListener) ;
        Button button36= (Button) findViewById(R.id.sbutton36) ;
        button36.setOnClickListener(onClickListener) ;
        Button button37 = (Button) findViewById(R.id.sbutton37) ;
        button37.setOnClickListener(onClickListener) ;
        Button button38 = (Button) findViewById(R.id.sbutton38) ;
        button38.setOnClickListener(onClickListener) ;
        Button button39 = (Button) findViewById(R.id.sbutton39) ;
        button39.setOnClickListener(onClickListener) ;
        Button button40 = (Button) findViewById(R.id.sbutton40) ;
        button40.setOnClickListener(onClickListener) ;
        Button button41 = (Button) findViewById(R.id.sbutton41) ;
        button41.setOnClickListener(onClickListener) ;
        Button button42= (Button) findViewById(R.id.sbutton42) ;
        button42.setOnClickListener(onClickListener) ;
        Button button43 = (Button) findViewById(R.id.sbutton43) ;
        button43.setOnClickListener(onClickListener) ;
        Button button44 = (Button) findViewById(R.id.sbutton44) ;
        button44.setOnClickListener(onClickListener) ;
        Button button45 = (Button) findViewById(R.id.sbutton45) ;
        button45.setOnClickListener(onClickListener) ;



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
