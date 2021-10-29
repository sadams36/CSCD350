package cs350f21task3;

//ignore toString()
public class State {
      
	//variable that are brought in from the constructor
	private double x,y,z,
				   heading,
				   speedHorizontal,speedVertical,
				   accelerationHorizontal,turnRate;
	//private variables made in class
	private double horizontalTarget,headingTarget;
	private boolean direction;
	
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
	
	public double getHeadingTarget() //revise
	{
		return this.headingTarget;
	}
	
	public boolean getHeadingTargetDirection() //revise
	{
		return this.direction;
	}
	
	public double getSpeedHorizontal()
	{
		return this.speedHorizontal;
	}
	
	public double getSpeedHorizontalTarget() //revise
	{
		return this.horizontalTarget;
	}
	
	public void setSpeedHorizontalTarget(final double speed)//revise
	{
		this.horizontalTarget = speed;
	}
	
	public double getSpeedVertical()
	{
		return this.speedVertical;
	}
	
	public void setSpeedVertical(final double speed)//couple of lines
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
	
	public void setHeadingTarget(final double heading, final boolean direction)//definetly couple of lines
	{
		this.heading = heading;	
		this.direction = direction;
	}
	
	public void update()// there is no wind in this method INGORE
	{
		
	}
}
