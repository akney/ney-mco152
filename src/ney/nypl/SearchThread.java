package ney.nypl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JList;

import com.google.gson.Gson;

public class SearchThread extends Thread {
	private String searchWord;
	private JList<Result> results;
	private Search search;

	public SearchThread(String searchWord, JList<Result> results) {
		this.searchWord = searchWord;
		this.results = results;

	}

	@Override
	public void run() {
		String goTo = "http://api.repo.nypl.org/api/v1/items/search?q=" + searchWord + "&publicDomainOnly=true";
		URL url;
		try {
			url = new URL(goTo);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Authorization", "Token token=\"9bzee4d0caryw8od\"");

			InputStream is = connection.getInputStream();
			InputStreamReader in = new InputStreamReader(is);
			BufferedReader bf = new BufferedReader(in);
			Gson gson = new Gson();

			search = gson.fromJson(bf, Search.class);

			results.setListData(search.getNyplAPI().getResponse().getResult());

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
