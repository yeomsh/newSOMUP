package com.example.kimsy.somup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
    }

    public void onLoginBtnClicked(View v){
        Intent intent=new Intent(this, logInActivity.class);
        startActivity(intent);
    }

    public void onRegisterBtnClicked(View v){
        Intent intent=new Intent(this, MenuActivity.class);
        startActivity(intent);

    }


}
