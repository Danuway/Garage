import static org.junit.Assert.*;
import org.junit.Test;
import model.Vehicle;
import model.utility.Color;
import model.utility.EngineType;

public class TestVehicle {

	@Test
	public void test() {
		Vehicle vehicle = new Vehicle("012012301234",Color.RED,1,EngineType.BOXER);
	}

}
