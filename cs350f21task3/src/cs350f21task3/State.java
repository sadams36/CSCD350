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
	private boolean direction = true; 
	
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
		
	  // private class variables intialized
	  //this.direction = true
		this.headingTarget = heading;
		this.horizontalTarget = speedHorizontal;
	}
	
	public double getAccelerationHorizontal()
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
	
	public boolean getHeadingTargetDirection()//revise
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
		return this.x + "," + this.y + "," + this.z + "," +  this.heading + "," + this.speedHorizontal + "," + this.speedVertical;
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
	public void update()// about 13 actual lines
	{
//========================================================================================================================================================
		//TURNING THE HEADING
		if(this.direction) // turning clockwise add 
		{ 
			 if(this.headingTarget > this.heading) 
	            {
	                if((this.heading + this.turnRate) > this.headingTarget) // the heading exceeds the target after adding 
	                    this.heading = this.headingTarget;                  // we set the heading to the target since it exceeded it
	                else
	                    this.heading += this.turnRate;                      // otherwise add like normal

		         }
	            else //if(this.headingTarget < this.heading)                  // the heading is larger than the target; target has been exceeded
	            {
	                    if(this.heading > 360)                              // the heading is larger than 360 we are going to have to set it back between 0 and 360
	                    {
	                        this.heading = this.heading - 360;          // the new heading will be set by subtracting 360. this will give us the left over amount             
	                    }
	            }
	    }// END CLOCKWISE CONDITION
	        else//turning counter clockwise subtract
	        {
	            if(this.headingTarget < this.heading)                             // Target < Heading
	            {
	                if((this.heading - this.turnRate) < this.headingTarget)  // Heading - Turnrate < Target meaning we exceeded the target
	                    this.heading = this.headingTarget;                   // the heading will be equal to the target
	                else
	                    this.heading -= this.turnRate;                       // otherwise subtract like normal
	            }
	        else //(this.headingTarget > this.heading)
	            {
	                this.heading -= this.turnRate;                           
	                if(this.heading < 0)                                     // heading has passed 0 and gone negative so we need to reset
	                {
	                    this.heading = (this.heading + 360);                          
	                }
	            }		       
	          }
//================================================================================================================================================================
		//HORIZONTAL SPEED LIMITS
		if(this.speedHorizontal < this.horizontalTarget)//Speeding up
        {
            if(this.speedHorizontal + this.accelerationHorizontal >= this.horizontalTarget) // Check if the speed exceeds the target
                this.speedHorizontal = this.horizontalTarget;                               // set equal 
            else
                this.speedHorizontal += this.accelerationHorizontal;
        }
    else if(this.speedHorizontal > this.horizontalTarget)//Slowing down
        {
                if(this.speedHorizontal + (this.accelerationHorizontal * -1) <= this.horizontalTarget) // Check if the speed exceeds the target
                    this.speedHorizontal = this.horizontalTarget;									   // set equal 
                else
                    this.speedHorizontal -= this.accelerationHorizontal;                              // otherwise procees as normal
        }
		
	
		this.z += this.speedVertical;
		this.x += Math.sin(Math.toRadians(this.heading)) * this.speedHorizontal; //update last
		this.y += Math.cos(Math.toRadians(this.heading)) * this.speedHorizontal;
		
	}
 }

