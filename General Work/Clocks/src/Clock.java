public class Clock {
	private Time currentTime;
	private Time alarmTime;
	private boolean alarm;

	public Clock(Time currentT, Time alarmT, boolean alarmOn) {
		currentTime = currentT;
		alarmTime = alarmT;
		alarm = alarmOn;
	}
	
	public Clock() {
		currentTime = null;
		alarmTime = null;
		alarm = false;
	}
		
	
	public Time getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Time currentTime) {
		this.currentTime = currentTime;
	}

	public Time getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(Time alarmTime) {
		this.alarmTime = alarmTime;
	}

	public boolean isAlarm() {
		return alarm;
	}

	public void setAlarm(boolean alarm) {
		this.alarm = alarm;
	}
	@Override
	public String toString() {
		return "Clock [currentTime=" + currentTime + ", alarmTime=" + alarmTime
				+ ", alarm=" + alarm + "]";
	}

}
