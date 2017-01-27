
public class Cars extends Vehicle {

	private String noOfDoors;
	private String color;

	public String getNoOfDoors() {
		return noOfDoors;
	}

	public void setNoOfDoors(String noOfDoors) {
		this.noOfDoors = noOfDoors;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String getIpPlate() {
		return idPlate;
	}

	@Override
	public void setIdPlate(String idPlate) {
		this.idPlate = idPlate;
	}

	@Override
	public String getBrand() {
		return brand;
	}

	@Override
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	void setType(String type) {
		this.type = type;

	}

	@Override
	String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	void setEntryDate(String date) {
		objEntry.setDate(date);

	}

	@Override
	void setEntryTime(String time) {
		objEntry.setTime(time);

	}

	@Override
	void setStatDate(String date) {
		objStat.setDate(date);

	}

	

	@Override
	void setLeaveTime(String time) {
		objLeave.setTime(time);

	}

	@Override
	String getEntryDate() {
		// TODO Auto-generated method stub
		return objEntry.getDate();
	}

	@Override
	String getEntryTime() {
		// TODO Auto-generated method stub
		return objEntry.getTime();
	}

	@Override
	String getLeaveDate() {
		// TODO Auto-generated method stub
		return objLeave.getDate();
	}

	@Override
	String getLeaveTime() {
		// TODO Auto-generated method stub
		return objLeave.getTime();
	}

}
