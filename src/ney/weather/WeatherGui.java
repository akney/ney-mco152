package ney.weather;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

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

	public WeatherGui() {
		setTitle("Weather");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		top = new JPanel();
		top.setBackground(Color.BLUE);
		top.setLayout(new BoxLayout(top, BoxLayout.LINE_AXIS));

		middle = new JPanel();
		middle.setBackground(Color.BLUE);
		middle.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));

		bottom = new JPanel();
		bottom.setBackground(Color.BLUE);
		bottom.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 40));

		temp = new JLabel("Tempature");
		temp.setFont(new Font("Courier New", Font.BOLD, 28));
		middle.add(temp);

		zip = new JLabel("Zipcode: ");
		zip.setAlignmentX(CENTER_ALIGNMENT);
		zip.setFont(new Font("Courier New", Font.BOLD, 28));

		zipEntry = new JTextField(10);
		zipEntry.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				all(e);

			}

			@Override
			public void keyReleased(KeyEvent e) {
				all(e);
			}

			@Override
			public void keyTyped(KeyEvent e) {
				all(e);
			}

			public void all(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						ConnectToInternet cti = new ConnectToInternet(zipEntry.getText());

					} catch (IOException e1) {
						notZipcode = new JLabel("Not a valid zipcode.");
						notZipcode.setFont(new Font("Courier New", Font.BOLD, 28));
						top.add(notZipcode);
					}
				}
			}
		});
		top.add(zip);
		top.add(zipEntry);
		add(top);
		add(middle);

	}

}
