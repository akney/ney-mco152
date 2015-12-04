package ney.weather;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import ney.ufo.UFOList;

public class ConnectToInternet {

	public ConnectToInternet() throws IOException {
		URL url = new URL(
				"http://api.openweathermap.org/data/2.5/weather?zip=11415,us&appid=2de143494c0b295cca9337e1e96b00e0");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		InputStream is = connection.getInputStream();
		InputStreamReader in = new InputStreamReader(is);
		BufferedReader bf = new BufferedReader(in);
		String s;
		while ((s = bf.readLine()) != null) {

		}

		BufferedReader in = new BufferedReader(new FileReader("./ufo_awesome.json"));

		Gson gson = new Gson();

		UFOList list = gson.fromJson(in, UFOList.class);

		in.close();
	}

}
