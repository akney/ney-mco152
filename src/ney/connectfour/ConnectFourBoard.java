package ney.connectfour;

public class ConnectFourBoard {
	private char[][] board;
	private int[] howFullIsColumn; // use it to determine next available space
									// in a column

	public ConnectFourBoard() {
		board = new char[6][7];
		howFullIsColumn = new int[6];
	}

	/**
	 * Simulates a players turn
	 * 
	 * @param col
	 *            - the player selects which column it wants to put the piece
	 *            into
	 * @param player
	 *            - char either r or b to show who is playing the turn
	 * @return an int of the row so the gui knows where it is
	 */
	public int turn(int col, char player) {
		if (!fullColumn(col)) {
			int row = howFullIsColumn[col];
			board[row][col] = player;
			howFullIsColumn[col]++;
			return row;
		} else {
			return -1;
		}

	}

	/**
	 * Checks whether a column is full or not
	 * 
	 * @param col
	 * @return boolean - true if full, false if not full
	 */
	private boolean fullColumn(int col) {
		if (howFullIsColumn[col] == 6) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Checks if the whole board is full
	 * 
	 * @return boolean - true if full, false if not full
	 */
	public boolean fullBoard() {
		for (int i = 0; i < howFullIsColumn.length; i++) {
			if (howFullIsColumn[i] < 6) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Determines if there is a winner
	 * 
	 * @return true if there is a winner
	 */
	public boolean winner() {
		int counter = 1;
		for (int i = 0; i < 6; i++) { // checks for row
			counter = 1;
			char first = board[i][0];
			for (int j = 1; j < 7; j++) {
				if (first == board[i][j]) {
					counter++;
				} else {
					first = board[i][j];
					counter = 1;
				}

				if (counter == 4) {
					return true;
				}
			} // inner for
		} // outer for

		for (int j = 0; j < 7; j++) { // checks for column
			counter = 1;
			if (howFullIsColumn[j] < 3) {
				break;
			}
			char first = board[0][j];
			for (int i = 0; i < 6; i++) {
				if (first == board[i][j]) {
					counter++;
				} else {
					first = board[i][j];
					counter = 1;
				}

				if (counter == 4) {
					return true;
				}
			} // inner for
		} // outer for

		for (int i = 0; i < 6; i++) { // diagnol up to the left
			if (board[i][0] != 'r' || board[i][0] != 'b') {
				break;
			}

			for (int j = 0; j < 7; j++) {
				char first = board[i][j];
				char next;
				counter = 1;
				boolean counterPlussed;
				do {
					if (i + counter < 6 && j + counter < 7) {
						next = board[i + counter][j + counter];

						if (next == first) {
							counter++;
							counterPlussed = true;
						} // end inner if
						else {
							counterPlussed = false;
						}

						if (counter == 4) {

							return true;
						} // end inner if
					} // end outer if
					else {
						counterPlussed = false;
					}
				} while (counterPlussed);

			}
		}

		for (int i = 0; i < 6; i++) { // diagnol up to the right
			if (board[i][0] != 'r' || board[i][0] != 'b') {
				break;
			}

			for (int j = 0; j < 7; j++) {
				char first = board[i][j];
				char next;
				counter = 1;
				boolean counterPlussed;
				do {
					if (i - counter < 6 && j - counter < 7) {
						next = board[i - counter][j - counter];

						if (next == first) {
							counter++;
							counterPlussed = true;
						} // end inner if
						else {
							counterPlussed = false;
						}

						if (counter == 4) {

							return true;
						} // end inner if
					} // end outer if
					else {
						counterPlussed = false;
					}
				} while (counterPlussed);

			}
		}

		return false;
	}

}
