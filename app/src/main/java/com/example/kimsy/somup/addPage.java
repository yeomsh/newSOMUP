package com.example.kimsy.somup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class addPage extends AppCompatActivity {
    Button btn1;
    EditText input1;
    EditText input2;
    EditText input3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_book_page);  // layout xml 과 자바파일을 연결
        input1 = (EditText)findViewById(R.id.editText5);
        input2 = (EditText)findViewById(R.id.editText6);
        input3 = (EditText)findViewById(R.id.editText7);
        btn1 = (Button)findViewById(R.id.button3);
        btn1.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.kimsy.somup.bookroom.class);
                intent.putExtra("name",input1.getText().toString());
                intent.putExtra("amount",input2.getText().toString());
                intent.putExtra("price",input3.getText().toString());
                startActivity(intent);

            }
        });
    } // end onCreate()
} // end MyTwo
