package ney.physics;

import org.junit.Assert;
import org.junit.Test;

public class ProjectileTest {
	@Test
	public void testGetLocationX() {
		Projectile projectile = new Projectile(31, 20, 2.7);
		double x = projectile.getLocationX();

		Assert.assertEquals(27.81, x, 0.01);
	}

	public void testGetLocationY() {
		Projectile p = new Projectile(31, 20, 2.7);
		double y = p.getLocationY();

		Assert.assertEquals(10.56, y, 0.01);
	}
}
