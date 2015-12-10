package ney.weather;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WeatherGui extends JFrame {
	private JPanel top;
	private JPanel bottom;
	private JLabel zip;
	private JTextField zipEntry;
	private JLabel temp;
	private JLabel description;

	public WeatherGui() {
		setTitle("Weather");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		top = new JPanel();
		top.setLayout(new BoxLayout(top, BoxLayout.LINE_AXIS));

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
					ConnectToInternet cti = new ConnectToInternet(zipEntry.getText());
				}
			}
		});
		top.add(zip);
		top.add(zipEntry);
		add(top);

	}

}
