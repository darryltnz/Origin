import java.util.Calendar; // import utilities and classes needed


import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.net.URLConnection;
import java.util.Scanner;
import java.net.URL;

// Class that takes a user entered start and end date as well as a stock to search with and stores the historical data for that stock in a series of array lists 
// which can then be printed
public class StockDownloader {

public static final int DATE = 0; // Constants for the columns in the CSV file returned by each download
public static final int OPEN = 1;
public static final int HIGH = 2;
public static final int LOW = 3;
public static final int CLOSE = 4;
public static final int VOLUME = 5;
public static final int ADJCLOSE = 6;

public ArrayList <String> output = new ArrayList<String>();

private ArrayList<GregorianCalendar> dates; // ArrayLists to hold the appropriate values for each entry in the CSV
private ArrayList<Double> opens;
private ArrayList<Double> highs;
private ArrayList<Double> lows;
private ArrayList<Double> closes;
private ArrayList<Integer> volumes;
private ArrayList<Double> adjCloses;

public StockDownloader (String symbol, GregorianCalendar start, GregorianCalendar end) { // constructor that takes the stock to search for and the start and end dates of the search as arguments
	
	dates = new ArrayList<GregorianCalendar>(); // initialise the ArrayLists
	opens = new ArrayList<Double>();
	highs = new ArrayList<Double>();
	lows = new ArrayList<Double>();
	closes = new ArrayList<Double>();
	volumes = new ArrayList<Integer>();
	adjCloses = new ArrayList<Double>();
	
	// create a URL that will return a CSV of historical data for our entered stock, between the start and end dates
	String url = "http://real-chart.finance.yahoo.com/table.csv?s="+symbol+"&d="+start.get(Calendar.MONTH)+"&e="+start.get(Calendar.DAY_OF_MONTH)+
			"&f="+start.get(Calendar.YEAR)+"&g=d"+
			"&a="+end.get(Calendar.MONTH)+
			"&b="+end.get(Calendar.DAY_OF_MONTH) +
			 "&c="+end.get(Calendar.YEAR)+
			 "&ignore=.csv";
	
	try { // try to retrieve the data
	URL yahooFinance = new URL(url); // create a URL stream from the constructed URL
	
	URLConnection data = yahooFinance.openConnection(); // open the connection to the URL
	
	Scanner input = new Scanner(data.getInputStream()); // create an input stream from the connection
	
	if (input.hasNext()) { // if the input has a line skip it as it is the header of the CSV
		
		input.nextLine();
		
		// read the data into the arrayLists line by line
		
		while (input.hasNextLine()) { // while the file is not at it's end
			
			String line = input.nextLine(); // get the current line of data
			
			String[] array = line.split(","); // split by column
			
			String longDate = array[0]; // get the date as a string
			
			String[] dateArray = longDate.split("-"); // split the date string into it's individual string components
						
			int year = Integer.parseInt(dateArray[0]); // get the year
			
			int month = Integer.parseInt(dateArray[1]); // get the month
			
			int day = Integer.parseInt(dateArray[2]); // get the day
			
			GregorianCalendar cal = new GregorianCalendar(year, month, day); // make a calendar object
			
			dates.add(cal); // add the calendar to the dates array
			
			opens.add(Double.parseDouble(array[1])); // get the open field, convert to a Double and add to the ArrayList
			
			highs.add(Double.parseDouble(array[2])); // get the high field, convert to a Double and add to the ArrayList
			
			lows.add(Double.parseDouble(array[3])); // get the low field, convert to a Double and add to the ArrayList
			
			closes.add(Double.parseDouble(array[4])); // get the close field, convert to a Double and add to the ArrayList
			
			volumes.add(Integer.parseInt(array[5])); // get the trading volume field, convert to an integer and add to the ArrayList
			
			adjCloses.add(Double.parseDouble(array[6])); // get the adjusted close field, convert to a Double and add to the ArrayList
			
			
			
		}
		formatData();
	}
	}
	
	catch (Exception e) { // print an error if the URL cannot be resolved
		System.err.println(e);
	}
}
// Method to format the data entry by entry. At the moment this prints all the data to the console
public void formatData() {
	
for(int i = 0; i < dates.size(); i++){ // loop through all entries
	
	GregorianCalendar current = dates.get(i); // get the current date object

	output.add(current.get(Calendar.DAY_OF_MONTH)+"-"+current.get(Calendar.MONTH)+"-" + current.get(Calendar.YEAR)+" " // print the string with all data
			+ opens.get(i) + " " + highs.get(i) + " " + lows.get(i) + " " + closes.get(i) + " " + volumes.get(i) + " " + adjCloses.get(i));


}

}

public void dump() {
	
	for (String s : output) {
		
		System.out.println(s);
	}
}
// return the data as a string
public ArrayList<String> returnData() {
	
	return output;
	
}
// return the dates
public ArrayList<GregorianCalendar> getDates() {
	
	return dates;
}
// return the highs
public ArrayList<Double> getHighs() {
	
	return highs;
}
// return the opens
public ArrayList<Double> getOpens() {
	
	return opens;
}
// return the lows
public ArrayList<Double> getLows() {
	
	return lows;
}
// return the closes
public ArrayList<Double> getCloses() {
	
	return closes;
}
// return the adjusted closes
public ArrayList<Double> getAdjCloses() {
	
	return adjCloses;
}
// return the volumes
public ArrayList<Integer> getVolumes() {
	
	return volumes;
}

}
