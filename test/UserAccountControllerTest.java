import static org.junit.Assert.*;

import org.junit.Test;


public class UserAccountControllerTest {

	

	@Test
	public void testCreateAccount() { // ensure an account can be created from user specified input
		
		UserAccountController.createAccount("testPlayer", "testEmail", "testUsername", "testPassword", 1000.00); // make a test account
		
		UserAccount tester = UserAccountController.returnAccount("testUsername"); // get the created account
		
		// ensure the account is valid and the fields are as expected
		assertNotNull(tester);
		
		assertEquals("testPlayer", tester.getPlayerName());
		
		assertEquals("testEmail", tester.getEmail());
		
		assertEquals("testUsername", tester.getUsername());
		
		assertEquals("testPassword", tester.getPassword());
		
		assertTrue(tester.getBalance() == 1000.00);
	}

	// Ensure that an account verification always returns the correct boolean result upon a user name and password submission
	@Test
	public void testCheckCredentials() {
		
		UserAccountController.createAccount("testPlayer", "testEmail", "testUsername", "testPassword", 1000.00); // make an account
		
		assertTrue(UserAccountController.checkCredentials("testUsername", "testPassword")); // test the verification with correct inputs
		
		// test the verification with inccorect inputs
		
		assertFalse(UserAccountController.checkCredentials("fakeUsername", "testPassword"));
		
		assertFalse(UserAccountController.checkCredentials("testUsername", "fakePassword"));
		
		assertFalse(UserAccountController.checkCredentials("fakeUsername", "fakePassword"));
	}
	
	// ensure an account that is created can be returned correctly
	@Test
	public void testReturnAccount() {
		
UserAccountController.createAccount("testPlayer", "testEmail", "testUsername", "testPassword", 1000.00); // make an account 
		
		UserAccount tester = UserAccountController.returnAccount("testUsername"); // retrieve the created account into a variable
		
		assertNotNull(tester); 
		
	}

}
