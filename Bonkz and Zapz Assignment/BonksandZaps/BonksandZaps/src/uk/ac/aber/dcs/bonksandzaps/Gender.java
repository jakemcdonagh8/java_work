package uk.ac.aber.dcs.bonksandzaps;

/**
 * The enum that is used to give the beings a gender. Needed to allow bonks to
 * take certain actions.
 * 
 * @author Jake McDonagh
 * @version 1.2 (6th May 2016)
 */
public enum Gender {
	MALE('M'), ZAP('Z'), FEMALE('F');

	private final char letter;

	private Gender(char letter) {
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
