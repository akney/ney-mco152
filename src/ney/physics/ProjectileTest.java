package ney.physics;

import org.junit.Assert;
import org.junit.Test;

public class ProjectileTest {
	@Test
	public void testGetLocationX(){
		Projectile projectile = new Projectile(31, 20, 2.7);
		double x =projectile.getLocationX();
		
		Assert.assertEquals(27.81, x, 0.01);
	}
}
