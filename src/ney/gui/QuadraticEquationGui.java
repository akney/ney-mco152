package ney.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ney.math.QuadraticEquation;

public class QuadraticEquationGui extends JFrame {
	private JLabel a;
	private JLabel b;
	private JLabel c;
	private JLabel xpos;
	private JLabel xneg;
	private JTextField responseA;
	private JTextField responseB;
	private JTextField responseC;
	private JButton compute;

	public QuadraticEquationGui() {
		setTitle("QuadraticEquationGui");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();

		setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

		a = new JLabel("A (cannot be 0)");
		add(a);
		responseA = new JTextField();
		add(responseA);
		b = new JLabel("B (cannot be 0)");
		add(b);
		responseB = new JTextField();
		add(responseB);
		c = new JLabel("C");
		add(c);
		responseC = new JTextField();
		add(responseC);
		xpos = new JLabel("+X = ");
		add(xpos);
		xneg = new JLabel("-X = ");
		add(xneg);

		compute = new JButton("Compute");
		compute.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				String s = responseA.getText();
				Double an = Double.parseDouble(s);
				s = responseB.getText();
				Double bn = Double.parseDouble(s);
				s = responseC.getText();
				Double cn = Double.parseDouble(s);
				QuadraticEquation qe = new QuadraticEquation(an, bn, cn);
				xpos.setText("+X = " + qe.getPosX());
				xneg.setText("-X = " + qe.getNegX());

			}
		});
		add(compute);

	}

}
