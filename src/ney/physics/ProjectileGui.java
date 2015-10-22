package ney.physics;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProjectileGui extends JFrame {
	private JLabel title;
	private JLabel a;
	private JLabel v;
	private JLabel t;
	private JTextField aEntry;
	private JTextField vEntry;
	private JTextField tEntry;
	private JLabel x;
	private JLabel y;
	private JButton compute;

	public ProjectileGui() {
		setTitle("Projectile GUI");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();

		setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

		title = new JLabel("Enter the angle, velocity, and time of the projectile");
		add(title);
		a = new JLabel("Angle (in degrees): ");
		add(a);
		aEntry = new JTextField();
		add(aEntry);
		v = new JLabel("Velocity: ");
		add(v);
		vEntry = new JTextField();
		add(vEntry);
		t = new JLabel("Time: ");
		add(t);
		tEntry = new JTextField();
		add(tEntry);
		x = new JLabel("X coordinate = ");
		add(x);
		y = new JLabel("Y coordinate = ");
		add(y);

		compute = new JButton("Compute");
		compute.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String s = aEntry.getText();
				Double an = Double.parseDouble(s);
				s = vEntry.getText();
				Double vn = Double.parseDouble(s);
				s = tEntry.getText();
				Double tn = Double.parseDouble(s);
				Projectile p = new Projectile(an, vn, tn);
				x.setText("X coordinate = " + p.getLocationX());
				y.setText("Y coordinate: " + p.getLocationY());

			}
		});
		add(compute);

	}

	public static void main(String[] args) {
		ProjectileGui pg = new ProjectileGui();
		pg.setVisible(true);
	}
}
