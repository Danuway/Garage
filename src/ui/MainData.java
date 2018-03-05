package ui;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.GarageHandler;
import model.Airplane;
import model.Boat;
import model.Bus;
import model.Car;
import model.Garage;
import model.GarageIsFullException;
import model.Motercycle;
import model.NoVehicleFoundException;
import model.Vehicle;
import model.utility.BoatType;
import model.utility.CarType;
import model.utility.Color;
import model.utility.EngineType;
import model.utility.FuelType;
import model.utility.PlaneTypes;
import model.utility.VehicleType;

public class MainData {
	private Garage myGarage;
	private GarageHandler myhandler;
	static Scanner cin = new Scanner(System.in);
	static int choice;
	public MainData(Garage myGarage, GarageHandler myhandler) {
		this.myGarage = myGarage;
		this.myhandler = myhandler;
	}

	public Garage getMyGarage() {
		return myGarage;
	}

	public void setMyGarage(Garage myGarage) {
		this.myGarage = myGarage;
	}

	public GarageHandler getMyhandler() {
		return myhandler;
	}

	public void setMyhandler(GarageHandler myhandler) {
		this.myhandler = myhandler;
	}

	public static void displayMenu() {
		System.out.println("Welcome to our garage!");
		System.out.println("======================");
		System.out.println();
		System.out.println("Please select from the menu below");
		System.out.println(  "1) List all parked vehicles.\n" 
				+ "2) List all vehicle types currently parked in the garage.\n" 
				+ "3) Park and unpark specific vehicles from the garage.\n"
				+ "4) Set the maximum capacity of the garage.\n"
				+ "5) Find a parcked vehicle.\n"
				+ "6) Create a garage.\n"
				+ "7) Seve garage and all its vehicles to a file.\n"
				+ "8) Exit the program.");
	}
	public static int consoleInput() {

		try {
			return cin.nextInt();
		} catch (Exception e) {
			System.out.println("Try a valid menue");
		}
		return 0;
	}

	public static void menuHandler(Garage garage, GarageHandler myhandler) {
		int choice;
		displayMenu();
		choice = consoleInput();
		switch (choice) {
		case 1:
			for(Vehicle vehicle : garage.getVehicles())
				System.out.println(vehicle.toString());
			break;

		case 2:
			for(Vehicle vehicle : garage.getVehicles())
				System.out.println(vehicle.toString());
			//System.out.println(vehicle.getType); TODO: getVehicleType
			break;

		case 3:			
			try {
				garage.addVehicle(discribeVehicle());
			} catch (GarageIsFullException e) {
				e.printStackTrace();
			}
			break;

		case 4:
			System.out.println("Enter the prefered capacity: ");
			int capacity = consoleInput();
			garage.setMaxCapacity(capacity);
			System.out.println("Maximum Capacity is set to " + capacity);
			break;

		case 5:
			System.out.println("Enter the registration number: ");
			Scanner sc = new Scanner(System.in);
			String regnr = sc.nextLine();
			sc.close();
			try {
				System.out.println(myhandler.getVehicleFromRegNr(regnr).toString()); // TODO: HANDLE THE RETURNED VEHICLE IN A USER FRIENDLY MANNER
			} catch (NoVehicleFoundException e) {
				System.out.println("Wrong registration number..."
						+ "The vehicle could not be found.");
			}
			break;

		case 6:
			System.out.println("Please enter the capaciaty: ");
			int cap = consoleInput();
			System.out.println("The name of the garage: ");
			Scanner sc1 = new Scanner(System.in);
			String name = sc1.nextLine();
			sc1.close();
			myhandler.createGarage(cap, name);
			System.out.println("Garage with name " + name + "and "
					+ "capacity " + cap + "is created");
			break;
		case 7:
			FileWriter writer;
			try {
				writer = new FileWriter("GarageOutput.txt");

				for(Vehicle myVehicle: myhandler.getParkedVehicles()){

					writer.write(myVehicle.toString());
				}
				writer.close();
			} catch (IOException e) {
				System.out.println("Something went wrong ...");
				System.err.println(e);
				;
			}
			break;
		default:
			System.out.println("Are you shure you want to leave? ");
			System.out.println("1) yes \n"
					+ "2) no");
			choice = consoleInput();
			if (choice == 1) {
				System.exit(0);
			}
			break;
		}

	}
	private static Garage selectGarage() {
		int counter = 0;
		GarageHandler newHandler = new GarageHandler();
		ArrayList<Garage> garages = newHandler.getGarages();
		System.out.println("Select a garage from the list: ");
		for(Garage g : garages)
			System.out.println(++counter + ")" + g.getName());
		counter = consoleInput();
		--counter;		
		return garages.get(counter);
	}
	private static Vehicle discribeVehicle() {

		VehicleType myType = selectVehicleType();
		System.out.println("Enter Registration Number:");
		cin.nextLine();
		String registrationNumber = cin.nextLine();
		Color color = selectColor();
		System.out.println("Enter the number of engin: ");
		int numberOfEngins = consoleInput();
		EngineType enginType = selectEngin();
		int cylinderVolume = selectCilndeVolume();
		FuelType fuelType = selectFuleType();
		int length = inputLength();
		System.out.println("Enter the number of wheels: ");
		int noOfWheels = consoleInput();
		switch (myType) {
		case MOTORCYCLE:
			boolean hasSideCart = false;
			System.out.println("Does the motercycle has side cart? enter yes or  no ");
			Scanner sc = new Scanner(System.in);
			String condition = sc.nextLine();
			if (condition == "yes") {
				hasSideCart = true;
			}
			return new Motercycle(registrationNumber, color, noOfWheels, numberOfEngins, enginType, cylinderVolume, fuelType, length, hasSideCart);

		case CAR:
			System.out.println("Enter the car type: ");
			CarType carType = carType();
			return new Car(registrationNumber, color, noOfWheels, numberOfEngins, enginType, carType, cylinderVolume, fuelType, length);
		case BUS:
			System.out.println("Enter the number of deck: ");
			int noOfDeck = consoleInput();
			return new Bus(registrationNumber, color, numberOfEngins, enginType, cylinderVolume, fuelType, length, noOfDeck, noOfWheels);
		case BOAT:
			BoatType boatType = getBoatType();
			return new Boat(registrationNumber, color, noOfWheels, numberOfEngins, enginType, cylinderVolume, fuelType, length, boatType);
		default:
			PlaneTypes planeType = getPlaneType();
			return new Airplane(registrationNumber, color, noOfWheels, numberOfEngins, enginType, cylinderVolume, fuelType, length, planeType);
		}



	}

	private static PlaneTypes getPlaneType() {
		System.out.println("Select Plane type: ");

		int choise = 1;
		for(PlaneTypes plane: PlaneTypes.values()) {
			System.out.println(choise + ") " + plane);
			++choise;
		}
		choise = consoleInput();
		return PlaneTypes.values()[--choise];


	}

	private static BoatType getBoatType() {
		System.out.println("Select Boat type: ");
		int choise = 1;
		for(BoatType bot: BoatType.values()) {
			System.out.println(choise + ") " + bot);
			++choise;
		}
		choise = consoleInput();
		return BoatType.values()[--choise];

	}

	private static CarType carType() {
		int choise = 1;
		System.out.println("Select car type: ");
		for(CarType car: CarType.values()) {
			System.out.println(choise + ") " + car);
			++choise;
		}
		choise = consoleInput();
		return CarType.values()[--choise];

	}

	private static VehicleType selectVehicleType() {

		System.out.println("Select vehicle type: ");
		int choise = 0;
		for(VehicleType vehicles :VehicleType.values() ) {
			System.out.println((choise + 1) + ") " + vehicles );
			++choise;
		}
		choise = consoleInput();
		return VehicleType.values()[--choise];


	}

	private static int inputLength() {
		System.out.println("Please enter the length of the vehicle: ");
		return consoleInput();
	}
	private static FuelType selectFuleType() {


		System.out.println("Select Fuel type: ");
		int choise = 0;
		for(FuelType fuel : FuelType.values()) {
			System.out.println((choise + 1) + ") " + fuel);
			++choise;
		}
		choise = consoleInput();
		return FuelType.values()[--choise];


	}
	private static int selectCilndeVolume() {
		System.out.println("What is the cilender volume :");
		return consoleInput();
	}
	private static EngineType selectEngin() {
		int counter = 0;
		System.out.println("Select Engine Type: ");
		for(EngineType engin: EngineType.values()) {
			System.out.println((counter + 1) + ") " + engin);
			++counter;
		}
		counter = consoleInput();
		return EngineType.values()[--counter];
	}
	private static Color selectColor() {
		int choise = 1;
		System.out.println("Select the color: ");
		for(Color color : Color.values()) {
			System.out.println(choise + ") " + color);
			++choise;
		}
		choise = consoleInput();
		return Color.values()[choise];
	}
	private static void displayVehiclesInASpecificGarage(ArrayList<Garage> garages) {
		int counter = 1;
		for (Garage garage : garages) {	
			System.out.println("List of Garages : ");
			System.out.println(counter + ")" + garage.getName() + "\n");	
			++counter;
		}
		System.out.print("Select a garage: ");

		choice = consoleInput();
		for (Vehicle vehicle : garages.get(choice).getVehicles()) {
			System.out.println(vehicle.toString());
		}
	}

	public static void clearScreen() {


		try
		{
			final String os = System.getProperty("os.name");

			if (os.contains("Windows"))
			{
				Runtime.getRuntime().exec("cls");
			}
			else
			{
				Runtime.getRuntime().exec("clear");
			}
		}
		catch (final Exception e)
		{
			System.out.println("Something went wrong in the 'clear screen method' . ");
		}


	}
}

