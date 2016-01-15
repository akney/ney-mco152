package ney.nypl;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.google.gson.Gson;

public class ResultSelectThread extends Thread {
	private SearchResult sresult;
	private ArrayList<String> imageURL;
	private Result result;
	private JLabel picture;

	public ResultSelectThread(Result result, ArrayList<String> imageURL, JLabel picture) {
		this.imageURL = imageURL;
		this.result = result;
		this.picture = picture;
	}

	@Override
	public void run() {
		String goTo = result.getApiItemURL();
		URL url;
		try {
			url = new URL(goTo);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Authorization", "Token token=\"9bzee4d0caryw8od\"");

			InputStream is = connection.getInputStream();
			InputStreamReader in = new InputStreamReader(is);
			BufferedReader bf = new BufferedReader(in);
			Gson gson = new Gson();

			sresult = gson.fromJson(bf, SearchResult.class);

			Capture[] captures = sresult.getNyplAPI().getResponse().getCapture();
			imageURL = new ArrayList<String>();
			for (Capture c : captures) {
				String string = c.getImageLinks().getImageLink()[4];
				imageURL.add(string);
			}
			picture.setIcon(new ImageIcon(connectToIcon(imageURL.get(0))));

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public BufferedImage connectToIcon(String urlString) throws IOException {
		BufferedImage image = ImageIO.read(new URL(urlString));
		return image;
	}

}
