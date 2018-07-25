import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Chris Loftus 
 * @version 1.0 (25th February 2016)
 *
 */

public class Map {
	private static final String SETTLEMENTS_FILENAME = "settlements.txt";
	private ArrayList <Settlement> settlements;
	
	public Map() {
		settlements = new ArrayList<Settlement>();
		
	}

	/**
	 * In this version we display the result of calling toString on the command
	 * line. Future versions may display graphically
	 */
	public void display() {
		System.out.println(toString());
	}

	public void addSettlement(Settlement newSettlement) throws IllegalArgumentException {
		settlements.add(newSettlement);
	}

	public void deleteSettlement (Settlement oldSettlement) {
		
	}
	
	// STEPS 7-10: INSERT METHODS HERE, i.e. those similar to addSettlement and required
	//  by the Application class
	
	public void search(Settlement currentSettlement) {
		
		for (Settlement s : settlements) {
			if(currentSettlement.getName().equals(s.getName())) {
				if(currentSettlement.getKind().equals(s.getKind())) {
					System.out.println("ERROR: Name of settlement already exists within program.");		
				}	
			}	
		}	
	}
	
	public void load() throws FileNotFoundException { 
		settlements.clear();
		
		Scanner scan = new Scanner(new FileReader(SETTLEMENTS_FILENAME));
		scan.useDelimiter(":|\r?\n|\r");

		int numofsettlements = scan.nextInt();
		
		for (int i = 0; i < numofsettlements; i++) {
			String n = scan.next();
			SettlementType k = SettlementType.valueOf(scan.next()); 
			int pop = scan.nextInt();
			
			
			Settlement s = new Settlement(n, k, pop);	
			settlements.add(s);
		}
		scan.close();
		
		//ROAD STUFF HERE
	}

	public void save() throws IOException {
		int numofsettlements = settlements.size();
		
		//ADD ROAD STUFF HERE
		
		PrintWriter pw = new PrintWriter(new FileWriter(SETTLEMENTS_FILENAME));
		pw.println(numofsettlements);
		
		for (Settlement s : settlements) {
			pw.print((s.getName()) + ":");
			pw.print(s.getKind() + ":");
			pw.println(s.getPopulation());
			
			//ADD ROAD STUFF HERE (JUST FOR NAME OF ROADS)
		}
		pw.close();
	}

	public String toString() {
		String result = "";
		// INSERT CODE HERE
		return result;
	}
}
