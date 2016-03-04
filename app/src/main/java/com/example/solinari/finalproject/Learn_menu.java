package com.example.solinari.finalproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Solinari on 2015/12/23.
 */
public class Learn_menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_menu_layout);
        String[] option  =new String[StringArray.practice_option.length] ;
        for (int i =0 ; i<StringArray.practice_option.length;i++){
            option[i] = StringArray.practice_option[i] ;

        }
        ListView list = (ListView) findViewById(R.id.learning_listView) ;
        list.setAdapter(new listAdapter(Learn_menu.this,option));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                                            TextView textItem = (TextView) v.findViewById(R.id.listTextView);
                                            Intent intent_practice = new Intent();
                                            intent_practice.setClass(Learn_menu.this, Learn_Activity.class);
                                            StringArray.Learn_Choice = position ;
                                            StringArray.ActionBar_Choice= 1;
                                            startActivity(intent_practice);
                                            //Toast.makeText(Learn_menu.this,position,Toast.LENGTH_SHORT).show();
                                        }
                                    }
        );
    }
    public class listAdapter extends BaseAdapter
    {
        private Activity activity;
        private String[] mList;
        private  LayoutInflater inflater = null;
        public listAdapter(Activity a, String[] list)
        {
            activity = a;
            mList = list;
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        public int getCount()
        {
            return mList.length;
        }
        public Object getItem(int position)
        {
            return position;
        }
        public long getItemId(int position)
        {
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent)
        {
            convertView = inflater.inflate(R.layout.list_item,parent,false);
            TextView listTextView;
            listTextView = (TextView) convertView.findViewById(R.id.listTextView);
            listTextView.setText(mList[position]);
            return convertView;
        }
    }
}
