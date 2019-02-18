package com.example.balaji.countdowntimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private EditText txt;
    private int value ;
    private CountDownTimer timer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.time);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null){

            value = savedInstanceState.getInt("value") ;
       }


    }

    View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            try {
                value = Integer.parseInt(txt.getText().toString());

                timer = new MyCountDownTimer(value) ;
                timer.start() ;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };


    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putInt("value",value);

        super.onSaveInstanceState(outState);

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        value = savedInstanceState.getInt("value") ;

        timer = new MyCountDownTimer(value);
        timer.start();

    }



    public class MyCountDownTimer extends CountDownTimer{

        public MyCountDownTimer(int start) {
            super((start+1)*1000, 1000);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            txt.setText(String.valueOf(value--));
        }

        @Override
        public void onFinish() {

        }

    }


}
