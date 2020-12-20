package mailstore;

import messages.*;


import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("serial")
public class InMemory implements MailStore {
	private static Map<String, List<Message>> messages = new HashMap<String, List<Message>>();

	public void sendMail(String u, Message m) {
		if (messages.containsKey(u)) {
			if (m.toString().matches(".+;"+u+";.+")) {
				messages.get(u).add(m);
			}else
				System.out.println("ERROR ==> Message(to) != User");
			return;
		}
		messages.put(u,new LinkedList<Message>(){{add(m);}});
	}
	/**
	 * 
	 * @param u
	 * @return
	 */
	public List<Message> getMail(String u) {
		if (messages.get(u) == null)
			return null;
		return messages.get(u);
	}
}