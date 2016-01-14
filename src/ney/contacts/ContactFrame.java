package ney.contacts;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class ContactFrame extends JFrame {
	private ContactArray contacts;
	private String[] names;
	private JList<Contact> list;

	public ContactFrame() {
		setTitle("Contact List");
		setSize(250, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		names = new String[0];

		list = new JList<Contact>();
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);

		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				JList<Contact> list = (JList<Contact>) evt.getSource();
				if (evt.getClickCount() == 2) {
					int index = list.locationToIndex(evt.getPoint());// change!
					if (index < 0 || index >= list.getModel().getSize()) {
						Contact contact = contacts.get(index);

						contactInfo(contact);

					}

				}
			}
		});

		ContactThread thread = new ContactThread(contacts, list);
		thread.start();

		add(list);

	}

	public void contactInfo(Contact contact) {
		JFrame cInfo = new JFrame();
		cInfo.setSize(250, 300);
		cInfo.setTitle("Contact Info");
		cInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultListModel listModel = new DefaultListModel();
		listModel.addElement(contact.getName());
		listModel.addElement(contact.getPhone());
		listModel.addElement(contact.getEmail());
		Address address = contact.getAddress();
		listModel.addElement(address.getSuite());
		listModel.addElement(address.getStreet());
		listModel.addElement(address.getCity());
		listModel.addElement(address.getZipcode());

		JList info = new JList(listModel);

		cInfo.add(info);
		cInfo.setVisible(true);

	}

}
