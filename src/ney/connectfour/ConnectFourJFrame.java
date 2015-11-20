package ney.connectfour;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ConnectFourJFrame extends JFrame {
	private char player;
	private ConnectFourComponent[][] holder;
	ConnectFourBoard board;
	HashMap<String, Integer> statistics;

	public ConnectFourJFrame() {
		setTitle("Connect Four");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		setLayout(new GridLayout(7, 7));

		holder = new ConnectFourComponent[6][7];
		board = new ConnectFourBoard();

		statistics = new HashMap<String, Integer>();
		statistics.put("Red", 0);
		statistics.put("Blue", 0);
		statistics.put("Draw", 0);

		choosePlayer();

		JButton[] buttons = new JButton[7];
		for (int i = 0; i < 7; i++) {
			buttons[i] = new JButton("Click");
			buttons[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					int col = 0;
					Object name = event.getSource();
					for (int i = 0; i < 7; i++) {
						if (name == buttons[i]) {
							col = i;
						}
					}

					int row = board.turn(col, player); // does a turn in the
														// ConnectFourBoard
														// and returns the row

					if (row != -1) {
						boolean restarted = false;

						holder[5 - row][col].changeColor(player); // based on
																	// the row,
																	// I draw
																	// the
																	// component
																	// that
																	// color
						if (board.winner(player, row, col)) { // checking for a
																// winner
							if (player == 'r') {
								statistics.put("Red", statistics.get("Red") + 1);
								JOptionPane.showMessageDialog(null, "Red Wins!");
								showStatistics();
								restart();
								restarted = true;
							} else {
								statistics.put("Blue", statistics.get("Blue") + 1);
								JOptionPane.showMessageDialog(null, "Blue Wins!");
								showStatistics();
								restart();
								restarted = true;
							}

						}
						if (board.fullBoard()) { // checking for draw
							statistics.put("Draw", statistics.get("Draw") + 1);
							JOptionPane.showMessageDialog(null, "No one wins.");
							showStatistics();
							restart();
							restarted = true;
						}
						if (!restarted) {
							player = player == 'r' ? 'b' : 'r'; // change the
																// player
							// for the next turn
						}
					} // end if row != -1

				}// action performed
			});
			add(buttons[i]);
		}

		for (int m = 0; m < 6; m++) {
			for (int n = 0; n < 7; n++) {
				holder[m][n] = new ConnectFourComponent();
				add(holder[m][n]);
			}
		}

	}

	public void choosePlayer() {
		JDialog j = new JDialog();
		JPanel f = new JPanel();

		JLabel l = new JLabel("Choose who should go first.");

		JRadioButton red = new JRadioButton("Red", true);

		JRadioButton blue = new JRadioButton("Blue");

		red.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (red.isSelected()) {
					player = 'r';
					j.dispose();
				}

			}

		});

		blue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (blue.isSelected()) {
					player = 'b';
					j.dispose();
				}
			}

		});

		ButtonGroup g = new ButtonGroup();
		;
		g.add(red);
		g.add(blue);

		f.add(l);
		f.add(red);
		f.add(blue);

		j.setSize(500, 100);
		j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		j.setLayout(new FlowLayout());
		j.add(f);
		j.setLocationRelativeTo(f);
		j.setModal(true);
		j.setAlwaysOnTop(true);
		j.setVisible(true);

	}

	public void showStatistics() {
		JOptionPane.showMessageDialog(null, "Statistics:\nRed Wins: " + statistics.get("Red") + "\nBlue wins: "
				+ statistics.get("Blue") + "\nDraws: " + statistics.get("Draw"));
	}

	public void restart() {
		choosePlayer();
		for (int m = 0; m < 6; m++) {
			for (int n = 0; n < 7; n++) {
				holder[m][n].changeColor(null);
				;

			}
		}
		board = new ConnectFourBoard();
	}

}
