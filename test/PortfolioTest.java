import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList; //import the use of ArrayLists
import java.util.Date; // import the use of Date objects

public class PortfolioTest {
	
	private Portfolio testPort; // test portfolio
	
	private Stock testStock; // test stock
	
	private Transaction testTrans; // test transaction
	
	private Date today = new Date(); // make a new date
	
// initialise the portfolio by making a new transaction, a new stock and adding it to the portfolio
	@Before
	public void setUp() throws Exception {
	
		testTrans = new Transaction("IBM", 100, 1.00, today);
		
		testStock = new Stock(testTrans);
		
		testPort = new Portfolio(1, "test");
		
		testPort.addStock(testStock);
	
	
	}
// make sure the constructor returns a valid object of the name specified upon creation, with the correct user id
	@Test
	public void testPortfolio() {
		
		assertNotNull(testPort);
		
		assertEquals("test", testPort.getName());
		
		assertEquals(1, testPort.getUserID());
	}
// Ensure that the created stock in the portfolio can be seen to exist on investigation
	@Test
	public void testDoesExist() {
		
		assertEquals(true, testPort.doesExist(testStock.getStockID()));
		
	}
// Ensure the portfolio can create a stock object and add it
	@Test
	public void testCreateStock() {
		
		testPort.createStock("AAPL", 100, 0.9);
		
		assertTrue(testPort.doesExist("AAPL"));
		
		
		
	}
// Ensure a new strategy can be added to the portfolio
	@Test
	public void testSetStrategy() {
		
	ArrayList<String> testRules = new ArrayList<String>(); // make new strategy rules
		
	testPort.setStrategy("test strategy", "admin", testRules); // set the new strategy
	
	TradingStrategy tester = testPort.getTradingStrategy(); // get the portfolio
	
	
	assertEquals("test strategy", tester.getName()); // make sure the name of the strategy is correct
	
	}

	// Ensure the strategy for the portfolio can be updated to the default in this case
	@Test
	public void testUpdateStrategy() {
		
		testPort.updateStrategy("default", "admin"); // update the strategy 
		
		TradingStrategy tester = testPort.getTradingStrategy(); // get the portfolio
		
		
		assertEquals("default", tester.getName()); // make sure the default strategy is set
		
	}
//Make sure a stock in the portfolio can be retrieved 
	@Test
	public void testGetStock() {
		
	Stock tester = testPort.getStock("IBM"); // get the stock added on initialization
	
	assertNotNull(tester); // ensure it is valid and is the stock added
	
	assertEquals("IBM", tester.getStockID());
	
	}
// make sure the stock list can add a new stock
	@Test
	public void testAddStock() {
		
        Transaction  testTrans2 = new Transaction("MSFT", 100, 1.00, today);
		
		Stock testStock2 = new Stock(testTrans2);
		
		testPort.addStock(testStock2);
		
		assertTrue(testPort.doesExist("MSFT"));
	
	}


}
