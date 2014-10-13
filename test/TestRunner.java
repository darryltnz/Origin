    import org.junit.runner.RunWith;
	import org.junit.runners.Suite;
	import org . junit.runners.Suite.SuiteClasses;
	

	/* Main method to run all tests
	 */
	
	@RunWith(Suite.class)
	@SuiteClasses({PortfolioTest.class,PurchasingControllerTest.class,UserAccountTest.class, StockTest.class,StockDataInterfaceTest.class, TransactionTest.class, TradingStrategyControllerTest.class,TradingStrategyTest.class,
		UserAccountControllerTest.class})
	public class TestRunner {

	}


