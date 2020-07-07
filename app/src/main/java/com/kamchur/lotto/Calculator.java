package com.kamchur.lotto;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Calculator {

    private String testBranch = "test";

    private String TAG = "Calculator";

    private int[] num = {0,0,0,0,0,0,0};
    private boolean iterate = false;

    private int number=0;

    public List shake(){
        List<Integer> list = new ArrayList<Integer>(num.length);

        for(int i=0; i<7; i++){
            number = (int)(Math.random()*45)+1;
            Log.d(TAG, "number["+i+"] : " + number);

            for(int j=0; j<list.size(); j++){

                if(num[j] == number){
                    iterate = true;
                    break;
                }
            }

            if (iterate == true){
                i--;
                iterate = false;
                continue;
            }
            num[i] = number;
            list.add(num[i]);
        }
        return list;
    }
}
