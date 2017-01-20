/**
 * 
 */
package edu.ncsu.csc216.wolf_scheduler.scheduler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import edu.ncsu.csc216.wolf_scheduler.course.Course;
import edu.ncsu.csc216.wolf_scheduler.io.CourseRecordIO;

/**
 * Creates a schedule that courses can be added to or removed from
 * 
 * @author Caitlyn
 *
 */
public class WolfScheduler {

	/** Array list of courses available to add to a schedule */
	public ArrayList<Course> courseCatalog;
	/** Array list of courses currently on the schedule */
	public ArrayList<Course> schedule;
	/** Title of the schedule */
	public String scheduleTitle;
	
	/**
	 * Constructs a schedule
	 * 
	 * @param fileName name of file to be used
	 */
	public WolfScheduler(String fileName) {
		courseCatalog = new ArrayList<Course>();
		schedule = new ArrayList<Course>();
		scheduleTitle = "My Schedule";
		try {
			courseCatalog = CourseRecordIO.readCourseRecords(fileName);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Cannot find file.");
		}
	}

	/**
	 * Generates a 2D array containing the name, section and title for each course in courseCatalog
	 * 
	 * @return the 2D array with the info for the courses in courseCatalog
	 */
	public String[][] getCourseCatalog() {
		if (courseCatalog == null) {
			return new String[1][1];
		}
		String catalog[][] = new String[courseCatalog.size()][3];
		for (int i = 0; i < courseCatalog.size(); i++) {
			catalog[i][0] = courseCatalog.get(i).getName();
			catalog[i][1] = courseCatalog.get(i).getSection();
			catalog[i][2] = courseCatalog.get(i).getTitle();
		}
		return catalog;
	}

	/**
	 * Gets the courses currently on the schedule and creates a 2D array containing each courses
	 * name, section, title, credits, instructor's id and meeting days
	 * 
	 * @return the 2D array containing all of the information for each course in schedule
	 */
	public String[][] getFullScheduledCourses() {
		if (schedule == null) {
			return new String[1][1];
		}
		String fullSchedule[][] = new String[schedule.size()][6];
		for (int i = 0; i < schedule.size(); i++) {
			fullSchedule[i][0] = schedule.get(i).getName();
			fullSchedule[i][1] = schedule.get(i).getSection();
			fullSchedule[i][2] = schedule.get(i).getTitle();
			fullSchedule[i][3] = Integer.toString(schedule.get(i).getCredits());
			fullSchedule[i][4] = schedule.get(i).getInstructorId();
			fullSchedule[i][5] = schedule.get(i).getMeetingString();
		}
		return fullSchedule;
	}

	/**
	 * Gets the courses currently on the schedule and creates a 2D array containing each courses
	 * name, section and title
	 * 
	 * @return the 2D array containing the schedule info
	 */
	public String[][] getScheduledCourses() {
		if (schedule == null) {
			return new String[1][1];
		}
		String partialSchedule[][] = new String[schedule.size()][3];
		for (int i = 0; i < schedule.size(); i++) {
			partialSchedule[i][0] = schedule.get(i).getName();
			partialSchedule[i][1] = schedule.get(i).getSection();
			partialSchedule[i][2] = schedule.get(i).getTitle();
		}
		return partialSchedule;
	}

	/**
	 * Gets the current title of the schedule
	 * 
	 * @return the title of the schedule
	 */
	public String getTitle() {
		return scheduleTitle;
	}

	/**
	 * Sets the title of the schedule
	 * 
	 * @param title the schedule will be set to
	 */
	public void setTitle(String title) {
		if (title == null) {
			throw new IllegalArgumentException("Title cannot be null.");
		}
		scheduleTitle = title;
	}
	
	/**
	 * Writes the schedule to a file
	 * 
	 * @param fileName the file the schedule will be written to
	 */
	public void exportSchedule(String fileName) {
		try {
			CourseRecordIO.writeCourseRecords(fileName, schedule);
		} catch (IOException e) {
			throw new IllegalArgumentException("The file cannot be saved.");
		}
	}

	/**
	 * Tells whether a course can be removed from the schedule or not based on whether it's already
	 * in the schedule
	 * 
	 * @param name of the course
	 * @param section of the course
	 * @return true if course can be removed
	 */
	public boolean removeCourse(String name, String section) {
		for (int i = 0; i < schedule.size(); i++) {
			if (schedule.get(i).getName().equals(name) && schedule.get(i).getSection().equals(section)) {
				schedule.remove(schedule.get(i));
				return true;
			}
		}
		return false;
	}

	/**
	 * Tells whether a course can be added to the schedule or not based on whether it's already
	 * in the schedule and if it's in the catalog
	 * 
	 * @param name of course
	 * @param section of course
	 * @return true if course can be added
	 */
	public boolean addCourse(String name, String section) {
		for (int i = 0; i < schedule.size(); i++) {
			if (schedule.get(i).getName().equals(name)) {
				throw new IllegalArgumentException("You are already enrolled in " + name);
			}
		}
		for (int i = 0; i < courseCatalog.size(); i++) {
			if (courseCatalog.get(i).getName().equals(name) && courseCatalog.get(i).getSection().equals(section)) {
				schedule.add(courseCatalog.get(i));
				return true;
			}
		}
 		return false;
	}

	/**
	 * Gets the course with the specified name and section from the courseCatalog
	 * 
	 * @param name of the course
	 * @param section of the course
	 * @return the course from courseCatalog with the same name and section
	 */
	public Course getCourseFromCatalog(String name, String section) {
		for (int i = 0; i < courseCatalog.size(); i++) {
			if (courseCatalog.get(i).getName().equals(name) && courseCatalog.get(i).getSection().equals(section)) {
				return courseCatalog.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Resets the schedule to an empty ArrayList
	 */
	public void resetSchedule() {
		schedule = new ArrayList<Course>();	
	}

}
