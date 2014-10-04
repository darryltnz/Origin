import java.util.GregorianCalendar;
import java.util.ArrayList;

public class API_Test { // Class for some simple tests showing how we may implement the API

	static API_Handler test;
	
	public static void testDumpString(String[] args){ // Method that takes the stock to get data for and dates to retrieve the data between as args and prints the result
		
		test = new API_Handler(args);
		
		test.print();
	}
	
	public static void testDumpSingleStockString(String stock, GregorianCalendar start, GregorianCalendar end){ // same as above but with passed in objects as data sources
		
		test = new API_Handler(stock, start, end );
		
		test.print();
	}
	
public static void testDifferenceOutput(String stock, GregorianCalendar start, GregorianCalendar end){ // this method gets the data for a single stock entry and calculates whether it made a gain or loss
		
		test = new API_Handler(stock, start, end ); // create a new test
		
		ArrayList<Double> values = test.returnSingleDiff(stock); // call the returnDiff method passing the result into a new ArrayList
		
		Double result = (values.get(1) - values.get(0)); // calculate the diff between the closing value and the opening value
		
		if (result > 0) { // if it was a gain
		System.out.println("The Stock " + stock + " Finished today with a rise of " + result + " points"); // display gain feedback
		}
		
		else { // otherwise
			System.out.println("The Stock " + stock + " Finished today with a loss of " + result + " points"); //display loss feedback
		}
	}
	
	
	public static void main(String[] args) { // call the tests one after another
		
		testDumpString(args);
		
		
		String stock = "IBM";
		
		GregorianCalendar start = new GregorianCalendar();
		
		GregorianCalendar end = new GregorianCalendar();
		
		testDumpSingleStockString(stock, start, end);
		
		testDifferenceOutput(stock, start, end);
		
		
	}

}
