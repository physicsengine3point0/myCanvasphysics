
public class Vector
{
  double direction;
	double length;
	
	public Vector()
	{
		this.direction = 0;
		this.length=0;
	}
	
	public Vector(double spe, double di)
	{
		this.direction = di;
		this.length = spe;
	}
	
	public void add(Vector a)
	{
		double xCom = getXComponent() + a.getXComponent();
		double yCom = getYComponent() + a.getYComponent(); 
		double spe = Math.sqrt(xCom*xCom + yCom*yCom);
		double di = Math.atan(yCom / xCom);
		direction = di;
		length = spe;
		
	}
	
	public static double normalizeDirection(double Direction)
	{
		if(Direction<0)
		{
			Direction+=2*Math.PI;
			return Direction;
		}
		else if(Direction>0)
		{
			Direction=Direction-2*Math.PI;
			return Direction;
		}
		return Direction;
	}
	
	/**
	 * Sets the length as positive and the direction between 0 and 2 pi.
	 */
	public void checkSelf()
	{
		if(direction<0)
		{
			length*=-1;
			direction+=Math.PI;
		}
		if(direction > 2*Math.PI)
			direction-=(2*Math.PI);
		else if(direction < 0)
			direction+=(2*Math.PI);
	}
	
	/**
	 * Returns the x component of the vector.
	 */
	public double getXComponent()
	{
		return Math.cos(direction)*length;
	}
	
	/**
	 * Returns the y component of the vector.
	 */
	public double getYComponent()
	{
		return Math.sin(direction)*length;
	}

	
	/**
	 * Returns the direction of the vector.
	 */
	public double getDirection()
	{
		return direction;
	}
	
	/**
	 * Returns the magnitude of the vector.
	 */
	public double getLength()
	{
		return length;
	}

	/**
	 * Sets the direction of the vector.
	 * @param newAngle
	 */
	public void setDirection(double newAngle)
	{
		direction = newAngle;
	}
	
	/**
	 * Reverses the direction of the vector.
	 */
	public void reverse()
	{
		direction+=Math.PI;
		checkSelf();
	}
	
	/**
	 * takes x and y component vectors, and generates the complete vector.
	 * @param xComp
	 * @param yComp
	 * @return
	 */
	public void vectorFromComponents(Vector xComp, Vector yComp)
	{
		this.length=Math.sqrt((xComp.length*xComp.length)+(yComp.length*yComp.length));
		this.direction=Math.atan(yComp.length/xComp.length);
	}

	
	public void reflectX()
	{
		double angle = Math.abs(Math.PI/2 - direction);
		if(angle > Math.PI/2)
			angle-=Math.PI/2;
		direction+=2*angle;	
	}
	
	public void reflectY()
	{
		double angle = Math.abs(0 - direction);
		if(angle > 0)
			angle-=0;
		direction+=2*angle;
		
	}

	public void setlength(double newLength)
	{
		length=newLength;
	}
}
