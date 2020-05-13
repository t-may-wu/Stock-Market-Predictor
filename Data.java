package project2;

import java.io.*;
import java.util.*;

public class Data implements StockDataADT {

	/*_________________________________________________________________________________________
	 * Variables
	 * 			String [dEFAULT_FILE]: default file use if no file is given
	 * 			ArrayList<String> [weeks]: list of all week dates in string format
	 * 			ArrayList<String> [stockNames]: list of all stock names in string format
	 * 			ArrayList<Stock>  [stocks]: container for all stocks and their data for each week
	 * Functions
	 * 			Data(): default constructor, intializes data with [dEFAULT_FILE]
	 * 			Data(fileName): constructor that initialized data with given file
	 * 			initialize(filename): translates data from file into (Week)s and (Stock)s 
	 * 			getStockCount(): returns number of stocks in data set
	 * 			getWeekCount(): returns number of weeks in data set
	 * 			getStockName(index): return the stock's name at a given index
	 * 			getWeekDate(weekIndex): return the date of the week at a given index
	 * 			getStocksWeek(stockIndex, weekIndex): return the data for the week [weekIndex] of the stock [stockIndex]
	 *_________________________________________________________________________________________*/

	private ArrayList<String> dateStrings;
	private ArrayList<Stock> stocks;
	private HashMap<String,String> nameLookup;

	// constructor, initializes data set to [fileName], if it exists
	// @param fileName: data set to use
	Data(String fileName)	
	{	dateStrings = new ArrayList<String>();
		stocks = new ArrayList<Stock>();
		nameLookup = new HashMap<String,String>();
		initialize(fileName);
	}

	// function that loads data from file [fileName] into [this]
	// @param fileName: data set to use
	public void initialize(String fileName)
	{

		// Initialize inputStream and buffered reader
		 InputStream inp;
		 BufferedReader read = null;
		try 
		{
			inp = getClass().getResourceAsStream("/project2/dow_jones_index.names");
			read = new BufferedReader(new InputStreamReader(inp));
			for (int i = 0; i < 48; i++) {
				String aLine = read.readLine(); // ignore the first descriptors
				
			}
			for (int i = 0; i < 30; i++) {
				String aLine = read.readLine(); // ignore the first descriptors
				aLine = aLine.trim();
				aLine = aLine.replaceAll("\t", ",");
				String[] tokens = aLine.split(",");
				String name = tokens[0];
				String abbr = tokens[tokens.length-1];
				nameLookup.put(abbr, name);
			}			
			read.close();
			inp.close();
		}
		catch(Exception e) 
		{

			// let the user know if file could not be found
			System.err.print("Error: processing '" + fileName);
		}

		// try, just in case fileStream cannot be opened
		try 
		{
			inp = getClass().getResourceAsStream(fileName);
			read = new BufferedReader(new InputStreamReader(inp));

			// Array of strings to hold all segments of strings between commas
			// skip the first line of data, just titles
			String[] current = read.readLine().split(",");
			current = read.readLine().split(",");

			// while the file still contains lines to read
			while(current != null)
			{
				Stock findStock = new Stock(current[1]);

				int stockIndex = stocks.indexOf(findStock);
				if (stockIndex < 0) { // never been added to ArrayList
					stocks.add(findStock);
				}
				else { // already added, find actual stock that matches this abbreviate name
					findStock = stocks.get(stockIndex);
				}
				
				// if the date isn't already in [dateStrings], add it
				if(!dateStrings.contains(current[2])) 
				{
					dateStrings.add(current[2]);
				}

				// get its values for open price, highest price, lowest price, close price
				// volume, and percent price change over the week
				double o = Double.parseDouble(current[3].substring(1));
				double h = Double.parseDouble(current[4].substring(1));
				double l = Double.parseDouble(current[5].substring(1));
				double c = Double.parseDouble(current[6].substring(1));
				double v = Double.parseDouble(current[7]);
				double pp = Double.parseDouble(current[8]);
				
				// add this week's data to this stock.
				findStock.addWeek(o, h, l, c, v, pp);

				current = read.readLine().split(",");
			}

			read.close();
			inp.close();
		}
		catch(FileNotFoundException e) 
		{

			// let the user know if file could not be found
			System.err.print("Error: file '" + fileName + "' not found.");
		}
		finally {
			return;
		}
	}
	
	// function that returns the number of (Stock)s in data set
	public int getStockCount()	
	{	
		return stocks.size();	
	}

	// function that returns the number of (Weeks)s in data set
	public int getWeekCount()	
	{	
		return dateStrings.size();		
	}

	// function that returns the name for the stock at [index]
	// @param index: id of stock to get name for
	public String getStockSymbol(int index) 	
	{	

		// print out an error message if index is out of bounds
		if(index < 0 || index >= stocks.size()) 
		{
			System.err.println("Incorrect index " + index + ", no stock at that index.");
			return null;
		}
		return stocks.get(index).getAbbrevatedName();	
	}

	// function that returns the date (as a string) for the week at [weekIndex]
	// @param weekIndex: id of week to get name for
	public String getWeekDate(int weekIndex)
	{

		// print out an error message if index is out of bounds	
		if(weekIndex < 0 || weekIndex >= dateStrings.size()) 
		{
			System.err.println("Incorrect index " + weekIndex + ", no date at that index.");
			return null;
		}
		return dateStrings.get(weekIndex);	
	}

	// function that returns the (Week) at [weekIndex] of the (Stock) at [stockIndex]
	// @param stockIndex: id of stock to get data for
	// @param weekIndex: id of week to get data for
	public Week getStocksWeek(int stockIndex, int weekIndex) 
	{

		// print out an error message if either of indexes are out of bounds
		if(weekIndex < 0 || weekIndex >= dateStrings.size()) 
		{
			System.err.println("Incorrect index " + weekIndex + ", no week at that index.");
			return null;
		}
		if(stockIndex < 0 || stockIndex >= stocks.size()) 
		{
			System.err.println("Incorrect index " + stockIndex + ", no stock at that index.");
			return null;
		}

		return stocks.get(stockIndex).getWeek(weekIndex);
	}


	public String getStockName(int index) {
		// print out an error message if index is out of bounds
		if(index < 0 || index >= stocks.size()) 
		{
			System.err.println("Incorrect index " + index + ", no stock at that index.");
			return null;
		}
		String abbr = stocks.get(index).getAbbrevatedName();
		return nameLookup.get(abbr);
	}
}
