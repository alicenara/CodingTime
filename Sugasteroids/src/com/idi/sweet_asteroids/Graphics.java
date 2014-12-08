package com.idi.sweet_asteroids;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

public class Graphics {

	private Drawable drawable; //El que dibuixarem
	private double posX, posY; //Posició
	private double incX, incY; //Velocitat
	private int angle, rotation; //Angle i velocitat de rotació
	private int width, height; //Ample i alçada
	private int radius_collision; //Per saber a quin radi estarà la col·lisió
	private View mainView; //Vista principal
	public static final int MAX_VEL = 10;
	
	public Graphics (View view, Drawable drawable){
		this.mainView = view;
		this.drawable = drawable;
		this.width = drawable.getIntrinsicWidth();
		this.height = drawable.getIntrinsicHeight();
		this.radius_collision = (this.width + this.height)/4;
	}
	
	public void drawGraphic (Canvas canvas){
		canvas.save();
		int x = (int) (posX + width/2);
		int y = (int) (posY + height/2);
		canvas.rotate ((float) angle, (float) x, (float) y);
		drawable.setBounds((int) posX, (int) posY, (int) posX+width, (int) posY+height);
		drawable.draw(canvas);
		canvas.restore();
		int rInval = (int) distanceE(0,0,width,height)/2+MAX_VEL;
		mainView.invalidate(x-rInval, y-rInval, x+rInval, y+rInval);
	}
	
	public static double distanceE (double x, double y, double x2, double y2){
		return Math.sqrt((x-x2)*(x-x2) + (y-y2)*(y-y2));
	}
	
	public double distance(Graphics g){
		return distanceE(posX, posY, g.posX, g.posY);
	}
	
	public boolean verifyCollision(Graphics g){
		return (distance(g) < (radius_collision+g.radius_collision));
	}
	
	public void incrementPos(){
		posX += incX;
		
		if(posX <= width/2){
			posX = mainView.getWidth() - width/2;
		}
		if(posX > mainView.getWidth() - width/2){
			posX = -width/2;
		}
		
		posY += incY;
		
		if(posY <= height/2){
			posY = mainView.getHeight() - height/2;
		}
		if(posY > mainView.getHeight() - height/2){
			posY = -height/2;
		}
		angle += rotation;
	}

	public Drawable getDrawable() {
		return drawable;
	}

	public void setDrawable(Drawable drawable) {
		this.drawable = drawable;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public double getIncX() {
		return incX;
	}

	public void setIncX(double incX) {
		this.incX = incX;
	}

	public double getIncY() {
		return incY;
	}

	public void setIncY(double incY) {
		this.incY = incY;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getRadius_collision() {
		return radius_collision;
	}

	public void setRadius_collision(int radius_collision) {
		this.radius_collision = radius_collision;
	}

	public View getMainView() {
		return mainView;
	}

	public void setMainView(View mainView) {
		this.mainView = mainView;
	}
}
