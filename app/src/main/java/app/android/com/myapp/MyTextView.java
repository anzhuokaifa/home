package app.android.com.myapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/8/30 0030.
 */

public class MyTextView extends View {
    private String text;
    private int textColor;
    private float textSize;
    private TypedArray typedArray;

    public MyTextView(Context context) {
        super(context);
        initAttr(null);
    }



    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttr(attrs);
    }
    private void initAttr(@Nullable AttributeSet attrs) {
        typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.MyTextView);
        text = typedArray.getString(R.styleable.MyTextView_text);
        textSize = typedArray.getDimension(R.styleable.MyTextView_textSize,16);
        textColor = typedArray.getColor(R.styleable.MyTextView_textColor, 0xffffff);
    }
    //绘画
    //画  canvas画布
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setTextSize(textSize);
        paint.setColor(textColor);
        canvas.drawText(text,10,100,paint);
    }

}
