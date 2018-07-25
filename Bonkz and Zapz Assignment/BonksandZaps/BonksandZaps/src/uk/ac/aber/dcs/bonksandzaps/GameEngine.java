package uk.ac.aber.dcs.bonksandzaps;

import java.io.IOException;
import java.util.Scanner;

/**
 * Main class that is used to ensure that game activity is persistent throughout
 * the program.
 * 
 * @author Jake McDonagh
 * @version 1.2 (6th May 2016)
 *
 */

// Initialising a GridWorld and scan object. The scan is used in order to allow
// the user to carry on with the simulation when
// they are ready to whilst the GridWorld is what is used in order to give the
// 20x20 world that the bonks and zaps use to inhabit.
public class GameEngine {
	private GridWorld grid;
	private Scanner scan;

	// Game Engine Constructor
	public GameEngine() {
		grid = new GridWorld();
		scan = new Scanner(System.in);
	}

	// The runMenu() method. Used to print the menu.
	public void runMenu() throws IOException {
		String choice;

		// Prints the menu
		printMenu();
		choice = scan.next().toUpperCase();

		switch (choice) {
		case "1":
			grid.setSpacesDefault();
			grid.createBeingsDefault();
			break;
		// If one of the following options wasn't chosen, this message box
		// appears.
		default:
			System.out.println("The following input was not a valid choice");
			break;
		}

	}

	// This allows the menu to be recalled if need be
	private void printMenu() {
		System.out.println("Press 1. to Watch the Bonks and Zaps Simulator.");

	}

	// This method is used throughout the program in order to construct the grid
	// needed to visually display gridword to the user.
	private void display() {
		System.out.println(grid);
	}

	// The method that drives the main activity of the game
	private void playDefault() throws InterruptedException {

		for (int i = 0; i < 29; i++) {
			grid.oneCycle();
			Thread.sleep(1000);
			display();
			GridWorld.getArray().addAll(GridWorld.getBabyArray());
			GridWorld.getBabyArray().clear();

		}
	}

	// The main method; the start of the program.
	public static void main(String args[]) throws IOException, InterruptedException {
		GameEngine game = new GameEngine();
		game.runMenu();
		game.playDefault();

	}

}
