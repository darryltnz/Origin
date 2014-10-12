import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;


public class TradingStrategyTest {

	TradingStrategy tsOne;
	
	TradingStrategy tsTwo;
	
	ArrayList<String> rules;
	
	UserAccount user;
	
	@Before
	public void setUp() throws Exception {
	
		rules = new ArrayList<String>();
		
		user = new UserAccount(1, "testPlayer", "testEmail", "testUsername", "testPassword", 1000.00);
		
		tsOne = new TradingStrategy("testOne", user, rules);
		
		tsTwo = new TradingStrategy("testTwo", rules);
		
		
	
	
	}

	@Test
	public void testTradingStrategyStringUserAccountArrayListOfString() {
		
		assertNotNull(tsOne);
		
		assertEquals("testOne", tsOne.getName());
	}

	@Test
	public void testTradingStrategyStringArrayListOfString() {
		
        assertNotNull(tsTwo);
		
		assertEquals("testTwo", tsTwo.getName());

	}



}
