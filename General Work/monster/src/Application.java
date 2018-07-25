import java.util.Scanner;

public class Application {



	public static void main(String[] args) {
		/*Monster anon = new Monster();
		Monster elf = new Monster("elf", "pink", "white", 123);
		anon.setPoints(50);
		System.out.println(anon.toString());
		System.out.println(elf.toString());

		elf.powerUp();
		System.out.println(elf.toString());

		Treasure treasure= new Treasure();
		treasure.setPower(50);

		Treasure wand = new Treasure("wand", 80, "yellow");
		
		System.out.println(treasure.treasureInfo());
		System.out.println(wand.treasureInfo());
*/
		
		

		
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("How many years?");
		double choiceyear = input.nextFloat();
		System.out.println("How many months?");
		double choicemonth = input.nextFloat();
		System.out.println("How many days?");
		double choiceday = input.nextFloat();
		System.out.println("How many hours?");
		double choicehour = input.nextFloat();
		System.out.println("How many minutes?");
		double choiceminute = input.nextFloat();
		System.out.println("How many seconds?");
		double choicesecond = input.nextFloat();
		
		
		double total = secs_FROM_years(choiceyear) + secs_FROM_months(choicemonth)+
				secs_FROM_days(choiceday) + secs_FROM_hours(choicehour) +
				secs_FROM_mins(choiceminute) + choicesecond;
		
		
		System.out.println(total);
	
	}
	
	public static double secs_FROM_mins(double minutes) {
		return minutes * 60;
		
	}
	
	public static double secs_FROM_hours(double hours) {
		double secs_PER_hour = secs_FROM_mins(60);
		return hours * secs_PER_hour;
		
	}
	
	public static double secs_FROM_days(double days) {
		double secs_PER_day = secs_FROM_hours(24);
		return days * secs_PER_day;
		
	}
	
	public static double secs_FROM_months(double months) {
		double secs_PER_month = secs_FROM_days(30.42);
		return months * secs_PER_month;
	}
	
	public static double secs_FROM_years(double years) {
		double secs_PER_year = secs_FROM_months(12);
		return years * secs_PER_year;
	}
	
	

		
}
