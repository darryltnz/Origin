import java.util.ArrayList;

/*
 * Static class which manages the available trading strategies. Has methods for creating trading strategies. 
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

	public static void createTradingStrategy(String name, UserAccount user,
			ArrayList<String> ruleList) {

		if (validStrategy(name, ruleList)) {
			strategyList.add(new TradingStrategy(name, user, ruleList));
		}
	}

	public static void createDefaultTradingStrategy(String name,
			ArrayList<String> ruleList) {

		if (validStrategy(name, ruleList)) {
			strategyList.add(new TradingStrategy(name, ruleList));
		}
	}
	
	//Returns a list of strategies available to a user
	public static ArrayList<TradingStrategy> getAvailableStrategies(UserAccount user){
		
		ArrayList<TradingStrategy> available = new ArrayList<TradingStrategy>();
		
		for(TradingStrategy ts : strategyList){
			//Is default strategy
			if(ts.getUserAccount() == null){
				available.add(ts);
				continue;
			}
			//Strategy belongs to user
			if(ts.getUserAccount() == user){
				available.add(ts);
				continue;
			}
			
		}
		
		return available;
	}

}
