package ney.connectfour;

public class ConnectFourBoard {
	private char[][] board;
	private int[] howFullIsColumn;

	public ConnectFourBoard() {
		board = new char[6][7];
		howFullIsColumn = new int[6];
	}

	public void turn(int col, char player) {
		if (!fullColumn(col)) {
			int row = howFullIsColumn[col - 1];
			board[row][col - 1] = player;
			howFullIsColumn[col - 1]++;
		}
	}

	private boolean fullColumn(int col) {
		if (howFullIsColumn[col - 1] == 6) {
			return true;
		} else {
			return false;
		}

	}

	private boolean fullBoard() {
		for (int i = 0; i < howFullIsColumn.length; i++) {
			if (howFullIsColumn[i] < 6) {
				return false;
			}
		}

		return true;
	}

}
