package ney.physics;

public class ProjectileMain {
	public static void main(String[] args) {
		Projectile projectile = new Projectile(31.0, 20.0, 0);
		double z = 0;
		double x;
		double y;
		do{
			x = projectile.getLocationX();
			y = projectile.getLocationY();
			
			System.out.println("At time " + z + " X: " + x + " Y: " + y);
			
			projectile.setTime(++z);
		}while(z<11);
		
	}

	

}
