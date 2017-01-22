/**
 * 
 */
package edu.ncsu.csc216.wolf_scheduler.course;

/**
 * @author Caitlyn
 *
 */
public class Event extends Activity {

	public int weeklyRepeat;
	public String eventDetails;
	
	/**
	 * 
	 */
	public Event (String title, String meetingDays, int startTime, int endTime, int weeklyRepeat, String eventDetails) {
		super(title, meetingDays, startTime, endTime);
		setWeeklyRepeat(weeklyRepeat);
		setEventDetails(eventDetails);
	}

	/**
	 * @return the weeklyRepeat
	 */
	public int getWeeklyRepeat() {
		return weeklyRepeat;
	}

	/**
	 * @param weeklyRepeat the weeklyRepeat to set
	 */
	public void setWeeklyRepeat(int weeklyRepeat) {
		if (weeklyRepeat < 1 || weeklyRepeat > 4) {
			throw new IllegalArgumentException("Invalid weekly repeat");
		}
		this.weeklyRepeat = weeklyRepeat;
	}

	/**
	 * @return the eventDetails
	 */
	public String getEventDetails() {
		return eventDetails;
	}

	/**
	 * @param eventDetails the eventDetails to set
	 */
	public void setEventDetails(String eventDetails) {
		if (eventDetails == null) {
			throw new IllegalArgumentException("Invalid event details");
		}
		this.eventDetails = eventDetails;
	}
	
	public void setMeetingDays(String meetingDays) {
		if (meetingDays == null || meetingDays == "") {
			throw new IllegalArgumentException();
		}
		if (meetingDays.indexOf("A") != -1) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < meetingDays.length(); i++) {
			char letter = meetingDays.charAt(i);
			if (letter != 'M' && letter != 'T' && letter != 'W' && letter != 'H' && letter != 'F' && letter != 'S' && letter != 'U') {
				throw new IllegalArgumentException();
			}
		}
		super.setMeetingDays(meetingDays);
	}
	
	@Override
	public String getMeetingString() {
		return super.getMeetingString() + " (every " + this.getWeeklyRepeat() + " weeks)";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getTitle() + "," + getMeetingDays() + "," + getStartTime() + "," + getEndTime() + "," + weeklyRepeat + "," + eventDetails;
	}

	@Override
	public String[] getShortDisplayArray() {
		String[] shortArray = {"", "", this.getTitle(), this.getMeetingString()};
		return shortArray;
	}

	@Override
	public String[] getLongDisplayArray() {
		String[] longArray = {"", "", this.getTitle(), "", "", this.getMeetingString(), this.getEventDetails()};
		return longArray;
	}

	@Override
	public boolean isDuplicate(Activity activity) {
		return false;
	}
}
