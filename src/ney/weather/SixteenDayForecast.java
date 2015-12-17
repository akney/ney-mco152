package ney.weather;

import java.util.Date;

public class SixteenDayForecast {
	private String cod;
	private List[] list;

	public SixteenDayForecast() {
		cod = new String();
		list = new List[16];
	}

	public String getCod() {
		return cod;
	}

	public List[] getList() {
		List[] copy = new List[16];
		for (int i = 0; i < 16; i++) {
			copy[i] = list[i];
		}
		return copy;
	}

	class List {

		private Date dt;
		private Temp temp;
		double humidity;
		private Weather weather;

		public List() {

		}

		public Date getDt() {
			return dt;
		}

		public Temp getTemp() {
			return temp;
		}

		public double getHumidity() {
			return humidity;
		}

		public Weather getWeather() {
			return weather;
		}

	}

	class Temp {
		double day;

		public Temp() {

		}

		public double getDayTemp() {
			return day;
		}

	}

	class Weather {

		private String description;
		private String icon;

		Weather() {

		}

		public String getDescription() {
			return description;
		}

		public String getIconId() {
			return icon;
		}
	}

}
