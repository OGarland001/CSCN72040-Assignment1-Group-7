package com.ctrlaltdefeatA01;

interface Classifer 
{
	//This is a classify method that will classify a phone orientation
	int classify(Data givenData);
	//This is a classify file method that will classify phone orientations in a given file
	void classifyFile(String filenameString);
	//This is a train method that will train the algorithm
	void train();
}
