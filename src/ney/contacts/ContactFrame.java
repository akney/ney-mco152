package ney.contacts;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

public class ContactFrame extends JFrame {
	private ContactArrayList contacts;
	private String[] names;
	private JList list;

	public ContactFrame() {
		setTitle("Contact List");
		setSize(250, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		names = new String[0];

		list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);

		list.addMouseListener(new ListSelectionListener() {
		});

		ContactThread thread = new ContactThread(contacts, names, list);
		thread.start();

		add(list);

	}

}
