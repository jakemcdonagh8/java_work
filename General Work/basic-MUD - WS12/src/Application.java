import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
	private static final String TREASURES_FILENAME = "treasures.txt";
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
				String faceColour = in.nextLine();
				monster.setFace(faceColour);
				break;
			case "3":
				System.out.println("Enter hair details: ");
				String hairColour = in.nextLine();
				monster.setHair(hairColour);
				break;
			case "4":
				System.out.println("enter info about the new treasure");
				treasure = new Treasure();
				treasure.readKeyboard();
				treasures.add(treasure);
				break;
			case "5":
				monster = giveTreasureToMonster(treasure);
				break;
			case "6":
				System.out.println("enter monster name");
				String toFind = in.nextLine();
				Monster monster1 = findMonster(toFind);
				if (monster1 != null) {
					System.out.println(monster1.toString());
				} else {
					System.err.println("Monster doesen't exist");
				}
				break;
			case "7":
				System.out.println("enter treasure name");
				toFind = in.nextLine();
				Treasure treasure1 = findTreasure(toFind);
				if (treasure1 != null) {
					System.out.println(treasure1.toString());
				} else {
					System.err.println("Treasure doesen't exist");
				}
				break;
			case "8":
				System.out.println(this.toString());
				break;
			case "9":
				save();
				System.out.println("Monster details saved");
				break;
			case "10":
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

	private void load() throws FileNotFoundException {
		treasures.clear();
		Scanner scan = new Scanner(new FileReader(TREASURES_FILENAME));
		int num = scan.nextInt();
		for (int i = 0; i < num; i++) {
			scan.nextLine();
			String n = scan.nextLine();
			int v = scan.nextInt();
			Treasure t = new Treasure(n, v);
			treasures.add(t);
		}
		scan.close();

		monsters.clear();
		scan = new Scanner(new FileReader(MONSTERS_FILENAME));
		scan.useDelimiter("\r?\n|\r");
		num = scan.nextInt();
		for (int i = 0; i < num; i++) {
			String t = scan.next();
			String h = scan.next();
			String f = scan.next();
			int powerP = scan.nextInt();
			Monster m = new Monster(t, h, f, powerP);

			int numTreasures = scan.nextInt();
			for (int nt = 0; nt < numTreasures; nt++) {
				String toFind = scan.next();
				Treasure foundTreasure = findTreasure(toFind);
				m.addTreasure(foundTreasure);
			}
			monsters.add(m);
		}
		scan.close();
	}

	private void save() throws IOException {
		int num = treasures.size();
		PrintWriter pw = new PrintWriter(new FileWriter(TREASURES_FILENAME));
		pw.println(num);
		for (Treasure t : treasures) {
			pw.println(t.getName());
			pw.println(t.getValue());
		}
		pw.close();

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
				pw.println(mt.getName());
			}
		}
		pw.close();

	}

	private Monster giveTreasureToMonster(Treasure treasure) {
		Monster monster = null;
		if (treasure != null) {
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
				.println("1 - create monster \n 2 - edit face \n"
						+ " 3 - edit hair \n 4 - create treasure \n 5 - give treasure to a monster \n"
						+ " 6 - search monster \n 7 - search treasure \n 8 - print \n 9 - save \n 10 - load \n q = quit");
	}

	public String toString() {
		return "All treasures: " + treasures
				+ " All monsters and their treasures: " + monsters;
	}

	public static void main(String args[]) throws IOException {
		Application app = new Application();
		app.runApp();
	}
}