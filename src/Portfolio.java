
import java.util.ArrayList;
import java.util.Date;

/* Holds a list of added stocks. The portfolio is named by the user
 * and contains a reference to the user that owns the portfolio. Users can buy and sell stocks from the
 * portfolio and add new stocks to it. A portfolio also has an associated trading strategy that will 
 * automatically buy or sell stocks under certain conditions.
 */
public class Portfolio {

	private int userID;

	private String name;

	public ArrayList<Stock> listOfStocks;

	private TradingStrategy tradingStrategy;

	public Portfolio(int user, String inName) {

		userID = user;

		name = inName;

		listOfStocks = new ArrayList<Stock>();

		tradingStrategy = TradingStrategyController.returnDefault();

	}

	/*
	 * Method to check whether a stock exists in the portfolio. This takes a
	 * String as an argument and returns the corresponding boolean value.
	 */
	public boolean doesExist(String stock) {

		boolean test = false;

		for (Stock s : listOfStocks) {

			if (s.getStockID().equals(stock)) {
				test = true;
			}
		}

		return test;
	}

	/*
	 * Creates a Stock object with transaction amount at the current value for
	 * the stock
	 */
	public void createStock(String stock, int amount, double value) {

		Date today = new Date();

		Transaction newBuy = new Transaction(stock, amount, value, today);

		Stock newStock = new Stock(newBuy); // create a new stock item and pass
											// in the new stock transaction

		listOfStocks.add(newStock);
	}

	/*
	 * Method to create a new trading strategy for the portfolio that will be
	 * added to the list of available trading strategies for the portfolio as
	 * well as setting the TradingStrategy for the portfolio to the newly
	 * created Trading Strategy
	 */
	public void setStrategy(String newStrat, String username,
			ArrayList<String> ruleList) {

		if (TradingStrategyController.createTradingStrategy(newStrat, username,
				ruleList)) {

			tradingStrategy = TradingStrategyController
					.returnStrategy(newStrat);
		}

	}

	/*
	 * Method to update the trading strategy for the portfolio.
	 */
	public void updateStrategy(String strat, String user) {

		for (TradingStrategy ts : TradingStrategyController
				.getAvailableStrategies(user)) {

			if (ts.getName().equals(strat)) {

				tradingStrategy = TradingStrategyController
						.returnStrategy(strat);

				return;
			}
		}

	}

	/*
	 * Method that returns a stock from the portfolio identified by a String.
	 */
	public Stock getStock(String inStockID) {

		Stock output = null; // stock output

		for (Stock s : listOfStocks) { // go through the stocks in the portfolio

			if (s.getStockID().equals(inStockID)) { // if the stock's name is
													// the one we want

				output = s; // copy it to the return variable

			}

			else { // if the stock is not the one we want

				output = null; // make sure the return object is still null
			}
		}

		return output; // return the stock object

	}

	/*
	 * Method to add a provided stock to the portfolio
	 */
	public void addStock(Stock inStock) {

		listOfStocks.add(inStock); // add the stock passed in to the ArrayList
									// of stocks

	}

	// Get methods for fields
	public String getName() {

		return name;
	}

	public int getUserID() {

		return userID;
	}

	public TradingStrategy getTradingStrategy() {

		return tradingStrategy;
	}

}
