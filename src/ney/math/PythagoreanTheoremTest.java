package ney.math;

import org.junit.Assert;
import org.junit.Test;

public class PythagoreanTheoremTest {
	@Test
	public void testSetAB() {
		PythagoreanTheorem pT = new PythagoreanTheorem();
		pT.setAB(3, 4);

		Assert.assertEquals(5, pT.getC(), .01);
		;
	}

	@Test
	public void testSetAC() {
		PythagoreanTheorem pT = new PythagoreanTheorem();
		pT.setAC(3, 5);

		Assert.assertEquals(4, pT.getB(), .01);
	}

	@Test
	public void testSetBC() {
		PythagoreanTheorem pT = new PythagoreanTheorem();
		pT.setBC(4, 5);

		Assert.assertEquals(3, pT.getA(), .01);
	}
}
