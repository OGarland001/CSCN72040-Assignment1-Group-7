package com.ctrlaltdefeatA01;
import java.util.LinkedList;
import java.util.Random;


class NearestNeighbor implements Classifer
{
	private LinkedList<Data> list;

	//This is a AnotherClassifiers constructor
	public NearestNeighbor() {
		list = null;
	} 
		
	//This is a classify method that will classify a phone orientation
	//This is an overridden method that implements the NearestNeighbor version of classify
	@Override
	public int classify(Data givenData) {
		int orientation = 0;
		double distance = 0.0;
		
		double shortestDistance = Double.MAX_VALUE;
		LinkedList<Data> currentNode = list;
		int i = 0;
		boolean canContinue = true;
		boolean hasTripped = false;
		do
		{
			//find distance between data and current node
			distance = givenData.findDistance(currentNode.get(i));
			
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
					orientation = currentNode.get(i).getOrientation();
				}
				//Otherwise we use the current point
			}
			//check to see if the distance is shorter than the shortest distance
			else if(shortestDistance > distance)
			{
				shortestDistance = distance;
				orientation = currentNode.get(i).getOrientation();
			}
			
			i++;
			
			//determine if we can continue looping
			if(hasTripped == true)
			{
				canContinue = false;
			}
			else if(currentNode.get(i) == currentNode.getLast() && !hasTripped)
			{
				//Use the has tripped to loop 1 time past the loop condition
				hasTripped = true;
			}
		}while(canContinue);
		return orientation;
	}

	//This is a classify file method that will classify phone orientations in a given file
	//This is an overridden method that implements the anotherClassifer version of train
	@Override
	public void train() {
		//open the training file 
		Input newFile = new Input();
		newFile.setFileName("trainingData.txt");
		//save the head of this list for later
		list = newFile.ReadData();
	}

	//This is a classify file method that will classify phone orientations in a given file	
	//This is an overridden method that implements the anotherClassifer version of classifyFile
	@Override
	public void classifyFile(String filename) {
		//read all the points in from a file
		Input newFile = new Input();
		newFile.setFileName(filename);
		LinkedList<Data> currentListNode = newFile.ReadData();
		int tempStoreOrientation = 0;
		Output saveFile = new Output();
		saveFile.setFileName(filename);
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
}