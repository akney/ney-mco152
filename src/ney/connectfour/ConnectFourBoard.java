package ney.connectfour;

public class ConnectFourBoard {
	private char[][] board;
	private int[] howFullIsColumn; // use it to determine next available space
									// in a column

	public ConnectFourBoard() {
		board = new char[6][7];
		howFullIsColumn = new int[7];
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
	public boolean winner(char player) {
		int counter = 0;
		for (int i = 0; i < 6; i++) { // checks for row
			for (int j = 1; j < 7; j++) {
				if (board[i][j] == player) {
					counter++;
				} else {
					counter = 0;
				}

				if (counter == 4) {
					return true;
				}
			} // inner for
		} // outer for

		counter = 0; // resetting the counter
		for (int j = 0; j < 7; j++) { // checks for column
			if (howFullIsColumn[j] > 3) {
				for (int i = 0; i < 6; i++) {
					if (board[i][j] == player) {
						counter++;
					} else {
						counter = 0;
					}
					if (counter == 4) {
						return true;

					}
				}
			}
		}
		counter = 0;
		for (int i = 0; i < 6; i++) { // diagnol up one way
			for (int j = 0; j < 7; j++) {
				if (board[i][j] == player) {
					counter++;
					boolean counterPlussed;
					do {
						if (i + counter < 6 && j + counter < 7) {
							if (board[i][j] == board[i + counter][j + counter]) {
								counter++;
								counterPlussed = true;
							} else {
								counter = 0;
								counterPlussed = false;
							}
						} else {
							counter = 0;
							counterPlussed = false;
						} // end if else

						if (counter == 4) {
							return true;
						} // end if
					} while (counterPlussed); // end do while
				} // end if
			} // end inner for
		} // end outer for

		counter = 0;
		for (int i = 5; i > -1; i--) { // diagnol the other way
			for (int j = 6; i > -1; i--) {
				if (board[i][j] == player) {
					counter++;
					boolean counterPlussed;
					do {
						if (i - counter > -1 && j - counter > -1) {
							if (board[i][j] == board[i - counter][j - counter]) {
								counter++;
								counterPlussed = true;
							} else {
								counter = 0;
								counterPlussed = false;
							}
						} else {
							counter = 0;
							counterPlussed = false;
						} // end if else

						if (counter == 4) {
							return true;
						} // end if

					} while (counterPlussed);
				}
			}
		} /**/

		return false;
	}

}
