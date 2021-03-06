package ney.contacts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class ContactConnectToInternet {
	private ContactArray contacts;

	public ContactConnectToInternet() throws IOException {
		String urlName = "http://jsonplaceholder.typicode.com/users";

		URL url = new URL(urlName);
		HttpURLConnection connect = (HttpURLConnection) url.openConnection();

		InputStream is = connect.getInputStream();
		InputStreamReader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader);

		Gson gson = new Gson();

		contacts = gson.fromJson(br, ContactArray.class);

	}

	public ContactArray getContacts() {
		return contacts;
	}
}
