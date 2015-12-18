package ney.contacts;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

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

		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				if (evt.getClickCount() == 2) {
					int index = list.locationToIndex(evt.getPoint());
				}
			}
		});

		ContactThread thread = new ContactThread(contacts, names, list);
		thread.start();

		add(list);

	}

	public JFrame contactInfo() {

	}

}
