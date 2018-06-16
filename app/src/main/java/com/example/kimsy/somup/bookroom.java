package com.example.kimsy.somup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class bookroom extends AppCompatActivity {

    private TextView mTextMessage;
    ListView listView;
    com.example.kimsy.somup.MyListAdapter myListAdapter;
    public ArrayList<com.example.kimsy.somup.list_item> list_itemArrayList;
    Button click_btn;
    Button click_btn2;
    EditText input1;
    EditText input2;
    Integer select;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_bookroom:
                    mTextMessage.setText(R.string.title_bookroom);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_sell);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) throws NullPointerException{
        select = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookroom);
        listView = (ListView)findViewById(R.id.Listview);
        list_itemArrayList = new ArrayList<com.example.kimsy.somup.list_item>();
        list_itemArrayList.add(new com.example.kimsy.somup.list_item("JAVASCRIPT",1 ,"123"));
        list_itemArrayList.add(new com.example.kimsy.somup.list_item("ASDF",1,"2,200"));
        list_itemArrayList.add(new com.example.kimsy.somup.list_item("PyTHon",1,"ii,iii"));

        click_btn = (Button)findViewById(R.id.button);
        click_btn2 = (Button)findViewById(R.id.button2);
        input1 = (EditText)findViewById(R.id.editText);
        input2 = (EditText)findViewById(R.id.editText2);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        View.OnClickListener mClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //list_itemArrayList.add(new list_item(input1.getText().toString(),1,input2.getText().toString()));
                Toast.makeText(bookroom.this ,select.toString(), Toast.LENGTH_LONG).show();
                list_itemArrayList.remove(select.intValue());
                listView.clearChoices();
                myListAdapter.notifyDataSetChanged();
            }
        };
        click_btn.setOnClickListener(mClickListener);
        click_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        addPage.class); // 다음 넘어갈 클래스 지정
                startActivity(intent); // 다음 화면으로 넘어간다
            }
        });
        myListAdapter = new com.example.kimsy.somup.MyListAdapter(bookroom.this,list_itemArrayList);
        listView.setAdapter(myListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(bookroom.this ,list_itemArrayList.get(position).getTitle(), Toast.LENGTH_LONG).show();
                select = position;
            }
        });

        Intent intent = getIntent();
        if(intent.getExtras() != null){
            list_itemArrayList.add(new com.example.kimsy.somup.list_item(intent.getStringExtra("name").toString(),intent.getIntExtra("amount",0),intent.getStringExtra("price").toString()));
        }

    }

}



