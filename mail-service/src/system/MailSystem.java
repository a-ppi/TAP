package system;

import mailbox.*;
import mailstore.*;
import messages.*;
import users.*;

import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class MailSystem {
	private static Map<User, MailBox> administrative = new HashMap<User, MailBox>();

	public static MailBox newUser(User u, MailStore store){
		if (getExist(u)) {
			System.out.println("=> username: " + u.getUserName() + " already exists.");
			u = null;
			return null;
		} else {
			MailBox box = new MailBox(u.getUserName(), store);
			administrative.put(u,box);
			System.out.println("=> username: " + u.getUserName() + " created.");
			return box;
		}
	}
	/**The mailbox can be retrieved later by giving the username (log in)
	 * 
	 * @return
	*/
	public static boolean logIn(String username) {
		User user = getUser(username);
		if (user == null)
			return false;
		return true;
	}
	
	/**Get all messages in the system.
	 * 
	 * @return
	 */
	public List<Message> getAllMessages() {
		
		

		return null;
	} 

	/**Get all users in the system.
	 * 
	 * @return
	 */
	public static Set<User> getAllUsers() {return administrative.keySet();}

	/**Filter messages globally: 
	 * Get all messages in the system that fulfill a condition.
	 * 
	 * @return
	 */
	public List<Message> filter() {return null;}

	/**Count total number of messages.
	 * 
	 * @return
	 */
	public int countMessages() {return 0;}


	public static void removeUser(String username) {
		User rm = getUser(username);
		if (rm != null) administrative.remove(rm);
	}

	public static User getUser(String username) {
		for (User u : administrative.keySet()) {
				if (u.getUserName().equals(username)) return u;
		}
		return null;
	}

	public static void printUsers() {
		administrative.forEach((key,value) -> System.out.println("User: " + key));
	}

	public static boolean getExist(User u) {
		return administrative.containsKey(u);
	}
	public static boolean getExist(String username) {
		for (User u : administrative.keySet()) {
			if (u.getUserName().equals(username)) return true;
		}
		return false;
	}



}
