import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList; //import the use of ArrayLists
import java.util.Date; // import the use of Date objects

public class PortfolioTest {
	
	private Portfolio testPort;
	
	private Stock testStock;
	
	private Transaction testTrans;
	
	private Date today = new Date();
	

	@Before
	public void setUp() throws Exception {
	
		testTrans = new Transaction("IBM", 100, 1.00, today);
		
		testStock = new Stock(testTrans);
		
		testPort = new Portfolio(1, "test");
		
		testPort.addStock(testStock);
	
	
	}

	@Test
	public void testPortfolio() {
		
		assertNotNull(testPort);
		
		assertEquals("test", testPort.getName());
		
		assertEquals(1, testPort.getUserID());
	}

	@Test
	public void testDoesExist() {
		
		assertEquals(true, testPort.doesExist(testStock.getStockID()));
		
	}

	@Test
	public void testCreateStock() {
		
		testPort.createStock("AAPL", 100, 0.9);
		
		assertTrue(testPort.doesExist("AAPL"));
		
		
		
	}

	@Test
	public void testSetStrategy() {
		
	ArrayList<String> testRules = new ArrayList<String>();
		
	testPort.setStrategy("test strategy", "admin", testRules);
	
	TradingStrategy tester = testPort.getTradingStrategy();
	
	
	assertEquals("test strategy", tester.getName());
	
	}

	@Test
	public void testUpdateStrategy() {
		
		testPort.updateStrategy("default", "admin");
		
		TradingStrategy tester = testPort.getTradingStrategy();
		
		
		assertEquals("default", tester.getName());
		
	}

	@Test
	public void testGetStock() {
		
	Stock tester = testPort.getStock("IBM");
	
	assertNotNull(tester);
	
	assertEquals("IBM", tester.getStockID());
	
	}

	@Test
	public void testAddStock() {
		
        Transaction  testTrans2 = new Transaction("MSFT", 100, 1.00, today);
		
		Stock testStock2 = new Stock(testTrans2);
		
		testPort.addStock(testStock2);
		
		assertTrue(testPort.doesExist("MSFT"));
	
	}


}
