	import java.util.*; // import utilities

	/* Class to handle the storage, creation and retrieval of user accounts 
	 * specified by a unique user id
	 */
public final class UserAccountController {

	private static int UID = 0; // set the user id incremental field for each instance of an account at zero
	
	private static HashMap<String, UserAccount> accountMap = new HashMap<String, UserAccount>(); // hash map to hold user accounts that have been created
	
	/* Method to make a user account. The player's chosen name, email address, user name, password and initial starting balance are passed in as arguments
	 */
	static UserAccount createAccount(String playerName, String email, String username, String password, double initBalance){
		
		UserAccount account=new UserAccount(UID, playerName, email, username, password, initBalance); // make a new user account from the passed in details
		
		accountMap.put(username, account); // add the account to the collection
		
		UID ++; //increment the user id count
		
		return account;
	}
	
	/* Check credentials method that takes a user name and password as arguments and checks whether there is a user account under these credentials
	 * stored in the controller (This is where a data base will need to be implemented)
	 */
	static boolean checkCredentials(String username, String password){
		
		
		if (accountMap.containsKey(username)) { // if the user name is in the collection
			
			if (accountMap.get(username).getPassword().equals(password)){ // if the selected user name corresponds to the supplied password
				
				System.out.println("Login successful."); // display confirmation message
				
				System.out.println(accountMap.get(username).getBalance());
				
				return true;
			}
			
			else{ // otherwise inform the user the credentials supplied were not valid
				
				System.out.println("Invalid username or password.");
				
				return false;
				
			}
		}
		
		else { // if the user name is not in the collection 
			
			System.out.println("User not found."); // display an error message
			
			return false;
		}
		
	
	}
	
public static UserAccount returnAccount(String username) {
	
	UserAccount output = accountMap.get(username);
	
	if(output != null) {
		
		return output;
	}
	
	else {
		
		return null;
	}
	
}

    /**
     * validate username. Must be between 4 and 10
     * @param username
     * @return
     */
    static boolean validUserName(String username) {

        if (username.length() < 3 || username.length() > 10) {

            return false;

        } else {

            return false;
        }
    }

    /**
     * validate password. Must be between 4 and 10
     * @param password
     * @return
     */
    static boolean validPassword(String password){

        if (password.length()<3 || password.length()>10) {

            return false;

        }else{

            return  true;

        }
    }

}
