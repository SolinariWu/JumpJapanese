package com.example.solinari.finalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by Solinari on 2015/12/23.
 */
public class Learn_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_activity);
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new GridAdapter(this));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                String learn_choice_detail ="";
                switch (StringArray.Learn_Choice){
                    case 0:
                        learn_choice_detail = StringArray.all[position] ;
                        break;
                    case 1:
                        learn_choice_detail = StringArray.all2[position] ;
                        break;
                }
                Intent intent = new Intent(Learn_Activity.this,Learn_dialog.class);
                if (learn_choice_detail!="") {
                    Bundle bundle = new Bundle();
                    bundle.putInt("soundid",position);
                    bundle.putString("text", learn_choice_detail);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                //Toast.makeText(Learn_Activity.this,a,Toast.LENGTH_SHORT).show();
            }
        });
        //SoundPool soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC,100);
    }

    public class GridAdapter extends BaseAdapter {
        TextView textView;
        private Context mContext;
        public GridAdapter(Context c) {
            mContext = c;
        }
        public int getCount() {
            return StringArray.characters.length;
        }
        public Object getItem(int position) {
            return null;
        }
        public long getItemId(int position) {
            return 0;
        }
        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                textView = new TextView(mContext);
                textView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));
                textView.setTextSize(24);
                textView.setGravity(Gravity.CENTER);
                int i = 0;
                textView.setId(i);

            } else {
                textView = (TextView) convertView;
            }
           if (StringArray.Learn_Choice==0){
               switch (StringArray.ActionBar_Choice){
                   case 1:textView.setText(StringArray.all[position]); break;
                   case 2:textView.setText(StringArray.characters[position]);break;
                   case 3:textView.setText(StringArray.pinyin[position]);break;
               }
           }
            if (StringArray.Learn_Choice==1){
                switch (StringArray.ActionBar_Choice){
                    case 1:textView.setText(StringArray.all2[position]); break;
                    case 2:textView.setText(StringArray.characters2[position]);break;
                    case 3:textView.setText(StringArray.pinyin[position]);break;
                }
            }
            return textView;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.learn_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.all:
                StringArray.ActionBar_Choice = 1;
                Intent intent = new Intent(this, Learn_Activity.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.characters:
                StringArray.ActionBar_Choice = 2;
                Intent intent3 = new Intent(this, Learn_Activity.class);
                startActivity(intent3);
                finish();
                return true;
            case R.id.pinyin:
                StringArray.ActionBar_Choice = 3;
                Intent intent2 = new Intent(this, Learn_Activity.class);
                startActivity(intent2);
                finish();
                return true;
            default:
                return false;
        }
    }
}
