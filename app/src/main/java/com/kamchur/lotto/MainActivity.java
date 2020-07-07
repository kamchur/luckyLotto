package com.kamchur.lotto;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG = "[MainActivity]";

    Calculator cal;
    List list;

    Load load;  //ProgressBar Event Motion
    Button luckyButton;
    LinearLayout linearLayout;

    TextView num1;
    TextView num2;
    TextView num3;
    TextView num4;
    TextView num5;
    TextView num6;
    TextView num7;
    TextView testtest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO : 버튼 누름시 약 3초간 동그란 프로그레스바 동작
        load = new Load(MainActivity.this);
        cal =new Calculator();


        linearLayout = (LinearLayout)findViewById(R.id.allView);
        linearLayout.setBackgroundColor(Color.DKGRAY);
        
        luckyButton = (Button) findViewById(R.id.luckyButton);
        luckyButton.setOnClickListener(clickListener);

        num1 = (TextView) findViewById(R.id.num1);
        num2 = (TextView) findViewById(R.id.num2);
        num3 = (TextView) findViewById(R.id.num3);
        num4 = (TextView) findViewById(R.id.num4);
        num5 = (TextView) findViewById(R.id.num5);
        num6 = (TextView) findViewById(R.id.num6);
        num7 = (TextView) findViewById(R.id.num7);

    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.luckyButton:
                    Log.d(TAG , "LuckyButton Click()");
                    mHandler.sendEmptyMessage(Constant.MESSAGE_PROGRESS);
                    break;
            }
        }
    };

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case Constant.MESSAGE_PROGRESS:
                    load();
                    break;
                case Constant.MESSAGE_REQUEST:
                    result();
                    break;
                case Constant.MESSAGE_RESULT:
                    //TODO : result lotto Number
                    test();
                    break;
            }
        }
    };


    private void load(){
        Log.d(TAG, "Progress Load ===>");
        load.show();
        mHandler.sendEmptyMessageDelayed(Constant.MESSAGE_REQUEST, 3000);
    }

    private void result(){
        Log.d(TAG, "Lucky Number result Ready ===>");
        load.dismiss();
        mHandler.sendEmptyMessage(Constant.MESSAGE_RESULT);
    }

    private void test(){
        list = cal.shake();
        Log.d(TAG, "test...? size " + list.size());

        num1.setText("["+list.get(0).toString()+"]");
        num2.setText("["+list.get(1).toString()+"]");
        num3.setText("["+list.get(2).toString()+"]");
        num4.setText("["+list.get(3).toString()+"]");
        num5.setText("["+list.get(4).toString()+"]");
        num6.setText("["+list.get(5).toString()+"]");
        num7.setText("["+list.get(6).toString()+"]");
    }
}
