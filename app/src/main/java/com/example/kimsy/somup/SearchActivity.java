package com.example.kimsy.somup;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.security.auth.Subject;

public class SearchActivity extends AppCompatActivity {
    Button btn;
    private ListView mListView = null;
    private ListViewAdapter mAdapter = null;
    public EditText text;
    public String[] select;
    public String[] essential;
    public ArrayList<String> _select;
    public ArrayList<String> _essential;
    public boolean check=false;
    int img;
    ArrayList<Subject> list;
    String str1;
    String str2;
    String str3;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        btn=findViewById(R.id.search);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        list=new ArrayList<>();
        _essential=new ArrayList<>();
        _select=new ArrayList<>();
        list = (ArrayList<Subject>) getIntent().getSerializableExtra("sub");
        str3=getIntent().getStringExtra("btn_text");

        //       Toast.makeText(getApplicationContext(),list.size()+"",Toast.LENGTH_SHORT).show();
        mListView = (ListView) findViewById(R.id.listView);

        mAdapter = new ListViewAdapter(this);
        mListView.setAdapter(mAdapter);

        if(str3!="null") {

            onSearch(str3);
        }

    }

    public void onSearch(final String str3){
        check=false;
        _essential.clear();
        _select.clear();
        text=findViewById(R.id.subject);
        text.setText(str3);
        final String str[]={"1-1","1-2","2-1","2-2","3-1","3-2","4-1","4-2"};
        for(int i=7;i>=0;i--) {
            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("sw/2017/Subject/"+str[i]);
            mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Iterator<DataSnapshot> child = dataSnapshot.getChildren().iterator();
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        if (data.getKey().equals(str3)) {
                            String sb = data.getValue().toString();
                            sb = sb.replaceAll("[{]", "");
                            sb = sb.replaceAll("[}]", "");
                            String[] arStr = sb.split("\\s");
                            String[] select_ = arStr[0].split("=");
                            String[] essential_ = arStr[1].split("=");
                            select = select_[1].split(",");
                            essential = essential_[1].split(",");
                            for (int i = 0; i < select.length; i++)
                                _select.add(select[i]);
                            for (int i = 0; i < essential.length; i++)
                                _essential.add(essential[i]);
                            check=true;
                        }
                        if(check) {
                            for (int j = 0; j < essential.length; j++)
                                if (data.getKey().equals(essential[j])) {
                                    String sb = data.getValue().toString();
                                    sb = sb.replaceAll("[{]", "");
                                    sb = sb.replaceAll("[}]", "");
                                    String[] arStr = sb.split("\\s");
                                    String[] essential_ = arStr[1].split("=");
                                    String[] essential2 = essential_[1].split(",");
                                    for (int i = 0; i < essential2.length; i++)
                                        _essential.add(essential2[i]);
                                }
                            showList();
                        }
//                            Intent intent = new Intent(getApplicationContext(), curricu.class);
//                            intent.putExtra("sub", sb);
//                            startActivity(intent);
                        //                          break;
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }
    }
    public void onSearchClicked(View v) {
        check=false;
        _essential.clear();
        _select.clear();
        text=findViewById(R.id.subject);
        final String str[]={"1-1","1-2","2-1","2-2","3-1","3-2","4-1","4-2"};
        for(int i=7;i>=0;i--) {
            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("sw/2017/Subject/"+str[i]);
            mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Iterator<DataSnapshot> child = dataSnapshot.getChildren().iterator();
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        if (data.getKey().equals(text.getText().toString())) {
                            String sb = data.getValue().toString();
                            sb = sb.replaceAll("[{]", "");
                            sb = sb.replaceAll("[}]", "");
                            String[] arStr = sb.split("\\s");
                            String[] select_ = arStr[0].split("=");
                            String[] essential_ = arStr[1].split("=");
                            select = select_[1].split(",");
                            essential = essential_[1].split(",");
                            for (int i = 0; i < select.length; i++)
                                _select.add(select[i]);
                            for (int i = 0; i < essential.length; i++)
                                _essential.add(essential[i]);
                            check=true;
                        }
                        if(check) {
                            for (int j = 0; j < essential.length; j++)
                                if (data.getKey().equals(essential[j])) {
                                    String sb = data.getValue().toString();
                                    sb = sb.replaceAll("[{]", "");
                                    sb = sb.replaceAll("[}]", "");
                                    String[] arStr = sb.split("\\s");
                                    String[] essential_ = arStr[1].split("=");
                                    String[] essential2 = essential_[1].split(",");
                                    for (int i = 0; i < essential2.length; i++)
                                        _essential.add(essential2[i]);
                                }
                            showList();
                        }
//                            Intent intent = new Intent(getApplicationContext(), curricu.class);
//                            intent.putExtra("sub", sb);
//                            startActivity(intent);
                        //                          break;
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }
    }
    private class ViewHolder {
        public ImageView mIcon;
        public TextView mText;
        public TextView mDate;
    }

    public void showList(){
        mListView = (ListView) findViewById(R.id.listView);

        mAdapter = new ListViewAdapter(getApplicationContext());
        mListView.setAdapter(mAdapter);
        for(int i=0;i<_essential.size();i++){
            if(_essential.get(i)=="$"){
                mAdapter.addItem(null,
                        "필수 과목 없음",
                        "1");
            }
            else{
                if(!_essential.get(i).equals("$")) {
                    boolean flag=false;
                    for(int j=0;j<list.size();j++){
                        if(_essential.get(i).equals(list.get(j))){
                            flag=true;
                            img=R.drawable.checked;
                            break;
                        }
                    }
                    if(flag==false)img=R.drawable.unchecked;
                    mAdapter.addItem(ContextCompat.getDrawable(this, img),
                            "필수",
                            _essential.get(i));
                }
            }
        }
        for(int i=0;i<_select.size();i++){
            if(_select.get(i)=="$"){
                mAdapter.addItem(null,
                        "선택 과목 없음",
                        "3");
            }
            else{
                if(!_select.get(i).equals("$")) {
                    boolean flag=false;
                    for(int j=0;j<list.size();j++){
                        if(_select.get(i).equals(list.get(j))){
                            flag=true;
                            img=R.drawable.s_checked;
                            break;
                        }
                    }
                    if(flag==false)img=R.drawable.s_unchecked;
                    mAdapter.addItem(ContextCompat.getDrawable(this, img),
                            "선택",
                            _select.get(i));
                }
            }
        }
    }
    private class ListViewAdapter extends BaseAdapter {
        private Context mContext = null;
        private ArrayList<ListData> mListData = new ArrayList<ListData>();

        public ListViewAdapter(Context mContext) {
            super();
            this.mContext = mContext;
        }
        //
        public void addItem(Drawable icon, String mTitle, String mDate){
            ListData addInfo = null;
            addInfo = new ListData();
            addInfo.mIcon = icon;
            addInfo.mTitle = mTitle;
            addInfo.mDate = mDate;

            mListData.add(addInfo);
        }

       /* addItem() : 아이템을 추가할때 사용합니다.
                remove() : 아이템을 제거합니다.
        sort() : 아이템을 바르게 배열합니다.
                dataChange() : 데이터를 변경한후 호출해야 합니다.
        */


        public void remove(int position){
            mListData.remove(position);
            dataChange();
        }

        public void sort(){
            Collections.sort(mListData, ListData.ALPHA_COMPARATOR);
            dataChange();
        }

        public void dataChange(){
            mAdapter.notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mListData.size();
        }

        @Override
        public Object getItem(int position) {
            return mListData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            //convertView는 아이템 화면
            //position -> 아이템 순서
            //getView -> 한 아이템에 들어갈 레이아웃을 지정해 주는 메소드
            //사용자가 스크롤 내릴때마다 생성-> null로 이미 만들어진 것을 재사용
            if(convertView==null){
                holder=new ViewHolder();

                LayoutInflater inflater= (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.list_view_item,null);

                holder.mIcon = (ImageView)convertView.findViewById(R.id.mImage);
                holder.mText = (TextView)convertView.findViewById(R.id.mText);
                holder.mDate = (TextView)convertView.findViewById(R.id.mDate);

                convertView.setTag(holder);
            }
            else
                holder=(ViewHolder)convertView.getTag();

            ListData mData = mListData.get(position);

            if(mData.mIcon!=null){
                holder.mIcon.setVisibility(View.VISIBLE);
                holder.mIcon.setImageDrawable(mData.mIcon);
            }
            else{
                holder.mIcon.setVisibility(View.GONE);
            }

            holder.mText.setText(mData.mTitle);
            holder.mDate.setText(mData.mDate);

            return convertView;
        }
    }
}