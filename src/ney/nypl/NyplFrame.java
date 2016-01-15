package ney.nypl;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;

public class NyplFrame extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel north, top, bottom;
	private JButton search, next, previous;
	private JList<Result> west;
	private JScrollBar updown, sides;
	private JScrollPane scrollPane;
	private JTextField entry;
	private ArrayList<String> imageURL;
	private ArrayList<ImageIcon> resultImages;
	private JLabel picture;

	public NyplFrame() {
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("NYPL Search");
		setLayout(new BorderLayout());

		resultImages = new ArrayList<ImageIcon>();
		picture = new JLabel();
		west = new JList<Result>();
		west.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				JList<Result> list = (JList<Result>) evt.getSource();
				if (evt.getClickCount() == 1) {
					Result result = list.getSelectedValue();
					ResultSelectThread srt = new ResultSelectThread(result, imageURL, picture);
					srt.start();

				}

			}

		});

		scrollPane = new JScrollPane();
		scrollPane.setLayout(new ScrollPaneLayout());
		updown = new JScrollBar(JScrollBar.VERTICAL);
		sides = new JScrollBar(JScrollBar.HORIZONTAL);
		scrollPane.add(updown, ScrollPane.RIGHT_ALIGNMENT);
		scrollPane.add(sides, ScrollPane.BOTTOM_ALIGNMENT);
		scrollPane.add(picture, ScrollPane.CENTER_ALIGNMENT);

		entry = new JTextField(50);
		search = new JButton("Search");

		entry.addActionListener(this);
		search.addActionListener(this);
		top = new JPanel();
		top.setLayout(new FlowLayout());
		top.add(entry);
		top.add(search);

		bottom = new JPanel();
		bottom.setLayout(new FlowLayout(FlowLayout.CENTER));

		previous = new JButton("Previous");
		previous.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		next = new JButton("Next");
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});
		bottom.add(previous);
		bottom.add(next);

		north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

		north.add(top);
		north.add(bottom);

		add(north, BorderLayout.NORTH);
		add(west, BorderLayout.WEST);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SearchThread st = new SearchThread(entry.getText(), west);
		st.start();
	}

}
