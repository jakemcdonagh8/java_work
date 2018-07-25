public class Treasure {
	private String treasuretype;
	private int powervalue;
	private String colourvalue;

	public Treasure() {
		treasuretype = "unknown";
		colourvalue = "unknown";
	}

	public Treasure(String startType, int startPower, String startColour) {
		treasuretype = startType;
		powervalue = startPower;
		colourvalue = startColour;
	}

	public void setPower(int power) {
		powervalue = power;
	}

	public int getPower() {
		return powervalue;
	}

	public void setColour(String colour) {
		colourvalue = colour;
	}

	public String getColour() {
		return colourvalue;
	}

	public String treasureInfo() {
		return "The following treasure is a " + treasuretype
				+ " with a power value of " + powervalue + " with a colour of "
				+ colourvalue + " and is owned by nobody";

	}
}
