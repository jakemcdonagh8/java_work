/**
 * This is the class Monster - a 'blueprint' for all Monsters
 *
 * @author Lynda
 * @version 1
 */
public class Monster {
	// *****************instance variables are the 'attributes' of a thing
	private String type;
	private String hair;
	private String skin;
	private int powerPoints;

	// *****************methods are the 'action' the thing can do
	/**
	 * Constructor for objects of class Monster
	 */
	public Monster() {
		type = "unknown";
		powerPoints = 100;
	}

	/**
	 * Constructor for objects of class Monster
	 * 
	 * @param startType
	 *            becomes initial type
	 * @param startHair
	 *            becomes initial hair colour
	 * @param startPoints
	 *            initial powerPoints
	 */
	public Monster(String startType, String startHair, String startskin,
			int startPoints) {
		type = startType;
		hair = startHair;
		skin = startskin;
		powerPoints = startPoints;
	}

	/**
	 * This method 'returns' information about a monster
	 *
	 * @return monster info for printing
	 */
	public String toString() {
		return "This scary monster is of type " + type + " with " + hair
				+ " hair with " + skin + " skin and " + powerPoints + " points";
	}

	/**
	 * This method makes the monster wail it uses a loop - not done yet
	 */
	public void wail() {
		System.out.println("I am a " + type + " watch me WAIL!!!");
		for (int i = 0; i < powerPoints / 5; i++)
			System.out.println("ooooooooOOOOOOh ");
	}

	public void powerUp() {
		System.out.println("The " + type + " drinks a potion!");
		System.out.println("The " + type + "'s" + " skin colour changes!");

		skin = "blue";
		powerPoints += 50;
	}

	/**
	 * This method sets a new hair colour
	 * 
	 * @param newHairColour
	 *            becomes new hair colour
	 */
	public void setHair(String newHairColour) {
		hair = newHairColour;
	}

	/**
	 * This method gets the hair colour
	 * 
	 * @return hair colour
	 */
	public String getHair() {
		return hair;
	}

	/**
	 * This method sets new powerPoints
	 * 
	 * @param newPoints
	 *            becomes new points
	 */
	public void setPoints(int newPoints) {
		powerPoints = newPoints;
	}
}
