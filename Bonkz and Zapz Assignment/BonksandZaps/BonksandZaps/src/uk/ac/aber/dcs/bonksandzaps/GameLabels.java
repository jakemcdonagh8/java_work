package uk.ac.aber.dcs.bonksandzaps;

/**
 * The enum that is used to give the beings a visual representation on the grid.
 * 
 * @author Jake McDonagh
 * @version 1.2 (6th May 2016)
 */
public enum GameLabels {

	ZAP('Z'), BONK('B'), BABYBONK('b'), DEADBONK('X'), BLANK(' ');

	private final char letter;

	private GameLabels(char letter) {
		this.letter = letter;
	}

	/**
	 * @return The string form of the enum
	 */
	@Override
	public String toString() {
		return this.letter + "";
	}
}
