package cs350f21task3;

public class Tester {

	public static void main(String[] args) {
		
		//public State(double x, double y, double z, double heading, double speedHorizontal, double speedVertical, double accelerationHorizontal, double turnRate)
		State state = new State(1, 2, 3, 0, 0, 6, 0, 0);
		Aircraft air = new Aircraft("Aircraft 123",state);
		
		//from aircraft
		System.out.println("From aircraft");
		System.out.println(air.getID());
			
		System.out.println();
		
		//from state
		System.out.println("From state, INTITAL STATE");
		System.out.println(state.getStateCSV());
		
		System.out.println("From state, AFTER UPDATE");
	//	state.setHeadingTarget(90, false);
	//	state.setSpeedHorizontalTarget​(100);
		state.update();
		System.out.println(state.getStateCSV());
		
		
	}

}
