package uk.ac.aber.dcs.bonksandzaps;

/**
 * Represents the location of a being.
 * 
 * @author Jake McDonagh
 * @version 1.2 (6th May 2016)
 */
class Location {
	private int Row;
	private int Column;

	public Location(int row, int col) {
		Row = row;
		Column = col;

	}

	public int getRow() {
		return Row;

	}

	public int getColumn() {
		return Column;
	}

}
