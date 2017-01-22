/**
 * 
 */
package edu.ncsu.csc216.wolf_scheduler.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import edu.ncsu.csc216.wolf_scheduler.course.Activity;

/**
 * @author Caitlyn
 *
 */
public class ActivityRecordIO {

	/**
	 * 
	 */
	public ActivityRecordIO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Writes Courses to course record file specified
	 * 
	 * @param fileName
	 *            name of file to write course records to
	 * @param courses
	 *            list of courses
	 * @throws IOException if file cannot be written to
	 */
	public static void writeActivityRecords(String fileName, ArrayList<Activity> activities) 
			throws IOException {
		PrintStream fileWriter = new PrintStream(new File(fileName));
		for (int i = 0; i < activities.size(); i++) {
			fileWriter.println(activities.get(i).toString());
		}
		fileWriter.close();
	}

}
