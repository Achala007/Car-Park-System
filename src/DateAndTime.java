import java.io.IOException;
import java.util.Scanner;

public class DateAndTime {

	private int month;
	private int day;
	private int hour;
	private int minute;
	private int year;

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public Scanner getSc() {
		return sc;
	}

	Scanner sc = new Scanner(System.in);

	public void setDate(String dIn) {
		try {
			String[] dateArray = (dIn.split("\\-"));
			if (Integer.parseInt(dateArray[0]) > 2000) {
				year = Integer.parseInt(dateArray[0]);
			} else {
				Exception Out = new Exception();
				throw Out;
			}
			if (Integer.parseInt(dateArray[1]) < 13 && Integer.parseInt(dateArray[1]) >= 0) {
				month = Integer.parseInt(dateArray[1]);
			} else {
				Exception Out = new Exception();
				throw Out;
			}
			if (Integer.parseInt(dateArray[2]) < 32 && Integer.parseInt(dateArray[2]) >= 0) {
				day = Integer.parseInt(dateArray[2]);
			} else {
				Exception Out = new Exception();
				throw Out;
			}
		} catch (Exception e) {
			System.err.print("Invalid date, enter a different date (year-month-date ) : ");
			setDate(sc.next());
		}
	}

	public void setTime(String tIn) {
		try {
			String[] timeArray = (tIn.split("\\:"));
			if (Integer.parseInt(timeArray[0]) < 25 && Integer.parseInt(timeArray[0]) >= 0) {
				hour = Integer.parseInt(timeArray[0]);
			} else {
				Exception Out = new Exception();
				throw Out;
			}
			if (Integer.parseInt(timeArray[1]) >= 0 && Integer.parseInt(timeArray[1]) < 61) {
				minute = Integer.parseInt(timeArray[1]);
			} else {
				Exception Out = new Exception();
				throw Out;
			}
		} catch (Exception e) {
			System.err.print("Invalid Time, enter a different time (Hour : Minute ) : ");
			setDate(sc.next());
		}
	}


}
