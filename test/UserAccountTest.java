import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;


public class UserAccountTest {
	
	UserAccount testAccount;
	
	Portfolio testPort;
	

	@Before
	public void setUp() throws Exception {
	
		testAccount = new UserAccount(1, "testPlayer", "testEmail", "testUsername", "testPassword", 1000.00);
		
		
	
	}

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

	@Test
	public void testCreatePortfolio() {
		
		testAccount.createPortfolio("testPort");
		
		assertTrue(testAccount.findPortfolio("testPort"));
		
	}

	@Test
	public void testBuyStock() {
		
		boolean test = false;
		
		testAccount.createPortfolio("testPort");
		
		testAccount.buyStock("IBM", "testPort", 10);
		
		Stock testStock = null;
		
		for (Portfolio p : testAccount.portfolios) {
			
			
		 testStock = p.getStock("IBM");
			
			if(testStock != null) {
				
				test = true;
				
				break;
			}
			
		}
		
		assertTrue(test);
		
		assertEquals("IBM", testStock.getStockID());
		
		assertEquals(10, testStock.getQuantity());
		
		assertTrue(testAccount.getBalance() < 1000.00);
		
	}

	@Test
	public void testSellStock() {
		
        boolean test = false;
		
		testAccount.createPortfolio("testPort");
		
		testAccount.buyStock("IBM", "testPort", 10);
		
		testAccount.sellStock("IBM", "testPort", 5);
		
		Stock testStock = null;
		
		for (Portfolio p : testAccount.portfolios) {
			
			
			 testStock = p.getStock("IBM");
				
				if(testStock != null) {
					
					test = true;
					
					break;
				}
				
			}
		assertTrue(test);
		
		assertEquals("IBM", testStock.getStockID());
		
		assertEquals(5, testStock.getQuantity());
		
		
		
	}
	
	@Test
	public void testGetAvailabeStrategies() {
		
		ArrayList<String> testArray = testAccount.getAvailabeStrategies();
		
		assertNotNull(testArray);
		
		assertTrue(testArray.contains("default"));
		
		
		
	}
	
	@Test
	public void testUpdateStrategy() {
		
		testAccount.createPortfolio("testPort");
		
		testAccount.updateStrategy("testPort", "default");
		
		assertEquals("default", testAccount.getStrategyName("testPort"));
		
		
	}
	
	@Test
	public void testSetStrategy() {
		
		ArrayList<String> rules = new ArrayList<String>();
		
        testAccount.createPortfolio("testPort");
		
		testAccount.setStrategy("testPort", "testStrat", rules);
		
		
		assertEquals("testStrat", testAccount.getStrategyName("testPort"));
		
		
		
		
		
		
	}
	


	@Test
	public void testgetStrategyName() {
		
        testAccount.createPortfolio("testPort");
		
		testAccount.updateStrategy("testPort", "default");
		
		assertEquals("default", testAccount.getStrategyName("testPort"));
		
		
		
	}

}
