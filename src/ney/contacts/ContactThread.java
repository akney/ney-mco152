package ney.contacts;

import java.io.IOException;
import java.util.Collections;

import javax.swing.JList;

public class ContactThread extends Thread {
	private ContactArray contacts;
	private JList<Contact> list;

	public ContactThread(ContactArray contacts, JList<Contact> list) {
		this.contacts = contacts;
		this.list = list;

	}

	@Override
	public void run() {
		try {
			ContactConnectToInternet connect = new ContactConnectToInternet();
			contacts = connect.getContacts();

			Collections.sort(contacts);
			Contact[] forJlist = new Contact[contacts.size()];
			int i = 0;
			for (Contact c : contacts) {
				forJlist[i++] = c;

			}

			list.setListData(forJlist);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
