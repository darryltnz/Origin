import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;


public class UserAccountTest {
	
	UserAccount testAccount;
	
	Portfolio testPort;
	
 // Set up the test by having a newly initialised account
	@Before
	public void setUp() throws Exception {
	
		testAccount = new UserAccount(1, "testPlayer", "testEmail", "testUsername", "testPassword", 1000.00);
		
		
	
	}

	// Ensure the constructor has created a valid object with fields correctly assigned 
	@Test
	public void testUserAccount() {
		
   assertNotNull(testAccount);
   
   assertEquals(1,testAccount.getUID());
   
   assertEquals("testPlayer",testAccount.getPlayerName());
   
   assertTrue(testAccount.getBalance() == 1000.00) ;
   
   assertEquals("testPassword",testAccount.getPassword());
	
   assertEquals("testUsername",testAccount.getUsername());
   
   assertEquals("testEmail",testAccount.getEmail());
	
	}

	// Ensure a portfolio can be created and added to the  account
	@Test
	public void testCreatePortfolio() {
		
		testAccount.createPortfolio("testPort");
		
		assertTrue(testAccount.findPortfolio("testPort"));
		
	}

	// Ensure the account can buy stock for the specified portfolio
	@Test
	public void testBuyStock() {
		
		boolean test = false;
		
		testAccount.createPortfolio("testPort"); // create a test portfolio
		
		testAccount.buyStock("IBM", "testPort", 10); // buy some stock
		
		Stock testStock = null; // Stock variable for testing
		
		for (Portfolio p : testAccount.portfolios) { // go through the specified portfolio
			
			
		 testStock = p.getStock("IBM"); // get the stock just created
			
			if(testStock != null) { // if the stock if the one created
				
				test = true; // the test is true
				
				break; // stop iterating through the portfolio
			}
			
		}
		// Ensure the stock brought  is the one specified and at the correct quantity and that the balance of the account has reduced as a result.
		assertTrue(test);
		
		assertEquals("IBM", testStock.getStockID());
		
		assertEquals(10, testStock.getQuantity());
		
		assertTrue(testAccount.getBalance() < 1000.00);
		
	}

	// Ensure the account can sell stock
	@Test
	public void testSellStock() {
		
        boolean test = false;
		
        // set up an account and portfolio
		testAccount.createPortfolio("testPort");
		
		testAccount.buyStock("IBM", "testPort", 10);
		
		testAccount.sellStock("IBM", "testPort", 5); // sell half the stock just purchased
		
		Stock testStock = null;
		
		for (Portfolio p : testAccount.portfolios) { // iterate through the stocks in the portfolio
			
			// get the sold stock
			 testStock = p.getStock("IBM");
				
				if(testStock != null) { // make sure it is there
					
					test = true;
					
					break;
				}
				
			}
		// ensure that the right amount of the correct stock was sold
		assertTrue(test);
		
		assertEquals("IBM", testStock.getStockID());
		
		assertEquals(5, testStock.getQuantity());
		
		
		
	}
	// make sure that an ArrayList of the trading strategy types available for the account can be retrieved 
	@Test
	public void testGetAvailabeStrategies() {
		
		ArrayList<String> testArray = testAccount.getAvailabeStrategies();
		
		assertNotNull(testArray);
		
		assertTrue(testArray.contains("default"));
		
		
		
	}
	// Make sure a Trading strategy can be assigned a portfolio in the account
	@Test
	public void testUpdateStrategy() {
		
		testAccount.createPortfolio("testPort"); // make a new portfolio
		
		testAccount.updateStrategy("testPort", "default"); // update the portfolios trading strategy to be the default strategy
		
		assertEquals("default", testAccount.getStrategyName("testPort")); // make sure the update occurred
		
		
	}
	// Ensure a new strategy can be created and set for a given portfolio
	@Test
	public void testSetStrategy() {
		
		ArrayList<String> rules = new ArrayList<String>(); // make some new strategy rules
		
        testAccount.createPortfolio("testPort2"); // create a new portfolio
		
		testAccount.setStrategy("testPort2", "testStrat2", rules); // set the new strategy
		
		
		assertEquals("testStrat2", testAccount.getStrategyName("testPort2")); // ensure this has happened
		
		
		
		
		
		
	}
	

// Make sure the trafing strategy name can be retrieved for a specified portfolio
	@Test
	public void testgetStrategyName() {
		
        testAccount.createPortfolio("testPort");
		
		testAccount.updateStrategy("testPort", "default");
		
		assertEquals("default", testAccount.getStrategyName("testPort"));
		
		
		
	}

}
