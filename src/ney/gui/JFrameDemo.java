package ney.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrameDemo extends JFrame {
	private JTextField jtf;
	private JLabel label;
	private JLabel label2;
	private JButton b1;

	public JFrameDemo() {
		setTitle("JFrameDemo");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();

		setLayout(new BoxLayout(c, BoxLayout.X_AXIS));

		jtf = new JTextField();
		jtf.setText("Here is some text");

		label = new JLabel("All this text gets shown all the time.");
		add(label);
		label2 = new JLabel("More Labels");
		add(label2);
		b1 = new JButton("A Button");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("IT WORKED!");

			}
		});
		add(b1);
		add(jtf);

	}

}
