package com.example.jetpacktest.event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 描述信息：
 *
 * @author xuyu
 * @date 2020/3/6
 */
public class MyFrameLayout extends android.widget.FrameLayout {
    public static final String TAG = "MyFrameLayout";

    public MyFrameLayout(@NonNull Context context) {
        super(context);
        Log.d(TAG, "MyFrameLayout: 1");
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "MyFrameLayout: 2");
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d(TAG, "MyFrameLayout: 3");
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Log.d(TAG, "MyFrameLayout: 4");
    }
}
