import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import java.util.Date;
// 

/*Test Class for the Stock class , test methods to ensure correct functionality
 * 
 */
public class StockTest {
	
// Set up Test Variables	
	 	Stock testStock1;
	 	Stock testStock2;
	  	Stock testStock3;
	  	Transaction testTransaction1;
	  	Transaction testTransaction2;
	 	Transaction testTransaction3;
	 	Date date;
	
/// Set a range of initial states to test
	  
	@Before
	public void setUp() throws Exception {
		
		date = new  Date();
		testTransaction1 = new Transaction ("IBM",100,1.50,date);
		testTransaction2 = new Transaction ("IBM",200,1.00,date);
		testTransaction3 = new Transaction ("AAPL",500,1.00,date);
		
		testStock1 = new Stock (testTransaction1);
		testStock2 = new Stock (testTransaction2);
		testStock3 = new Stock (testTransaction3);
		
	}

// Test the constructor builds a stock

	@Test
	public final void testStockConstructor() {
		
// test the constructor works
		assertTrue("Ensure a Stock Is Loaded and with the correct quantity ",testStock1.getQuantity() == 100);
		assertTrue("Ensure a Stock Is Loaded and with the correct price ",testStock2.getStockID() == "IBM");
		assertTrue("Ensure a the initial transaction is added to the Stocks transaction List. ",testStock2.getTransactionList().size() == 1);
		
		
		
		}
// test the createTransaction method adds to an existring stock , the quantity is updated and if the ID is invalid it makes no changes
	
	@Test
	public final void testCreateTransaction() {
		
	// add true stock
		testStock1.createTransaction(testTransaction2);
		
		assertTrue("Ensure a Stock Quantity is updated ",testStock1.getQuantity() == 300);
		assertTrue("Ensure a the new transaction is added to the list ",testStock1.getTransactionList().size() == 2);
// add false and see that their are no changes
		testStock1.createTransaction(testTransaction3);
		assertTrue("Ensure that  an invalid transaction is not added to the stock ",testStock1.getTransactionList().size() == 2);
		
		}
	
	// Test the Sell Stock method ensure that a valid transaction updates the quantity and an invalid transaction is ignored.
	@Test
	public final void testSellStock() {
		
	//test valid q from 100 to 50 
		testStock1.sellStock(50);
		// test the constructor works
		assertTrue("Ensure a Stock Quantity is updated ",testStock1.getQuantity() == 50);
	// test invalid Q remains at 50
		testStock1.sellStock(5000);
		assertTrue("Ensure a Stock Quantity is not updated if the see amount is to large ",testStock1.getQuantity() == 50);
		
		}
	// Test the calculate value method 
	@Test
	public final void CalculateValue() {
		
// more work to come here so better testing to be developed, just a place holder really as current iteration just has a random number for price
// So this will multiply the quantity by the Price
		
		
		 
		assertTrue("Ensure a value is created  ",testStock1.calculateValue() >=1 );
		
			}
// Test the calculate cost method 
		@Test
	public final void CalculateCost() {
	// add a  transaction to the base transaction
		testStock1.createTransaction(testTransaction2);
			
		assertTrue("Ensure the code tests each purchase in the transaction list and comes up with the correct total cost  ",testStock1.calculateCost() == 350 );
			
				}
		
// Test the difference method
				@Test
	public final void CalculateDifference() {
			// add a  transaction to the base transaction
			testStock1.createTransaction(testTransaction2);
					
					
// Once again more of a place holder for a test, the calculate difference uses a current cost which is a the moment set to random ( I.e varies when called)
			//
		assertTrue("Ensure that the method minuses the total cost from the current value  ",testStock1.calculateDifference() != 0 );
					
				}
	
	
}
	