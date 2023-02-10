package com.ctrlaltdefeatA01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.WriteAbortedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {

	protected String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String givenFileName) {
		fileName = givenFileName;
	}
	
	public void testingFileClean(String fileName) {
		ArrayList<String> strlist = new ArrayList<String>();
		try 
		{
			//opens the file to read each line.
			Scanner fileInFileReader = new Scanner(new FileInputStream(fileName));
			int i = 0;
			while (fileInFileReader.hasNextLine() == true) {
				//reads each line and stores it as a string
				String line = fileInFileReader.nextLine();
				
				//adds it to an array list and removes the last 2 characters.
				strlist.add(i, line.substring(0, line.length()-2));
				
				
			i++;
			}
			//closes the file with a full list of modified strings
			fileInFileReader.close();

		} catch (FileNotFoundException e) 
		{
			System.out.println("Error opening:" + fileName);
			e.printStackTrace();		
		}
		Output newfileOutput = new Output();
		newfileOutput.setFileName(fileName);
		newfileOutput.ClearFile();
		
		try 
		{
			//opens the file again to write
			FileWriter fileOutFileWriter = new FileWriter(fileName, true);//use true to append to the file
			int i = 0;
			//write the list to the file
			while(i < strlist.size()) {
				fileOutFileWriter.write(strlist.get(i) + '\n');
				
				
				i++;
			}
					fileOutFileWriter.close();
		} catch (IOException e) 
		{
					System.out.println("Error opening:" + fileName);
					e.printStackTrace();
		}
		
	}
}
