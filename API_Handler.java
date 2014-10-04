
import java.util.GregorianCalendar;
import java.util.ArrayList;



public class API_Handler {

	 StockDownloader go; // StockDownloader object to get stock info
	 
	 ArrayList<String> download; // ArrayList to hold the stocks entries as strings 
	 
	 GregorianCalendar prevDate; // Gregorian calendar to hold the previous date the stock information was gathered 
	
	// Constructor that takes an array of Strings, breaks them up and passes them to the stockDownloader
	 public API_Handler(String[] args) {
				
		String stock = args[0]; // get the stock name from the user
		
		GregorianCalendar start; // calendar objects to mark start and end of search
		
		GregorianCalendar end;
		
		String startDate = args[1]; // get the start date as a string
		
		String endDate = args[2]; // get the end date as a string
		
		String[] startArray = startDate.split("-"); // split the start date into it's individual components
		
		int sDay = Integer.parseInt(startArray[0]); // get the start day
		
		int sMonth = Integer.parseInt(startArray[1]); // get the start month
		
		sMonth --; // take 1 off the month as these start from 0 in the object
		
		int sYear = Integer.parseInt(startArray[2]); // get the start year
		
		start = new GregorianCalendar(sYear, (sMonth), sDay); // make a calendar object for the start date
		
		String[] endArray = endDate.split("-"); // get the end date as individual components
		
        int eDay = Integer.parseInt(endArray[0]); // get the end date
		
		int eMonth = Integer.parseInt(endArray[1]); // get the end month
		
		eMonth --; // take 1 off the month as these start from 0 in the object
		
		int eYear = Integer.parseInt(endArray[2]); // get the year
		
		end = new GregorianCalendar(eYear, (eMonth), eDay); // make a calendar object for the end date
		
		go = new StockDownloader(stock, start, end); // make a StockDownloader and pass in the search credentials
		
		
	}
	
	// Constructor that takes the neccesary fields directly as objects
	public API_Handler(String stock, GregorianCalendar start, GregorianCalendar end) {
		
		start.add((GregorianCalendar.MONTH), -1); // get yesterdays stock as we are a day ahead
		
		end.add((GregorianCalendar.MONTH), -1);
		
		go = new StockDownloader(stock, start, end);
	}
	// Blank constructor
	public API_Handler() {
		
		// default constructor
	}
	// print the data
	public void print() {
		
        go.dump(); // print the results
		}
	
	
	
	// Return the important 2 pieces of data in an ArrayList (For use with single stock queries only)
	public ArrayList<Double> returnSingleDiff (String stock) {
		
		GregorianCalendar todayStart = new GregorianCalendar(); // get a start and end date for today
		
		GregorianCalendar todayEnd = new GregorianCalendar();
		
		todayStart.add((GregorianCalendar.MONTH), -1); // get yesterdays stock as we are a day ahead
		
		todayEnd.add((GregorianCalendar.MONTH), -1);
		
		go = new StockDownloader(stock, todayStart, todayEnd); // make a StockDownloader and pass in the search credentials
		
		ArrayList<Double> returnData = new ArrayList<Double>(); // array list for the result
		
		ArrayList<Double> returnOpen = go.getOpens(); // array list for opens
		
		ArrayList<Double> returnClose = go.getCloses();// array list for closes
		
		returnData.add(returnOpen.get(0)); // add the opens value to the result
		
		returnData.add(returnClose.get(0)); // add the closes value to the result
		
		return returnData; // return the result array
		
		// <Usage> Subtract index 1 from index 0 of the return array list to get the difference as a Double. For feedback calculations
		
		
	}
	
	// Return the data downloaded as an array of Strings  
	public ArrayList<String> returnData () {
		if (go != null) {
		download = go.returnData();
		}
		
		else { return null;}
		
		return download;
	}
	
	// return the opens value for the download
	public ArrayList<Double> returnOpens() {
		
		return go.getOpens();
	
	}
	// return the closes value for the download
	public ArrayList<Double> returnCloses() {
		
		return go.getCloses();
	
	}
	
	// return the highs value for the download
		public ArrayList<Double> returnHighs() {
			
			return go.getHighs();
		
		}
		
	// return the lows value for the download
				public ArrayList<Double> returnLows() {
					
					return go.getLows();
				
		}
				
	// return the adjusted closes value for the download
	public ArrayList<Double> returnadjCloses() {
						
		return go.getAdjCloses();
					
		}				
	// return the adjusted closes value for the download
	public ArrayList<Integer> returnVolumes() {
						
		return go.getVolumes();
					
		}	
	
	// return the adjusted closes value for the download
		public ArrayList<GregorianCalendar> returnDates() {
							
			return go.getDates();
						
			}
	
}

