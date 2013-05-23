import java.util.*;

public class Location
{
	double x;
	double y;
	
	/**
	 * Creates a default location, 0,0
	 */
	public Location()
	{
		this.x=0;
		this.y=0;
	}
	
	/**
	 * Creates a location at specified coordinates.
	 */
	public Location(double xCoord,double yCoord)
	{
		this.x=xCoord;
		this.y=yCoord;
	}
	
	/**
	 * Copies a different location into current one.
	 * @param newLocation
	 */
	public void setLocation(Location newLocation)
	{
		x = newLocation.getX();
		y = newLocation.getY();
	}
	
	/**
	 * Returns the x coordinate of the location
	 * @return x
	 */
	public double getX()
	{
		return x;
	}
	
	/**
	 * Returns the y coordinate of the location.
	 * @return y
	 */
	public double getY()
	{
		return y;
	}
	
	/**
	 * Finds the distance to another specified location.
	 */
	public double getDistanceTo(Location a)
	{
		double xDistance=a.getX();
		double yDistance=a.getY();
		xDistance=Math.abs(xDistance-this.x);
		yDistance=Math.abs(yDistance-this.y);
		double distance=xDistance*xDistance+yDistance*yDistance;
		distance=Math.sqrt(distance);
		return distance;
	}
	
	/**
	 * Moves the location by the specified distance.
	 * @param v
	 */
	public void vectorMove(Vector v)
	{
		x+=v.getXComponent()*Universe.timeStepLength;
		y+=v.getYComponent()*Universe.timeStepLength;
	}

	/**
	 * Tests if the location is within the universe.
	 */
	public boolean inUniverse() {
		if(x > Universe.xSize)
		{
			x = Universe.xSize;
			return false;
		}
		else if(x < 0)
		{
			x=0;
			return false;
		}
		else if(y > Universe.ySize)
		{
			y=Universe.ySize;
			return false;
		}
		else if(y < 0)
		{
			y=0;
			return false;
		}
		else
		{
			return true;
		}
	}

	public double getAngleTo(Location theta)
	{
		Vector jim = new Vector(getDistanceTo(theta), Math.atan((theta.getY()-getY()) / (theta.getX()-getX())));
		return jim.getDirection();
	}
	
	/**
	 * Returns all particles within a given distance of this location.
	 * @param distance
	 */
	public ArrayList<Particle> getParticlesWithinDistance(int distance)
	{
		ArrayList<Particle> results=new ArrayList<Particle>();
		for(Particle particle:Universe.matter)
		{
			if(this.getDistanceTo(particle.getLocation())<=distance) 
			{
				System.out.println(this.getDistanceTo(particle.getLocation()));
				results.add(particle);
			}
		}
		return results;
	}
}
