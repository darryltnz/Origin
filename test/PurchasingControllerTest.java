import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PurchasingControllerTest {
	
	Portfolio testPort; // test portfolio
	
	
	

	@Before
	public void setUp() throws Exception {
	
	testPort = new Portfolio(1, "test"); // initialise the test portfolio before each test
	}

	
	
	// Ensure a stock can be purchased in a given portfolio
	@Test
	public void testPurchaseStock() {
		
	PurchasingController.purchaseStock("IBM", testPort, 100, 1.00); // buy some stock
		
	Stock tester = testPort.getStock("IBM"); // get the stock back
	
	assertNotNull(tester); // make sure it is a valid stock
	
	assertEquals("IBM", tester.getStockID()); // make sure it is the one created, at the right quantity
	
	assertTrue(tester.getQuantity() == 100);
	
	double testValue = tester.calculateCost(); // make sure the cost of the stock is correct
	
	assertTrue(testValue == 100);
	
	
	
	}
	// make sure a stock that doesn't exist can't be brought
	@Test
	public void testPurchaseStockFalse() {
		
	PurchasingController.purchaseStock("FALSE", testPort, 100, 1.00);
		
	Stock tester = testPort.getStock("FALSE");
	
	assertNull(tester);
	
	
	}

	// Sell stock from a given prtofolio, and ensure it worked
	@Test
	public void testSellStock() {
		
		PurchasingController.purchaseStock("IBM", testPort, 100, 1.00); // buy some stock
		
		PurchasingController.sellStock("IBM", testPort, 50, 1.00); // sell half of it
		
		Stock tester = testPort.getStock("IBM"); // get the stock object sold from
		
		assertTrue(tester.getQuantity() == 50); // amke sure the correct quantity is left
		
		double testValue = tester.calculateCost(); // make sure the cost is still correct
		
		assertTrue(testValue == 50);
	
	}
// make a Stock that doesn't exist can't be sold
	@Test
	public void testSellStockFalse() {
		
		PurchasingController.sellStock("FALSE", testPort, 100, 1.00);
		
		Stock tester = testPort.getStock("FALSE");
		
		assertNull(tester);
		
	}
}
