package com.kamchur.lotto;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;

public class Load extends Dialog {
    public Load(@NonNull Context context) {
        super(context);
    }

    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.progressbar);
        setCancelable(false);
        setCanceledOnTouchOutside(false);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.progress_anim);
        progressBar.startAnimation(anim);

    }



}
