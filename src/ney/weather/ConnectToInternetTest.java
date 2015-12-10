package ney.weather;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ConnectToInternetTest {

	@Test
	public void connectTest() throws IOException {
		ConnectToInternet cti = new ConnectToInternet("11415");
		Assert.assertEquals("Queens County", cti.getName());
	}

	@Test
	public void testGetDescription() throws IOException {
		ConnectToInternet cti = new ConnectToInternet("11415");
	}
}
