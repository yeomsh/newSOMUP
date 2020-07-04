package com.example.kimsy.somup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Menu2Activity extends AppCompatActivity {

    String id, password, name;
    CheckBox[] sub_check;
    ArrayList<String> subject;
    int num;
    //LinearLayout grade1_linear;
    //LinearLayout grade2_linear;
    //LinearLayout grade3_linear;
    //LinearLayout grade4_linear;

    android.widget.ScrollView grade1_scroll;
    android.widget.ScrollView grade2_scroll;
    android.widget.ScrollView grade3_scroll;
    android.widget.ScrollView grade4_scroll;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        sub_check=new CheckBox[45];

        sub_check[0]=(CheckBox)findViewById(R.id.checkBox1);
        sub_check[1]=(CheckBox)findViewById(R.id.checkBox2);
        sub_check[2]=(CheckBox)findViewById(R.id.checkBox3);
        sub_check[3]=(CheckBox)findViewById(R.id.checkBox4);
        sub_check[4]=(CheckBox)findViewById(R.id.checkBox5);
        sub_check[5]=(CheckBox)findViewById(R.id.checkBox6);
        sub_check[6]=(CheckBox)findViewById(R.id.checkBox7);
        sub_check[7]=(CheckBox)findViewById(R.id.checkBox8);
        sub_check[8]=(CheckBox)findViewById(R.id.checkBox9);
        sub_check[9]=(CheckBox)findViewById(R.id.checkBox10);
        sub_check[10]=(CheckBox)findViewById(R.id.checkBox11);
        sub_check[11]=(CheckBox)findViewById(R.id.checkBox12);
        sub_check[12]=(CheckBox)findViewById(R.id.checkBox13);
        sub_check[13]=(CheckBox)findViewById(R.id.checkBox14);
        sub_check[14]=(CheckBox)findViewById(R.id.checkBox15);
        sub_check[15]=(CheckBox)findViewById(R.id.checkBox16);
        sub_check[16]=(CheckBox)findViewById(R.id.checkBox17);
        sub_check[17]=(CheckBox)findViewById(R.id.checkBox18);
        sub_check[18]=(CheckBox)findViewById(R.id.checkBox19);
        sub_check[19]=(CheckBox)findViewById(R.id.checkBox20);
        sub_check[20]=(CheckBox)findViewById(R.id.checkBox21);
        sub_check[21]=(CheckBox)findViewById(R.id.checkBox22);
        sub_check[22]=(CheckBox)findViewById(R.id.checkBox23);
        sub_check[23]=(CheckBox)findViewById(R.id.checkBox24);
        sub_check[24]=(CheckBox)findViewById(R.id.checkBox25);
        sub_check[25]=(CheckBox)findViewById(R.id.checkBox26);
        sub_check[26]=(CheckBox)findViewById(R.id.checkBox27);
        sub_check[27]=(CheckBox)findViewById(R.id.checkBox28);
        sub_check[28]=(CheckBox)findViewById(R.id.checkBox29);
        sub_check[29]=(CheckBox)findViewById(R.id.checkBox30);
        sub_check[30]=(CheckBox)findViewById(R.id.checkBox31);
        sub_check[31]=(CheckBox)findViewById(R.id.checkBox32);
        sub_check[32]=(CheckBox)findViewById(R.id.checkBox33);
        sub_check[33]=(CheckBox)findViewById(R.id.checkBox34);
        sub_check[34]=(CheckBox)findViewById(R.id.checkBox35);
        sub_check[35]=(CheckBox)findViewById(R.id.checkBox36);
        sub_check[36]=(CheckBox)findViewById(R.id.checkBox37);
        sub_check[37]=(CheckBox)findViewById(R.id.checkBox38);
        sub_check[38]=(CheckBox)findViewById(R.id.checkBox39);
        sub_check[39]=(CheckBox)findViewById(R.id.checkBox40);
        sub_check[40]=(CheckBox)findViewById(R.id.checkBox41);
        sub_check[41]=(CheckBox)findViewById(R.id.checkBox42);
        sub_check[42]=(CheckBox)findViewById(R.id.checkBox43);
        sub_check[43]=(CheckBox)findViewById(R.id.checkBox44);
        sub_check[44]=(CheckBox)findViewById(R.id.checkBox45);


        grade1_scroll=(android.widget.ScrollView)findViewById(R.id.grade1_scroll);
        grade2_scroll=(android.widget.ScrollView)findViewById(R.id.grade2_scroll);
        grade3_scroll=(android.widget.ScrollView)findViewById(R.id.grade3_scroll);
        grade4_scroll=(android.widget.ScrollView)findViewById(R.id.grade4_scroll);

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
        String str;
        for(int i=0; i<45; i++){
            if(sub_check[i].isChecked()) {
                str=sub_check[i].getText().toString();
                subject.add(str);
            }
        }
        /*if(checkBox1.isChecked())
            subject.add("c프로그래밍");
        if(checkBox2.isChecked())
            subject.add("c++프로그래밍");
        if(checkBox3.isChecked())
            subject.add("java프로그래밍");*/

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


    public void showgrade1(View v){
        grade1_scroll.setVisibility(View.VISIBLE);
        grade2_scroll.setVisibility(View.GONE);
        grade3_scroll.setVisibility(View.GONE);
        grade4_scroll.setVisibility(View.GONE);
    }
    public void showgrade2(View v){
        grade1_scroll.setVisibility(View.GONE);
        grade2_scroll.setVisibility(View.VISIBLE);
        grade3_scroll.setVisibility(View.GONE);
        grade4_scroll.setVisibility(View.GONE);
    }
    public void showgrade3(View v){
        grade1_scroll.setVisibility(View.GONE);
        grade2_scroll.setVisibility(View.GONE);
        grade3_scroll.setVisibility(View.VISIBLE);
        grade4_scroll.setVisibility(View.GONE);
    }
    public void showgrade4(View v){
        grade1_scroll.setVisibility(View.GONE);
        grade2_scroll.setVisibility(View.GONE);
        grade3_scroll.setVisibility(View.GONE);
        grade4_scroll.setVisibility(View.VISIBLE);
    }

}
