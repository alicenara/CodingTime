package com.idi.sweet_asteroids;

import java.util.Vector;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

public class GameView extends View{

	private Vector<Graphics> Asteroids;
	private int numAsteroids = 10;
	private int numFragments = 2;
	
	public GameView (Context context, AttributeSet attributes){
		super(context, attributes);
		Drawable drShip, drAsteroid, drMissile;
		drAsteroid = context.getResources().getDrawable(R.drawable.asteroid);
		Asteroids = new Vector<Graphics>();
		for (int i = 0; i < numAsteroids; i++){
			Graphics asteroid = new Graphics (this, drAsteroid);
			asteroid.setIncY(Math.random() * 4 - 2 );
			asteroid.setIncX(Math.random() * 4 - 2 );
			asteroid.setAngle((int)(Math.random() * 360));
			asteroid.setRotation((int)(Math.random() * 8 - 4));
			Asteroids.add(asteroid);
		}
	}
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh){
		super.onSizeChanged(w, h, oldw, oldh);
		for (Graphics asteroid:Asteroids){
			asteroid.setPosX(Math.random()*(w-asteroid.getWidth()));
			asteroid.setPosY(Math.random()*(w-asteroid.getHeight()));
		}
	}
	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		for (Graphics asteroid:Asteroids){
			asteroid.drawGraphic(canvas);
		}
	}
}
