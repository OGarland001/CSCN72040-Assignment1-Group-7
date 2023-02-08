package com.ctrlaltdefeatA01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class KNearestNeighbor implements Classifer{
	private LinkedList<Data> list;

	
	//This is a AnotherClassifiers constructor
	public KNearestNeighbor() {
		this.list = new LinkedList<Data>();
	}
	
	public void addDataItem(Data data) {
		this.list.add(data);
	}

	@Override
	public int classify(Data givenData) {
		// TODO Auto-generated method stub
		
		//KNN nearest neighbor algorithm.
		
		//calculates all the distances from the given data point.
		//and adds them to a double list.
		List<Double> pointDistances = new ArrayList<>();
		
		for(int i = 0; i < this.list.size(); i++) {
			pointDistances.add(this.list.get(i).findDistance(givenData));
		}
		
		System.out.println(pointDistances);
	
		
		//Pick the K nearest ones and let them "vote" on the correct classification.
		
		
		return 0;
	}

	@Override
	public void classifyFile(String filenameString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void train() {
		// TODO Auto-generated method stub
		
	}
	
	
	 
}
