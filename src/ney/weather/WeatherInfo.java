package ney.weather;

public class WeatherInfo {

	private Weather[] weather;
	private Main main;
	private String name;
	private String cod;

	public String getCod() {
		return cod;
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
	}// end weather descriptions

	class Main {
		private double temp;
		private double humidity;
		private double temp_min;
		private double temp_max;

		Main() {

		}

		public double getTemp() {
			return temp;
		}
	} // end MAin

	public WeatherInfo() {
		weather = new Weather[1];
		main = new Main();
		name = new String();
		cod = new String();
	}

	public Weather[] getWeather() {
		return weather;
	}

	public double getTemp() {
		return main.getTemp();
	}

	public String getName() {
		return name;
	}
}
