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
			pointDistances.add(i ,this.list.get(i).findDistance(givenData));
		}
		
		

		
		  int n = list.size();  
	        
	        int k = 5;
	        double temp = 0;
	         for(int i=0; i < n; i++){  
	                 for(int j=1; j < (n-i); j++){  
	                	 
	                          if(pointDistances.get(j-1) > pointDistances.get(j)){
	                        	  Data tempData = new Data();
	                        	  
	                        	  
	                                 //swap elements in point distances
	                                 temp = pointDistances.get(j-1);  
	                                 pointDistances.set(j-1, pointDistances.get(j));  
	                                 pointDistances.set(j, temp);  
	                                 
	                                 //swap data items.
	                                 tempData = list.get(j-1);  
	                                 list.set(j-1,list.get(j));  
	                                 list.set(j, tempData); 
	                         } 
	                          
	                 }  
	         }
	
	         
	     	
		//Pick the K nearest ones and let them "vote" on the correct classification.
		int fuCount = 0, fdCount = 0, portCount = 0, portSDCount = 0, landLeft = 0, LandRight = 0, no = 0;
	    for(int c = 0; c < k; c++) {
	    	int orientation = list.get(c).getOrientation();
	    	
	    	if(orientation == 1) {
	    		fuCount++;
	    		System.out.println("face up incremented");
	    	}else if(orientation == 2) {
	    		fdCount++;
	    		System.out.println("face down incremented");
	    	}else if(orientation == 3) {
	    		portCount++;
	    		System.out.println("portrate face intrmented");
	    	}else if(orientation == 4) {
	    		portSDCount++;
	    		System.out.println("portrate side down intrmented");
	    	}else if(orientation == 5) {
	    		landLeft++;
	    		System.out.println("landscape left intrmented");
	    	}else if(orientation == 6) {
	    		LandRight++;
	    		System.out.println("landscape right face intrmented");
	    	}else {
	    		no++;
	    		System.out.println("Nothing");
	    	}
			
		}
	    
	    if(fuCount > fdCount && fuCount > portCount && fuCount > portSDCount && fuCount > landLeft && fuCount > LandRight && fuCount > no) {
	    	return 1;
	    }else if(fdCount > fuCount && fdCount > portCount && fdCount > portSDCount && fdCount > landLeft && fdCount > LandRight && fdCount > no) {
	    	return 2;
	    }else if(portCount > fuCount && portCount > fdCount && portCount > portSDCount && portCount > landLeft && portCount > LandRight && portCount > no) {
	    	return 3;
	    }else if(portSDCount > fuCount && portSDCount > fdCount && portSDCount > portCount && portSDCount > landLeft && portSDCount > LandRight && portSDCount > no) {
	    	return 4;
	    }else if(landLeft > fuCount && landLeft > fdCount && landLeft > portCount && landLeft > portSDCount && landLeft > LandRight && landLeft > no) {
	    	return 5;
	    }else if(LandRight > fuCount && LandRight > fdCount && LandRight > portCount && LandRight > portSDCount && LandRight > landLeft && LandRight > no) {
	    	return 6;
	    }else if(no > fuCount && no > fdCount && no > portCount && no > portSDCount && no > landLeft &&  no > LandRight) {
	    	return -1;
	    }else return 0;
		
	       
}
	         
	@Override
	public void classifyFile(String filenameString) {
		//read all the points in from a file
		Input newFile = new Input();
		
		newFile.setFileName(filenameString);
		
		LinkedList<Data> currentListNode = newFile.ReadData();
		
		int tempStoreOrientation = 0;
		
		Output saveFile = new Output();
		
		saveFile.setFileName("result.txt");
		//ensure to clear the file before writing to it
		saveFile.ClearFile();
		int i = 0;
		boolean canContinue = true;
		boolean hasTripped = false;
		//loop through our list of data and save the points 
		do
		{
			//classify the orientation
			tempStoreOrientation = classify(currentListNode.get(i));
			//save the orientation
			currentListNode.get(i).setOrientation(tempStoreOrientation);
			saveFile.WriteAllData(currentListNode.get(i));
			i++;
			//determine if we can continue looping
			if(hasTripped == true)
			{
				canContinue = false;
			}
			else if(currentListNode.get(i) == currentListNode.getLast() && !hasTripped)
			{
				//Use the has tripped to loop 1 time past the loop condition
				hasTripped = true;
			}
		}while(canContinue);
		
	}

	@Override
	public void train() {
		
		//open the training file 
		Input newFile = new Input();
		newFile.setFileName("trainingData.txt");
		//save the head of this list for later
		list = newFile.ReadData();
		
	}
	
	
	 
}