
public class Motorbikes extends Vehicle {

	private String engineSize;

	public String getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(String engineSize) {
		this.engineSize = engineSize;
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
	void setLeaveDate(String date) {
		objLeave.setDate(date);

	}

	@Override
	void setLeaveTime(String time) {
		objLeave.setTime(time);

	}

	@Override
	void setStatDate(String date) {
		objStat.setDate(date);

	}

	@Override
	void setStatTime(String time) {
		objStat.setTime(time);

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
