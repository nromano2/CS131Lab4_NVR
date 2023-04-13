/**
 * FileProcessor class reads through a given file. If the file does not exist, then a FileNotFoundException is thrown.
 * If the file does exist, the class reads through the file and compares the string to a given length. An Exception thrown if the string exceeds the length requirement.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * @author nicholasromano
 * @version 1.0
 * CS131 Programming Lab 4
 * Spring 2023
 */
public class FileProcessor {
	
	private String fileName; //store the name of the file
	private int stringLength; //store the length value of a string to test the string of the file
	private ArrayList<String> stringList; //stores the strings that meet the size length
	private Scanner input; //scanner object that reads the file.
	
	/**
	 *  Preferred constructor that sets the filename that is going to be processed, and the size of the string you are testing for.
	 */
	public FileProcessor(String filename, int stringLength)
	{
		setFileName(filename);
		setStringLength(stringLength);
		stringList = new ArrayList<String>();
	}// end Preferred constructor
	
	/**
	 * Accessor method that returns the name of the file.
	 * @return fileName
	 */
	public String getFileName()
	{
		return fileName;
	}// end getFileName
	
	/**
	 * Mutator method that sets the fileName to the newFileName that is being passed through the parameter list
	 * @param newFileName
	 */
	public void setFileName(String newFileName)
	{
		this.fileName = newFileName;
	}// end setFileName
	
	/**
	 * Method returns the size of the stringList arraylist.
	 * @return the number of elements within the arraylist.
	 */
	public int getArrayListSize()
	{
		return stringList.size();
	}// end getArrayListSize
	
	/**
	 * Accessor method that returns the string length that you are testing strings within a file against
	 * @return the string length that you are testing strings within a file against
	 */
	public int getStringLength()
	{
		return stringLength;
	}// end getStringLenth
	
	/**
	 * Mutator method that modifies the string length to the length passed in through the parameter list. 
	 * If the length passed in is less than 5, the length is set to 5.
	 * Otherwise it is set to the value passed in through the parameter list.
	 * 
	 * @param the new length of the string that you want to test.
	 */
	public void setStringLength(int length)
	{
		if(length < 5)
		{
			this.stringLength = 5;
		}
		else 
		{
			this.stringLength = length;
		}
	}// end setStringLength
	
	/**
	 * processFile method reads through a given file to see if the strings within that file are greater than the string length you want to test for.
	 * If the string is less than or equal to the string length you are testing for, the string is added to the stringList, otherwise a StringTooLongException is thrown.
	 * A FileNotFound exception is also caught if the file you are testing does not exist. 
	 * 
	 * @throws StringTooLongException
	 */
	public void processFile() throws StringTooLongException
	{	
		StringTooLongException stringException = new StringTooLongException("String too long!");
		
		try
		{
			input = new Scanner(new File(fileName));
			
			while(input.hasNextLine())
			{
				String line = input.nextLine();
				
				if(line.length() <= getStringLength())
				{
					stringList.add(line);
				}
				else
				{
					throw stringException;
				}
			}
	
		}
		catch(StringTooLongException e)
		{
			System.out.println("String too long!");
		}
		catch(FileNotFoundException exception)
		{
			System.out.println("Sorry, the file with the name \'" + fileName + "\' cannot be found.");
		}
		
		System.out.println("Number of elements meeting the character length crtieria of length " + getStringLength() + " before exception is thrown: " + stringList.size());
	}//end processFile
}
