package com.vinh.radiuscollection;

import java.util.Random;

public class Circle {
	public int radius;
	public float area;
	private static final float  PI = 3;
	public int index;

	public int getRadius() {
		return radius;
	}
	
	public int getIndex() {
		return index;
	}
	
	public float getArea() {
		return area;
	}
	
	public void setRandomRadius(int maxRadius) {
		Random random = new Random();
		this.radius = random.nextInt(maxRadius);
	}
	
	public Circle(int maxRadius, int circleIndex) {
		Random random = new Random();
		this.radius = random.nextInt(maxRadius);
		this.index = circleIndex;
		this.area = radius * radius * PI;
	}
	
	public Circle() {
	}

}