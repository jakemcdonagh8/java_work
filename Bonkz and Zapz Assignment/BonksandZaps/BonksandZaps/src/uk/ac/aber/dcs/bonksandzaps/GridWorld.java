package uk.ac.aber.dcs.bonksandzaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * The class that is used visually represent the data to the user.
 * 
 * @author Jake McDonagh
 * @version 1.2 (6th May 2016)
 *
 */
public class GridWorld {
	static Random generator = new Random();
	private static ArrayList<BeingInterface> beings;
	private static ArrayList<BeingInterface> babyArray;
	private int choiceRow;
	private int choiceCol;
	static GameLabels[][] world;

	// The constructor for gridworld. It creates two arraylists that are used
	// throughout the program.
	public GridWorld() {
		beings = new ArrayList<BeingInterface>();
		babyArray = new ArrayList<BeingInterface>();
	}

	// Calls the toString() method in order to create the visual grid for the
	// user.
	public void display() {
		System.out.println(world);
	}

	// Creates the spaces for gridworld.
	public void setSpacesDefault() {
		world = new GameLabels[20][20];
		for (int row = 0; row < world.length; row++) {
			for (int col = 0; col < world[row].length; col++) {
				world[row][col] = GameLabels.BLANK;
			}
		}
	}

	// Creates the default number of beings for the beginning of the program, 20
	// bonks and 5 zaps.
	public void createBeingsDefault() {
		beings.clear();
		for (int i = 0; i < 19; i++) {
			String name = "Bonk";
			Gender gender = assignGender();
			boolean maturity = true;
			boolean mated = false;
			boolean alive = true;
			GameLabels label = GameLabels.BONK;

			int r = generator.nextInt(20);
			int c = generator.nextInt(20);

			Location position = new Location(r, c);

			Bonk b = new Bonk(name, gender, maturity, mated, alive, position);
			beings.add(b);
			world[r][c] = label;
		}

		for (int i = 0; i < 4; i++) {
			String name = "Zap";
			GameLabels label = GameLabels.ZAP;
			Gender gender = Gender.ZAP;

			int r = generator.nextInt(20);
			int c = generator.nextInt(20);

			Location position = new Location(r, c);

			Zap z = new Zap(name, gender, position);
			beings.add(z);
			world[r][c] = label;

		}
	}

	// Assigns a random gender to each bonk that is created.
	public static Gender assignGender() {

		int gender = generator.nextInt(99);

		if (gender < 50) {
			return Gender.MALE;
		} else {
			return Gender.FEMALE;
		}

	}

	// The method used to demonstrate one cycle within the game
	public void oneCycle() {

		for (BeingInterface i : beings) {
			i.act();
		}
	}

	// The following two functions are used in order to call the arraylists to
	// other classes throughout the program.
	// This is needed to allow comparisons between other beings so that they are
	// capable of reproducing, killing etc.
	public static ArrayList<BeingInterface> getArray() {
		return beings;
	}

	public static ArrayList<BeingInterface> getBabyArray() {
		return babyArray;
	}

	// The grid that is displayed to the user. This could be improved upon by
	// creating a basic GUI using JFrame.
	public String toString() {
		String result = "Bonks and Zaps Board State: \n";
		result += "\n---1---2---3---4---5---6---7---8---9---10--11" + "--12--13--14--15--16--17--18--19--20\n";

		for (int row = 0; row < world.length; row++) {
			if (row < 9) {
				result += (row + 1) + " | ";
			} else {
				result += (row + 1) + "| ";
			}
			for (int col = 0; col < world[row].length; col++) {
				result += world[row][col] + " | ";
			}
			result += "\n-------------------------------------------------" + "----------------------------------\n";
		}
		return result;

	}

}
