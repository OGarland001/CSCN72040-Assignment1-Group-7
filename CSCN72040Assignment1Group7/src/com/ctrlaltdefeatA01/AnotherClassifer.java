package com.ctrlaltdefeatA01;

class AnotherClassifer implements Classifer
{

	//This is a AnotherClassifiers constructor
	public AnotherClassifer() {
		// Print out what the constructor is doing
		System.out.println("AnotherClassifier constructor called");
	}
	
	//This is a classify method that will classify a phone orientation
	//This is an overridden method that implements the anotherClassifer version of classify
	@Override
	public int classify(Data givenData) {
		// Print out what the method is doing
		System.out.println("AnotherClassifier constructor called");
		return 0;
	}

	//This is a classify file method that will classify phone orientations in a given file
	//This is an overridden method that implements the anotherClassifer version of train
	@Override
	public void train() {
		// Print out what the method is doing
		System.out.println("AnotherClassifier classify called");
		
	}

	//This is a classify file method that will classify phone orientations in a given file	
	//This is an overridden method that implements the anotherClassifer version of classifyFile
	@Override
	public void classifyFile(String filenameString) {
		// Print out what the method is doing
		System.out.println("AnotherClassifier classifyFile called");
	}
}
