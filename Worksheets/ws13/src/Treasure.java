import java.io.PrintWriter;
import java.util.Scanner;

public class Treasure {
	String name;
	int value;
	String firePower;

	public Treasure() {
		name = "no weapon";
	}

	public Treasure(String n, int v) {
		name = n;
		value = v;
	}

	public void readKeyboard() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter treasure name: ");
		name = in.next();
		System.out.print("enter value: ");
		value = in.nextInt();
	}

	@Override
	public String toString() {
		return name + " worth " + value;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
	
	public void save(PrintWriter pw){
		pw.println(name);
		pw.println(value);
	}
	
	public void load(Scanner scan) {
		name = scan.next();
		value = scan.nextInt();
		scan.nextLine(); 
	}
}
