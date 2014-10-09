import java.util.ArrayList; // import the use of ArrayLists

public class UserAccount {

	int UID; // user id field 
	
	String playerName; // String for the player's chosen name
	
	String email; // email field for the user
	
	String username; // string to hold the user name the user has selected 
	
	String password; // password field 
	
	double balance; // balance that the user currently has on their account 
	
	double gainLoss; // field to hold if they have made a gain or loss
	
	PurchasingController purchaser; // object to handle each users purchases and sales of stock
	
	StockDataInterface stockRef; // stock data interface for providing info about stocks to the user account
	
	ArrayList<Portfolio> portfolios; // list of portfolios that the user has under their account
	
	/* Constructor for creating an account. The necessary fields to set up the account are passed in as arguments
	 */
	public UserAccount(int inUID, String inPlayerName, String inEmail, String inUsername, String inPassword, double initBalance){
		
		UID = inUID; // set the user id 
		
		playerName = inPlayerName; // set the players chosen name
		
		email = inEmail; // set the email associated with the account 
		
		username = inUsername; // set the user name
		
		password = inPassword; // set the password
		
		 balance = initBalance; // set the balance that has been set for the account
			
		portfolios = new ArrayList<Portfolio>(); // initialise the list of portfolios the account has
		
		
		
		
		
	}
	
	/* Method to create a new portfolio for the account which is identified by a unique name and a trading strategy which will operate 
	 * on the portfolio
	 */
public void createPortfolio(String inName, String tradeStrat) {
	
	Portfolio newPort = new Portfolio(UID,inName, tradeStrat); // create a new portfolio passing in the account id, the chosen name of the portfolio and a String identifying the chosen trading strategy
	
	portfolios.add(newPort); // add this new portfolio to the list of portfolios for the account
	
}

/* Method to buy a Stock and add it to a specified portfolio. The stock to buy and the quantity are supplied to the method as strings
 */
public void buyStock (String symbol, String portfolio, int amount) {
	
	Double sellPrice = StockDataInterface.getCurrentPrice(); // get the current price of the stock from the interface (Simulation of the API)
	
	if (StockDataInterface.doesExist(symbol)) { // if the stock is in our list of stocks we can buy or sell
		
	for(Portfolio p : portfolios) { // go through the portfolios currently active in this account
		
		if(p.name.equals(portfolio)) { // find the correct portfolio
					
			PurchasingController.purchaseStock(symbol, p, amount, sellPrice); // pass in the portfolio, the stock name, the quantity and the current price to the purchasing controller
			
			balance -= (sellPrice * amount); // take away the amount just spent from the users balance
			
			return; // exit the method
		
		}
	}
	
	
	
	}
}
/* Method to sell a specified number of a certain stock from a supplied portfolio 
 */
public void sellStock(String symbol, String portfolio, int amount) {
	
	Double sellPrice = StockDataInterface.getCurrentPrice(); // get the current price of the stock (Simulating the API)
	
	if (StockDataInterface.doesExist(symbol)) { // if the stock the user has supplied to sell is in the list we offer
		
		for(Portfolio p : portfolios) { // find the supplied portfolio
		
			if(p.name.equals(portfolio)) {
				
				PurchasingController.sellStock(symbol, p, amount, sellPrice); // get the purchase/sale controller to handle the sale
				
				balance += (sellPrice * amount); // add the sold value to the users balance
				
			
			   return;
				
			}
		
	}
	
}


}

}
