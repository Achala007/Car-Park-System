
public abstract class Vehicle {
	String idPlate;
	String brand;
	String type;
	DateAndTime objEntry = new DateAndTime();
	DateAndTime objLeave = new DateAndTime();
	DateAndTime objStat = new DateAndTime();

	abstract void setEntryDate(String date);

	abstract void setEntryTime(String time);

	abstract void setStatDate(String date);

	abstract void setStatTime(String time);

	abstract void setLeaveDate(String date);


	abstract String getEntryDate();

	abstract String getEntryTime();

	abstract String getLeaveDate();

	abstract String getLeaveTime();

	abstract void setIdPlate(String id);

	abstract void setBrand(String brand);

	abstract void setType(String type);

	abstract String getIpPlate();

	abstract String getBrand();

	abstract String getType();

	public int totalPay() {
		int totalHours = 0;
		int totalAmmount = 0;
		totalHours = ((objLeave.getYear() - objEntry.getYear()) * 365 * 24)
				+ ((objLeave.getMonth() - objEntry.getMonth()) * 30 * 24)
				+ ((objLeave.getDay() - objEntry.getDay()) * 24) + ((objLeave.getHour() - objEntry.getHour()));
		if ((objLeave.getMinute() - objEntry.getMinute()) > 0) {
			totalHours++;
		}

		System.out.println("\tTotal Hours :" + totalHours);

		totalAmmount = (totalHours / 24) * 30;
		// check weather the remainder is greater than 7 if then the cost
		// will be 30.
		if (((totalHours % 24) / 7) >= 1) {
			totalAmmount += 30;
		} else {
			// i the remainder is less than 7 it checks weather its greater
			// than 3
			if ((totalHours % 24) > 3) {
				totalAmmount += 9 + ((totalHours % 24) - 3) * 4;
			} else {
				totalAmmount += ((totalHours % 24)) * 3;
			}
		}

		return totalAmmount;
	}

	public int totalTime() {
		return ((((objStat.getYear() - objEntry.getYear()) * 365) + (objStat.getDay() - objEntry.getDay())
				+ ((objStat.getMonth() - objEntry.getMonth()) * 30) * 24) + (objStat.getHour() - objEntry.getHour()))
				* 60 + (objStat.getMinute() - objEntry.getMinute());

	}

}
