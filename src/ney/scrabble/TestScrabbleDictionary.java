package ney.scrabble;

import org.junit.Assert;
import org.junit.Test;

public class TestScrabbleDictionary {

	@Test
	public void testContains() {
		ScrabbleDictionary sc = ScrabbleDictionary.getInstance();
		boolean word = sc.contains("data");

		Assert.assertTrue(word);
	}

}
