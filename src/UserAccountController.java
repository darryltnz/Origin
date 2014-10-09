	import java.util.*; // import utilities

	/* Class to handle the storage, creation and retrieval of user accounts 
	 * specified by a unique user id
	 */
public final class UserAccountController {

	static int UID = 0; // set the user id incremental field for each instance of an account at zero
	
	static HashMap<String, UserAccount> accountMap = new HashMap<String, UserAccount>(); // hash map to hold user accounts that have been created
	
	/* Method to make a user account. The player's chosen name, email address, user name, password and initial starting balance are passed in as arguments
	 */
	static void createAccount(String playerName, String email, String username, String password, double initBalance){
		
		UserAccount account=new UserAccount(UID, playerName, email, username, password, initBalance); // make a new user account from the passed in details
		
		accountMap.put(username, account); // add the account to the collection
		
		UID ++; //increment the user id count
	}
	
	/* Check credentials method that takes a user name and password as arguments and checks whether there is a user account under these credentials
	 * stored in the controller (This is where a data base will need to be implemented)
	 */
	static void checkCredential(String username, String password){
		
		if (accountMap.containsKey(username)) { // if the user name is in the collection
			
			if (accountMap.get(username).password.equals(password)){ // if the selected user name corresponds to the supplied password
				
				System.out.println("Login successful."); // display confirmation message
				
				System.out.println(accountMap.get(username).balance);
				
			}
			
			else{ // otherwise inform the user the credentials supplied were not valid
				
				System.out.println("Invalid username or password.");
				
			}
		}
		
		else // if the user name is not in the collection 
			
			System.out.println("User not found."); // display an error message
	}
	
}
