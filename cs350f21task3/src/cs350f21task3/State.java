package cs350f21task3;
// Name: Samuel Urcino-Martinez
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
	
	// return in  x,y,z,heading,hSpeed, vSpeed
	public String getStateCSV() 
	{
		return this.x + "," + this.y + "," + this.heading + "," + this.speedHorizontal + "," + this.speedVertical;
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
	
	public void setHeadingTarget(final double heading, final boolean direction)//about 2 lines
	{
		this.headingTarget = heading;	
		this.direction = direction;
	}
	
	// there is no wind in this method INGORE
	//speed vertical and horizontal
	//heading
	//positioning  x,y,z
	public void update()// about 13 lines
	{
		if(this.direction) // turning clockwise
		 this.heading += this.turnRate;
		else               // turning counter clockwise
		 this.heading -= this.turnRate;
		
		this.speedHorizontal += this.accelerationHorizontal;
		this.z += this.speedVertical;
		this.x += Math.sin(Math.toRadians(this.heading)) * this.speedHorizontal; //update last
		this.y += Math.cos(Math.toRadians(this.heading)) * this.speedHorizontal;
		
	}
}
