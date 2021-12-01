package atcsim.part2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import atcsim.datatype.*;


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
		
		//alt = alt or 1000 == 1000
		int res = testAlt.compareTo(testAlt);
		assertEquals(0,res);
		
		// alt < alt2  or 1000 < 200
		//   returns 1
		//needs a check
		int res2 = testAlt.compareTo(testAlt2);
		assertEquals(1,res2);
		
		// alt2 > alt or 200 > 1000
		//returns -1
		//needs a check
		int res3 = testAlt2.compareTo(testAlt);
		assertEquals(-1,res3);
		
		
	}
	
	@Test
	public void testAngleNavigational() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAttitudePitch() {
		// fail("Not yet implemented");
		
		// Create pitch (p = 10)
		AttitudePitch p = new AttitudePitch(10); 
		
		// Verify (0 + p) is correct
		AttitudePitch zero = new AttitudePitch(0);
		AttitudePitch sum1 = p.add_(zero); 
		double sum1Result = sum1.getValue_();
		assertEquals(10, sum1Result,"from result");
		
		// Verify (90 + p) is correct
		AttitudePitch ninety = new AttitudePitch(90);
		AttitudePitch sum2 = p.add_(ninety); 
		double sum2Result = sum2.getValue_();
		assertEquals(100, sum2Result,"from result");
		
		
		// Verify (175 + p) is correct
		AttitudePitch oneSeventyFive = new AttitudePitch(175);
		AttitudePitch sum3 = p.add_(oneSeventyFive); 
		double sum3Result = sum3.getValue_();
		assertEquals(-175, sum3Result,"from result");
		
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
