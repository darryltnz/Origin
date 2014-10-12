import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class UserAccountControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateAccount() {
		
		UserAccountController.createAccount("testPlayer", "testEmail", "testUsername", "testPassword", 1000.00);
		
		UserAccount tester = UserAccountController.returnAccount("testUsername");
		
		assertNotNull(tester);
		
		assertEquals("testPlayer", tester.getPlayerName());
		
		assertEquals("testEmail", tester.getEmail());
		
		assertEquals("testUsername", tester.getUsername());
		
		assertEquals("testPassword", tester.getPassword());
		
		assertTrue(tester.getBalance() == 1000.00);
	}

	@Test
	public void testCheckCredentials() {
		
		UserAccountController.createAccount("testPlayer", "testEmail", "testUsername", "testPassword", 1000.00);
		
		assertTrue(UserAccountController.checkCredentials("testUsername", "testPassword"));
		
		assertFalse(UserAccountController.checkCredentials("fakeUsername", "testPassword"));
		
		assertFalse(UserAccountController.checkCredentials("testUsername", "fakePassword"));
		
		assertFalse(UserAccountController.checkCredentials("fakeUsername", "fakePassword"));
	}
	
	@Test
	public void testReturnAccount() {
		
UserAccountController.createAccount("testPlayer", "testEmail", "testUsername", "testPassword", 1000.00);
		
		UserAccount tester = UserAccountController.returnAccount("testUsername");
		
		assertNotNull(tester);
		
	}

}
