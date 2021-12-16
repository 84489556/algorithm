package com.demo.algorithm.help;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;


/**
 * 初始顺序：1 onLayout，2 onDraw
 * 已经显示了：
 *          点击'显示'按钮：无反应
 *          点击'隐藏'按钮：不会重新执行onLayout 、onDraw
 * 现在不显示：
 *          invisible状态：点击gone 不会执行onlayout、onDraw
 *          invisble状态：点击visible，只会执行onDraw
 *          gone状态：点击invisible，会执行onlayout，不会执行onDraw
 *          gone状态：点击visible ，执行onlayout，onDraw
 *总结：
 *               调用visible的时候，如果上次调用的是invisible，就会只调用onLayout
 *               调用visible的时候，如果上次调用的是gone，就会调用onLayout 和 onDraw
 */
public class InVisibleView  extends TextView {
    public InVisibleView(Context context) {
        super(context);
    }

    public InVisibleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public InVisibleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public InVisibleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context,attrs,defStyleAttr);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d("InVisibleView","onLayout");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Log.d("InVisibleView","onDraw");

    }
}
