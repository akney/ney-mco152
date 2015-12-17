package ney.weather;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ney.weather.SixteenDayForecast.List;

public class SixteenThread extends Thread {
	int dayUpto;
	private JLabel day;
	private JLabel image;
	private JLabel tempature;
	private JLabel description;
	private JLabel humidity;
	private String city;
	private JLabel invalid;

	public SixteenThread(int dayUpto, JLabel day, JLabel image, JLabel tempature, JLabel description, JLabel humidity,
			String city, JLabel invalid) {
		this.dayUpto = dayUpto;
		this.day = day;
		this.image = image;
		this.tempature = tempature;
		this.description = description;
		this.humidity = humidity;
		this.city = city;
		this.invalid = invalid;
	}

	@Override
	public void run() {
		ConnectFor16 six;
		SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM");
		List weatherToday;
		try {
			six = new ConnectFor16(city);
			weatherToday = six.getListObject(dayUpto);

			Date date = new Date(weatherToday.getDt());
			day.setText(format.format(date));

			image.setIcon(new ImageIcon(six.getImage(dayUpto)));

			Double te = weatherToday.getTemp().getDayTemp();
			char degree = 176;
			tempature.setText(te.toString() + degree);

			description.setText(weatherToday.getWeather().getDescription());

			Double hu = weatherToday.getHumidity();
			humidity.setText(hu.toString() + degree);

		} catch (IOException e) {
			invalid.setText("Not connecting...check internet connection");
		} catch (NullPointerException n) {
			invalid.setText("Invalid City");
		}

	}

}
