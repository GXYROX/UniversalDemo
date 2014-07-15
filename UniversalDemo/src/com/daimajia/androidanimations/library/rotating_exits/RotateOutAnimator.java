package com.daimajia.androidanimations.library.rotating_exits;

import android.animation.ObjectAnimator;
import android.view.View;

import com.daimajia.androidanimations.library.BaseViewAnimator;

/**
 * Created by daimajia on 14-6-22.
 */
public class RotateOutAnimator extends BaseViewAnimator {
    @Override
    protected void prepare(View target) {
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target,"alpha",1,0),
                ObjectAnimator.ofFloat(target,"rotation",0,200)
        );
    }
}
