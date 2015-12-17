package ney.airline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * This class is part of an Airline Reservation system. It holds seats that are
 * reserved. You are allowed to add your own member variables and private
 * methods.
 */
public class AirplaneSeats {
	HashMap<Integer, HashSet<Character>> seats;
	int rows;
	int columns;
	char highestCol;

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {
		seats = new HashMap<Integer, HashSet<Character>>();
		this.rows = rows;
		this.columns = columns;
		highestCol = (char) (columns + 64);
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
		char letter = seatName.charAt(0);
		int number = Character.getNumericValue(seatName.charAt(1));
		if (isReserved(seatName)) {
			throw new AlreadyReservedException();
		} else if (letter > highestCol || number > columns) {
			throw new SeatOutOfBoundsException();
		} else {
			HashSet<Character> letters = new HashSet<Character>();
			if (seats.containsKey(number)) {
				letters = seats.get(number);
				letters.add(letter);
				seats.replace(number, letters);
			} else {
				letters.add(letter);
				seats.put(number, letters);
			}
		}

	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved(String seatName) {
		char letter = seatName.charAt(0);
		int number = Character.getNumericValue(seatName.charAt(1));
		return seats.containsKey(letter) && seats.get(letter).contains(number);

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
	 * @throws SeatOutOfBoundsException
	 * @throws AlreadyReservedException
	 */
	public ArrayList<String> reserveGroup(int numberOfSeatsTogether)
			throws NotEnoughSeatsException, AlreadyReservedException, SeatOutOfBoundsException {
		ArrayList<String> group = new ArrayList<String>();
		if (numberOfSeatsTogether > columns) {
			throw new NotEnoughSeatsException();
		} else if (isPlaneFull()) {
			throw new NotEnoughSeatsException();
		} else {
			for (Integer i = 0; i < rows; i++) {
				if (!seats.containsKey(i)) {
					for (int j = 1; j < numberOfSeatsTogether; j++) {
						String seat = i.toString() + (char) (j + 64);
						reserve(seat);
						group.add(seat);
					}
					return group;
				} else if (seats.get(i).size() > columns - numberOfSeatsTogether) {
					break;
				} else {

				}
			}

		}
		return null;
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {
		if (seats.size() < rows) {
			return false;
		}

		for (Map.Entry<Integer, HashSet<Character>> entry : seats.entrySet()) {
			if (entry.getValue().size() < columns) {
				return false;
			}
		}

		return true;

	}

}
