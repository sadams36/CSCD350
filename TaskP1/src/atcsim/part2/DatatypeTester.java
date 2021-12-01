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
		
		//alt + alt2
		Altitude add = testAlt.add_(testAlt2);
		double addResult = add.getValue_();
		assertEquals(1200, addResult,"from result");
		
		//alt2 + alt
		Altitude add2 = testAlt2.add_(testAlt);
		double addResult2 = add2.getValue_();
		assertEquals(1200, addResult2,"from result");
		
		//alt - alt2
		Altitude sub = testAlt.subtract_(testAlt2);
		double subResult = sub.getValue_();
		assertEquals(800, subResult);
		
		//alt2 - alt
		Altitude sub2 = testAlt2.subtract_(testAlt);
		double subResult2 = sub2.getValue_();
		assertEquals(-800, subResult2);
		
		//alt = alt2
		
		// alt < alt2
		
		// alt2 > alt
		
		
		
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
