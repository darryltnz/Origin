import static org.junit.Assert.*; //

import java.util.Date;


import org.junit.Before;
import org.junit.Test;

/* Test the transactions
 */
public class TransactionTest {
	
// set up the variables for testing	
		private  Transaction testTransaction1;
		private  Transaction testTransaction2;
		private  Transaction testTransaction3;
		Date date;

	

	@Before
	public void setUp() throws Exception {
		
		date = new  Date();
		testTransaction1 = new Transaction("IBM",100,1.00,date);
		testTransaction2 = new Transaction("F",200,1.00,date);
		testTransaction3 = new Transaction("AAPL",500,1.00,date);
		
		
		
	}

// run the test on the transaction

	@Test
	public final void test() {
		assertTrue("Ensure the Stock ID name is correctly loaded into the transaction ",testTransaction1.getStockID() == "IBM");
		assertTrue("Ensure the Stock Quantity is correctly loaded into the transaction ",testTransaction2.getQuantity() == 200);
		assertTrue("Ensure the Stock Price is correctly loaded into the transaction ",testTransaction3.getPrice() == 1.00);
		assertTrue("Ensure the Stock Purchase Date is correctly loaded into the transaction ",(testTransaction3.getDate().getTime()/1000) == (date.getTime()/1000) );
		
		
		
		
	}

}