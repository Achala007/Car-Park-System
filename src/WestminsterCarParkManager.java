
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WestminsterCarParkManager implements carParkManager {

	static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	static Map<String, SpecificHistory> HistorySegment = new HashMap<String, SpecificHistory>();
	Scanner sc = new Scanner(System.in);

	public void addVehicle() {
		Cars objCar = new Cars();
		Vans objVan = new Vans();
		Motorbikes objBike = new Motorbikes();
		
		SpecificHistory objHis = new SpecificHistory();
		String input = "";
		int vehicle = 0;
		do {
			System.out.print("Enter the Vehicle type (Car/Van/Bike)  : ");
			input = sc.next();
			input = input.toLowerCase();
		} while (!(input.equalsIgnoreCase("car") || input.equalsIgnoreCase("van") || input.equalsIgnoreCase("bike")));

		if ((vehicle) < 20) {
			switch (input) {
			case "car":
				objCar.setType("CAR");
				System.out.print("Enter the Id Plate number : ");
				objCar.setIdPlate(sc.next());
				System.out.print("Enter the Brand of the Car : ");
				objCar.setBrand(sc.next());
				System.out.print("Enter the date of the entry? (Year-Month-Day) : ");
				objCar.setEntryDate(sc.next());
				System.out.print("Enter the time of the entry? (Hour:Minute) : ");
				objCar.setEntryTime(sc.next());
				System.out.print("Enter the number of doors : ");
				objCar.setNoOfDoors(sc.next());
				System.out.print("Enter the colour of the car : ");
				objCar.setColor(sc.next());
				vehicles.add(objCar);
				parkDate = objCar.getEntryDate();
				details = objCar.getBrand() + " Holding te Id Plate : " + objCar.getIpPlate();
				vehicle++;
				break;
			case "van":
				if ((vehicle) < 19) {
					objVan.setType("VAN");
					System.out.print("Enter the Id Plate number : ");
					objVan.setIdPlate(sc.next());
					System.out.print("Enter the Brand of the Var : ");
					objVan.setBrand(sc.next());
					System.out.print("Enter the date of the entry? (Year-Month-Day) : ");
					objVan.setEntryDate(sc.next());
					System.out.print("Enter the time of the entry? (Hour:Minute) : ");
					objVan.setEntryTime(sc.next());
					System.out.print("Enter the Cargo volume of the van : ");
					objVan.setCargoVolume(sc.next());
					vehicles.add(objVan);
					parkDate = objVan.getEntryDate();
					details = objVan.getBrand() + "Holding the Id Plate : " + objVan.getIpPlate();
					vehicle += 2;
					break;
				} else {
					System.out.println("Sorry, Your vehicle cannot afford a slot in the park");
				}
			case "bike":
				objBike.setType("BIKE");
				System.out.print("Enter the Id Plate number : ");
				objBike.setIdPlate(sc.next());
				System.out.print("Enter the Brand of the Bike : ");
				objBike.setBrand(sc.next());
				System.out.print("Enter the date of the entry? (Year-Month-Day) : ");
				objBike.setEntryDate(sc.next());
				System.out.print("Enter the time of the entry? (Hour:Minute) : ");
				objBike.setEntryTime(sc.next());
				System.out.print("Enter the engine Size of the bike : ");
				objBike.setEngineSize(sc.next());
				vehicles.add(objBike);
				parkDate = objBike.getEntryDate();
				details = objBike.getBrand() + " Holding the Id Plate : " + objBike.getIpPlate();
				vehicle++;
				break;
			}

			if (parkDate != null) {
				if (HistorySegment.get(parkDate) == null) {
					objHis.add(details);
					HistorySegment.put(parkDate, objHis);
				} else {
					HistorySegment.get(parkDate).add(details);
				}
			}
		}
	}

	public void deleteVehicle() {
		System.out.print("Enter the id plate of the vehicle to be removed : ");
		String search = sc.next();
		int index = -1;
		for (int x = 0; x < vehicles.size(); x++) {
			if (vehicles.get(x).getIpPlate().equalsIgnoreCase(search)) {
				index = x;
				break;
			}
		}
		if (index != -1) {
			System.out.print("Enter the departed Date (year-month-date ) : ");
			vehicles.get(index).setLeaveDate(sc.next());
			System.out.print("Enter the departed Time (Hour : Minute ) : ");
			vehicles.get(index).setLeaveTime(sc.next());
			System.out.println("......................................................................");
			System.out.println("A Vehicle has being Removed from the System \n");
			
			System.out.println("\tId Plate : " + vehicles.get(index).getIpPlate());
			System.out.println("\tBrand : " + vehicles.get(index).getBrand());
			
			System.out.println("\tEntry Time : " + vehicles.get(index).getEntryDate() + " @ "
					+ vehicles.get(index).getEntryTime());
			System.out.println("\tLeave Time : " + vehicles.get(index).getLeaveDate() + " @ "
					+ vehicles.get(index).getLeaveTime());
			
			System.out.println("\tThe Total fare for the Paking is : " + vehicles.get(index).totalPay());
			vehicles.remove(index);
			System.out.println("........................................................................");

		} else {
			System.out.println("No such vehicle Found");
		}
	}

	public void List() {
		if (vehicles.size() > 0) {
			for (Vehicle rot : vehicles) {
				System.out.println("................................................................");
				System.out.println("Id plate : " + rot.getIpPlate());
				System.out.println("Type : " + rot.type);
				System.out.println("Brand : " + rot.brand);
				System.out.println("Entry Time : " + rot.getEntryDate() + " at " + rot.getEntryTime());
				System.out.println("................................................................");
			}

		} else {
			System.out.println("No Vehicles is availble at the car park");
		}
	}

	public void MaxANDMin() {
		if (vehicles.size() > 0) {
			System.out.println("Specify the date you need");
			String currentDate = sc.next();
			System.out.println("Specify the time you need");
			String currentTime = sc.next();
			DateAndTime objd = new DateAndTime();
			objd.setDate(currentDate);
			objd.setTime(currentTime);
			int maxIndex = -1;
			int max = 0;
			for (int x = 0; x < vehicles.size(); x++) {
				vehicles.get(x).setStatDate(objd.getDate());
				vehicles.get(x).setStatTime(objd.getTime());
				if (vehicles.get(x).totalTime() > max) {
					maxIndex = x;
					max = vehicles.get(x).totalTime();
				}
			}
			if (maxIndex != -1) {
				System.out.println("................................................................");
				System.out.println("The vehicle that parked for the longest time is : ");
				System.out.println("\tId Plate : " + vehicles.get(maxIndex).getIpPlate());
				System.out.println("\tBrand : " + vehicles.get(maxIndex).getBrand());
				System.out.println("\tEntry Time : " + vehicles.get(maxIndex).getEntryDate() + " @ "
						+ vehicles.get(maxIndex).getEntryTime());
				System.out.println("................................................................");
			} else {
				System.out.println("No Vehicles is availble at the car park");
			}
			System.out.println("................................................................");
			System.out.println("The last entered vehicle is : ");
			System.out.println("\tId Plate : " + vehicles.get((vehicles.size() - 1)).getIpPlate());
			System.out.println("\tBrand : " + vehicles.get((vehicles.size() - 1)).getBrand());
			System.out.println("\tEntry Time : " + vehicles.get((vehicles.size() - 1)).getEntryDate() + " @ "
					+ vehicles.get((vehicles.size() - 1)).getEntryTime());
			System.out.println("................................................................");
		} else {
			System.out.println("No Vehicles is availble at the car park");
		}

	}

	public void Stat() {

		int carCount = 0;
		int vanCount = 0;
		int bikeCount = 0;
		System.out.println("\t\tStatistics \n");
		System.out.println("................................................................");
		for (Vehicle objVehicle : vehicles) {
			if (objVehicle.getType().equals("CAR")) {
				carCount++;
			} else if (objVehicle.getType().equals("VAN")) {
				vanCount++;
			} else if (objVehicle.getType().equals("BIKE")) {
				bikeCount++;
			}
		}
		System.out.println("Cars : " + ((carCount * 1.00 / (carCount + vanCount + bikeCount)) * 100) + "    Van : "
				+ ((vanCount * 1.00 / (carCount + vanCount + bikeCount)) * 100) + "    Bike : "
				+ ((bikeCount * 1.00 / (carCount + vanCount + bikeCount)) * 100));
		System.out.println("................................................................");
	}

	@Override
	public void History() {
		DateAndTime objdateIn = new DateAndTime();
		System.out.println("Enter the specific date to display the history log : ");
		objdateIn.setDate(sc.next());
		if (HistorySegment.get(objdateIn.getDate()) != null) {
			HistorySegment.get(objdateIn.getDate()).printLine();
		} else {
			System.out.println("No Vehicle were Parked on that date");
		}
	}

}
