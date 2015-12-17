package ney.weather;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

import com.google.gson.Gson;

import ney.weather.SixteenDayForecast.List;

public class ConnectFor16 {
	private SixteenDayForecast six;

	public ConnectFor16(String city) throws IOException {
		String urlName = "http://api.openweathermap.org/data/2.5/forecast/daily?q=" + city
				+ "&units=metric&cnt=7&appid=2de143494c0b295cca9337e1e96b00e0";

		URL url = new URL(urlName);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		InputStream is = connection.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		Gson gson = new Gson();

		six = gson.fromJson(br, SixteenDayForecast.class);

		isr.close();

		if (six.getCod().equals("404")) {
			throw new NullPointerException();
		}

	}

	public List getListObject(int position) {
		return six.getList()[position];
	}

	public BufferedImage getImage(int position) {
		String iconPath = "http://openweathermap.org/img/w/" + six.getList()[position].getWeather().getIconId()
				+ ".png";
		BufferedImage icon = ImageIO.read(new URL(iconPath));

		return icon;
	}

}
