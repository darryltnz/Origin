import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


public final class StockDataInterface {

	
	private static  ArrayList<String> stocks; // list of stocks hard coded we can choose from
	
	private static  Date today; // date object for the stock request. This is for future proofing when data and dates etc all need to be fetched from the api		
	
	private static  Random rand; // random number generator to simulate the prices of stocks
	
	// Constructor to initialise fields and add some stocks to the list we can choose from
	 
private static void setUp() {
	
	 stocks = new ArrayList<String>(); // initialise list of stocks

	 stocks.add("IBM"); // add IBM to the list of hard coded stocks
	 
	 stocks.add("F"); // add Ford to the list of hard coded stocks
	 
	 stocks.add("AAPL"); // add Apple to the list of hard coded stocks
	 
	 stocks.add("MSFT"); // add Microsoft to the list of hard coded stocks
	 
	 stocks.add("DELL.MX"); // add Dell to the list of hard coded stocks
	 
	 stocks.add("GOOG"); // add Google to the list of hard coded stocks
	 
	 stocks.add("YHOO"); // add Yahoo to the list of hard coded stocks
	 
	 stocks.add("SNE"); // add Sony to the list of hard coded stocks
	 
	 stocks.add("TM"); // add Toyota to the list of hard coded stocks
	 
	 stocks.add("GE"); // add General Electric to the list of hard coded stocks
	 
	 rand = new Random(); // new random number
	 
}
/* get a simulated stock price as a Double
 */
public static  double getCurrentPrice() {
	
	setUp();
	
	return rand.nextDouble() * 100; // return a random value between 0 and 1, times 100
}

/* return the date of the stock data query
 */
public static Date returnDate () {
	
	setUp();
	
	today = new Date(); // get todays date 
	
	return today; // return it
}

/* Test if a given stock exists in the stocks we can search for 
 */
public static boolean doesExist (String inStock) {
	
	setUp();
	
	boolean test = false; // test variable
	
	if(stocks.contains(inStock)) { // if the stock is one in our list
		
		test = true; // the test is true
	}
	
	else { // otherwise the test must be false as the stock is not in our list
		test = false;
	}

return test; // return the result

}

}
