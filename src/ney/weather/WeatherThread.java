package ney.weather;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class WeatherThread extends Thread {
	private JLabel temp;
	private JLabel city;
	private JLabel tempNum;
	private JLabel icon;
	
	public WeatherThread(JLabel temp, JLabel city, JLabel tempNum, JLabel icon){
		this.temp = temp;
		this.city = city;
		this.tempNum = tempNum;
		this.icon = icon;
	}
	
	@Override
	public void run() {
		ConnectToInternet cti;

		try {

			cti = new ConnectToInternet(zipEntry.getText());
			city.setText(cti.getName());
			temp.setText("Tempature");
			Integer tem = (int) cti.getTempF();
			char degree = 176;
			tempNum.setText(tem.toString() + degree);
			icon.setIcon(new ImageIcon(cti.getIcon()));
			description.setText(cti.getDescription());

		} catch (IOException e) {
			
			city.setText("Invalid Zipcode");
		} catch (NullPointerException e) {
			city.setText("Invalid Zipcode");
		}

	}
}
