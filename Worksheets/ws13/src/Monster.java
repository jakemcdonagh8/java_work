import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the class Monster - a 'blueprint' for all Monsters lots of get and
 * set methods and comments deleted for space saving on handout
 */
public class Monster {
	// *****************instance variables are the 'attributes' of a thing
	private String type;
	private String hair;
	private String face;
	private int powerPoints;
	private ArrayList<Treasure> loot;

	// *****************methods are the 'action' the thing can do
	public Monster() {
		// This is how we can get one constructor to call another
		this("unknown", "unknown", "unknown", 100);
	}

	public Monster(String startType, String startHair, String startFace, int powerP) {
		type = startType;
		hair = startHair;
		face = startFace;
		powerPoints = powerP;
		loot = new ArrayList<Treasure>(); // Starts with an empty ArrayList (no
											// loot)
	}

	public void setFace(String faceColour) {
		face = faceColour;
	}

	public String getFace() {
		return face;
	}

	public void setHair(String hairColour) {
		hair = hairColour;
	}

	public String getHair() {
		return hair;
	}

	public String toString() {
		if (loot.size() > 0) {
			return "This scary monster is of type " + type + " with " + hair
					+ " hair and " + face + " face and " + powerPoints
					+ " points\n   holding " + loot;
		} else {
			return "This scary monster is of type " + type + " with " + hair
					+ " hair and " + face + " face and " + powerPoints
					+ " points\n holding no loot";
		}
	}

	public void addTreasure(Treasure newstuff) {
		loot.add(newstuff);
	}
	
	public int getPowerPoints() {
		return powerPoints;
	}
	
	public String getType() {
		return type;
	}
	
	public Treasure[] getLoot(){
		// For encapsulation reasons we are not going to return the loot ArrayList
		// but rather will return an array copy. That way, external code cannot
		// change the internal structure of loot directly, except by calling
		// addTreasure method
		Treasure[] lootCopy = new Treasure[loot.size()];
		loot.toArray(lootCopy);
		return lootCopy;
	}

	public void readKeyboard() {
		Scanner in = new Scanner(System.in);
		System.out.print("enter type: ");
		type = in.next();
		System.out.print("enter hair: ");
		hair = in.next();
		System.out.print("enter face: ");
		face = in.next();
		System.out.print("enter power: ");
		powerPoints = in.nextInt();
	}
}