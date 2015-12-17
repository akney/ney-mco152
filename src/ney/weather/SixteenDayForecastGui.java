package ney.weather;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SixteenDayForecastGui extends JFrame {
	private JPanel top;
	private JLabel city;
	private JTextField cityEntry;

	private JPanel middle;
	private JLabel invalid;

	private JPanel bottom;

	public SixteenDayForecastGui() {
		setTitle("Connect Four");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// setting up the top pane
		top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
		top.setSize(200, 600);
		city = new JLabel("City:");
		cityEntry = new JTextField("Enter the city name here...");
		cityEntry.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 16; i++) {
					String city = cityEntry.getText();
					JPanel dayOfWeather = new JPanel();

					dayOfWeather.setLayout(new BoxLayout(dayOfWeather, BoxLayout.Y_AXIS));
					JLabel day = new JLabel();
					JLabel image = new JLabel();
					JLabel tempature = new JLabel();
					JLabel description = new JLabel();
					JLabel humidity = new JLabel();
					SixteenThread thread = new SixteenThread(i, day, image, tempature, description, humidity, city,
							invalid);
					dayOfWeather.add(day);
					dayOfWeather.add(image);
					dayOfWeather.add(tempature);
					dayOfWeather.add(description);
					dayOfWeather.add(humidity);
					bottom.add(dayOfWeather);
				}

			}
		});
		top.add(city);
		top.add(cityEntry);
		add(top);

		// setting up the middle pane
		middle = new JPanel();
		middle.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
		middle.setSize(200, 600);
		invalid = new JLabel();
		middle.add(invalid);
		add(middle);

		// setting up the bottom pane
		bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 16));
		bottom.setSize(400, 600);
		add(bottom);

	}

}

/*
 * JLabel day = new JLabel(); JLabel image = new JLabel(); JLabel tempature =
 * new JLabel(); JLabel description = new JLabel(); JLabel humidity = new
 * JLabel();
 */
