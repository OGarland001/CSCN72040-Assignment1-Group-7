package com.ctrlaltdefeatA01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //KNearestNeighbor newClassifierKNearestNeighbor = null;
        //newClassifierKNearestNeighbor.train();
        NearestNeighbor newClassifierNearestNeighbor = new NearestNeighbor();
        newClassifierNearestNeighbor.train();
        double x, y, z;
        System.out.println("Please manually enter the x y and z coordinates for a phone to find the orientation");
        try (Scanner userInput = new Scanner(System.in)) {
            x = userInput.nextDouble();
            y = userInput.nextDouble();
            z = userInput.nextDouble();
            
            
            Data usersEntryData = new Data();
            usersEntryData.setX(x);
            usersEntryData.setY(y);
            usersEntryData.setZ(z);
            
            System.out.println(x + "," + y + "," + z);
           
            
            usersEntryData.setOrientation(newClassifierNearestNeighbor.classify(usersEntryData));

            System.out.println("The orientation of the phone based on the above inputs is:");

            Output showAnswerOutput = new Output();
           

            showAnswerOutput.printOrientation(usersEntryData);

            //Classify a single input using another classifier------------------------------------------

            AnotherClassifer newClassifier2 = new AnotherClassifer();
            newClassifier2.train();
            newClassifier2.classify(usersEntryData);
            newClassifier2.classifyFile("unknownData.txt");

            //Classify a set of data in a text file to test nearest neighbor----------------------------

            newClassifierNearestNeighbor.classifyFile("testingData.txt");

            //Classify a set of data in a text file using nearest neighbor------------------------------

            newClassifierNearestNeighbor.classifyFile("unknownData.txt");
        }
        catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error getting input");
            e.printStackTrace();
        }


    }

}