
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class to test the Road and Settlement classes
 * 
 * @author Chris Loftus (add your name and change version number/date)
 * @version 1.0 (24th February 2016)
 *
 */
public class Application {
	private Map map;
	private Scanner scan;

	public Application() {
		map = new Map();
		scan = new Scanner(System.in);

	}

	private void runMenu() throws IOException {
		
		String choice;
		do {
			printMenu();
			choice = scan.next().toUpperCase();

			switch (choice) {
			
			case "1":
				createSettlement();
				break;
			case "2":

				break;
			case "3":

				break;
			case "4":

				break;
			case "5":

				break;
			case "6":
				map.save();
				System.out.println("Map Successfully Saved!");
				break;
			case "Q":
				System.out.println("Are you sure you want to quit the program? (Y/N)");
			    String quitchoice = scan.next().toUpperCase();
				if (quitchoice.equals("Y")) {
					System.out.println("Quiting System...");
					break;
				} else {
					System.out.println("Returning to Menu...");
					choice = "J";
					break;
				}
			default:
				System.out.println("The following input was not a valid choice");
			}
		} while (!choice.equals("Q"));
	}

	// STEP 1: ADD PRIVATE UTILITY MENTHODS HERE. askForRoadClassifier, save and
	// load provided

	private Classification askForRoadClassifier() {
		Classification result = null;
		boolean valid;
		do {
			valid = false;
			System.out.print("Enter a road classification: ");
			for (Classification cls : Classification.values()) {
				System.out.print(cls + " ");
			}
			String choice = scan.nextLine().toUpperCase();
			try {
				result = Classification.valueOf(choice);
				valid = true;
			} catch (IllegalArgumentException iae) {
				System.out.println(choice + " is not one of the options. Try again.");
			}
		} while (!valid);
		return result;
	}

	private void save() throws IOException {
		map.save();
	}

	private void load() throws FileNotFoundException {
		map.load();
	}

	private void printMenu() {
		System.out.println(
				"Please select one of the following options: \n 1. Create a settlement \n 2. Delete a settlement \n"
						+ " 3. Create a road \n 4. Delete a road \n 5. Display the Map \n" + " 6. Save Map \n Q. Quit");
	}

	private void createSettlement() {
		Settlement settlement = null;
		Scanner in = new Scanner(System.in);

		System.out.println("Please enter the following info about the settlement");

		System.out.print("The Name: ");
		String name = in.nextLine();

		System.out.print("The type of Settlement (Hamlet, Village, Town or City: ");
		String typeStringSize = in.next();
		SettlementType settlementType = SettlementType.valueOf(typeStringSize.toUpperCase());

		switch (settlementType) {
		case HAMLET:
			in.nextLine();
			System.out.println("HAMLET");
			break;
		case VILLAGE:
			in.nextLine();
			System.out.println("VILLAGE");
			break;
		case TOWN:
			in.nextLine();
			System.out.println("TOWN");
			break;
		case CITY:
			in.nextLine();
			System.out.println("CITY");
			break;
		default:
			System.out.println("None of the following options were selected");
			break;
		}

		System.out.print("The population:");
		int population;
		while (true)
			try {
				population = Integer.parseInt(in.nextLine());
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("The following input is invalid: Please try again.");
			}

		settlement = new Settlement(name, settlementType, population);

		map.search(settlement);
		map.addSettlement(settlement);

	}

	public static void main(String args[]) throws IOException {
		Application app = new Application();
		app.load();
		app.runMenu();
		app.save();
	}

}
