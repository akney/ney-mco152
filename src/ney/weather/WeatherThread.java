package ney.weather;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WeatherThread extends Thread {
	private JTextField zipEntry;
	private JLabel temp;
	private JLabel city;
	private JLabel tempNum;
	private JLabel icon;
	private JLabel description;

	public WeatherThread(JTextField zipEntry, JLabel temp, JLabel city, JLabel tempNum, JLabel icon,
			JLabel description) {
		this.zipEntry = zipEntry;
		this.temp = temp;
		this.city = city;
		this.tempNum = tempNum;
		this.icon = icon;
		this.description = description;
	}

	@Override
	public void run() {
		ConnectToInternet cti;

		try {

			cti = new ConnectToInternet(zipEntry.getText());
			city.setText(cti.getName());
			temp.setText("Tempature");
			Integer tem = (int) cti.getTempF();
			char degree = 176;
			tempNum.setText(tem.toString() + degree);
			icon.setIcon(new ImageIcon(cti.getIcon()));
			description.setText(cti.getDescription());

		} catch (IOException e) {

			city.setText("Invalid Zipcode");
		} catch (NullPointerException e) {
			city.setText("Invalid Zipcode");
		}

	}
}
