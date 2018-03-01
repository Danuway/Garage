import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import controller.GarageHandler;
import model.Car;
import model.Garage;
import model.GarageIsFullException;
import model.Vehicle;
import model.utility.CarType;
import model.utility.EngineType;

public class GarageHandlerTest {
	private GarageHandler handler;
	private Garage garage1;
	private Car car1;
	
	public GarageHandlerTest() {
		car1 = new Car("ABC-123","Red",4,1,EngineType.FOUR_CYLINDER,CarType.SUV,100,"fueltype",4);
		handler = new GarageHandler();
		garage1 = new Garage("Garage1", 5);
	}
	
	@Test
	public void getParkedVehiclesTest() {
		try {
			handler.addGarage(garage1);
			int t = handler.park(garage1, car1);
			assertEquals(1, t);
		} catch (GarageIsFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Vehicle> vehicles = handler.getParkedVehicles();
		System.out.println("Number Of vehicles: " + vehicles.size());
	}

}
