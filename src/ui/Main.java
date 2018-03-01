package ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import model.Garage;
import model.Vehicle;
import model.utility.Color;
import model.utility.EngineType;
import model.utility.FuelType;
public class Main {

	static Scanner cin = new Scanner(System.in);
	static int choice;

	public static void displayMenu() {
		System.out.println("Welcome to our garage!");
		System.out.println("======================");
		System.out.println();
		System.out.println("Please select from the menu below");
		System.out.println(  "1) List all parked vehicles.\n" 
				+ "2) List all vehicle types currently parked in the garage.\n" 
				+ "3) Park and unpark specific vehicles from the garage.\n"
				+ "4) Set the maximum capacity of the park.\n"
				+ "5) Find a vehicle.\n"
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

	public static void menuHandler(Garage garage) {
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
			Vehicle vehicle = discribeVehicle();
			Garager garage = selectGarage();
			
			garage.addVehicle(newVehicle);
			break;
			
		case 4:
			
			break;
			
		case 5:
			
			break;
			
		case 6:
			
			break;
		case 7:
			
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
	private static Garager selectGarage() {
		// TODO Auto-generated method stub
		return null;
	}
	private static Vehicle discribeVehicle() {
		System.out.println("Enter Registration Number:");
		String registrationNumber = cin.nextLine();
		System.out.println("Select the color of the car: ");
		Color color = selectColor();
		int numberOfEngins;
		EngineType enginType;
		int cylinderVolume;
		FuelType fuelType2;
		int length;
		
		Vehicle newVehicle = new Vehicle( registrationNumber,  color,  numberOfEngins,  enginType, cylinderVolume,  fuelType2,  length);
		return newVehicle;
	}
	private static Color selectColor() {
		Color newColor = Color.BLACK; //Default color
		System.out.println("1) " + Color.BLACK);
		System.out.println("2) " + Color.BLUE);
		System.out.println("3) " + Color.BROWN);
		System.out.println("4) " + Color.GREEN);
		System.out.println("5) " + Color.GREY);
		System.out.println("6) " + Color.RED);
		System.out.println("7) " + Color.SILVER);
		System.out.println("8) " + Color.WHITE);
		int choice = consoleInput();
		switch (choice) {
		case 1:
			newColor = Color.BLACK;
			break;
		case 2:
			newColor = Color.BLUE;
			break;
		case 3:
			newColor = Color.BROWN;
			break;
		case 4:
			newColor = Color.GREEN;
			break;
		case 5:
			newColor = Color.GREY;
			break;
		case 6:
			newColor = Color.RED;
			break;
		case 7:
			newColor = Color.SILVER;
			break;
		case 8:
			newColor = Color.WHITE;
			break;
		}
		return newColor;
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
	public static void main(String[] args) {		
	}

}















