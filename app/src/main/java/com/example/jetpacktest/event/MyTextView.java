package com.example.jetpacktest.event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * 描述信息：
 *
 * @author xuyu
 * @date 2020/3/6
 */
public class MyTextView extends androidx.appcompat.widget.AppCompatTextView {
    public static final String TAG = "MyTextView";

    public MyTextView(Context context) {
        super(context);
        Log.d(TAG, "MyTextView: 1");
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "MyTextView: 2");
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d(TAG, "MyTextView: 3");
    }
}
