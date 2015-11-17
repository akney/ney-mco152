package ney.connectfour;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConnectFourJFrame extends JFrame {
	private char player;
	private ConnectFourComponent[][] holder;
	ConnectFourBoard board;

	public ConnectFourJFrame() {
		setTitle("Connect Four");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		setLayout(new GridLayout(7, 7));

		holder = new ConnectFourComponent[6][7];
		board = new ConnectFourBoard();

	

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
					int row = board.turn(col, player);
					holder[5 - row][col].changeColor(player);
				}
			});
			add(buttons[i]);
		}

		for (int m = 0; m < 6; m++) {
			for (int n = 0; n < 7; n++) {
				holder[m][n] = new ConnectFourComponent();
				add(holder[m][n]);
			}
		}	
		
		player = JOptionPane.showInputDialog("Enter who will go first red or blue: ").toLowerCase().charAt(0);
		while (player != 'r' && player != 'b') {
			player = JOptionPane.showInputDialog("Enter who will go first red or blue: ").toLowerCase().charAt(0);
		}
		do{
		
			player = player == 'r' ? 'b' : 'r';
			if(board.winner()){
				
			}
		}while(!board.winner() && !board.fullBoard());

	}
}
