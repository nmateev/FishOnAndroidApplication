package com.mateev.fishon.views.personalrecords;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {
    private Paint mPainter = new Paint();
    private Rect mRect;
    private String mSpeciesNameToDraw;

    public CustomView(Context context) {
        super(context);
        init(null, 0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(mRect, mPainter);
        mPainter.setTextSize(150);
        canvas.drawText(mSpeciesNameToDraw, 350, 500, mPainter);
    }

    void setSpeciesNameToDraw(String speciesName) {
        mSpeciesNameToDraw = speciesName;
    }

    private void init(AttributeSet set, int defStyle) {

        mPainter.setColor(Color.rgb(234, 79, 45));
        mPainter.setAntiAlias(true);
        mPainter.setStyle(Paint.Style.STROKE);
        mPainter.setStrokeWidth(6);
        mRect = new Rect();
        mRect.left = 150;
        mRect.top = 150;
        mRect.right = (mRect.left + 800);
        mRect.bottom = (mRect.top + 600);

    }
}
