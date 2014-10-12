package com.example.jl.softstock2014;

import java.io.Serializable;
import java.util.ArrayList; // import the use of ArrayLists

public class UserAccount {

	int UID; // user id field

	private String playerName; // String for the player's chosen name

	private String email; // email field for the user

	private String username; // string to hold the user name the user has
								// selected

	private String password; // password field

	private double balance; // balance that the user currently has on their
							// account

	private double gainLoss; // field to hold if they have made a gain or loss

	ArrayList<Portfolio> portfolios; // list of portfolios that the user has
										// under their account

	public UserAccount(int inUID, String inPlayerName, String inEmail,
			String inUsername, String inPassword, double initBalance) {

		UID = inUID;

		playerName = inPlayerName;

		email = inEmail;

		username = inUsername;

		password = inPassword;

		balance = initBalance;

		portfolios = new ArrayList<Portfolio>();

	}

	public void createPortfolio(String inName) {

		Portfolio newPort = new Portfolio(UID, inName);

		portfolios.add(newPort);

	}

	/*
	 * Method to buy a Stock and add it to a specified portfolio.
	 */
	public void buyStock(String symbol, String portfolio, int amount) {

		// get the current price of the stock from the interface (Simulation of
		// the API)
		double sellPrice = StockDataInterface.getCurrentPrice();

		// if the stock is in our list of stocks we can buy or sell
		if (StockDataInterface.doesExist(symbol)) {

			for (Portfolio p : portfolios) {

				// find the correct portfolio
				if (p.getName().equals(portfolio)) {

					PurchasingController.purchaseStock(symbol, p, amount,
							sellPrice);

					balance -= (sellPrice * amount); // take away the amount
														// just spent from the
														// users balance

					return;

				}
			}

		}
	}

	/*
	 * Method to sell a specified number of a certain stock from a supplied
	 * portfolio
	 */
	public void sellStock(String symbol, String portfolio, int amount) {

		// get the current price of the stock (Simulating the API)
		double sellPrice = StockDataInterface.getCurrentPrice();

		// if the stock the user has supplied to sell is in the list we offer
		if (StockDataInterface.doesExist(symbol)) {

			// find the supplied portfolio
			for (Portfolio p : portfolios) {

				if (p.getName().equals(portfolio)) {

					// get the purchase/sale controller to handle the sale
					PurchasingController
							.sellStock(symbol, p, amount, sellPrice);

					balance += (sellPrice * amount); // add the sold value to
														// the users balance

					return;

				}

			}

		}

	}

	/*
	 * Method to get all of the names of the trading strategies currently
	 * available for the user as strings to display
	 */
	public ArrayList<String> getAvailabeStrategies() {

		ArrayList<String> output = new ArrayList<String>();

		for (TradingStrategy ts : TradingStrategyController
				.getAvailableStrategies(username)) {

			output.add(ts.getName());

		}

		return output;
	}

	/*
	 * Update a portfolio's trading strategy by passing in a String as a key. If
	 * that string corresponds to the name of a strategy set up for this
	 * account, pass it to the portfolio to update along with the username of
	 * the account
	 */
	public void updateStrategy(String portfolio, String strat) {

		for (String s : getAvailabeStrategies()) {

			if (s.equals(strat)) {

				for (Portfolio p : portfolios) {

					if (p.getName().equals(portfolio)) {

						p.updateStrategy(strat, username);
					}
				}

			}
		}
	}

	/*
	 * Create and set a newly defined trading strategy for a given portfolio by
	 * passing in the portfolio name to set the strategy for, the new strategy
	 * name, a list of rules for the strategy and the username of the account
	 * the strategy can be used with.
	 */
	public void setStrategy(String portfolio, String strat,
			ArrayList<String> rules) {

		for (Portfolio p : portfolios) {

			if (p.getName().equals(portfolio)) {

				p.setStrategy(strat, username, rules);
			}
		}

	}

	/*
	 * Test method to see if a portfolio exists in an account
	 */
	public boolean findPortfolio(String port) {

		for (Portfolio p : portfolios) {

			if (p.getName().equals(port)) {

				return true;
			}

		}

		return false;

	}

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

	/*
	 * Method to return the name of the trading strategy set for a given
	 * portfolio
	 */
	public String getStrategyName(String portfolio) {

		String output = null;

		for (Portfolio p : portfolios) {

			if (p.getName().equals(portfolio)) {

				TradingStrategy ts = p.getTradingStrategy();

				if (ts != null) {
					output = ts.getName();
				}
			}
		}

		return output;
	}
}
