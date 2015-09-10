package ney.math;

import org.junit.Assert;
import org.junit.Test;

public class QuadraticEquationTest {
	@Test
	public void testGetPosX() {
		QuadraticEquation qE = new QuadraticEquation(2, 3, 1);
		double x = qE.getPosX();

		Assert.assertEquals(-.5, x,.01);

	}

	public void testGetNegX() {
		QuadraticEquation qE = new QuadraticEquation(2, 3, 1);
		double x = qE.getNegX();

		Assert.assertEquals(-1, x, .01);
	}
}
