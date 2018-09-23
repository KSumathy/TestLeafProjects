package wdMethods;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		
		// Get the current date
				Date date = new Date();
		// Get only the date (and not month, year, time etc)
				DateFormat sdf = new SimpleDateFormat("dd"); 
		// Get today's date
				String today = sdf.format(date);
		// Convert to integer and add 1 to it
				int tomorrow = Integer.parseInt(today)+1;
		// Print tomorrow's date
				System.out.println(tomorrow);

	}

}
