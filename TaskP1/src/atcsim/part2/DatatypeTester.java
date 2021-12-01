package atcsim.part2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import atcsim.datatype.Altitude;

//API https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html

class DatatypeTester {

	@Test
	public void testAltitude() {
		
		Altitude testAlt = new Altitude(1000);
		Altitude testAlt2 = new Altitude(200);
		
		//assertEquals(Expected Result(We set this),Actual Result(The result that is calculated))
		
		//alt1 + alt2
		double result = testAlt.getValue_() + testAlt2.getValue_();
		assertEquals(1200, result,"from result");
		
		//alt2 + alt1
		double result2 = testAlt2.getValue_() + testAlt.getValue_();
		assertEquals(1200, result2,"from result");
		
		
	}
	
	@Test
	public void testAngleNavigational() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAttitudePitch() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAttitudeYaw() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCourse() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCoordinateWorld() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCoordinateWorld3D() {
		fail("Not yet implemented");
	}
	
	

		
	
	

}
