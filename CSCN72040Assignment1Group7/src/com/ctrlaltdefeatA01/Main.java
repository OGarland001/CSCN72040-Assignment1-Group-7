package com.ctrlaltdefeatA01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    	System.out.println("-------------------------------------------------------------------------------");
    	System.out.println("|                                                                             |");
    	System.out.println("|                           \\o/ Ctrl-Alt-Defeat \\o/                           |");
    	System.out.println("|                                                                             |");
    	System.out.println("|    Detect Phone Orientation Using Different Machine Learning Algorithms     |");
    	System.out.println("|                                                                             |");
    	System.out.println("-------------------------------------------------------------------------------");

    	System.out.println("\nPlease select from the following list of classifiers to use this time in the program:");
    	System.out.println(" 1. KNearestNeighbor");
    	System.out.println(" 2. NearestNeighbor");
    	System.out.println(" 3. AnotherClassifier");

    	
    	//Get users selection for the above menu-------------------------------------------------------------------------------------------------
    	int selection = 0;
    	boolean validInput = false;
        Scanner userInput = new Scanner(System.in);
    	do
		{
			validInput = false;
			System.out.println("Please Enter Your Selection Here:");
			
			try 
  		  	{
				selection = userInput.nextInt();
				if (selection <= 3 && selection >= 1)
				{
					validInput = true;
				}
				else
				{
	  		  		System.out.println("Invalid Selection");
				}
  		  	} catch (Exception e) 
  		  	{
  		  		userInput.nextLine();
				System.out.println("Invalid Selection");
  		  	}	

		} while (!validInput);

    	
    	//Perform the selected action-------------------------------------------------------------------------------------------------
    	switch (selection) {
        case 1:
          System.out.println("NearestNeighbor Selected");
          
          //Setup KNearestNeighbor-------------------------------------------------------------------------------------------------
          KNearestNeighbor newClassifierKNearestNeighbor = new KNearestNeighbor();
          newClassifierKNearestNeighbor.train();
        
          //Have user enter values to see orientation-------------------------------------------------------------------------------------------------
          System.out.println("Please manually enter the x y and z coordinates for a phone to find the orientation");
          Input inputsInput = new Input();   
          Data usersEntryData = inputsInput.collectData(userInput);    
          usersEntryData.setOrientation(newClassifierKNearestNeighbor.classify(usersEntryData));
          System.out.println("The orientation of the phone based on the above inputs is:");
          Output showAnswerOutput = new Output();
          showAnswerOutput.printOrientation(usersEntryData);
          
          //Have user enter the name of the text file they would like to classify-------------------------------------------------------------------------------------------------
          BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
          
          String selectedTextFile = null;
          do
  		  {
        	  System.out.println("Please enter the name of the text file to classify (remember this text file should be loaded into the project)");
              System.out.println(" Having trouble getting started? << try the out the 'testingData.txt' file...");

    		  try 
    		  {
    			  selectedTextFile = reader.readLine();
    		  } catch (IOException e) 
    		  {
    			  e.printStackTrace();
    		  }

  		  } while (!validInput);
          
          
          //Classify the users file-------------------------------------------------------------------------------------------------
          newClassifierKNearestNeighbor.classifyFile(selectedTextFile);
          
          break;
        case 2:
          System.out.println("KNearestNeighbor Selected");
          
          //Setup NearestNeighbor-------------------------------------------------------------------------------------------------
          NearestNeighbor newClassifierNearestNeighbor = new NearestNeighbor();
          newClassifierNearestNeighbor.train();
          
          //Have user enter values to see orientation-------------------------------------------------------------------------------------------------
          System.out.println("Please manually enter the x y and z coordinates for a phone to find the orientation");
          Input NearestNeighborInput = new Input();   
          Data NearestNeighnorusersEntryData = NearestNeighborInput.collectData(userInput); 
          NearestNeighnorusersEntryData.setOrientation(newClassifierNearestNeighbor.classify(NearestNeighnorusersEntryData));
          System.out.println("The orientation of the phone based on the above inputs is:");
          Output showAnswerOutput1 = new Output();
          showAnswerOutput1.printOrientation(NearestNeighnorusersEntryData);
          
          //Have user enter the name of the text file they would like to classify-------------------------------------------------------------------------------------------------
          BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in)); 
          
          String selectedTextFile1 = null;
          do
  		  {
        	  System.out.println("Please enter the name of the text file to classify (remember this text file should be loaded into the project)");
              System.out.println(" Having trouble getting started? << try the out the 'testingData.txt' file...");

    		  try 
    		  {
    			  selectedTextFile1 = reader1.readLine();
    		  } catch (IOException e) 
    		  {
    			  e.printStackTrace();
    		  }

  		  } while (!validInput);
          
          //Classify the users file-------------------------------------------------------------------------------------------------
          newClassifierNearestNeighbor.classifyFile(selectedTextFile1);

          break;
        case 3:
          System.out.println("AnotherClassifier Selected");
          
          //Setup AnotherClassifier-------------------------------------------------------------------------------------------------
          AnotherClassifer newClassifierAnotherClassifier = new AnotherClassifer();
          newClassifierAnotherClassifier.train();

          //Have user enter values to see orientation-------------------------------------------------------------------------------------------------
          System.out.println("Please manually enter the x y and z coordinates for a phone to find the orientation");
          Input AnotherClassifierInput = new Input();   
          Data AnotherClassifierInputEntryData = AnotherClassifierInput.collectData(userInput); 
          newClassifierAnotherClassifier.classify(AnotherClassifierInputEntryData);
          
          //Have user enter the name of the text file they would like to classify-------------------------------------------------------------------------------------------------
          BufferedReader reader11 = new BufferedReader(new InputStreamReader(System.in)); 
          
          String selectedTextFile11 = null;
          do
  		  {
        	  System.out.println("Please enter the name of the text file to classify (remember this text file should be loaded into the project)");
              System.out.println(" Having trouble getting started? << try the out the 'testingData.txt' file...");

    		  try 
    		  {
    			  selectedTextFile11 = reader11.readLine();
    		  } catch (IOException e) 
    		  {
    			  e.printStackTrace();
    		  }

  		  } while (!validInput);
          
          //Classify the users file-------------------------------------------------------------------------------------------------
          newClassifierAnotherClassifier.classifyFile(selectedTextFile11);
                    
          break;
        default:
          System.out.println("Invalid selection");
          break;
        }
        System.out.println("DONE! Please re-run the program to try another classifier");
	  	userInput.close();
    }
}
