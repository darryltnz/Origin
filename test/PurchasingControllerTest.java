import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PurchasingControllerTest {
	
	Portfolio testPort;
	
	
	

	@Before
	public void setUp() throws Exception {
	
	testPort = new Portfolio(1, "test");
	}

	
	
	
	@Test
	public void testPurchaseStock() {
		
	PurchasingController.purchaseStock("IBM", testPort, 100, 1.00);
		
	Stock tester = testPort.getStock("IBM");
	
	assertNotNull(tester);
	
	assertEquals("IBM", tester.getStockID());
	
	assertTrue(tester.getQuantity() == 100);
	
	double testValue = tester.calculateCost();
	
	assertTrue(testValue == 100);
	
	
	
	}
	
	@Test
	public void testPurchaseStockFalse() {
		
	PurchasingController.purchaseStock("FALSE", testPort, 100, 1.00);
		
	Stock tester = testPort.getStock("FALSE");
	
	assertNull(tester);
	
	
	}

	
	@Test
	public void testSellStock() {
		
		PurchasingController.purchaseStock("IBM", testPort, 100, 1.00);
		
		PurchasingController.sellStock("IBM", testPort, 50, 1.00);
		
		Stock tester = testPort.getStock("IBM");
		
		assertTrue(tester.getQuantity() == 50);
		
		double testValue = tester.calculateCost();
		
		assertTrue(testValue == 50);
	
	}

	@Test
	public void testSellStockFalse() {
		
		PurchasingController.sellStock("FALSE", testPort, 100, 1.00);
		
		Stock tester = testPort.getStock("FALSE");
		
		assertNull(tester);
		
	}
}
