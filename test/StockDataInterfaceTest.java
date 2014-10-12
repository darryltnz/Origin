import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Date;

public class StockDataInterfaceTest {

	
	@Test
	public void testGetCurrentPrice() {
	
		double testValue = StockDataInterface.getCurrentPrice();
		
		assertTrue(testValue >= 0 || testValue <= 100);
	}

	@Test
	public void testReturnDate() {
		Date testDate = StockDataInterface.returnDate();
		
		assertNotNull(testDate);
		
	}

	@Test
	public void testDoesExist() {
		
		assertTrue(StockDataInterface.doesExist("IBM"));
		
		assertTrue(StockDataInterface.doesExist("AAPL"));
		
		assertTrue(StockDataInterface.doesExist("MSFT"));
		
		assertTrue(StockDataInterface.doesExist("F"));
	}

}
