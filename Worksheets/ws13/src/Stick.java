import java.io.PrintWriter;
import java.util.Scanner;


public class Stick extends Treasure {
	private int length;
	
	public Stick() {
		name = "no weapon";
	}

	public Stick(String n, int v, int l) {
		super(n, v);
		length = l;
	}
	
	@Override
	public void readKeyboard() {
		super.readKeyboard();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter stick length: ");
		length = in.nextInt();
	}

	public int getlength() {
		return length;
	}

	@Override
	public String toString() {
		return super.toString() + " length= " + length;
	}
	
	@Override
	public void save(PrintWriter pw){
		pw.println("stick");
		super.save(pw);
		pw.println(length);
	}
	
	@Override
	public void load(Scanner scan){
		super.load(scan);
		length = scan.nextInt();
		scan.nextLine();
	}
}
