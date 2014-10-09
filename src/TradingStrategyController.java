import java.util.ArrayList;

/*
 * Static class which manages the available trading strategies. 
 * Has methods for creating trading strategies and getting available strategies for a given user. 
 */

public class TradingStrategyController {

	// List of all known trading strategies - will be replaced with database
	private static ArrayList<TradingStrategy> strategyList = new ArrayList<TradingStrategy>();

	private static boolean validStrategy(String n, ArrayList<String> ruleList) {

		for (String r : ruleList) {

			// TODO: Validation logic
			if (false) {
				System.out.println(n + " contains invalid rules.");
				return false;
			}

		}

		return true;

	}

	public static boolean createTradingStrategy(String name, UserAccount user,
			ArrayList<String> ruleList) {

		// Check rules are all valid
		boolean validStrategy = validStrategy(name, ruleList);

		// Check ts name is unique
		boolean uniqueName = true;

		for (TradingStrategy ts : strategyList) {
			if (ts.getName().equals(name)
					&& (ts.getUserAccount() == user || ts.getUserAccount() == null)) {

				uniqueName = false;
			}
		}

		if (validStrategy && uniqueName) {
			strategyList.add(new TradingStrategy(name, user, ruleList));
			return true;
		} else if (!validStrategy) {
			System.out.println("Strategy is invalid for " + name);
		} else if (!uniqueName) {
			System.out.println("Name " + name + " is already in use.");
		}

		return false;
	}

	public static boolean createDefaultTradingStrategy(String name,
			ArrayList<String> ruleList) {

		// Check ts name is unique
		boolean uniqueName = true;

		for (TradingStrategy ts : strategyList) {
			if (ts.getName().equals(name) && ts.getUserAccount() == null) {
				uniqueName = false;
			}
		}

		boolean validStrategy = validStrategy(name, ruleList);

		if (uniqueName && validStrategy) {
			strategyList.add(new TradingStrategy(name, ruleList));
			return true;
		} else if (!uniqueName) {
			System.out.println("Name " + name + " is already in use.");
		} else if (!validStrategy) {
			System.out.println("Strategy is invalid for " + name);
		}
		return false;
	}

	// Returns a list of strategies available to a user
	public static ArrayList<TradingStrategy> getAvailableStrategies(
			UserAccount user) {

		ArrayList<TradingStrategy> available = new ArrayList<TradingStrategy>();

		for (TradingStrategy ts : strategyList) {
			// Is default strategy
			if (ts.getUserAccount() == null) {
				available.add(ts);
				continue;
			}
			// Strategy belongs to user
			if (ts.getUserAccount() == user) {
				available.add(ts);
				continue;
			}

		}

		return available;
	}

}
