package com.daimajia.androidanimations.library.rotating_entrances;

import android.animation.ObjectAnimator;
import android.view.View;

import com.daimajia.androidanimations.library.BaseViewAnimator;

/**
 * Created by daimajia on 14-6-21.
 */
public class RotateInAnimator extends BaseViewAnimator {
    @Override
    public void prepare(View target) {
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target, "rotation", -200, 0),
                ObjectAnimator.ofFloat(target, "alpha", 0, 1)
        );
    }
}
