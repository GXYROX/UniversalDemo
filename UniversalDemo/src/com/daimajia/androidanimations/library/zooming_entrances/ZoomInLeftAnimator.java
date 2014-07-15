package com.daimajia.androidanimations.library.zooming_entrances;

import android.animation.ObjectAnimator;
import android.view.View;

import com.daimajia.androidanimations.library.BaseViewAnimator;

/**
 * Created by daimajia on 14-6-22.
 */
public class ZoomInLeftAnimator extends BaseViewAnimator {
    @Override
    protected void prepare(View target) {
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target, "scaleX", 0.1f, 0.475f, 1),
                ObjectAnimator.ofFloat(target,"scaleY",0.1f,0.475f,1),
                ObjectAnimator.ofFloat(target,"translationX",-2000,48,0),
                ObjectAnimator.ofFloat(target,"alpha",0,1,1)
        );
    }
}
