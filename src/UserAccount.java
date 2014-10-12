import java.util.ArrayList; // import the use of ArrayLists

public class UserAccount {

	int UID; // user id field 
	
	private String playerName; // String for the player's chosen name
	
	private String email; // email field for the user
	 
	private String username; // string to hold the user name the user has selected 
	
	private String password; // password field 
	
	private double balance; // balance that the user currently has on their account 
	
	private double gainLoss; // field to hold if they have made a gain or loss
	
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
public void createPortfolio(String inName) {
	
	Portfolio newPort = new Portfolio(UID,inName); // create a new portfolio passing in the account id, the chosen name of the portfolio and a String identifying the chosen trading strategy
	
	portfolios.add(newPort); // add this new portfolio to the list of portfolios for the account
	
}

/* Method to buy a Stock and add it to a specified portfolio. The stock to buy and the quantity are supplied to the method as strings
 */
public void buyStock (String symbol, String portfolio, int amount) {
	
	double sellPrice = StockDataInterface.getCurrentPrice(); // get the current price of the stock from the interface (Simulation of the API)
	
	if (StockDataInterface.doesExist(symbol)) { // if the stock is in our list of stocks we can buy or sell
		
	for(Portfolio p : portfolios) { // go through the portfolios currently active in this account
		
		if(p.getName().equals(portfolio)) { // find the correct portfolio
					
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
	
	double sellPrice = StockDataInterface.getCurrentPrice(); // get the current price of the stock (Simulating the API)
	
	if (StockDataInterface.doesExist(symbol)) { // if the stock the user has supplied to sell is in the list we offer
		
		for(Portfolio p : portfolios) { // find the supplied portfolio
		
			if(p.getName().equals(portfolio)) {
				
				PurchasingController.sellStock(symbol, p, amount, sellPrice); // get the purchase/sale controller to handle the sale
				
				balance += (sellPrice * amount); // add the sold value to the users balance
				
			
			   return;
				
			}
		
	}
	
}


}

/* Method to get all of the names of the trading strategies currently
 * available for the user as strings to display
 */
public ArrayList<String> getAvailabeStrategies() {
	
	ArrayList<String> output = new ArrayList<String>();
	
	for(TradingStrategy ts : TradingStrategyController.getAvailableStrategies(username) ) {
		
		output.add(ts.getName());
		
		
	}
	
	return output;
}

/* Update a portfolio's trading strategy by passing in a String as a 
 * key. If that string corresponds to the name of a strategy set
 * up for this account, pass it to the portfolio to update along with 
 * the username of the account
 */
public void updateStrategy (String portfolio, String strat) {
	
	for(String s : getAvailabeStrategies()) {
		
		if(s.equals(strat)) {
			
			for(Portfolio p : portfolios) {
				
				if(p.getName().equals(portfolio)) {
					
					p.updateStrategy(strat, username);
				}
			}
			
		}
	}
}

/* Create and set a newly defined trading strategy for a given portfolio
 * by passing in the portfolio name to set the strategy for, the new 
 * strategy name, a list of rules for the strategy and the username of
 * the account the strategy can be used with.
 */
public void setStrategy (String portfolio, String strat, ArrayList<String> rules) {
	
	for(Portfolio p : portfolios) {
		
		if(p.getName().equals(portfolio)) {
			
			p.setStrategy(strat, username, rules);
		}
	}
	
}
/* Test method to see if a portfolio exists in an account
 */
public boolean findPortfolio(String port) {
	
	for (Portfolio p : portfolios) {
		
		if(p.getName().equals(port)) {
			
			return true;
		}
		
	}

	return false;

}

// get methods for the fields
public String getPlayerName() {
	
	return playerName;
}

public String getEmail() {
	
	return email;
}

public String getPassword() {
	
	return password;
}

public String getUsername() {
	
	return username;
}

public double getBalance() {
	
	return balance;
}

public double getGainLoss() {
	
	return gainLoss;
}

public int getUID() {
	
	return UID;
}

/* Method to return the name of the trading strategy set for a given portfolio
 */
public String getStrategyName(String portfolio) {
	
	String output = null;
	
	for(Portfolio p : portfolios) {
		
		if(p.getName().equals(portfolio)) {
			
			TradingStrategy ts = p.getTradingStrategy();
			
			if(ts != null) {
			output = ts.getName();
			}
		}
	}

return output;
}
}
