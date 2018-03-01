import static org.junit.Assert.*;

import org.junit.Test;

import model.Car;
import model.utility.CarType;
import model.utility.Color;
import model.utility.EngineType;
import model.utility.FuelType;

public class CarTest {
	Car sportsCar = new Car("123456789", Color.BLACK
			, 4, 1, EngineType.VR_AND_W, CarType.MPV
			, 2000, FuelType.PETROLEUM, 285);
	@Test
	public void testGetCarType() {
		assertEquals(CarType.MPV, sportsCar.getCarType());
	}
	
	@Test
	public void testGetNumberOfWheels() {
		assertEquals(4,sportsCar.getNoOfWheels());
	}
	
}
