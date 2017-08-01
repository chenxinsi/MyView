package com.liangyu.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * Created by liangyu on 17-8-1.
 */

public class MyTextView extends View {

    private String mText;

    private int mTextColor;

    private int mTextsize;

    private Rect mBound;
    private Paint mPaint;

    private OnClickListener listener;

    public MyTextView(Context context) {
        super(context);
        initData();
        Log.d("xinsi","Context context");
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData();
        Log.d("xinsi","Context context  AttributeSet attrs");
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
        Log.d("xinsi","Context context  AttributeSet attrs int defStyleAttr");
    }

    private void initData(){
        mText = "chenxinsi";
        mTextColor = Color.BLACK;
        mTextsize = 50;

        mPaint = new Paint();
        mPaint.setTextSize(mTextsize);
        mPaint.setColor(mTextColor);

        mBound = new Rect();
        mPaint.getTextBounds(mText,0,mText.length(), mBound);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //测量多次而且不准确
        Log.d("xinsi","onMeasure");
        Log.d("xinsi","getMeasuredWidth: " + getMeasuredWidth());
        Log.d("xinsi","getMeasuredHeight: " + getMeasuredHeight());
    }

    @Override
    public void layout(@Px int l, @Px int t, @Px int r, @Px int b) {
        super.layout(l, t, r, b);
        Log.d("xinsi","layout");
        Log.d("xinsi","l: " + l + ", t: " + t +", r: " + r + ", b: " + b);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        Log.d("xinsi","changed: " + changed + "left: " + left + ", top: " + top + ",right: " + right + ",bottom :" + bottom);
        Log.d("xinsi","onLayout" + "height: " + getHeight() + "width: " + getWidth());
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d("xinsi","onDraw");
        canvas.drawText(mText, getWidth() / 2 - mBound.width() / 2,
                getHeight() / 2 + mBound.height() / 2, mPaint);
    }

    public void setOnClickListener(OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("xinsi1","ACTION_DOWN");

                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("xinsi1","ACTION_MOVE");

                break;
            case MotionEvent.ACTION_UP:
                Log.d("xinsi1","ACTION_UP");

                if((getX() - getScrollX()) <= ViewConfiguration.get(getContext()).getScaledTouchSlop()){
                    listener.click(getContext());
                }
                break;
        }
        return true;
    }

    public interface OnClickListener{
        void click(Context context);
    }
}
