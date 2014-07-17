/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 daimajia
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.daimajia.easing.library;

import com.daimajia.easing.library.back.BackEaseIn;
import com.daimajia.easing.library.back.BackEaseInOut;
import com.daimajia.easing.library.back.BackEaseOut;
import com.daimajia.easing.library.bounce.BounceEaseIn;
import com.daimajia.easing.library.bounce.BounceEaseInOut;
import com.daimajia.easing.library.bounce.BounceEaseOut;
import com.daimajia.easing.library.circ.CircEaseIn;
import com.daimajia.easing.library.circ.CircEaseInOut;
import com.daimajia.easing.library.circ.CircEaseOut;
import com.daimajia.easing.library.cubic.CubicEaseIn;
import com.daimajia.easing.library.cubic.CubicEaseInOut;
import com.daimajia.easing.library.cubic.CubicEaseOut;
import com.daimajia.easing.library.elastic.ElasticEaseIn;
import com.daimajia.easing.library.elastic.ElasticEaseOut;
import com.daimajia.easing.library.expo.ExpoEaseIn;
import com.daimajia.easing.library.expo.ExpoEaseInOut;
import com.daimajia.easing.library.expo.ExpoEaseOut;
import com.daimajia.easing.library.linear.Linear;
import com.daimajia.easing.library.quad.QuadEaseIn;
import com.daimajia.easing.library.quad.QuadEaseInOut;
import com.daimajia.easing.library.quad.QuadEaseOut;
import com.daimajia.easing.library.quint.QuintEaseIn;
import com.daimajia.easing.library.quint.QuintEaseInOut;
import com.daimajia.easing.library.quint.QuintEaseOut;
import com.daimajia.easing.library.sine.SineEaseIn;
import com.daimajia.easing.library.sine.SineEaseInOut;
import com.daimajia.easing.library.sine.SineEaseOut;


public enum  Skill {

    BackEaseIn(BackEaseIn.class),
    BackEaseOut(BackEaseOut.class),
    BackEaseInOut(BackEaseInOut.class),

    BounceEaseIn(BounceEaseIn.class),
    BounceEaseOut(BounceEaseOut.class),
    BounceEaseInOut(BounceEaseInOut.class),

    CircEaseIn(CircEaseIn.class),
    CircEaseOut(CircEaseOut.class),
    CircEaseInOut(CircEaseInOut.class),

    CubicEaseIn(CubicEaseIn.class),
    CubicEaseOut(CubicEaseOut.class),
    CubicEaseInOut(CubicEaseInOut.class),

    ElasticEaseIn(ElasticEaseIn.class),
    ElasticEaseOut(ElasticEaseOut.class),

    ExpoEaseIn(ExpoEaseIn.class),
    ExpoEaseOut(ExpoEaseOut.class),
    ExpoEaseInOut(ExpoEaseInOut.class),

    QuadEaseIn(QuadEaseIn.class),
    QuadEaseOut(QuadEaseOut.class),
    QuadEaseInOut(QuadEaseInOut.class),

    QuintEaseIn(QuintEaseIn.class),
    QuintEaseOut(QuintEaseOut.class),
    QuintEaseInOut(QuintEaseInOut.class),

    SineEaseIn(SineEaseIn.class),
    SineEaseOut(SineEaseOut.class),
    SineEaseInOut(SineEaseInOut.class),

    Linear(Linear.class);


    private Class easingMethod;

    private Skill(Class clazz) {
        easingMethod = clazz;
    }

    public BaseEasingMethod getMethod(float duration) {
        try {
            return (BaseEasingMethod)easingMethod.getConstructor(float.class).newInstance(duration);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("Can not init easingMethod instance");
        }
    }
}
