package cs350f21task3;
//Name: Samuel Urcino-Martinez
//IGNORE toString() 
public class Aircraft {

	private String id;
	private State state;
	
	public Aircraft(String id,State state)
	{
		this.id = id;
		this.state = state;
	}
	
	public String getID()
	{
		return this.id;
	}
	
	public State getState()
	{
		return this.state;
	}
	
	public void update()//from state
	{
		this.state.update();
	}
}
