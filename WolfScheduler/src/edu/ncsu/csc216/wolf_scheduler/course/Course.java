/**
 * 
 */
package edu.ncsu.csc216.wolf_scheduler.course;

/**
 * Creates a Course object with fields specifying the name, section, instructor's id, times, etc
 * 
 * @author Caitlyn Wiley
 *
 */
public class Course {
	/** Course's name. */
	private String name;
	/** Course's title. */
	private String title;
	/** Course's section. */
	private String section;
	/** Course's credit hours */
	private int credits;
	/** Course's instructor */
	private String instructorId;
	/** Course's meeting days */
	private String meetingDays;
	/** Course's starting time */
	private int startTime;
	/** Course's ending time */
	private int endTime;

	/**
	 * Creates a course with all fields
	 * 
	 * @param name
	 *            - the name of the course
	 * @param title
	 *            - the title of the course
	 * @param section
	 *            - the course section
	 * @param credits
	 *            - credit hours for the course
	 * @param instructorId
	 *            - instructor's unity id
	 * @param meetingDays
	 *            - days the course meets
	 * @param startTime
	 *            - time course starts
	 * @param endTime
	 *            - time course ends
	 */
	public Course(String name, String title, String section, int credits, String instructorId,
			String meetingDays, int startTime, int endTime) {
		setName(name);
		setTitle(title);
		setSection(section);
		setCredits(credits);
		setInstructorId(instructorId);
		setMeetingDays(meetingDays);
		setCourseTime(startTime, endTime);
	}

	/**
	 * Creates a course with the name, title, section, credits, instructor's id,
	 * and meeting days of the course
	 * 
	 * @param name
	 *            - the name of the course
	 * @param title
	 *            - the title of the course
	 * @param section
	 *            - the course section
	 * @param credits
	 *            - credit hours for the course
	 * @param instructorId
	 *            - instructor's unity id
	 * @param meetingDays
	 *            - days the course meets
	 */
	public Course(String name, String title, String section, int credits, String instructorId,
			String meetingDays) {
		this(name, title, section, credits, instructorId, meetingDays, 0, 0);
	}

	/**
	 * Returns the Course's name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the Course's name
	 * 
	 * @param name
	 *            the name to set
	 * @throws IllegalArgumentException
	 *             if name is null, greater than 6 characters or less than 4
	 */
	private void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException();
		}
		if (name.length() < 4 || name.length() > 6) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

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
	 * Returns Course's section
	 * 
	 * @return the section
	 */
	public String getSection() {
		return section;
	}

	/**
	 * Sets Course's section
	 * 
	 * @param section
	 *            the section to set
	 */
	public void setSection(String section) {
		if (section == null) {
			throw new IllegalArgumentException();
		}
		if (section.length() != 3) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < 3; i++) {
			if (!Character.isDigit(section.charAt(i))) {
				throw new IllegalArgumentException();
			}
		}
		this.section = section;
	}

	/**
	 * Returns Course's credits
	 * 
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * Sets Course's credits
	 * 
	 * @param credits
	 *            the credits to set
	 */
	public void setCredits(int credits) {
		if (credits > 5 || credits < 1) {
			throw new IllegalArgumentException();
		}
		this.credits = credits;
	}

	/**
	 * Returns the instructor's id
	 * 
	 * @return the instructorId
	 */
	public String getInstructorId() {
		return instructorId;
	}

	/**
	 * Gets the instructor's id
	 * 
	 * @param instructorId
	 *            the instructorId to set
	 */
	public void setInstructorId(String instructorId) {
		if (instructorId == null) {
			throw new IllegalArgumentException();
		}
		if (instructorId.length() < 1) {
			throw new IllegalArgumentException();
		}
		this.instructorId = instructorId;
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
		if (startTime < 0 || startTime > 2359 || endTime < 0 || endTime > 2359) {
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
		if (startMinutes > 59) {
			throw new IllegalArgumentException();
		}
		int endHours = endTime / 100;
		int endMinutes = endTime % 100;
		if (endHours > 24) {
			throw new IllegalArgumentException();
		}
		if (endMinutes > 59) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	/**
	 * Sets the hash code for the Course object
	 * 
	 * @return result - the hash code generated
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + credits;
		result = prime * result + endTime;
		result = prime * result + ((instructorId == null) ? 0 : instructorId.hashCode());
		result = prime * result + ((meetingDays == null) ? 0 : meetingDays.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		result = prime * result + startTime;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		Course other = (Course) obj;
		if (credits != other.credits)
			return false;
		if (endTime != other.endTime)
			return false;
		if (instructorId == null) {
			if (other.instructorId != null)
				return false;
		} else if (!instructorId.equals(other.instructorId))
			return false;
		if (meetingDays == null) {
			if (other.meetingDays != null)
				return false;
		} else if (!meetingDays.equals(other.meetingDays))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	/**
	 * Returns a comma separated value String of all Course fields.
	 * 
	 * @return String representation of Course
	 */
	@Override
	public String toString() {
		if (meetingDays.equals("A")) {
			return name + "," + title + "," + section + "," + credits + "," + instructorId + ","
		+ meetingDays;
		}
		return name + "," + title + "," + section + "," + credits + "," + instructorId + "," + 
		meetingDays + "," + startTime + "," + endTime;
	}
}
