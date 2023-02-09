package com.ctrlaltdefeatA01;

public class Main {
    public static void main(String[] args) {
    	
        KNearestNeighbor newClassifierKNearestNeighbor = new KNearestNeighbor();
        //newClassifierNearestNeighbor.train();
        newClassifierKNearestNeighbor.train();
      
        System.out.println("KNearestNeighbor:");
        System.out.println("Please manually enter the x y and z coordinates for a phone to find the orientation");
       
        
       Input inputsInput = new Input();   
       Data usersEntryData = inputsInput.collectData();    
       usersEntryData.setOrientation(newClassifierKNearestNeighbor.classify(usersEntryData));

        System.out.println("The orientation of the phone based on the above inputs is:");

        Output showAnswerOutput = new Output();
           

        showAnswerOutput.printOrientation(usersEntryData);
        
        NearestNeighbor newClassifierNearestNeighbor = new NearestNeighbor();
        newClassifierNearestNeighbor.train();
        
        System.out.println("NearestNeighbor:");
        System.out.println("Please manually enter the x y and z coordinates for a phone to find the orientation");
        Input NearestNeighborInput = new Input();   
        Data NearestNeighnorusersEntryData = NearestNeighborInput.collectData();    
        NearestNeighnorusersEntryData.setOrientation(newClassifierNearestNeighbor.classify(NearestNeighnorusersEntryData));

        System.out.println("The orientation of the phone based on the above inputs is:");

        Output showResultOutput = new Output();
           

        showResultOutput.printOrientation(NearestNeighnorusersEntryData);
            
            

        //Classify a single input using another classifier------------------------------------------

        AnotherClassifer newClassifier2 = new AnotherClassifer();
        newClassifier2.train();
        //newClassifier2.classify(usersEntryData);
        newClassifier2.classifyFile("unknownData.txt");

        //Classify a set of data in a text file to test nearest neighbor----------------------------

        newClassifierNearestNeighbor.classifyFile("testingData.txt");

        //Classify a set of data in a text file using nearest neighbor------------------------------

        newClassifierNearestNeighbor.classifyFile("unknownData.txt");
    
        
    }
}
