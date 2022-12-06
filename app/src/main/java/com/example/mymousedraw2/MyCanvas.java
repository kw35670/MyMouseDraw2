package com.example.mymousedraw2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class MyCanvas extends View {
    private Path path;
    private Paint paint;
    private MainActivity mainActivity;
    Button red_button,blue_button,green_button,black_button;
    private int lineColor;
    private int lineStrokeWidth;

    public MyCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        // 線を引いたり、図形を描いたり、要するにグラフィック
        path = new Path();

        // 筆
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 枠の描画
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawRect(20, 20, canvas.getWidth()-20, canvas.getHeight()-20, paint);
        // 線のレイアウト
        paint.setColor(lineColor);
        paint.setStyle(Paint.Style.STROKE);   // 輪郭
        paint.setStrokeWidth(lineStrokeWidth);
        canvas.drawPath(path, paint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 座標を取得（x座標、y座標）
        float x = event.getX();
        float y = event.getY();

        // タッチの処理
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return true;
    }

    // クリア処理
    public void clearCanvas(){
        path.reset();
        invalidate();
    }

    public void setLineColor(int LineColor) {
        this.lineColor = LineColor;
    }

    public void setLineStrokeWidth(int LineStrokeWidth) {
        this.lineStrokeWidth = LineStrokeWidth;
    }
}
