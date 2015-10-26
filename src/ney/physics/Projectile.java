package ney.physics;

public class Projectile {

	private double angle;
	private double velocity;
	private double time;
	private double radians;

	public Projectile(double angle, double velocity, double time) {
		this.angle = angle;
		this.velocity = velocity;
		this.time = time;
		this.radians = Math.toRadians(angle);
	}

	public double getLocationX() {
		double x = Math.sin(radians) * velocity * time;
		return x;
	}

	public double getLocationY() {
		double y = Math.cos(radians) * velocity * time - .5 * 9.8 * time * time;
		return y;
	}

	public void setTime(double time) {
		this.time = time;
	}
}
