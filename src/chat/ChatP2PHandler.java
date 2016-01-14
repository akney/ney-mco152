package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JTextArea;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class ChatP2PHandler extends AbstractHandler{
	private JTextArea area;
	 
	public ChatP2PHandler(JTextArea area){
		 this.area = area;
	 }
	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
		
		InputStream in = request.getInputStream();
		InputStreamReader inp = new InputStreamReader(in);
		BufferedReader bf = new BufferedReader(inp);
		String s = bf.readLine();
		area.append(s + "\n");
	}

}
