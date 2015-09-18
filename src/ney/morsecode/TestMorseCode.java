package ney.morsecode;

import org.junit.Test;
import org.junit.Assert;

public class TestMorseCode {

	@Test
	public void testEncode() {
		String message = "Gr8 job";
		MorseCode mc = new MorseCode();

		String s = mc.encode(message);

		Assert.assertEquals("--. .-. ---..    .--- --- -... ", s);

	}

	@Test
	public void testDecode() {
		String morse = "-...   .--- ";
		MorseCode mc = new MorseCode();

		String s = mc.decode(morse);

		Assert.assertEquals("b j", s);
	}

}
