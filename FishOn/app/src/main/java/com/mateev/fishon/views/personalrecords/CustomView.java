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
    private static final int PAINTER_COLOR_RED = 234;
    private static final int PAINTER_COLOR_GREEN = 79;
    private static final int PAINTER_COLOR_BLUE = 45;
    private static final int PAINTER_TEXT_SIZE = 150;
    private static final int PAINTER_STROKE_WIDTH = 6;
    private static final int CANVAS_START_X = 350;
    private static final int CANVAS_START_Y = 500;
    private static final int RECT_START = 150;
    private static final int RECT_END_X = 800;
    private static final int RECT_END_Y = 600;
    private static final int DEFAULT_STYLE = 0;
    private Paint mPainter = new Paint();
    private Rect mRect;
    private String mSpeciesNameToDraw;

    public CustomView(Context context) {
        super(context);
        init(null, DEFAULT_STYLE);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, DEFAULT_STYLE);
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
        mPainter.setTextSize(PAINTER_TEXT_SIZE);
        canvas.drawText(mSpeciesNameToDraw, CANVAS_START_X, CANVAS_START_Y, mPainter);
    }

    void setSpeciesNameToDraw(String speciesName) {
        mSpeciesNameToDraw = speciesName;
    }

    private void init(AttributeSet set, int defStyle) {

        mPainter.setColor(Color.rgb(PAINTER_COLOR_RED, PAINTER_COLOR_GREEN, PAINTER_COLOR_BLUE));
        mPainter.setAntiAlias(true);
        mPainter.setStyle(Paint.Style.STROKE);
        mPainter.setStrokeWidth(PAINTER_STROKE_WIDTH);
        mRect = new Rect();
        mRect.left = RECT_START;
        mRect.top = RECT_START;
        mRect.right = (mRect.left + RECT_END_X);
        mRect.bottom = (mRect.top + RECT_END_Y);

    }
}
