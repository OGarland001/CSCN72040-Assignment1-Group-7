package com.ctrlaltdefeatA01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        KNearestNeighbor newClassifierKNearestNeighbor = null;
        newClassifierKNearestNeighbor.train();
        NearestNeighbor newClassifierNearestNeighbor = null;
        newClassifierNearestNeighbor.train();
        int x, y, z;
        System.out.println("Please manually enter the x y and z coordinates for a phone to find the orientation");
        try (Scanner userInput = new Scanner(System.in)) {
            x = userInput.nextInt();
            y = userInput.nextInt();
            z = userInput.nextInt();
            Scanner usersEntryData = userInput.collectData(); //function in input.java

            System.out.println("The orientation of the phone based on the above inputs is:");

            Output showAnswerOutput;

            showAnswerOutput.printOrientation(usersEntryData);

            //Classify a single input using another classifier------------------------------------------

            AnotherClassifer newClassifier2;
            newClassifier2.train();
            newClassifier2.classify(usersEntryData);
            newClassifier2.classifyFile("unknownData.txt");

            //Classify a set of data in a text file to test nearest neighbor----------------------------

            newClassifier1.classifyFile("testingData.txt");

            //Classify a set of data in a text file using nearest neighbor------------------------------

            newClassifier1.classifyFile("unknownData.txt");
        }
        catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error getting input");
            e.printStackTrace();
        }


    }

}