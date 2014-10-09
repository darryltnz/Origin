import java.util.ArrayList; //import the use of ArrayLists

import java.util.Date; // import the use of Date objects

/* Portfolio class that holds a list of added stocks. The portfolio is named by the user
 * and contains a reference to the user that owns the portfolio. Users can buy and sell stocks from the
 * portfolio and add new stocks to it. A portfolio also has an associated trading strategy that will 
 * automatically buy or sell stocks under certain conditions.
 */
public class Portfolio { 

private int userID; // holds the user id of the account associated with this portfolio

private String name; // a name for the portfolio

public ArrayList<Stock> listOfStocks; // ArrayList to hold the stocks in the portfolio

//Trading_Strategy tradingStrategy; // trading strategy currently applied to this portfolio

/* Portfolio constructor that takes a user id, a string that names the portfolio
 * and a string that identifies the trading strategy to be used for the portfolio
 */
public Portfolio (int user, String inName, String tradeStrat) {
	
	userID = user; // set the user id the portfolio is to be associated with
	
	name = inName; // set the name of the portfolio
	
	listOfStocks = new ArrayList<Stock>(); // initialise the listOfStocks
	
	//tradingStrategy = new Trading_Strategy(tradeStrat);
	
}

/* Method to check whether a stock exists in the portfolio. This takes a 
 * String as an argument and returns the corresponding boolean value.
 */
public boolean doesExist (String stock) {
	
	boolean test = false; // test variable
	
  for(Stock s : listOfStocks) { // go through all the stocks in the portfolio
	  
	  
	  if(s.getStockID().equals(stock)) { // if the stock name can be found
		  test = true; // set the test variable to be true
	  }
  }

    return test; // return the boolean test
}

/* Method that creates a Stock object with a transaction amount at the current value for the stock
 */
public void createStock(String stock, int amount, Double value) {
	
	Date today = new Date(); // get todays date
	
	Transaction newBuy = new Transaction(stock, amount, value, today); // create a new transaction 
	
	Stock newStock = new Stock(newBuy); // create a new stock item and pass in the new stock transaction
	
	listOfStocks.add(newStock); // add the new stock to the list of stocks 
	
	
}
/*
public void updateStrategy(String newStrat) {
	
	tradingStrategy = new Trading_Strategy(newStrat);
	
}
*/

/* Method that returns a stock from the portfolio identified by a String. 
 */
public Stock getStock(String inStockID) {
	
	Stock output = null; // stock output
	
	for(Stock s: listOfStocks) { // go through the stocks in the portfolio
		
		if(s.getStockID().equals(inStockID)) { // if the stock's name is the one we want
			
			output = s; // copy it to the return variable
			
		}
	
		else { // if the stock is not the one we want 
			
			output = null; // make sure the return object is still null
		}
	}
	
	return output; // return the stock object
	
}

/* Method to add a provided stock to the portfolio
 */
public void addStock(Stock inStock) {
	
	listOfStocks.add(inStock); // add the stock passed in to the ArrayList of stocks
	
}

// Get methods for fields
public String getName() {
	
	return name;
}

public int getuserID() {
	
	return userID;
}

}
