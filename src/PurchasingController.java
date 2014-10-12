package com.example.jl.softstock2014;

import java.util.Date;

/*  PurchasingController class that will handle transactions of stocks from a provided portfolio.
 * Methods are available for purchasing stock and selling stock
 */
public final class PurchasingController {

	/*
	 * Method to purchase a given amount of a certain stock. The stock to buy,
	 * its price, the amount of the stock to buy and the portfolio that the
	 * stock purchase is to belong to are provided as arguments
	 */
	public static void purchaseStock(String inStockID, Portfolio myPort,
			int amount, double value) {

		if (StockDataInterface.doesExist(inStockID)) {

			Date today = new Date();

			for (Stock s : myPort.listOfStocks) {

				if (s.getStockID().equals(inStockID)) {

					// make a new transaction for the stock based on the input
					// value
					Transaction newBuy = new Transaction(inStockID, amount,
							value, today);

					// pass this to the stock as a new transaction
					s.createTransaction(newBuy);

					return;

				}
			}

			Transaction newBuy = new Transaction(inStockID, amount, value,
					today);

			Stock newStock = new Stock(newBuy);

			myPort.addStock(newStock); // add the new stock to the portfolio

			return;
		}
	}

	/*
	 * Method to sell and/or remove the given amount of stock from an input
	 * portfolio, at a given rate by calling the purchasestock method but with a
	 * negative value, so if there will still be a positive quantity of the
	 * stock amount after the transaction
	 */
	public static void sellStock(String inStockID, Portfolio myPort,
			int amount, double inValue) {

		if (StockDataInterface.doesExist(inStockID)) {

			// find the stock in the portfolio to remove the quantity from
			for (Stock s : myPort.listOfStocks) {

				if (s.getStockID().equals(inStockID)) {

					if (s.getQuantity() > amount) {

						amount = amount * -1;

						double value = (inValue * -1);

						purchaseStock(inStockID, myPort, amount, value);

						return;

					}

					// if the user is selling all of the stocks for a given
					// stock
					else if (s.getQuantity() == amount) {
						// remove the stock from the portfolio
						myPort.listOfStocks.remove(s);

						return;
					}
					// if user does not have enough of the stock to sell
					else {

						System.out
								.println("You do not have enough stocks to sell that amount");

						return;

					}

				}

			}

		}

	}

}
