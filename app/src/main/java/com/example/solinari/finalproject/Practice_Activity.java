package com.example.solinari.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Solinari on 2015/12/21.
 */
public class Practice_Activity extends AppCompatActivity {
    String[] PracticeRangeArray;
    String[] PracticeRangeArrayAns;
    int[] RandomTopic ;
    Integer NowTopicNumber ;
    int correct ;
    int RandomAmount ;
    Button[] ansBut = new Button[7];
    TextView TopicView;
    TextView NumberofQuestion;
    Integer UserTotalSlectNumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_layout);
        Bundle bundleInfo =this.getIntent().getExtras();
        String range = bundleInfo.getString("range");
        UserTotalSlectNumber = bundleInfo.getInt("numberofquestion");

        switch (range){
            case "h":
                PracticeRangeArray = new String[46];
                PracticeRangeArrayAns = new String[46];
                RandomTopic = new int[46] ;
                RandomAmount = 46 ;
                int h_amount = 0;
               for (int i = 0; i<StringArray.characters.length;i++){
                    if(StringArray.characters[i]!="") {
                        PracticeRangeArray[h_amount] = StringArray.characters[i];
                        PracticeRangeArrayAns[h_amount] = StringArray.pinyin[i];
                        h_amount +=1;
                    }
                }
                if (UserTotalSlectNumber == 40){
                    UserTotalSlectNumber = 46 ;
                }
                break;
            case "k":
                PracticeRangeArray = new String[46];
                PracticeRangeArrayAns = new String[46];
                RandomTopic = new int[46] ;
                RandomAmount = 46 ;
                int k_amount = 0;
                for (int i = 0; i<StringArray.characters2.length;i++){
                    if(StringArray.characters2[i]!="") {
                        PracticeRangeArray[k_amount] = StringArray.characters2[i];
                        PracticeRangeArrayAns[k_amount] = StringArray.pinyin[i];
                        k_amount +=1;
                    }
                }
                if (UserTotalSlectNumber == 40){
                    UserTotalSlectNumber = 46 ;
                }
                break;
            case "hk":
                PracticeRangeArray = new String[92];
                PracticeRangeArrayAns = new String[92];
                RandomTopic = new int[92] ;
                RandomAmount = 92 ;
                int hk_amount = 0;
                for (int i = 0; i<StringArray.characters.length;i++) {
                    if (StringArray.characters[i] != "") {
                        PracticeRangeArray[hk_amount] = StringArray.characters[i];
                        PracticeRangeArrayAns[hk_amount] = StringArray.pinyin[i];
                        hk_amount += 1;
                    }
                }
                for (int x = 0; x < StringArray.characters2.length; x++) {
                    if (StringArray.characters2[x] != "") {
                        PracticeRangeArray[hk_amount] = StringArray.characters2[x];
                        PracticeRangeArrayAns[hk_amount] = StringArray.pinyin[x];
                        hk_amount += 1;
                    }
                }
                if (UserTotalSlectNumber == 40){
                    UserTotalSlectNumber = 92 ;
                }
                break;
        }
       ansBut[1] = (Button) findViewById(R.id.practice_button1);
        ansBut[2] = (Button) findViewById(R.id.practice_button2);
        ansBut[3] = (Button) findViewById(R.id.practice_button3);
        ansBut[4] = (Button) findViewById(R.id.practice_button4);
        ansBut[5] = (Button) findViewById(R.id.practice_button5);
        ansBut[6] = (Button) findViewById(R.id.practice_button6);
        TopicView = (TextView) findViewById(R.id.Topic) ;
        NumberofQuestion = (TextView) findViewById(R.id.Numberofquestions) ;
        for (int i = 1 ;i<7 ;i++){
            ansBut[i].setTransformationMethod(null);
        }
        TopicView.setTextSize(50);
        NumberofQuestion.setTextSize(30);
        TopicRandom();
        TopicChange();



    }
    public void TopicChange(){
        if((NowTopicNumber+1) <= UserTotalSlectNumber) {
            TopicView.setText(PracticeRangeArray[RandomTopic[NowTopicNumber]]);

            String NumberofQuestionText;
            Integer NowTopicNumberAdd = NowTopicNumber + 1;
            String nownumber = NowTopicNumberAdd.toString();
            String total = UserTotalSlectNumber.toString();
            NumberofQuestionText = nownumber + "/" + total;
            NumberofQuestion.setText( NumberofQuestionText);
            AnsRandomOptionChange();
        }
        else{
            Intent intent = new Intent();
            intent.setClass(Practice_Activity.this, Practice_dialog.class);
            startActivity(intent);
            finish();
        }

    }
    public void AnsRandomOptionChange(){
        correct = (int) (Math.random()*6)+1 ;
        int rnd ;
        int errorAns[] = new int[5];
        HashSet intHash = new HashSet<String>();
        intHash.add(PracticeRangeArrayAns[RandomTopic[NowTopicNumber]]);
        ansBut[correct].setText(PracticeRangeArrayAns[RandomTopic[NowTopicNumber]]);
       for (int i = 0 ;i <5;i++){
           rnd = (int) (Math.random()*RandomAmount);
           while(!intHash.add(PracticeRangeArrayAns[RandomTopic[rnd]])) {
               rnd = (int) (Math.random() * RandomAmount);
           }
           intHash.add(PracticeRangeArrayAns[RandomTopic[rnd]]) ;
           errorAns[i] = rnd ;
       }
        int k = 0 ;
        for (int i = 1;i < 7;i++){
            ansBut[i].setEnabled(true);
            if (i != correct){
                ansBut[i].setText(PracticeRangeArrayAns[RandomTopic[errorAns[k]]]);
                k = k +1 ;
            }
        }


    }
    public void TopicRandom(){
        int rndInt ;
        HashSet intHash = new HashSet<Integer>();
        NowTopicNumber = 0 ;
        for (int i = 0; i<RandomAmount;i++){
            rndInt = (int) (Math.random()*RandomAmount);
            while(!intHash.add(rndInt)){
                rndInt = (int) (Math.random()*RandomAmount);
            }
            RandomTopic[i] = rndInt ;
        }
    }
    public void AnsCheck(int buttonId) {
       if(buttonId == correct){
           NowTopicNumber +=1 ;
           TopicChange();
       }
        else
       {

           ansBut[buttonId].setEnabled(false);
       }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practice_activity, menu);
        return true;
    }
    public void ButtonClicked(View v){
       switch(v.getId()){
           case R.id.practice_button1:
               AnsCheck(1);
               break;
           case R.id.practice_button2:
               AnsCheck(2);
               break;
           case R.id.practice_button3:
               AnsCheck(3);
               break;
           case R.id.practice_button4:
               AnsCheck(4);
               break;
           case R.id.practice_button5:
               AnsCheck(5);
               break;
           case R.id.practice_button6:
               AnsCheck(6);
               break;


       }
    }
}


