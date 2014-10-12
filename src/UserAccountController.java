package com.example.jl.softstock2014;

import android.app.Application;

import java.util.*; // import utilities

/* Class to handle the storage, creation and retrieval of user accounts 
 * specified by a unique user id
 */
public final class UserAccountController {

	// set the user id incremental field for each instance of an account at zero
	private static int UID = 0;

	// hash map to hold user accounts that have been created
	private static HashMap<String, UserAccount> accountMap = new HashMap<String, UserAccount>();

	// Make a user account
	static UserAccount createAccount(String playerName, String email,
			String username, String password, double initBalance) {

		UserAccount account = new UserAccount(UID, playerName, email, username,
				password, initBalance);

		accountMap.put(username, account); // add the account to the collection

		UID++; // increment the user id count

		return account;
	}

	/*
	 * Takes a user name and password as arguments and checks whether there is a
	 * user account under these credentials stored in the controller (only
	 * stored in controller for first iteration)
	 */
	static boolean checkCredentials(String username, String password) {

		// if the user name is in the collection
		if (accountMap.containsKey(username)) {

			// Check password
			if (accountMap.get(username).getPassword().equals(password)) {

				System.out.println("Login successful.");

				System.out.println(accountMap.get(username).getBalance());

				return true;
			}

			else {
				System.out.println("Invalid username or password.");

				return false;
			}
		}

		// if the user name is not in the collection
		else {

			System.out.println("User not found.");
		}
		return false;

	}

	public static UserAccount returnAccount(String username) {

		UserAccount output = accountMap.get(username);

		if (output != null) {

			return output;
		}

		else {

			return null;
		}

	}

	public static void updateAccount(UserAccount account) {

		if (accountMap.containsKey(account.getUsername()))
			accountMap.put(account.getUsername(), account);
		else
			return;

	}

}
