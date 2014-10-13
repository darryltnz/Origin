package com.example.jl.softstock2014;

import java.util.Date;

/* Symbolizes a snapshot purchase of a given stock by recording
 * the quantity of the stock that was traded, the date the transaction happened, and 
 * the current price for the stock
 */
public class Transaction {

	private Date date; // when transaction happened

	private String stockName; // stock name that the transaction applies to

	private double price; // price for each stock in the transaction

	private int quantity; // quantity of stocks purchased in this transaction

	public Transaction(String symbol, int amount, double priceIn, Date inDate) {

		stockName = symbol;

		quantity = amount;

		price = priceIn;
		
		date = inDate;
	}

	public String getStockID() {

		return stockName;

	}

	public int getQuantity() {

		return quantity;

	}

	public Date getDate() {

		return date;

	}

	public double getPrice() {

		return price;
	}

}
