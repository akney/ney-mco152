package ney.airline;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is part of an Airline Reservation system. It holds seats that are
 * reserved. You are allowed to add your own member variables and private
 * methods.
 */
public class AirplaneSeats {
	boolean[][] seats;
	HashMap<Character, Integer> letterValues;

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {
		seats = new boolean[rows][columns];
		letterValues.put('A', 1);
		letterValues.put('B', 2);
		letterValues.put('C', 3);
		letterValues.put('D', 4);
		letterValues.put('E', 5);
		letterValues.put('F', 6);
		letterValues.put('G', 7);
		letterValues.put('H', 8);
		letterValues.put('I', 9);
		/*letterValues.put("J", 10);
		letterValues.put("K", 11);
		letterValues.put("L", 12);
		letterValues.put("M", 13);
		letterValues.put("N", 14);
		letterValues.put("O", 15);
		letterValues.put("P", 16);
		letterValues.put("Q", 17);
		letterValues.put("R", 18);
		letterValues.put("S", 19);
		letterValues.put("T", 20);
		letterValues.put("U", 21);
		letterValues.put("V", 22);
		letterValues.put("W", 23);
		letterValues.put("X", 24);
		letterValues.put("Y", 25);
		letterValues.put("Z", 26);*/

	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @throws AlreadyReservedException
	 *             if the seat has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if the seat is outside the columns and rows set in the
	 *             constructor
	 */
	public void reserve(String seatName) throws AlreadyReservedException, SeatOutOfBoundsException {
		char[] name = seatName.toCharArray();
		if ((int) name[1] > seats.length || letterValues.get((Character)name[0]) > seats[0].length) {
			throw new SeatOutOfBoundsException();
		} else if (isReserved(seatName)) {
			throw new AlreadyReservedException();
		} else {
			seats[(int) name[1] - 1][letterValues.get((Character)name[0])] = true;
		}

	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved(String seatName) {
		char[] name = seatName.toCharArray();
		return seats[(int) name[1] - 1][(int) (name[0] - 'A')];

	}

	/**
	 * Reserve all seats in the array of seatNames. This is provided her for
	 * convenience of testing. Do not modify this method.
	 * 
	 * @param seatNames
	 *            is an array of seatNames
	 * @throws AlreadyReservedException
	 *             if one of the seats has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if one of the seats is outside the columns and rows set in
	 *             the constructor
	 */
	public void reserveAll(String... seatNames) throws AlreadyReservedException, SeatOutOfBoundsException {
		for (String seatName : seatNames) {
			reserve(seatName);
		}
	}

	/**
	 * This method is worth 10 points.
	 * 
	 * @return a String representation of reserved and empty seats on the plane
	 *         in the form of.
	 * 
	 *         ABCD 1 #oo#\n 2 #ooo\n 3 ###o\n 4 ##oo\n 5 #ooo\n
	 * 
	 *         Where o is an empty seat and # is a reserved seat.
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		for (int i = 1; i <= seats.length; i++) {
			sb.append(i + 'A' - 1);
		}
		sb.append("\n");
		for (int i = 0; i <= seats.length; i++) {
			sb.append((i + 1) + " ");
			for (int j = 0; j <= seats[i].length; j++) {
				if (seats[i][j]) {
					sb.append("#");
				} else {
					sb.append("o");
				}
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	/**
	 * This method is worth 10 points Reserve a group of seats in the same row.
	 * For instance, on a 3,4 airplane whose "A1" is occupied, calling
	 * reserveGroup(4) should return a list of elements ["A2", "B2", "C2", "D2"]
	 * 
	 * @param numberOfSeatsTogether
	 *            the number of seats to look for that are together
	 * @return an ArrayList of seatNames of the seats that have been reserved.
	 * @throws NotEnoughSeatsException
	 *             if there are not enough seats together to reserve.
	 */
	public ArrayList<String> reserveGroup(int numberOfSeatsTogether) throws NotEnoughSeatsException {
		if (isPlaneFull()) {
			throw new NotEnoughSeatsException();
		}
		if (numberOfSeatsTogether > seats[0].length) {
			throw new NotEnoughSeatsException();
		}
		int row = -1;
		int colCounter = 0;
		int lastCol = -1;
		boolean full = true;
		for (int i = 0; i <= seats.length; i++) {
			for (int j = 0; j <= seats[i].length; j++) {
				if (!seats[i][j]) {
					colCounter++;
					if (colCounter == numberOfSeatsTogether) {
						row = i;
						lastCol = j;
						full = false;
						break;
					}// end inner if
				}// end outer if
			}// end inner for
			if (full == false) {
				break;
			}// end if
		}// end outer for

		if (full == true) {
			throw new NotEnoughSeatsException();
		}

		ArrayList<String> group = new ArrayList<String>(numberOfSeatsTogether);
		StringBuilder sb = new StringBuilder();
		int j = numberOfSeatsTogether - 1;
		for (int i = 0; i < numberOfSeatsTogether; i++) {
			sb.append((lastCol - j + 'A' - 1) + row);
			group.add(sb.toString());
			j--;
		}

		return group;
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		for (int i = 0; i <= seats.length; i++) {
			for (int j = 0; j <= seats[i].length; j++) {
				if (!seats[i][j]) {
					return false;
				}
			}
		}

		return true;

	}

}
