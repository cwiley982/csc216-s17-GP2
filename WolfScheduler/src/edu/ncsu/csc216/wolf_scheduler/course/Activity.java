package edu.ncsu.csc216.wolf_scheduler.course;

public abstract class Activity {
	
	/** If the time is any higher, it is invalid */
	private static final int UPPER_TIME = 2400;
	/** 1 + Max number of minutes in each hour */
	private static final int UPPER_HOUR = 60;
	/** Course's title. */
	private String title;
	/** Course's meeting days */
	private String meetingDays;
	/** Course's starting time */
	private int startTime;
	/** Course's ending time */
	private int endTime;

	public Activity(String title, String meetingDays, int startTime, int endTime) {
		setTitle(title);
		setMeetingDays(meetingDays);
		setCourseTime(startTime, endTime);		
	}

	public abstract String[] getShortDisplayArray();
	
	public abstract String[] getLongDisplayArray();
	/**
	 * Returns Course's title
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets Course's title
	 * 
	 * @param title
	 *            the title to set
	 * @throws IllegalArgumentException
	 *             if string is null or empty
	 */
	public void setTitle(String title) {
		if (title == null) {
			throw new IllegalArgumentException();
		}
		if (title.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.title = title;
	}

	/**
	 * Returns the meeting days
	 * 
	 * @return the meetingDays
	 */
	public String getMeetingDays() {
		return meetingDays;
	}

	/**
	 * Sets the meeting days
	 * 
	 * @param meetingDays
	 *            the meetingDays to set
	 */
	public void setMeetingDays(String meetingDays) {
		if (meetingDays == null) {
			throw new IllegalArgumentException();
		}
		if (meetingDays.length() < 1) {
			throw new IllegalArgumentException();
		}
		if (meetingDays.indexOf("A") >= 0 && meetingDays.length() != 1) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < meetingDays.length(); i++) {
			char letter = meetingDays.charAt(i);
			if (letter != 'M' && letter != 'T' && letter != 'W' && letter != 'H' && letter != 'F'
					&& letter != 'A') {
				throw new IllegalArgumentException();
			}
		}
		this.meetingDays = meetingDays;
	}

	/**
	 * Returns the start time
	 * 
	 * @return the startTime
	 */
	public int getStartTime() {
		return startTime;
	}

	/**
	 * Returns the end time
	 * 
	 * @return the endTime
	 */
	public int getEndTime() {
		return endTime;
	}

	/**
	 * Sets the start and end times for the course
	 * 
	 * @param startTime start time of course
	 * @param endTime end time of course
	 */
	public void setCourseTime(int startTime, int endTime) {
		if (startTime < 0 || startTime >= UPPER_TIME || endTime < 0 || endTime >= UPPER_TIME) {
			throw new IllegalArgumentException();
		}
		if (endTime < startTime) {
			throw new IllegalArgumentException();
		}
		
		int startHours = startTime / 100;
		int startMinutes = startTime % 100;
		if (startHours > 24) {
			throw new IllegalArgumentException();
		}
		if (startMinutes >= UPPER_HOUR) {
			throw new IllegalArgumentException();
		}
		int endHours = endTime / 100;
		int endMinutes = endTime % 100;
		if (endHours > 24) {
			throw new IllegalArgumentException();
		}
		if (endMinutes >= UPPER_HOUR) {
			throw new IllegalArgumentException();
		}
		if (this.getMeetingDays().equals("A") && startTime != 0 && endTime != 0) {
			throw new IllegalArgumentException();
		}
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * Creates a string containing all of the info for a course separated with commas
	 * 
	 * @return string with course info
	 */
	public String getMeetingString() {
		if (getMeetingDays().indexOf("A") == 0) {
			return "Arranged";
		} else {
			String meetingString = "";
			meetingString += getMeetingDays() + " ";
			int startHour = getStartTime() / 100;
			int startMinutes = getStartTime() % 100;
			if (startHour > 12) {
				meetingString += startHour - 12 + ":" + startMinutes;
				if (startMinutes == 0) {
					meetingString += "0";
				}
				meetingString += "PM-";
			} else {
				meetingString += startHour + ":" + startMinutes;
				if (startMinutes == 0) {
					meetingString += "0";
				}
				meetingString += "AM-";
			}
			int endHour = getEndTime() / 100;
			int endMinutes = getEndTime() % 100;
			if (endHour > 12) {
				meetingString += endHour - 12 + ":" + endMinutes;
				if (endMinutes == 0) {
					meetingString += "0";
				}
				meetingString += "PM";
			} else {
				meetingString += endHour + ":" + endMinutes;
				if (endMinutes == 0) {
					meetingString += "0";
				}
				meetingString += "AM";
			}
			return meetingString;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + endTime;
		result = prime * result + ((meetingDays == null) ? 0 : meetingDays.hashCode());
		result = prime * result + startTime;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		if (endTime != other.endTime)
			return false;
		if (meetingDays == null) {
			if (other.meetingDays != null)
				return false;
		} else if (!meetingDays.equals(other.meetingDays))
			return false;
		if (startTime != other.startTime)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}