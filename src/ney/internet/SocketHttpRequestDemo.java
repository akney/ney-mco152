package ney.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketHttpRequestDemo {

	// bare minumum in internet communications

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket sock = new Socket("www.google.com", 80);

		String httprequestString = "GET /index.html\n\n";

		PrintWriter out = new PrintWriter(sock.getOutputStream());

		out.write(httprequestString);
		out.flush();

		InputStream is = sock.getInputStream();
		InputStreamReader in = new InputStreamReader(is);
		BufferedReader bf = new BufferedReader(in);
		String s;
		while ((s = bf.readLine()) != null) {

			System.out.println(s);
		}

		sock.close();

	}

}
