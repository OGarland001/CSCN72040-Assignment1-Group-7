package com.ctrlaltdefeatA01;

public class Data {
	double x;
	double y;
	double z;
	int orientation;
	
	//This is a data default constructor
	public Data() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
		this.orientation = 0;
	}
	//parameterized Data constructor. 
	public Data(double x, double y, double z, int orientation) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.orientation = orientation;
	}
	//Data copy constructor
	public Data(Data data) { // copy constructor
		this.x = data.x;
		this.y = data.y;
		this.z = data.z;
		this.orientation = data.orientation;
	}
	//This is a getter that can get the x value of the phone 
	public double getX() {
		return x;
	}
	//This is a getter that can get the x value of the phone 
	public void setX(double x) {
		this.x = x;
	}
	//This is a getter that can get the y value of the phone 
	public double getY() {
		return y;
	}
	//This is a setter that can set the y value of the data set
	public void setY(double y) {
		this.y = y;
	}
	//This is a getter that can get the z value of the phone
	public double getZ() {
		return z;
	}
	//This is a setter that can set the z value of the data set
	public void setZ(double z) {
		this.z = z;
	}
	//This is a getter that can get the orientation of the phone using a classifier 
	public int getOrientation() {
		return orientation;
	}
	//This is a setter that can set the orientation value of the data set
	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}
	//This is the equals method, sets the current object equal to parameter object
	public void equals(Data data) {
		this.x = data.x;
		this.y = data.y;
		this.z = data.z;
		this.orientation = data.orientation;
		
	}
	
	//This is a find distance function that will calculate the distance between two data points
	/// This function is overridden from the classifier class
	public double findDistance(Data point2) {
		return Math.sqrt((Math.pow(point2.getX() - this.getX(), 2)) + (Math.pow(point2.getY() - this.getY(), 2)) + (Math.pow(point2.getZ() - this.getZ(), 2)));
	}
	
}


