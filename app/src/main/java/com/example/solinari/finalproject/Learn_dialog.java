package com.example.solinari.finalproject;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Solinari on 2015/12/23.
 */
public class Learn_dialog extends AppCompatActivity {
    TextView text_content;
    ImageButton sound_buttton;
    SoundPool soundPool;
    int choiceId;
    int sound ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_dialog);
        Bundle bundleInfo =this.getIntent().getExtras();
         choiceId = bundleInfo.getInt("soundid");
        text_content = (TextView) findViewById(R.id.text_content);
        text_content.setText(bundleInfo.getString("text"));
        sound_buttton = (ImageButton) findViewById(R.id.sound_buttton) ;
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        LoadSound();




    }
    public void ButtonClicked(View v){
       finish();
    }
    public void SoundButton(View v){
        soundPool.play(choiceId, 1.0F, 1.0F, 0, 0, 1.0F);
    }
    public void LoadSound() {
        switch (choiceId) {
            case 0:
                choiceId = soundPool.load(this, R.raw.h0, 1);
                break;
            case 1:
                choiceId = soundPool.load(this, R.raw.h1, 1);
                break;
            case 2:
                choiceId = soundPool.load(this, R.raw.h2, 1);
                break;
            case 3:
                choiceId = soundPool.load(this, R.raw.h3, 1);
                break;
            case 4:
                choiceId = soundPool.load(this, R.raw.h4, 1);
                break;
            case 5:
                choiceId = soundPool.load(this, R.raw.h5, 1);
                break;
            case 6:
                choiceId = soundPool.load(this, R.raw.h6, 1);
                break;
            case 7:
                choiceId = soundPool.load(this, R.raw.h7, 1);
                break;
            case 8:
                choiceId = soundPool.load(this, R.raw.h8, 1);
                break;
            case 9:
                choiceId = soundPool.load(this, R.raw.h9, 1);
                break;
            case 10:
                choiceId = soundPool.load(this, R.raw.h10, 1);
                break;
            case 11:
                choiceId = soundPool.load(this, R.raw.h11, 1);
                break;
            case 12:
                choiceId = soundPool.load(this, R.raw.h12, 1);
                break;
            case 13:
                choiceId = soundPool.load(this, R.raw.h13, 1);
                break;
            case 14:
                choiceId = soundPool.load(this, R.raw.h14, 1);
                break;
            case 15:
                choiceId = soundPool.load(this, R.raw.h15, 1);
                break;
            case 16:
                choiceId = soundPool.load(this, R.raw.h16, 1);
                break;
            case 17:
                choiceId = soundPool.load(this, R.raw.h17, 1);
                break;
            case 18:
                choiceId = soundPool.load(this, R.raw.h18, 1);
                break;
            case 19:
                choiceId = soundPool.load(this, R.raw.h19, 1);
                break;
            case 20:
                choiceId = soundPool.load(this, R.raw.h20, 1);
                break;
            case 21:
                choiceId = soundPool.load(this, R.raw.h21, 1);
                break;
            case 22:
                choiceId = soundPool.load(this, R.raw.h22, 1);
                break;
            case 23:
                choiceId = soundPool.load(this, R.raw.h23, 1);
                break;
            case 24:
                choiceId = soundPool.load(this, R.raw.h24, 1);
                break;
            case 25:
                choiceId = soundPool.load(this, R.raw.h25, 1);
                break;
            case 26:
                choiceId = soundPool.load(this, R.raw.h26, 1);
                break;
            case 27:
                choiceId = soundPool.load(this, R.raw.h27, 1);
                break;
            case 28:
                choiceId = soundPool.load(this, R.raw.h28, 1);
                break;
            case 29:
                choiceId = soundPool.load(this, R.raw.h29, 1);
                break;
            case 30:
                choiceId = soundPool.load(this, R.raw.h30, 1);
                break;
            case 31:
                choiceId = soundPool.load(this, R.raw.h31, 1);
                break;
            case 32:
                choiceId = soundPool.load(this, R.raw.h32, 1);
                break;
            case 33:
                choiceId = soundPool.load(this, R.raw.h33, 1);
                break;
            case 34:
                choiceId = soundPool.load(this, R.raw.h34, 1);
                break;
            case 35:
                choiceId = soundPool.load(this, R.raw.h35, 1);
                break;
            case 37:
                choiceId = soundPool.load(this, R.raw.h37, 1);
                break;
            case 39:
                choiceId = soundPool.load(this, R.raw.h39, 1);
                break;
            case 40:
                choiceId = soundPool.load(this, R.raw.h40, 1);
                break;
            case 41:
                choiceId = soundPool.load(this, R.raw.h41, 1);
                break;
            case 42:
                choiceId = soundPool.load(this, R.raw.h42, 1);
                break;
            case 43:
                choiceId = soundPool.load(this, R.raw.h43, 1);
                break;
            case 44:
                choiceId = soundPool.load(this, R.raw.h44, 1);
                break;
            case 45:
                choiceId = soundPool.load(this, R.raw.h45, 1);
                break;
            case 49:
                choiceId = soundPool.load(this, R.raw.h49, 1);
                break;
            case 50:
                choiceId = soundPool.load(this, R.raw.h50, 1);
                break;

        }
    }
}
