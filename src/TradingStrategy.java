
import java.util.ArrayList;

/*
 * Holds a list of rules describing automatic stock buying/selling behavior.
 */

public class TradingStrategy {
	private String name;
	private UserAccount user; // If null then is a "default" strategy
	ArrayList<String> ruleList = new ArrayList<String>();

	public TradingStrategy(String n, UserAccount u, ArrayList<String> rl) {
		name = n;
		user = u;
		ruleList = rl;
	}

	// Constructor for "default" strategy - not attached to specific user
	public TradingStrategy(String n, ArrayList<String> rl) {
		name = n;
		user = null;
		ruleList = rl;
	}

	public String getName() {
		return name;
	}

	public UserAccount getUserAccount() {
		return user;
	}

	public int getNumberRules() {
		return ruleList.size();
	}

	public String getRule(int i) {
		return ruleList.get(i);
	}
}
