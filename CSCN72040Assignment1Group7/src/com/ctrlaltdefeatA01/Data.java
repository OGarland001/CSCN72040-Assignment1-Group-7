package com.ctrlaltdefeatA01;

public class Data {
	double x;
	double y;
	double z;
	int orientation;
	
	public Data() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
		this.orientation = 0;
	}
	public Data(double x, double y, double z, int orientation) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.orientation = orientation;
	}
	public Data(Data data) { // copy constructor
		this.x = data.x;
		this.y = data.y;
		this.z = data.z;
		this.orientation = data.orientation;
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public int getOrientation() {
		return orientation;
	}
	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}
	
	public void equals(Data data) {
		this.x = data.x;
		this.y = data.y;
		this.z = data.z;
		this.orientation = data.orientation;
		
	}
	
	public double findDistance(Data point2) {
		return Math.sqrt((Math.pow(point2.getX() - this.getX(), 2)) + (Math.pow(point2.getY() - this.getY(), 2)) + (Math.pow(point2.getZ() - this.getZ(), 2)));
	}
	
}


