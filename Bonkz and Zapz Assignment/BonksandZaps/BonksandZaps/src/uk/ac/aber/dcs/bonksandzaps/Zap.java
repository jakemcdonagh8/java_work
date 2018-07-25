package uk.ac.aber.dcs.bonksandzaps;

import java.util.Random;

import javax.swing.text.Position;

/**
 * The class that is used to the data and methods belonging to the zap class.
 * 
 * @author Jake McDonagh
 * @version 1.2 (6th May 2016)
 *
 */
public class Zap implements BeingInterface {
	private static int zapIdentifier = 1;

	private String name;
	private Location location;
	private Gender gender;
	private GameLabels symbol = GameLabels.ZAP;

	// Zap constructor
	public Zap(String Name, Gender Gender, Location Location) {

		name = Name + zapIdentifier;
		gender = Gender;
		location = Location;

		zapIdentifier++;
	}

	// The act method on the Zap. Please keep in mind that unfortunelately, the
	// method was not completed
	// in time and is not as robust as I would have liked it to have been.
	@Override
	public void act() {
		for (BeingInterface j : GridWorld.getArray()) {
			if ((j.getLocation().getRow() == location.getRow())
					&& (j.getLocation().getColumn() == location.getColumn())) {
				if (!j.getName().equals(name) && !j.equals(Gender.ZAP)) {
					System.out.println(getName() + " has zapped " + j.getName() + " to death");
					j.isAlive();
				}
			}
		}

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

	@Override
	public boolean hasMated() {

		return false;
	}

	@Override
	public void isAlive() {

	}

}
