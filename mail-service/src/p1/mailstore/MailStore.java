package p1.mailstore;

import p1.messages.*;

import java.util.List;


/**
 * MailStore
 */
public interface MailStore {

	static final String regex = ";";

	public void sendMail(String u, Message m);

	public List<Message> getMail(String u) throws Exception;
}
