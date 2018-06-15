package com.example.kimsy.somup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Menu2Activity extends AppCompatActivity {

    String id, password, name;
    CheckBox checkBox1, checkBox2, checkBox3;
    ArrayList<String> subject;
    int num;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        checkBox1=(CheckBox)findViewById(R.id.checkBox);
        checkBox2=(CheckBox)findViewById(R.id.checkBox2);
        checkBox3=(CheckBox)findViewById(R.id.checkBox3);

        Intent intent=getIntent();
        id=intent.getStringExtra("id");
        password=intent.getStringExtra("password");
        name=intent.getStringExtra("name");
        num=Integer.parseInt(intent.getStringExtra("num"));

        subject=new ArrayList<>();

       RadioGroup rg_status=(RadioGroup)findViewById(R.id.rg_status);

        final LinearLayout user_con=(LinearLayout)findViewById(R.id.user_con);
        final LinearLayout admin_con=(LinearLayout)findViewById(R.id.admin_con);

        rg_status.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rBtn_user){
                    user_con.setVisibility(View.VISIBLE);
                    admin_con.setVisibility(View.INVISIBLE);
                }
                else{
                    user_con.setVisibility(View.INVISIBLE);
                    admin_con.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void GoToLogin(View v){

        Student student=new Student(id, password, name, num);

        if(checkBox1.isChecked())
            subject.add("c프로그래밍");
        if(checkBox2.isChecked())
            subject.add("c++프로그래밍");
        if(checkBox3.isChecked())
            subject.add("java프로그래밍");

        student.subject=new ArrayList<>();
        for(int i=0;i<subject.size();i++)
            student.subject.add(subject.get(i));

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("sw/students");
        mDatabase.child(id.toString()).setValue(student);

        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data:dataSnapshot.getChildren()){
                    if(data.getKey().equals("10")){
                        Student st=data.getValue(Student.class);
                        Toast.makeText(getApplicationContext(),st.get_password(),Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        Toast.makeText(getApplicationContext(), student.get_password(), Toast.LENGTH_LONG).show();

        Intent intent=new Intent(this, logInActivity.class);
        startActivity(intent);
        //finish();


    }
}
