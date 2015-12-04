package ney.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionDemo {

	public static void main(String[] args) throws IOException {

		URL url = new URL("http://google.com");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		InputStream is = connection.getInputStream();
		InputStreamReader in = new InputStreamReader(is);
		BufferedReader bf = new BufferedReader(in);
		String s;
		while ((s = bf.readLine()) != null) {

			System.out.println(s);
		}

	}

}
