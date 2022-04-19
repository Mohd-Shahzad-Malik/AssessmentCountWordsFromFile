package com.application.count;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class countWords {
	static int stringCountWithSpecifiedChar = 0;
	static int stringLength = 0;  // String length fetch from businessRule file.
	static String charToFind = ""; // Character fetch from businessRule file.
	
	public static void main(String... args)
	{
		try(BufferedReader stringReader = new BufferedReader(new FileReader("/AssessmentCountWords/File/properies.txt"));
			FileReader businessLogicProperties = new FileReader("/AssessmentCountWords/File/businessRule.txt"))
		{	
			
			Properties  businessLogicPropertiesFile = new Properties();
			businessLogicPropertiesFile.load(businessLogicProperties); // load properties from businessRule file
		
			//fetch values from the businessRule file according to key passed
			String charToFindfetched = businessLogicPropertiesFile.getProperty("INPUTCHAR");
			String stringLengthFetched = businessLogicPropertiesFile.getProperty("STRINGLENGTH");
			
			charToFind = charToFindfetched;
			stringLength = Integer.parseInt(stringLengthFetched);
			
			//Print list for string 
			System.out.println("List of string which start from " + charToFind +" and having length greater than " + stringLength + " --> " + countStringStartWithSpecifiedChar(stringReader));
			System.out.println("Count of string which is starting from " + charToFind + " and having length greater than " + stringLength + " --> " + stringCountWithSpecifiedChar);
		}
		catch(IOException  e)
		{
			System.out.println("Provided properties/businessRule file is not found in FILE FOLDER or Path Provided is not correct, Please check and correct.");
		}
		
	}
	
	//function to fetch list of string having length greater than stringLength and having starting character charToFind
	public static List<String> countStringStartWithSpecifiedChar(BufferedReader reader) throws IOException
	{
		String line = reader.readLine();
		List<String> listOfChar = new ArrayList<>();
		
		while(line != null)
		{	
			String fetchFirstChar = String.valueOf(line.charAt(0));
			if(fetchFirstChar.equalsIgnoreCase(charToFind) && line.length() > stringLength)
			{
				stringCountWithSpecifiedChar++;
				listOfChar.add(line);
			}
			line = reader.readLine();
		}
		return listOfChar;
	}
	
}
