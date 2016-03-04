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
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Solinari on 2015/12/22.
 */
public class Practice_menu extends AppCompatActivity {
    ArrayList<Boolean> checkedtextviewList ;
    ArrayList<String> practice_option;
    String Pra_Range ;
    RadioButton rb_10 ;
    RadioButton rb_20 ;
    RadioButton rb_30 ;
    RadioButton rb_full ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_menu_layout);
        ListView list = (ListView) findViewById(R.id.listView) ;
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                                            CheckedTextView chkItem = (CheckedTextView) v.findViewById(R.id.check1);
                                            chkItem.setChecked(!chkItem.isChecked());
                                            checkedtextviewList.set(position, chkItem.isChecked());
                                        }
                                    }
        );
        checkedtextviewList = new  ArrayList<Boolean>();
         practice_option = new ArrayList<String>();
        for (int i = 0;i<StringArray.practice_option.length;i++){
           practice_option.add(StringArray.practice_option[i]) ;
                checkedtextviewList.add(true);
        }
        adapterItem listitem  = new adapterItem(this,practice_option);
        list.setAdapter(listitem);
        rb_10 = (RadioButton) findViewById(R.id.radio_10);
        rb_20 = (RadioButton) findViewById(R.id.radio_20);
        rb_30 = (RadioButton) findViewById(R.id.radio_30);
        rb_full = (RadioButton) findViewById(R.id.radio_full);
    }
    public String PracticeRange(){
        Pra_Range = "";
        for (int i=0;i<checkedtextviewList.size();i++)
        {
            if(checkedtextviewList.get(i)==true){
                switch(i){
                    case  0:Pra_Range = Pra_Range + "h" ;
                        break;
                    case  1:Pra_Range = Pra_Range + "k" ;
                }
            }
        }
        return Pra_Range;
    }
    public int NumborOfQuestion(){
        if (rb_10.isChecked()==true){
            return 10;
        }
        else if(rb_20.isChecked()==true){
            return 20;
        }
        else if (rb_30.isChecked()==true){
            return 30;
        }
        else{
            return 40;
        }
    }
    public void ButtonClicked(View v){
        String range ;
        range = PracticeRange();
        if (range =="") {
            Toast.makeText(Practice_menu.this, "請選擇範圍!", Toast.LENGTH_SHORT).show();
        }
        else {
            int numofqu;
            numofqu=NumborOfQuestion();
            Intent intent = new Intent();
            intent.setClass(Practice_menu.this, Practice_Activity.class);
            Bundle bundle = new Bundle();
            bundle.putString("range", range);
            bundle.putInt("numberofquestion",numofqu);
            intent.putExtras(bundle);
            startActivity(intent);
        }



    }
    public class adapterItem extends BaseAdapter
    {
        private Activity activity;
        private List<String> mList;

        private  LayoutInflater inflater = null;

        public adapterItem(Activity a, List<String> list)
        {
            activity = a;
            mList = list;
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        public int getCount()
        {
            return mList.size();
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
            View vi = convertView;
            if(convertView==null)
            {
                vi = inflater.inflate(R.layout.checkedtextview_item, null);
            }

            CheckedTextView chkBshow = (CheckedTextView) vi.findViewById(R.id.check1);

            chkBshow.setText(mList.get(position).toString());

            return vi;
        }
    }
}
