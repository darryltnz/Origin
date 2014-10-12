package com.example.jl.softstock2014;

import java.util.ArrayList; // import the use of arrayLists

/*Class to represent a stock. Our stock objects are defined by the name, the quantity of 
 * that stock the user currently has and a list of transactions for that stock type
 */
public class Stock {

	private ArrayList<Transaction> transactionList;

	private int quantity;

	private String stockID;

	/*
	 * Constructor that takes an initial transaction for the stock as an
	 * argument
	 */
	public Stock(Transaction initialTrans) {

		// Set the stock's name from the input transaction
		stockID = initialTrans.getStockID();

		transactionList = new ArrayList<Transaction>();

		transactionList.add(initialTrans);

		// Update quantity
		quantity = initialTrans.getQuantity();

	}

	/*
	 * Method to add aTransaction for the stock, to the stocks list of
	 * transactions
	 */
	public void createTransaction(Transaction newBuy) {

		// If input transaction is for this stock object
		if (newBuy.getStockID().equals(stockID)) {

			quantity += newBuy.getQuantity(); // update quantity

			transactionList.add(newBuy);
		}

		// if the transaction and the stock don't match
		else {

			return;
		}

	}

	/*
	 * Method that removes a given amount of the stock from the quantity. This
	 * also goes through the list of transactions for the stock in reverse order
	 * and adjusts the quantity/removes transactions so the list of transactions
	 * will accurately reflect the total quantity of the stock still remaining
	 */
	public void sellStock(int amount) {

		if (quantity >= amount) {

			quantity -= amount; // subtract the amount to sell from the stock

		}

	}

	public void setQuantity(int amount) {

		quantity += amount;
	}

	// get methods for fields
	public String getStockID() {

		return stockID;
	}

	public int getQuantity() {

		return quantity;
	}

	// method to get the total current value of our stock
	public double calculateValue() {

		// get the stock price currently
		double value = StockDataInterface.getCurrentPrice();

		// get the total for the amount of stock we have
		return (value * quantity);

	}

	// method to get the current price of one stock
	public double calculatePrice() {

		// return the current price of the stock
		return StockDataInterface.getCurrentPrice();

	}

	// method to get the average price paid for a stock
	public double calculateCost() {

		if (transactionList.size() > 0) {

			double value = 0; // running variable

			for (Transaction t : transactionList) {

				// if the transaction was not a sale.
				if (t.getQuantity() > 0) {

					// add the price paid in each transaction
					value += (double) (t.getPrice() * t.getQuantity());

				}

				// if the transaction was a sale
				else {

					// add the price that each stock sold times the positive
					// quantity of sold stocks
					value += (double) (t.getPrice() * (t.getQuantity() * -1));
				}
			}

			return value; // return the average

		} else
			return 0; // if their are no transaction return zero
	}

	// method to get the average price paid for a stock
	public double calculateDifference() {

		if (transactionList.size() > 0) {

			double current = calculateValue();

			double cost = calculateCost();

			return (current - cost);

		} else
			return 0; // if their are no transaction return zero
	}

	public ArrayList<Transaction> getTransactionList() {

		return transactionList;
	}

}
