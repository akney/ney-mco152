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

import ney.weather.WeatherInfo.Weather;

public class ConnectToInternet {
	private WeatherInfo info;

	public ConnectToInternet(String zip) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("http://api.openweathermap.org/data/2.5/weather?zip=");
		sb.append(zip);
		sb.append(",us&appid=2de143494c0b295cca9337e1e96b00e0");

		URL url = new URL(sb.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		InputStream is = connection.getInputStream();
		InputStreamReader in = new InputStreamReader(is);
		BufferedReader bf = new BufferedReader(in);
		Gson gson = new Gson();

		info = gson.fromJson(bf, WeatherInfo.class);

		in.close();

		if (info.getCod().equals("404")) {
			throw new NullPointerException();
		}

	}

	public String getName() {
		return info.getName();
	}

	public double getTempF() {

		return info.getTemp() * 9 / 5 - 459.67;
	}

	public String getDescription() {
		Weather[] array = info.getWeather();
		return array[0].getDescription();
	}

	private String getIconId() {
		Weather[] array = info.getWeather();
		return array[0].getIconId();
	}

	public BufferedImage getIcon() throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("http://openweathermap.org/img/w/");
		sb.append(getIconId());
		sb.append(".png");
		BufferedImage icon = ImageIO.read(new URL(sb.toString()));

		return icon;
	}

}
