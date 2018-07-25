
public class Application {

	/**
	 * This is the starting place for your program.
	 * The JVM will call this method when you run the program from
	 * Eclipse or from the command line: java Application
	 * We will say more about this method during a later talk,
	 * e.g. what static means.
	 * @param args Is an array that contains all the command line
	 * arguments, e.g. java Application arg1 arg2 arg3
	 */
	public static void main(String[] args) {
		// ADD loopy-circles.txt CODE HERE
		Circle circle1 = new Circle();
		Canvas c = Canvas.getCanvas();

		int width = c.getWidth();
		int height = c.getHeight();
		int xPos = 0;
		int currentXPos = 0;
		int yPos = 0;
		int currentYPos = 0;
		java.util.Random rand = new java.util.Random();
		circle1.makeVisible();
		int count = 0;
		while (count < 10){
		   xPos = rand.nextInt(width);
		   yPos = rand.nextInt(height);
		   currentXPos = circle1.getXCoord();
		   currentYPos = circle1.getYCoord();
		   circle1.slowMoveHorizontal(xPos - currentXPos);
		   circle1.slowMoveVertical(yPos - currentYPos);
		   count = count + 1;
		}


	}

}
