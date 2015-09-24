package ney.scrabble;

import org.junit.Assert;
import org.junit.Test;

public class TestScrabbleDictionary {

	@Test
	public void testContains() {
		ScrabbleDictionary sc = new ScrabbleDictionary();
		boolean word = sc.contains("data");

		Assert.assertTrue(word);
	}

}
