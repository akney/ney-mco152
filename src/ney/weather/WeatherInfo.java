package ney.weather;

public class WeatherInfo {

	private Weather[] array;
	private Main main;
	private String name;

	class Weather {
		private int wdid;
		private String main;
		private String description;
		private String icon;

		Weather(int wdid, String main, String description, String icon) {
			this.wdid = wdid;
			this.main = main;
			this.description = description;
			this.icon = icon;
		}
	}// end weather descriptions

	class Main {
		private double temp;
		private double pressure;
		private double humidity;
		private double temp_min;
		private double temp_max;

		Main(double temp, double pressure, double humidity, double temp_min, double temp_max) {
			this.temp = temp;
			this.pressure = pressure;
			this.humidity = humidity;
			this.temp_min = temp_min;
			this.temp_max = temp_max;

		}

		public double getTemp() {
			return temp;
		}
	} // end MAin

	public WeatherInfo(Weather[] weather, Main main, String name) {
		this.array = weather;
		this.main = main;
		this.name = name;
	}

	public Weather[] getWeather() {
		return array;
	}

	public double getTemp() {
		return main.getTemp();
	}

	public String getName() {
		return name;
	}
}
