
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class to test the Road and Settlement classes
 * 
 * @author Jake McDonagh (add your name and change version number/date)
 * @version 1.0 (17th March 2016)
 *
 */
public class Application {
	private Map map;
	private Scanner scan;

	//Initialising a map object and a scanner for further use.
	public Application() {
		map = new Map();
		scan = new Scanner(System.in);
	}

	//The function that is called once the map object has been loaded. From here the menu is printed to the user. The case statements
	//are the list of options that the user is capable of selecting.
	private void runMenu() throws IOException {

		String choice;
		do {
			//Prints the menu
			printMenu();
			choice = scan.next().toUpperCase();

			switch (choice) {
			//Case 1 allows the user to create a settlement.
			case "1":
				createSettlement();
				break;
				
			//Case 2 allows the user to delete a settlement from the text file.
			case "2":
				deleteSettlement();
				break;
				
			//Case 3 allows the user to create a road.
			case "3":
				addRoad();
				break;
				
			//Case 4 allows the user to delete a road from the text file. Please note that this requirement does not work properly.
			case "4":
					deleteRoad();		
				break;
				
			//Case 5 allows the user to display a text based map from the roads and settlements (Also displays all of the information of each
			//road and settlement)
			case "5":
				map.display();
				break;
				
			//Case 6 allows the user to save the map (and all of the content inside of it)	
			case "6":
				map.save();
				System.out.println("Map Successfully Saved!");
				break;
				
			//Case Q allows the user to quit the program. The following code below is a prompt to make sure the user
			//Wants to quit. 
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
				
			//If one of the following options wasn't chosen, this message box appears.	
			default:
				System.out.println("The following input was not a valid choice");
			}
		} while (!choice.equals("Q"));
	}

	//Displays the options of road classes that the user can input. Used during the createRoad() method.
	private Classification askForRoadClassifier() {
		Classification result = null;
		Scanner in = new Scanner(System.in);
		boolean valid;
		do {
			valid = false;
			System.out.println("Enter a road classification: ");
			for (Classification cls : Classification.values()) {
				System.out.print(cls + " ");
			}
			String choice = in.nextLine().toUpperCase();
			try {
				result = Classification.valueOf(choice);
				valid = true;
			} catch (IllegalArgumentException iae) {
				System.out.println("Please enter one of the following options");
			}
		} while (!valid);
		return result;
	}

	//Saves the map. This method is used frequently throughout the program, primarily when the user quits the program or when
	//Case 6 is selected
	private void save() throws IOException {
		map.save();
	}

	//Loads the map. Is called at the beginning.
	private void load() throws FileNotFoundException {
		map.load();
	}

	//This method is continuously used throughout the program. Once the user is done with one of the options, this menu will be recalled
	//to allow the user to select another choice.
	private void printMenu() {
		System.out.println(
				"Please select one of the following options: \n 1. Create a settlement \n 2. Delete a settlement \n"
						+ " 3. Create a road \n 4. Delete a road \n 5. Display the Map \n" + " 6. Save Map \n Q. Quit");
	}

	//This method asks the user to input a name, type of settlement and population in order to create a settlement.
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
		map.addSettlement(settlement);
	}
	
	//This method asks the user to input the settlement's name. Once the name has been inputted, the entire arraylist is searched.
	//Once the settlement has been found, it is deleted.
	private void deleteSettlement() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the settlement's name:");
		String name = in.nextLine();
		map.deleteSettlement(name);
	}
	
	//This method asks the user to input the information about the road in order to add a new road object into the arraylist.
	private void addRoad() {
		Road road = null;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the following info about the road");
		System.out.print("The Name: ");
		String name = in.nextLine();
		
		System.out.print("The length of the road:");
		double length;
		
		while (true)
			try {
				length = Double.parseDouble(in.nextLine());
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("The following input is invalid: Please try again.");
			}
		
		System.out.print("The Source Settlement's Name:");
		String sourceName = in.nextLine();
		Settlement sourceResult = map.findSettlement(sourceName);
		
		System.out.print("The Destination Settlement's Name:");
		String destinationName = in.nextLine();
		Settlement destinationResult = map.findSettlement(destinationName);
		Classification classifier = askForRoadClassifier();
		
		if (sourceResult == null || destinationResult == null){
			System.out.println("ERROR: Source or Destination Settlement could not be found");
		}else{
			road = new Road(name, classifier, sourceResult, destinationResult, length);
			map.addRoad(road);
		}
	    System.out.println("Road has been created");
	}
	
	//This method allows the user to delete a road from the roads arraylist.
	private void deleteRoad() {
		System.out.println("Please enter the road's name: ");
		String n = scan.next();
		System.out.println("Please enter the source settlement's name: ");
		String sourceSet = scan.next();
		System.out.println("Please enter the destination settlement's name: ");
		String desSet = scan.next();
		
		if (map.findRoad(n, sourceSet, desSet) != null) {
			map.removeRoad(map.findRoad(n, sourceSet, desSet));
		
			System.out.println("Road has been removed.");
		} else {
			System.out.println("ERROR: Road does not exist within the system");	
		}
	}

	//The method that runs when the application is running.
	public static void main(String args[]) throws IOException {
		Application app = new Application();
		app.load();
		app.runMenu();
		app.save();
	}

}
