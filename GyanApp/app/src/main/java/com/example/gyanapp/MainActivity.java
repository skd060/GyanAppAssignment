package com.example.gyanapp;

import android.animation.Animator;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class MainActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener{
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAppBarLayout = findViewById(R.id.app_bar_layout);
        mToolBar = findViewById(R.id.toolbar);
        mToolBar.setAlpha(0.0f);
        mAppBarLayout.addOnOffsetChangedListener(this);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        if(offset == 0){
            mToolBar.animate().alpha(0.0f).setInterpolator(new AccelerateInterpolator())
                    .setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            mToolBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
        }
        else{
            Log.d("GyanApp","offset "+offset);
            mToolBar.animate().alpha(1.0f).setInterpolator(new DecelerateInterpolator())
            .setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    Log.d("GyanApp","Animation started");
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    mToolBar.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }
    }
}
