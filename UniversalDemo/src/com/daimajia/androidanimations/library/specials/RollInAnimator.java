package com.daimajia.androidanimations.library.specials;

import android.animation.ObjectAnimator;
import android.view.View;

import com.daimajia.androidanimations.library.BaseViewAnimator;

/**
 * Created by daimajia on 14-6-22.
 */
public class RollInAnimator extends BaseViewAnimator {
    @Override
    protected void prepare(View target) {
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target,"alpha",0,1),
                ObjectAnimator.ofFloat(target,"translationX",-(target.getWidth()-target.getPaddingLeft() - target.getPaddingRight()),0),
                ObjectAnimator.ofFloat(target,"rotation",-120,0)
        );
    }
}
