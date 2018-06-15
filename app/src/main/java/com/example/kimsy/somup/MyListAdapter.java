package com.example.kimsy.somup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {
    Context context;
    ArrayList<com.example.iuhoo.myapplication.list_item> list_itemArrayList;

    public MyListAdapter(Context context, ArrayList<com.example.iuhoo.myapplication.list_item> list_itemArrayList) {
        this.context = context;
        this.list_itemArrayList = list_itemArrayList;
    }

    @Override
    public int getCount() {
        return  this.list_itemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return list_itemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item,null);
            TextView nickname_textView = (TextView)convertView.findViewById(R.id.textView2);
            TextView title_textView  =(TextView)convertView.findViewById(R.id.textView3);
            nickname_textView.setText(list_itemArrayList.get(position).getBookname());
            title_textView.setText(list_itemArrayList.get(position).getTitle());
        }
        return convertView;
    }
}
