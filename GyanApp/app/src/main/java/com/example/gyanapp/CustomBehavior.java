package com.example.gyanapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.support.v7.widget.Toolbar;

public class CustomBehavior extends CoordinatorLayout.Behavior<Toolbar> {
    public CustomBehavior(Context cxt, AttributeSet attributeSet){
        super(cxt,attributeSet);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull Toolbar child, @NonNull View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull Toolbar child, @NonNull View dependency) {
        Log.d("Suresh","1213");
        return true;
    }
}
