import java.util.Date; // import the use of date objects

/* Transaction class that symbolizes a snapshot purchase of a given stock by recording
 * the quantity of the stock that was traded, the date the transaction happened, and 
 * the current price for the stock
 */
public class Transaction {

private Date date; // date field to hold when this transaction happened

private String stockName; // stock name that the transaction applies to

private Double price; // price for each stock in the transaction

private int quantity; // quantity of stocks purchased in this transaction

/* Constructor that takes the stock, the amount, the price and the date that 
 * the transaction relates to as arguments
 */
public Transaction(String symbol, int amount, Double priceIn, Date inDate) {
	
	stockName = symbol; // set the stock name for the transaction
	
	quantity = amount; // set the transaction quantity
	
	price = priceIn;	// set the price for the transaction
}

// Get the stock id of the transaction
public String getStockID() {
	
	return stockName;
	
}
// Get the transaction quantity
public int getQuantity() {
	
	return quantity;
	
}
// Get the transaction date
public Date getDate() {
	
	return date;
	
}

public Double getPrice() {
	
	return price;
}

}
