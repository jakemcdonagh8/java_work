import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
	private static final String TEASURES_FILENAME = "treasures.txt";
	private static final String MONSTERS_FILENAME = "monsters.txt";
	private ArrayList<Monster> monsters;
	private ArrayList<Treasure> treasures;
	private Scanner in;

	public Application() {
		monsters = new ArrayList<Monster>();
		treasures = new ArrayList<Treasure>();
		in = new Scanner(System.in);
	}

	public void runApp() throws IOException {
		Treasure treasure = null;
		Monster monster = null;
		String choice;
		System.out.println("*** HELLO - WELCOME TO MONSTER LAND ");
		do {
			printMenu();
			choice = in.nextLine().toUpperCase();

			switch (choice) {

			case "1":
				System.out.println("enter info about the monster");
				monster = new Monster();
				monster.readKeyboard();
				monsters.add(monster);
				break;
			case "2":
				System.out.println("Enter face details: ");
				String faceColour = in.next();
				monster.setFace(faceColour);
				break;
			case "3":
				System.out.println("Enter hair details: ");
				String hairColour = in.next();
				monster.setHair(hairColour);
				break;
			case "4":
				treasure = readTreasure(treasure);
				break;
			case "5":
				monster = giveTreasureToMonster(treasure);
				break;
			case "6":
				System.out.println(this.toString());
				break;
			case "7":
				save();
				System.out.println("Monster details saved");
				break;
			case "8":
				load();
				System.out.println("Monster details loaded");
				break;
			case "Q":
				System.out.println("*** THANK YOU FOR USING MONSTER LAND");
				break;
			default:
				System.out.println("not a valid choice");
			}
		} while (!choice.equals("Q"));
	}

	private Treasure readTreasure(Treasure treasure) {
		boolean correct = false;
		System.out.println("What kind of treasure (gun, stick or magic)?");
		String type = in.nextLine();
		switch(type){
		case "gun":
			treasure = new Gun();
			correct = true;
			break;
		case "stick":
			treasure = new Stick();
			correct = true;
			break;
		case "magic":
			treasure = new Magic();
			correct = true;
			break;
		default:
			System.err.println("wrong kind, try again");
		}
		if (correct){
			treasure.readKeyboard();
			treasures.add(treasure);
		}
		return treasure;
	}

	/**
	 * 
	 * @throws IOException
	 */
	private void load() throws IOException {
		treasures.clear();
		Scanner scan = new Scanner(new FileReader(TEASURES_FILENAME));
		Treasure treas;
		int num = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < num; i++) {
			String type = scan.nextLine();
			switch(type){
			case "gun":
				treas = new Gun();
				break;
			case "stick":
				treas = new Stick();
				break;
			case "magic":
				treas = new Magic();
				break;
			default:
				throw new IOException("Corrupt data file");
			}
			treas.load(scan);
			treasures.add(treas);
		}
		scan.close();

		// Now Monsters and their treasures
		// Clear out the monsters so that we can load afresh again
		monsters.clear();
		scan = new Scanner(new FileReader(MONSTERS_FILENAME));
		num = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < num; i++) {	
			String t = scan.nextLine();
			String h = scan.nextLine();
			String f = scan.nextLine();
			int powerP = scan.nextInt();
			scan.nextLine();
			Monster m = new Monster(t, h, f, powerP);

			int numTreasures = scan.nextInt();
			scan.nextLine();
			for (int nt = 0; nt < numTreasures; nt++) {
				String toFind = scan.nextLine();
				// Find the treasure in the existing treasures list
				Treasure foundTreasure = findTreasure(toFind);
				m.addTreasure(foundTreasure);
			}
			monsters.add(m);
		}
		scan.close();
	}

	private void save() throws IOException {
		// Treasures first
		int num = treasures.size();
		PrintWriter pw = new PrintWriter(new FileWriter(TEASURES_FILENAME));
		pw.println(num);
		for (Treasure t : treasures) {
			t.save(pw);
		}
		pw.close();

		// Now Monsters and their treasures
		num = monsters.size();
		pw = new PrintWriter(new FileWriter(MONSTERS_FILENAME));
		pw.println(num);
		for (Monster m : monsters) {
			pw.println(m.getType());
			pw.println(m.getHair());
			pw.println(m.getFace());
			pw.println(m.getPowerPoints());
			Treasure[] loot = m.getLoot();
			pw.println(loot.length);
			for (Treasure mt : loot) {
				// We just save the name
				pw.println(mt.getName());
			}
		}
		pw.close();

	}

	private Monster giveTreasureToMonster(Treasure treasure) {
		Monster monster = null;
		if (treasure != null) {
			// Find the relevant monster
			System.out.println("Which monster (name)? ");
			String toFind = in.nextLine();
			monster = findMonster(toFind);
			if (monster != null) {
				monster.addTreasure(treasure);
				System.out.println("DONE!");
			} else {
				System.err.println("Couldn't find monster: " + toFind);
			}
		} else {
			System.err.println("You haven't created any new treasure!");
		}
		return monster;
	}

	private Monster findMonster(String toFind) {
		Monster foundMonster = null;
		for (Monster m : monsters) {
			if (m.getType().equals(toFind)) {
				foundMonster = m;
				break;
			}
		}
		return foundMonster;
	}

	private Treasure findTreasure(String toFind) {
		Treasure foundTreasure = null;
		for (Treasure t : treasures) {
			if (t.getName().equals(toFind)) {
				foundTreasure = t;
				break;
			}
		}
		return foundTreasure;
	}

	public void printMenu() {
		System.out
				.println(" 1 - create monster \n 2 - change face details \n"
						+ " 3 - change hair details \n 4 - create treasure \n 5 - give treasure to a monster \n"
						+ " 6 - print \n 7 - save \n 8 - load \n q = quit");
	}

	public String toString() {
		return "All treasures: " + treasures
				+ " All monsters and their treasures: " + monsters;
	}

	// ////////////////
	public static void main(String args[]) throws IOException {
		Application app = new Application();
		app.runApp();
	}
}
