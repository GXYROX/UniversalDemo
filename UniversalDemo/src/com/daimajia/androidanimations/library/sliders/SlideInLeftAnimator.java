package com.daimajia.androidanimations.library.sliders;

import android.animation.ObjectAnimator;
import android.view.View;

import com.daimajia.androidanimations.library.BaseViewAnimator;

/**
 * Created by daimajia on 14-6-22.
 */
public class SlideInLeftAnimator extends BaseViewAnimator{
    @Override
    protected void prepare(View target) {
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target, "alpha", 0, 1),
                ObjectAnimator.ofFloat(target,"translationX",-2000,0)
        );
    }
}
