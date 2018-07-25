import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Application app = new Application();
		app.runTests();

	}

	private void runTests() {
		String choice;
		Time currenttime = new Time(15, 05);
		Time alarmtime = new Time(7, 25);

		Clock clock1 = new Clock();
		clock1.setCurrentTime(currenttime);
		clock1.setAlarmTime(alarmtime);

		System.out.println(clock1);

		do {
			Scanner input = new Scanner(System.in);
			System.out.println("Please press a number for one of "
					+ "the following options");
			System.out.println("1. Change the current time");
			System.out.println("2. Change the alarm time");
			System.out.println("3. Set or unset the alarm");
			System.out.println("4. Quit the program");
			choice = input.nextLine();
			switch (choice) {
			case "1":
				System.out.println("You have chosen option 1");
				System.out
						.println("Please enter the hour value for current time");
				int hour = input.nextInt();
				currenttime.setHour(hour);
				System.out
						.println("Please enter the minute value for current time");
				int minute = input.nextInt();
				currenttime.setMinutes(minute);
				break;

			case "2":
				System.out.println("You have chosen option 2");
				System.out
						.println("Please enter the hour value for alarm time");
				hour = input.nextInt();
				alarmtime.setHour(hour);
				System.out
						.println("Please enter the minute value for alarm time");
				minute = input.nextInt();
				alarmtime.setMinutes(minute);
				break;

			case "3":
				System.out.println("You have chosen option 3");

				if (clock1.isAlarm() == false) {
					clock1.setAlarm(true);
				} else {
					clock1.setAlarm(false);
				}
				System.out.println("Alarm is set");
				break;

			case "4":
				System.out.println("Thanks for using the program");
				break;
			default:
				System.out.println("You did not choose one of the following options, please try again");
				break;
			}
			System.out.println(clock1);

		} while (!choice.equals("4"));
	}

}
