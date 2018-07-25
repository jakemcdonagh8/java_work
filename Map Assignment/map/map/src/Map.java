import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Jake McDonagh
 * @version 1.0 (17th March 2016)
 *
 */

public class Map {
	private static final String SETTLEMENTS_FILENAME = "settlements.txt";
	private static final String ROADS_FILENAME = "roads.txt";
	private ArrayList<Settlement> settlements;
	private ArrayList<Road> roads;

	//Constructor for the Map.
	public Map() {
		settlements = new ArrayList<Settlement>();
		roads = new ArrayList<Road>();
	}

	/**
	 * In this version we display the result of calling toString on the command
	 * line. Future versions may display graphically
	 */
	public void display() {
		System.out.println(toString());
	}

	//The method to add a settlement to the map
	public void addSettlement(Settlement newSettlement) throws IllegalArgumentException {
		if (settlements.contains(newSettlement)) {
			System.out.println("ERROR: Settlement already exists. Please choose a new name.");

		} else {
			settlements.add(newSettlement);
		}
	}

	//The method to delete a settlement from the map.
	public void deleteSettlement(String n) {
		for (Settlement s : settlements) {
			if (n.equals(s.getName())) {
				settlements.remove(s);
				System.out.println("The following settlement has been removed");
				return;
			}

		}
		System.out.println(
				"ERROR: Name of settlement not found." + " Please ensure that the details have been entered correctly");
	}

	//The method to add a road to the map.
	public void addRoad(Road newRoad) throws IllegalArgumentException {
		boolean canCreate = true;
		for (Road r : roads) {
			if ((r.getSourceSettlement() == newRoad.getSourceSettlement()
					&& r.getDestinationSettlement() == newRoad.getDestinationSettlement())
					|| (r.getSourceSettlement() == newRoad.getDestinationSettlement()
							&& r.getDestinationSettlement() == newRoad.getSourceSettlement())) {
				canCreate = false;
			}
		}
		if (!canCreate) {
			System.out.println("ERROR, ROAD ALLREDY EXIST !!!");
		} else {
			roads.add(newRoad);
		}
	}
	
	//The method to delete a road from the map. NOTE: the deletion of the roads doesen't work. Please keep that in mind whilst testing.
	public void removeRoad(Road r){
		r.getDestinationSettlement().delete(r);
		r.getSourceSettlement().delete(r);
	}
	//The method to find a road.
	public Road findRoad (String n, String source, String destination) {
		for (Road r : roads){
			if ((r.getName().equals(n) && r.getSourceSettlement().getName().equals(source)
					&& r.getDestinationSettlement().getName().equals(destination))
					||
					(r.getName().equals(n) && r.getSourceSettlement().getName().equals(destination)
							&& r.getDestinationSettlement().getName().equals(source))) {
				return r;
			}		
		}
		return null;
	}

	//The method to find a settlement
	public Settlement findSettlement(String name) {

		Settlement settlementFound = null;
		for (Settlement s : settlements) {
			if (s.getName().equals(name)) {
				settlementFound = s;
			}
		}
		return settlementFound;
	}

	//The method to load the settlements.txt and roads.txt files into the map.
	public void load() throws FileNotFoundException {
		settlements.clear();
		roads.clear();

		Scanner scan = new Scanner(new FileReader(SETTLEMENTS_FILENAME));
		scan.useDelimiter(":|\r?\n|\r");

		int num = scan.nextInt();
		for (int i = 0; i < num; i++) {
			String n = scan.next();
			SettlementType k = SettlementType.valueOf(scan.next());
			int pop = scan.nextInt();

			addSettlement(new Settlement(n, k, pop));
		}
		scan.close();

		scan = new Scanner(new FileReader(ROADS_FILENAME));
		scan.useDelimiter(":|\r?\n|\r"); // UNIX and Windows line endings
		num = scan.nextInt();

		for (int i = 0; i < num; i++) {
			String n = scan.next();
			Classification c = Classification.valueOf(scan.next());
			double l = scan.nextDouble();

			String s = scan.next();
			Settlement source = findSettlement(s);

			String d = scan.next();
			Settlement destination = findSettlement(d);

			Road r = new Road(n, c, source, destination, l);
			addRoad(r);
		}
		scan.close();
	}

	//The method to save the settlements and roads from the map into their .txt counterparts.
	public void save() throws IOException {
		int num = roads.size();
		PrintWriter pw = new PrintWriter(new FileWriter(ROADS_FILENAME));
		pw.println(num);
		for (Road r : roads) {
			pw.print(r.getName() + ":");
			pw.print(r.getClassification() + ":");
			pw.print(r.getLength() + ":");
			pw.print(r.getSourceSettlement().getName() + ":");
			pw.println(r.getDestinationSettlement().getName());
		}
		pw.close();

		num = settlements.size();
		pw = new PrintWriter(new FileWriter(SETTLEMENTS_FILENAME));
		pw.println(num);

		for (Settlement s : settlements) {
			pw.print((s.getName()) + ":");
			pw.print(s.getKind() + ":");
			pw.println(s.getPopulation());
		}
		pw.close();
	}

	public String toString() {
		System.out.println("Below is the following information about the settlements within the system:");
		String result = "";

		result += "Below is the following information about the settlements witin the system: \nSettlements:\n";
		result += settlements.toString();
		result += "\n\n";
		result += "\n\nRoads: \n" + roads.toString();

		return result;
	}
}
