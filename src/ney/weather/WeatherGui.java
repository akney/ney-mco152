package ney.weather;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WeatherGui extends JFrame {
	private JPanel top;
	private JPanel middle;
	private JPanel bottom;
	private JLabel zip;
	private JTextField zipEntry;
	private JLabel notZipcode;
	private JLabel temp;
	private JLabel tempNum;
	private JLabel description;
	private JLabel icon;

	public WeatherGui() {
		setTitle("Weather");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		// top panel
		top = new JPanel();
		top.setLayout(new BoxLayout(top, BoxLayout.LINE_AXIS));
		top.setAlignmentX(TOP_ALIGNMENT);
		top.setBackground(Color.GRAY);

		zip = new JLabel("Zipcode: ");
		zip.setAlignmentX(CENTER_ALIGNMENT);
		zip.setFont(new Font("Courier New", Font.BOLD, 28));

		notZipcode = new JLabel();
		notZipcode.setFont(new Font("Courier New", Font.BOLD, 28));

		zipEntry = new JTextField();
		zipEntry.setColumns(5);
		zipEntry.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				WeatherThread thread = new WeatherThread(zipEntry, temp, notZipcode, tempNum, icon, description);
				thread.run();
			}

		});

		top.add(zip);
		top.add(zipEntry);
		top.add(notZipcode);

		// middle panel
		middle = new JPanel();
		middle.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));

		temp = new JLabel();
		temp.setFont(new Font("Courier New", Font.BOLD, 28));
		middle.add(temp);
		description = new JLabel();
		description.setFont(new Font("Courier New", Font.BOLD, 28));
		middle.add(description);

		// bottom panel
		bottom = new JPanel();
		bottom.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));

		tempNum = new JLabel();
		tempNum.setFont(new Font("Courier New", Font.BOLD, 28));
		icon = new JLabel();
		bottom.add(tempNum);
		bottom.add(icon);

		add(top);
		add(middle);
		add(bottom);

	}

}
