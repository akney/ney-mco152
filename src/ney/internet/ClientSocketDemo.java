package ney.internet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketDemo {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String serverIP = "192.168.117.145";
		Socket socket = new Socket(serverIP, 52746);

		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.write("Hi there!\n");
		out.flush();

		InputStream in = socket.getInputStream();
		BufferedReader bf = new BufferedReader(new InputStreamReader(in));
		String response = bf.readLine();
		
		System.out.println("Response:" );
		System.out.println(response);
		
		socket.close();

	}
}
