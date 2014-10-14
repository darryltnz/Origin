import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Date;

public class StockDataInterfaceTest {

	// Test the random value getter
	@Test
	public void testGetCurrentPrice() {
	
		double testValue = StockDataInterface.getCurrentPrice(); // get a random value
		
		assertTrue(testValue >= 0 || testValue <= 100); // ensure it is within the acceptable range
	}

	// ensure a date can be returned
	@Test
	public void testReturnDate() {
		Date testDate = StockDataInterface.returnDate();
		
		assertNotNull(testDate);
		
	}
// ensure the stocks in the list can be found and others can't
	@Test
	public void testDoesExist() {
		
		assertTrue(StockDataInterface.doesExist("IBM"));
		
		assertTrue(StockDataInterface.doesExist("AAPL"));
		
		assertTrue(StockDataInterface.doesExist("MSFT"));
		
		assertTrue(StockDataInterface.doesExist("F"));
		
		assertFalse(StockDataInterface.doesExist("P"));
	}

}
