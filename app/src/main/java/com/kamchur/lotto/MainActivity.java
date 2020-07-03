package com.kamchur.lotto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String TAG = "[MainActivity]";

    Load load;  //ProgressBar Event Motion
    Button luckyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO : 버튼 누름시 약 3초간 동그란 프로그레스바 동작
        load = new Load(MainActivity.this);

        luckyButton = (Button) findViewById(R.id.luckyButton);
        luckyButton.setOnClickListener(clickListener);
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
}
