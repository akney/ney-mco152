package chat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.eclipse.jetty.server.Server;

public class ChatFrame extends JFrame{
	private JTextArea textarea;
	private JTextField textfield;
	private JButton button;
	private JPanel bottom;
	
	public ChatFrame(){
		setSize(600,800);
		setTitle("ChatterBox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		textarea = new JTextArea();
		JScrollPane sp = new JScrollPane(textarea);
		
		add(sp, BorderLayout.CENTER);
		bottom  = new JPanel();
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
		textfield = new JTextField();
		bottom.add(textfield);
		button = new JButton("Send");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent ae) {
				URL url;
				try {
					url = new URL("http://192.168.117.111:8080");
				
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setDoOutput(true);
				OutputStream out = connection.getOutputStream();
				PrintWriter writer = new PrintWriter(out);
				writer.println("Atara: " + textfield.getText());
				writer.flush();
				
				//ready to get response
				connection.getInputStream();
				} catch (MalformedURLException e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		bottom.add(button);
		add(bottom, BorderLayout.SOUTH);
		
		Server server = new Server(8080);
		server.setHandler(new ChatP2PHandler(textarea));
		try {
			server.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		ChatFrame chat = new ChatFrame();
		chat.setVisible(true);
	}
}
