package cs350f21task3;

//ignore toString()
public class State {
      
	//variable that are brought in from the constructor
	private double x,y,z,heading,speedHorizontal,speedVertical,accelerationHorizontal,turnRate;


	public State(double x, double y, double z, double heading, double speedHorizontal, 
			     double speedVertical, double accelerationHorizontal, double turnRate)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.heading = heading;
		this.speedHorizontal = speedHorizontal;
		this.speedVertical = speedVertical;
		this.accelerationHorizontal = accelerationHorizontal;
		this.turnRate = turnRate;
	}
	
	public double getAccelerationHoizontal()
	{
		return this.accelerationHorizontal;
	}
	
	public double getHeading()
	{
		return this.heading;
	}
	
	public double getHeadingTarget() 
	{
		return 0;
	}
	
	public double getHeadingTargetDirection()
	{
		return 0;
	}
	
	public double getSpeedHorizontal()
	{
		return this.speedHorizontal;
	}
	
	public double getSpeedHorizontalTarget()
	{
		return 0;
	}
	
	public void setSpeedHorizontalTarget(double speed)//couple of lines
	{
		
	}
	
	public double getSpeedVertical()
	{
		return this.speedVertical;
	}
	
	public void setSpeedVertical(double speed)//couple of lines
	{
		this.speedVertical = speed; 
	}
	
	public String getStateCSV()
	{
		return "";
	}
	
	public double getTurnRate()
	{
		return this.turnRate;
	}
	
	public double getX()
	{
		return this.x;
	}
	
	public double getY()
	{
		return this.y;
	}
	
	public double getZ()
	{
		return this.z;
	}
	
	public void setHeadingTarget(double heading, boolean direction)//definetly couple of lines
	{
		this.heading = heading;

	}
	
	public void update()// there is no wind in this method INGORE
	{
		
	}
}
