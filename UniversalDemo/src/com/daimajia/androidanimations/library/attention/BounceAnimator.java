package com.daimajia.androidanimations.library.attention;

import android.animation.ObjectAnimator;
import android.view.View;

import com.daimajia.androidanimations.library.BaseViewAnimator;

/**
 * Created by daimajia on 14-6-21.
 */
public class BounceAnimator extends BaseViewAnimator {
    @Override
    public void prepare(View target) {
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target,"translationY",0,0,-30,0,-15,0,0)
        );
    }
}
