package com.ctrlaltdefeatA01;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Output extends FileIO
{
	// This is the print Orientation function
	// This function prints the orientation label as a string
    void printOrientation(Data givenData)
    {
    	int label = givenData.getOrientation();

    	switch (label)
    	{
    	case 1:
    		System.out.println("Face Up");
    		break;
    	case 2:
    		System.out.println("Face Down");
    		break;
    	case 3:
    		System.out.println("Portrait");
    		break;
    	case 4:
    		System.out.println("Portrait Side Down");
    		break;
    	case 5:
    		System.out.println("Landscape left");
    		break;
    	case 6:
    		System.out.println("Landscape Right");
    		break;
    	default:
    		System.out.println("No orientation has been found.");
    		break;
    	}
    }
    
	// This is the write all data function
	// This function writes the X, Y, X and orientation to a file 
    void WriteAllData(Data givenData)
	{
		//write the points to the file with the determined orientation
		try 
		{
			FileWriter fileOutFileWriter = new FileWriter(fileName, true);//use true to append to the file
			int label = givenData.getOrientation();
			String orientation;

	    	switch (label)
	    	{
	    	case 1:
	    		orientation = "Face Up";
	    		break;
	    	case 2:
	    		orientation = "Face Down";
	    		break;
	    	case 3:
	    		orientation = "Portrait";
	    		break;
	    	case 4:
	    		orientation ="Portrait Side Down";
	    		break;
	    	case 5:
	    		orientation ="Landscape left";
	    		break;
	    	case 6:
	    		orientation ="Landscape Right";
	    		break;
	    	default:
	    		orientation ="No orientation has been found";
	    		break;
	    	}
			fileOutFileWriter.write(givenData.getX() + "," + givenData.getY() + "," + givenData.getZ() + "," + givenData.getOrientation() + "," + orientation + "\n");
			fileOutFileWriter.close();
		}
		 catch (IOException e) 
		{
			System.out.println("Error opening:" + fileName);
			e.printStackTrace();
		}
	}
	
	// This is the function that can clear a file
	void ClearFile() 
	{
		PrintWriter fileOutFileWriter;
		try 
		{
			fileOutFileWriter = new PrintWriter(fileName);
			fileOutFileWriter.print("");
			fileOutFileWriter.close();
		} catch (FileNotFoundException e) 
		{
			System.out.println("Error opening:" + fileName);
			e.printStackTrace();
		}
	}
}
