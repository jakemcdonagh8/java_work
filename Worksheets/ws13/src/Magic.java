import java.io.PrintWriter;
import java.util.Scanner;


public class Magic extends Treasure {
	private String type;
	private int damage;
	
	public Magic() {
		name = "no weapon";
	}

	public Magic(String n, int v, String t, int numB) {
		super(n, v);
		type = t;
		damage = numB;
	}
	
	@Override
	public void readKeyboard() {
		super.readKeyboard();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter magic type: ");
		type = in.nextLine();
		System.out.print("Enter magic damage: ");
		damage = in.nextInt();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDamage() {
		return damage;
	}

	@Override
	public String toString() {
		return super.toString() + " magic type= " + type + ", damage= " + damage;
	}
	
	@Override
	public void save(PrintWriter pw){
		pw.println("magic");
		super.save(pw);
		pw.println(type);
		pw.println(damage);
	}
	
	@Override
	public void load(Scanner scan){
		super.load(scan);
		type = scan.next();
		scan.nextLine();
		damage = scan.nextInt();
		scan.nextLine();
	}
}