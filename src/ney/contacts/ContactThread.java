package ney.contacts;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JList;

public class ContactThread extends Thread {
	private Contact[] contacts;
	private JList<Contact> list;

	public ContactThread(Contact[] contacts, JList<Contact> list) {
		this.contacts = contacts;
		this.list = list;

	}

	@Override
	public void run() {
		try {
			ContactConnectToInternet connect = new ContactConnectToInternet();
			contacts = connect.getContacts();

			Collections.sort(contacts, new Comparator<Contact>() {

				@Override
				public int compare(Contact a, Contact b) {
					String[] arraya = a.getName().split(" ");
					String[] arrayb = b.getName().split(" ");
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

			list.setListData(contacts);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
