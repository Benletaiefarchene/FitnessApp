package com.elgindy.Fitness_App;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    String buttonvalue;
    Button startbtn;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MTimeRunnig;
    private long MtimeLeftinmills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        Intent intent=getIntent();
        buttonvalue = intent.getStringExtra("value");

        int intvalue = Integer.valueOf(buttonvalue);

        switch (intvalue){




            case 1:
                setContentView(R.layout.activity_ex1);
                break;
            case 2:
                setContentView(R.layout.activity_ex2);
                break;
            case 3:
                setContentView(R.layout.activity_ex3);
                break;
            case 4:
                setContentView(R.layout.activity_ex4);
                break;
            case 5:
                setContentView(R.layout.activity_ex5);
                break;
            case 6:
                setContentView(R.layout.activity_ex6);
                break;
            case 7:
                setContentView(R.layout.activity_ex7);
                break;
            case 8:
                setContentView(R.layout.activity_ex8);
                break;
            case 9:
                setContentView(R.layout.activity_ex9);
                break;
            case 10:
                setContentView(R.layout.activity_ex10);
                break;
            case 11:
                setContentView(R.layout.activity_ex11);
                break;
            case 12:
                setContentView(R.layout.activity_ex12);
                break;
            case 13:
                setContentView(R.layout.activity_ex13);
                break;
            case 14:
                setContentView(R.layout.activity_ex14);
                break;
            case 15:
                setContentView(R.layout.activity_ex15);
                break;

        }


        startbtn = findViewById(R.id.startbutton);
        mtextview = findViewById(R.id.time);



        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MTimeRunnig){

                      stoptimer();

                }
                else {

                     startTimer();
                }
            }
        });
    }

    private void stoptimer(){
        countDownTimer.cancel();
        MTimeRunnig=false;
        startbtn.setText("START");
    }

    private void startTimer(){

        final CharSequence value1 =mtextview.getText();
        String num1 = value1.toString();
        String num2 = num1.substring(0,2);
        String num3 = num1.substring(3,5);


        final int number = Integer.valueOf(num2)*60 + Integer.valueOf(num3);
        MtimeLeftinmills = number*1000;


        countDownTimer = new CountDownTimer(MtimeLeftinmills,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                MtimeLeftinmills = millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {


                int newvalue = Integer.valueOf(buttonvalue)+1;
                if(newvalue<=7){

                    Intent intent = new Intent(ThirdActivity.this,ThirdActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);

                }
                else {
                    newvalue = 1;
                    Intent intent= new Intent(ThirdActivity.this,ThirdActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }
            }
        }.start();
        startbtn.setText("Pause");
        MTimeRunnig=true;

    }


    private void updateTimer(){


        int minutes =(int) MtimeLeftinmills/60000;
        int seconds = (int) MtimeLeftinmills%60000/1000;


        String timeLeftText="";
        if(minutes<10)
            timeLeftText="0";
        timeLeftText=timeLeftText+minutes+":";
        if (seconds<10)
            timeLeftText+="0";
        timeLeftText+=seconds;
        mtextview.setText(timeLeftText);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}