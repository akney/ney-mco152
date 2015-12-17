package ney.weather;

public class SixteenDayForecast {
	private String cod;
	private List[] list;

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

		private long dt;
		private Temp temp;
		double humidity;
		private Weather[] weather;

		public List() {

		}

		public long getDt() {
			return dt * 1000;
		}

		public Temp getTemp() {
			return temp;
		}

		public double getHumidity() {
			return humidity * 9 / 5 - 459.67;
		}

		public Weather getWeather() {
			return weather[0];
		}

	}

	class Temp {
		double day;

		public Temp() {

		}

		public double getDayTemp() {
			return day * 9 / 5 - 459.67;
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
