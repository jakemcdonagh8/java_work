public class Time {
	private int hours;
	private int minutes;
	
	public Time(int starthours, int startminutes) {
		hours = starthours;
		minutes = startminutes;
	}

	public int getHour() {
		return hours;
	}

	public void setHour(int hour) {
		this.hours = hour;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	@Override
	public String toString() {
		return "Time [hour=" + hours + ", minutes=" + minutes + "]";
	}

}
