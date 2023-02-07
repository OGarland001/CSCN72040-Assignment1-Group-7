package com.ctrlaltdefeatA01;
import java.security.PublicKey;
import java.util.Random;
import java.util.random.*;


class NearestNeighbor implements Classifer
{
	
	private Node headOfList;
	
	

	//This is a AnotherClassifiers constructor
	public NearestNeighbor() {
		
		
		headOfList = null;
	} 
		// Print out what the constructor is doing
		
	
	
	//This is a classify method that will classify a phone orientation
	//This is an overridden method that implements the NearestNeighbor version of classify
	@Override
	public int classify(Data givenData) {
		int orientation = 0;
		double distance = 0.0;
		
		double shortestDistance = Double.MAX_VALUE;
		Node currentNode = headOfList;
		
		while(currentNode != null)
		{
			//find distance between data and current node
			distance = findDistance(givenData, currentNode.point);
			
			//check to see if the points are the same
			if(shortestDistance == distance)
			{
				//Generate a random number between 0 and 1 to determine nearest point if point distance are the same 
				Random rand = new Random();
				int upperLimit = 1;
				int randomNum = rand.nextInt(upperLimit);
				
				if(randomNum == 1)
				{
					//Save the determined closet point 
					shortestDistance = distance;
					orientation = currentNode.point.getOrientation();
				}
				//Otherwise we use the current point
			}
			//check to see if the distance is shorter than the shortest distance
			else if(shortestDistance > distance)
			{
				shortestDistance = distance;
				orientation = currentNode.point.getOrientation();
				
			}
		    currentNode = currentNode.nextNode();
		}
		
		return orientation;
	}

	//This is a classify file method that will classify phone orientations in a given file
	//This is an overridden method that implements the anotherClassifer version of train
	@Override
	public void train() {
		//open the training file 
		Input newFile;
		newFile.setFilename("trainingData.txt");
		//save the head of this list for later
		headOfList = newFile.ReadData();
	}

	//This is a classify file method that will classify phone orientations in a given file	
	//This is an overridden method that implements the anotherClassifer version of classifyFile
	@Override
	public void classifyFile(String filename) {
		//read all the points in from a file
		Input newFile;
		newFile.setFilename(filename);
		Node currentListNode = newFile.ReadData();
		int tempStoreOrientation = 0;
		Output saveFile;
		saveFile.setFilename(filename);
		//ensure to clear the file before writing to it
		saveFile.ClearFile();
		//loop through our list of data and save the points 
		while (currentListNode != null)
		{
			//classify the orientation
			tempStoreOrientation = classify(currentListNode.point);
			//save the orientation
			currentListNode.point.setOrientation(tempStoreOrientation);
			saveFile.WriteAllData(currentListNode.point);
			currentListNode = currentListNode.nextNode;
		}
	}
}