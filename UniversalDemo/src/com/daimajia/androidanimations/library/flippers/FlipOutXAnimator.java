package com.daimajia.androidanimations.library.flippers;

import android.animation.ObjectAnimator;
import android.view.View;

import com.daimajia.androidanimations.library.BaseViewAnimator;

/**
 * Created by daimajia on 14-6-21.
 */
public class FlipOutXAnimator extends BaseViewAnimator {
    @Override
    public void prepare(View target) {
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target, "rotationX", 0, 90),
                ObjectAnimator.ofFloat(target, "alpha", 1, 0)
        );
    }
}
