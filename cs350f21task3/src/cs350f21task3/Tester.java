package cs350f21task3;

public class Tester {

	public static void main(String[] args) {
		
		//public State(double x, double y, double z, double heading, double speedHorizontal, double speedVertical, double accelerationHorizontal, double turnRate)

		State state = new State(1, 2, 3, 0, 0, 6, 0, 0);

		State state1 = new State(1, 2, 3, 4, 5, 6, 7, 8);

		Aircraft air = new Aircraft("Aircraft 123",state);
		
		//from aircraft
		System.out.println("From aircraft");
		System.out.println(air.getID());
			
		System.out.println();

//=====================================================================================
//from state INITIAL STATE CALL
		System.out.println("From state, INTITAL STATE");
		System.out.println("headingTarget: " + state.getHeadingTarget());
		System.out.println("targetDirection: " + state.getHeadingTargetDirection());
	    System.out.println("speedHorizontalTarget: " + state.getSpeedHorizontalTarget());
		System.out.println("Printing CSV: "+state.getStateCSV());
		System.out.println();
//===================================================================================
//from state UPDATED STATE CALL
	
		System.out.println("From state, UPDATED STATE");
		//state.setHeadingTarget(4, true);
		//state.setSpeedHorizontalTarget​(5);
		//state.setSpeedVertical(0);
		System.out.println("headingTarget " + state.getHeadingTarget());
		System.out.println("horizontal Target " + state.getSpeedHorizontalTarget());
		//state.setSpeedHorizontalTarget​(0);
		//state.setSpeedVertical(0);
		state.update();
		System.out.println("Printing CSV: " + state.getStateCSV());
		

		System.out.println("From state, AFTER UPDATE");
	//	state.setHeadingTarget(90, false);
	//	state.setSpeedHorizontalTarget​(100);
		state.update();
		System.out.println(state.getStateCSV());
		

		
	
	}

}
