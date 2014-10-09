import java.util.ArrayList; // import the use of arrayLists 


/*Class to represent a stock. Our stock objects are defined by the name, the quantity of 
 * that stock the user currently has and a list of transactions for that stock type
 */
public class Stock {
	
	private ArrayList <Transaction> transactionList; // list of transactions for the stock
	
	private int quantity; // current quantity
	
	private String stockID; // stock name/id
	
/* Constructor that takes an initial transaction for the stock as an argument
 */
public Stock(Transaction initialTrans) {
	
	stockID = initialTrans.getStockID(); // set the stocks name from the input transaction
	
	transactionList.add(initialTrans); // add the transaction to the list of transactions for the stock
	
	quantity = initialTrans.getQuantity();	 // update the quantity as per the transaction
}

/* Method to add aTransaction for the stock, to the stocks list of transactions 
 */
public void createTransaction(Transaction newBuy) {
	
if(newBuy.getStockID().equals(stockID)) { // if the input transaction is for this stock object
	
	quantity += newBuy.getQuantity(); // update the quantity
	
	transactionList.add(newBuy); // add the transaction to the list of transactions for the stock
	
}

else { // if the transaction and the stock don't match
	
	return; // exit the message
}


}

/* Method that removes a given amount of the stock from the quantity.
 * This also goes through the list of transactions for the stock in reverse order
 * and adjusts the quantity/removes transactions so the list of transactions
 * will accurately reflect the total quantity of the stock still remaining 
 */
public void sellStock(int amount) {
	
	
if (quantity >= amount) {
	
	quantity -= amount; // subtract the amount to sell from the stock
		
	}
	
}

// get methods for fields
public String getStockID() {
	
	return stockID;
}

public int getQuantity() {
	
	return quantity;
}
}
