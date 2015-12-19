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
					String[] arraya = a.split(" ");
					String[] arrayb = b.split(" ");
					String aLast;
					String bLast;

					if (arraya[arraya.length - 1].matches("[IVX]*") || arraya[arraya.length - 1].equals("Jr")
							|| arraya[arraya.length - 1].equals("Sr")) {
						aLast = arraya[arraya.length - 2];
					} else {
						aLast = arraya[arraya.length - 1];
					}
					if (arrayb[arrayb.length - 1].matches("[IVX]*") || arrayb[arrayb.length - 1].equals("Jr")
							|| arrayb[arrayb.length - 1].equals("Sr")) {
						bLast = arrayb[arrayb.length - 2];
					} else {
						bLast = arrayb[arrayb.length - 1];
					}
					return aLast.compareTo(bLast);
				}

			});

			list.setListData(names);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
