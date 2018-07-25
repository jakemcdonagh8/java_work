package uk.ac.aber.dcs.bonksandzaps;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.text.Position;

/**
 * The class that is used for the data and methods belonging to the bonk class.
 * 
 * @author Jake McDonagh
 * @version 1.2 (6th May 2016)
 *
 */
public class Bonk implements BeingInterface {

	private static int bonkIdentifier = 1;
	private static int babyIdentifier = 1;
	private String name;
	private Gender gender;
	private boolean isMature;
	private boolean hasMated;
	private boolean alive = true;
	private GameLabels symbol = GameLabels.BONK;
	private GameLabels babySymbol = GameLabels.BABYBONK;
	private Location location;

	// Bonk constructor.
	public Bonk(String Name, Gender Gender, boolean Mature, boolean Mated, boolean Alive, Location Location) {
		isMature = Mature;
		if (isMature == true) {
			name = Name + bonkIdentifier;
			bonkIdentifier++;
		} else {
			name = "Baby" + Name + babyIdentifier;
			babyIdentifier++;
		}

		hasMated = Mated;
		gender = Gender;
		alive = Alive;
		location = Location;

	}

	// The act method on the Bonk. Please keep in mind that unfortunelately, the
	// method was not completed
	// in time and is not as robust as I would have liked it to have been.
	@Override
	public void act() {

		for (BeingInterface j : GridWorld.getArray()) {

			if ((alive == false)) {

			} else if ((j.getLocation().getRow() == location.getRow())
					&& (j.getLocation().getColumn() == location.getColumn())) {
				if (!j.getName().equals(name)) {
					if (!j.getGender().equals(gender) && !j.equals(Gender.ZAP)) {
						if (j.hasMated() == false) {
							hasMated = true;

							String babyName = "Bonk";
							Gender babyGender = GridWorld.assignGender();
							boolean maturity = false;
							boolean mated = false;
							boolean alive = true;
							GameLabels label = babySymbol;
							Location birthLocation = location;

							int birthRow = birthLocation.getRow();
							int birthCol = birthLocation.getColumn();

							Bonk b = new Bonk(babyName, babyGender, maturity, mated, alive, birthLocation);
							GridWorld.getBabyArray().add(b);
							GridWorld.world[birthRow][birthCol] = label;

							System.out.println(getName() + " Has procreated with " + j.getName() + " to give birth to"
									+ b.getName());
						}
					}
				}
			}
		}

		if (alive == true) {
			Random generator = new Random();
			int action = generator.nextInt(8);

			int currentRow = location.getRow();
			int currentCol = location.getColumn();
			Location newLocation;

			switch (action) {

			case 0:
				GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow][currentCol];
				GridWorld.world[currentRow][currentCol] = symbol;
				break;

			case 1:
				GridWorld.world[currentRow][currentCol] = GameLabels.BLANK;
				GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow--][currentCol--];
				if (currentRow < 0) {
					currentRow = 0;
					GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow][currentCol];
				} else if (currentCol < 0) {
					currentCol = 0;
					GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow][currentCol];
				}
				GridWorld.world[currentRow][currentCol] = symbol;
				newLocation = new Location(currentRow, currentCol);
				setLocation(newLocation);

				break;

			case 2:
				GridWorld.world[currentRow][currentCol] = GameLabels.BLANK;
				GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow--][currentCol];
				if (currentRow < 0) {
					currentRow = 0;
					GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow][currentCol];
				}
				GridWorld.world[currentRow][currentCol] = symbol;
				newLocation = new Location(currentRow, currentCol);
				setLocation(newLocation);
				break;

			case 3:
				GridWorld.world[currentRow][currentCol] = GameLabels.BLANK;
				GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow--][currentCol++];
				if (currentRow < 0) {
					currentRow = 0;
					GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow][currentCol];
				} else if (currentCol > 19) {
					currentCol = 19;
					GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow][currentCol];
				}
				GridWorld.world[currentRow][currentCol] = symbol;
				newLocation = new Location(currentRow, currentCol);
				setLocation(newLocation);
				break;

			case 4:
				GridWorld.world[currentRow][currentCol] = GameLabels.BLANK;
				GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow][currentCol--];
				if (currentCol < 0) {
					currentCol = 0;
					GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow][currentCol];
				}
				GridWorld.world[currentRow][currentCol] = symbol;
				newLocation = new Location(currentRow, currentCol);
				setLocation(newLocation);
				break;

			case 5:
				GridWorld.world[currentRow][currentCol] = GameLabels.BLANK;
				GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow][currentCol++];
				if (currentCol > 19) {
					currentCol = 19;
					GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow][currentCol];
				}
				GridWorld.world[currentRow][currentCol] = symbol;
				newLocation = new Location(currentRow, currentCol);
				setLocation(newLocation);
				break;

			case 6:
				GridWorld.world[currentRow][currentCol] = GameLabels.BLANK;
				GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow++][currentCol--];
				if (currentRow > 19) {
					currentRow = 19;
					GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow][currentCol];
				} else if (currentCol < 0) {
					currentCol = 0;
					GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow][currentCol];
				}
				GridWorld.world[currentRow][currentCol] = symbol;
				newLocation = new Location(currentRow, currentCol);
				setLocation(newLocation);
				break;

			case 7:
				GridWorld.world[currentRow][currentCol] = GameLabels.BLANK;
				GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow++][currentCol];
				if (currentRow > 19) {
					currentRow = 19;
					GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow][currentCol];
				}
				GridWorld.world[currentRow][currentCol] = symbol;
				newLocation = new Location(currentRow, currentCol);
				setLocation(newLocation);
				break;

			case 8:
				GridWorld.world[currentRow][currentCol] = GameLabels.BLANK;
				GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow++][currentCol++];
				if (currentRow > 19) {
					currentRow = 19;
					GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow][currentCol];
				} else if (currentCol > 19) {
					currentCol = 19;
					GridWorld.world[currentRow][currentCol] = GridWorld.world[currentRow][currentCol];
				}
				GridWorld.world[currentRow][currentCol] = symbol;
				newLocation = new Location(currentRow, currentCol);
				setLocation(newLocation);
				break;

			default:
				System.err.println("ERROR: Bonk was not capable of moving.");
				break;
			}
		}

	}

	// The gets and sets used in order to call certain information needed
	// throughout the program.
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public void setLocation(Location newLocation) {
		location = newLocation;

	}

	public Gender getGender() {
		return gender;

	}

	public boolean hasMated() {
		return hasMated;
	}

	public void isAlive() {
		alive = false;
		name = name + "dead";
	}

	public boolean getAlive() {
		return alive;
	}

	public String toString() {
		return null;

	}

}
