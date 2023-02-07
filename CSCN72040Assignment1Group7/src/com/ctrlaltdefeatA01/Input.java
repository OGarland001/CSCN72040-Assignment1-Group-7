package com.ctrlaltdefeatA01;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Input extends FileIO
{
	// This is the read data function that can read in sets of information from a text file
	LinkedList<Data> ReadData() {
		Data newData = new Data();
		String number;
		LinkedList<Data> list = new LinkedList<Data>() ;
		double newX, newY, newZ;
		int orientation = 0;
		try 
		{
			File readableFile = new File(fileName);
			Scanner fileInFileReader = new Scanner(readableFile);
			while (fileInFileReader.hasNextLine()) {
				String line = fileInFileReader.nextLine();
				line = line + ",";
				String parts[] = line.split(",");
				newX = Double.parseDouble(parts[0]);
				newY = Double.parseDouble(parts[1]);
				newZ = Double.parseDouble(parts[2]);
				number = "\0";
				number = parts[3];
				if (number != "\0") {
					orientation = Integer.parseInt(number);
				}
				newData.setX(newX);
				newData.setY(newY);
				newData.setZ(newZ);
				newData.setOrientation(orientation);
				list.add(newData);
			}
			fileInFileReader.close();

		} catch (FileNotFoundException e) 
		{
			System.out.println("Error opening:" + fileName);
			e.printStackTrace();		
		}
		
		return list;
	}

	// This is the collect data function
	// This function is used to collect user's input 
	Data collectData()
	{
		double tempX;
		double tempY;
		double tempZ;
		Data Data1 = new Data();
		boolean validInput;
		try (Scanner userInput = new Scanner(System.in)) 
		{
			do
			{
				validInput = false;
				System.out.println("Please enter the X value:");
				tempX = userInput.nextDouble();
				if (tempX <= 1 && tempX >= -1)
				{
					Data1.setX(tempX);
					validInput = true;
				}
				else
				{
					System.out.println("Invalid X input");
				}

			} while (!validInput);

			do
			{
				validInput = false;
				System.out.println("Please enter the Y value:");
				tempY = userInput.nextDouble();
				if (tempY <= 1 && tempY >= -1)
				{
					Data1.setY(tempY);
					validInput = true;
				}
				else
				{
					System.out.println("Invalid Y input");
				}

			} while (!validInput);

			do
			{
				validInput = false;
				System.out.println("Please enter the Z value:");
				tempZ = userInput.nextDouble();;
				if (tempZ <= 1 && tempZ >= -1)
				{
					Data1.setZ(tempZ);
					validInput = true;
				}
				else
				{
					System.out.println("Invalid Z input");
					
				}

			} while (!validInput);
		}
		return Data1;
	}
}
