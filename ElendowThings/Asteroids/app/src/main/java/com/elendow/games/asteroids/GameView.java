package com.elendow.games.asteroids;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.View;

public class GameView extends View{
    private SurfaceHolder holder;

    Paint paint = new Paint();

    float speedX = 5;
    float speedY = 2;

    float posX = 50;
    float posY = 50;

    float radius = 20;

    public GameView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas){
        updateAll();
        drawAll(canvas);
    }

    public void updateAll(){
        posX += speedX;
        posY += speedY;

        if(posX + radius >= getWidth() || posX - radius <= 0) speedX *= -1;
        if(posY + radius >= getHeight() || posY - radius <= 0) speedY *= -1;
    }

    public void drawAll(Canvas canvas) {
        //Clear
        canvas.drawColor(Color.BLACK);

        //Draw
        paint.setColor(Color.RED);
        canvas.drawCircle(posX, posY, radius, paint);
    }
}