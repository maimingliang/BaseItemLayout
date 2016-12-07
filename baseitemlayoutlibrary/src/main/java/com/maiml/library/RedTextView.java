package com.maiml.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

import com.maiml.baseitemlayoutlibrary.R;
import com.maiml.library.utils.DensityUtil;


/**
 * Created by maimingliang on 2016/11/23.
 */

public class RedTextView extends TextView{

    private String badgeCount = "0";
    private Paint badgerPaint;
    private int badgerBgColor, badgerTextColor;
    private int badgerMargin = 0, badgerPadding = 0;
    private int textHeight = 0;
    private float strokeWidth = 1;
    private int xFolat = 68;
    private int yFolat = 10;
    public RedTextView(Context context) {
        super(context);
        init(context, null);
    }

    public RedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RedTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        badgerPaint = new Paint();
        badgerPaint.setAntiAlias(true);
        badgerPaint.setStyle(Paint.Style.FILL);
        badgerPaint.setTextAlign(Paint.Align.CENTER);


            badgerPaint.setTextSize(DensityUtil.sp2px(context,8));
            badgerTextColor = 0xFFFFFFFF;
            badgerBgColor = Color.RED;
            badgerMargin = DensityUtil.dip2px(context,2);
            badgerPadding = DensityUtil.dip2px(context,6);

        textHeight = getTextHeight(badgerPaint);
        strokeWidth = getResources().getDisplayMetrics().density * strokeWidth + 0.5f;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (!"0".equals(badgeCount)) {
            badgerPaint.setTypeface(Typeface.DEFAULT);
            String countStr = String.valueOf(badgeCount);
            float textWidth = badgerPaint.measureText("88");
            float bgRadius = badgerPadding + textWidth / 2;

             //画徽章背景圆
            badgerPaint.setColor(badgerBgColor);
            float cx = canvas.getWidth() - badgerMargin - bgRadius-xFolat;
            float cy = badgerMargin + bgRadius-yFolat;
            canvas.drawCircle(cx, cy, bgRadius, badgerPaint);
            //画徽章背景圆描边
            badgerPaint.setColor(badgerTextColor);
            badgerPaint.setStyle(Paint.Style.STROKE);
            badgerPaint.setStrokeWidth(strokeWidth);
            canvas.drawCircle(cx, cy, bgRadius, badgerPaint);
            //画徽章数字
            badgerPaint.setStyle(Paint.Style.FILL);
            badgerPaint.setTypeface(Typeface.DEFAULT_BOLD);
            canvas.drawText(countStr, cx, cy + textHeight / 3, badgerPaint);
        }

    }
    public void setBadgeCount(String count) {
        this.badgeCount = count;
        invalidate();
    }

    /**
     * 获取指定画笔的文字高度
     */
    private int getTextHeight(Paint paint) {
        Paint.FontMetrics fm = paint.getFontMetrics();
        return (int) Math.ceil(fm.descent - fm.ascent);
    }

}
