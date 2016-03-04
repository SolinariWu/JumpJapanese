package com.example.solinari.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void ButtonClicked(View v){
        switch(v.getId()){
            case R.id.menu_practice:
                Intent intent_practice = new Intent();
                intent_practice.setClass(MenuActivity.this, Practice_menu.class);
                startActivity(intent_practice);
                break;
            case R.id.menu_learning:
                Intent intent_learning = new Intent();
                intent_learning.setClass(MenuActivity.this, Learn_menu.class);
                startActivity(intent_learning);
                break;
            case R.id.location_name:
                Intent intent_location_name = new Intent();
                intent_location_name.setClass(MenuActivity.this, Location_name_Activity.class);
                startActivity(intent_location_name);
                break;

        }
    }
}
