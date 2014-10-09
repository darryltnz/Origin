import java.util.Date; // import the use of date objects

/*  PurchasingController class that will handle transactions of stocks from a provided portfolio.
 * Methods are available for purchasing stock and selling stock
 */
public final class PurchasingController {


	private PurchasingController () {
		
		// empty constructor as this object requires no initial settings as it has no fields.
		
	}
	
	/* Method to purchase a given amount of a certain stock. The stock to buy, its price, the amount of 
	 * the stock to buy and the portfolio that the stock purchase is to belong to are provided as arguments
	 */
	public static void purchaseStock (String inStockID, Portfolio myPort, int amount, double value) {
		
		Date today = new Date(); // get todays date as the transaction date
		
		for(Stock s : myPort.listOfStocks) { // go through the stocks currently in the portfolio provided
			
			if (s.getStockID().equals(inStockID)) { // if the stock is in the portfolio already
				
				Transaction newBuy = new Transaction(inStockID, amount, value, today); // make a new transaction for the stock based on the input value
				
				s.createTransaction(newBuy); // pass this to the stock as a new transaction
				
				return; // exit the method
				
			}
			
			else { // otherwise the stock is not already in the portfolio
		
		Transaction newBuy = new Transaction(inStockID, amount, value, today); // make a new transaction based on the input values
		
		 Stock newStock = new Stock(newBuy); // make a new stock object from the new transaction
				
		myPort.addStock(newStock); // add the new stock to the portfolio
		
				
	   }
		
		}
		
	}
    /* Method to sell and/or remove the given amount of stock from an input portfolio, at a given rate
     * by calling the purchasestock method but with a negative value, so if there will still be a
     * positive quantity of the stock amount after the transaction
     */
	public static void sellStock (String inStockID, Portfolio myPort, int amount, double value) {
		
		value = (value * -1);
		
		for(Stock s : myPort.listOfStocks) { // find the stock in the portfolio to remove the quantity from
		
			if (s.getStockID().equals(inStockID)) { // if the stock exists in the portfolio
		
			if(  s.getQuantity() > amount) { // if the amount to sell is less than the amount of stock the user owns
				
			 purchaseStock(inStockID, myPort, amount, value);
				
			 return; // exit the method
				
			}
				
			else if (s.getQuantity() == amount) { // if the user is selling all of the stocks for a given stock
				  
				  myPort.listOfStocks.remove(s); // remove the stock from the portfolio
				  
				  return; // exit the method
			  }
			
	        else { // if you do not have enough of the stock to sell
				
				System.out.println("You do not have enough stocks to sell that amount"); // display feedback
		
	              return; //exit the method
		
				
	   }
			
			
			
				
			}
			
		
			
		}
		
		
		
	}

}
