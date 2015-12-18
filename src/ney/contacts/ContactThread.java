package ney.contacts;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JList;

public class ContactThread extends Thread {
	private ContactArrayList contacts;
	private String[] names;
	private JList list;

	public ContactThread(ContactArrayList contacts, String[] names, JList list) {
		this.contacts = contacts;
		this.names = names;
		this.list = list;

	}

	@Override
	public void run() {
		try {
			ContactConnectToInternet connect = new ContactConnectToInternet();
			contacts = connect.getContacts();
			names = new String[contacts.size()];

			for (int i = 0; i < contacts.size(); i++) {

				names[i] = contacts.get(i).getName();
			}

			Arrays.sort(names, new Comparator<String>() {

				@Override
				public int compare(String a, String b) {
					int lastSpacea = a.lastIndexOf(" ");
					int lastSpaceb = b.lastIndexOf(" ");
					return a.substring(lastSpacea + 1).compareTo(b.substring(lastSpaceb + 1));
				}

			});

			list.setListData(names);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
