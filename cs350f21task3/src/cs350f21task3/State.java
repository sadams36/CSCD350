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
		//initialization private class var
		this.horizontalTarget = speedHorizontal; // check
		this.headingTarget = heading;            //check
		this.direction = true;
	}
	
	public double getAccelerationHorizontal() //1
	{
		return this.accelerationHorizontal;
	}
	
	public double getHeading() // 2
	{
		return this.heading;
	}
	
	public double getHeadingTarget() //3
	{
		return this.headingTarget;
	}
	
	public boolean getHeadingTargetDirection()//4
	{
		return this.direction;
	}
	
	public double getSpeedHorizontal() // 5
	{
		return this.speedHorizontal;
	}
	
	public double getSpeedHorizontalTarget() //6
	{
		return this.horizontalTarget;
	}
	
	public void setSpeedHorizontalTarget​(final double speed)//7
	{
		this.horizontalTarget = speed;
	}
	
	public double getSpeedVertical() //8
	{
		return this.speedVertical;
	}
	
	public void setSpeedVertical(final double speed)//9
	{
		this.speedVertical = speed; 
	}
	
	// return in  x,y,z,heading,hSpeed, vSpeed
	public String getStateCSV() // 10 
	{
		return this.x + "," + this.y + "," + this.z + "," + this.heading + "," + this.speedHorizontal + "," + this.speedVertical;
	}
	
	public double getTurnRate() // 11
	{
		return this.turnRate;
	}
	
	public double getX() // 12
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
	            else 
	            	if(this.headingTarget < this.heading)                  // the heading is larger than the target; target has been exceeded
	            {	
	            		this.heading += this.turnRate;
	                    if(this.heading > 360)                              // the heading is larger than 360 we are going to have to set it back between 0 and 360
	                    {
	                        this.heading = this.heading - 360;          // the new heading will be set by subtracting 360. this will give us the left over amount             
	                        if(this.heading > this.headingTarget)
	                            this.heading = this.headingTarget;
	                    }
	            }
	           
	    }// END CLOCKWISE CONDITION
	        else //turning counter clockwise subtract
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
	                    if( this.headingTarget > this.heading)
	                        this.heading = this.headingTarget;
	                }
	            }		       
	          }
		
//================================================================================================================================================================
		//HORIZONTAL SPEED LIMITS
		if(this.speedHorizontal < this.horizontalTarget)//Gotta speed up
        {
            if(this.speedHorizontal + this.accelerationHorizontal >= this.horizontalTarget) // Check if the speed exceeds the target
                this.speedHorizontal = this.horizontalTarget;                               // set equal 
            else
                this.speedHorizontal += this.accelerationHorizontal;
        }
    else if(this.speedHorizontal > this.horizontalTarget)//Goota slow down
        {
                if(this.speedHorizontal + (this.accelerationHorizontal * -1) <= this.horizontalTarget) // Check if the speed exceeds the target
                    this.speedHorizontal = this.horizontalTarget;									   // set equal 
                else
                    this.speedHorizontal -= this.accelerationHorizontal;                              // otherwise procees as normal
        }
// ===============================================================================================================================================================
		//3D position 

		this.z += this.speedVertical;
		
		this.x += Math.sin(Math.toRadians(this.heading)) * this.speedHorizontal; //update last
		this.y += Math.cos(Math.toRadians(this.heading)) * this.speedHorizontal;
		
	}
 }

