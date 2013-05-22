import java.awt.Color;
import java.util.*;


public class Particle {
  
	//location and Direction
	Location myLocation;
	Vector velocity;

	//physical characteristics
	Color color;
	int size;
	int density;
	
	
	/**
	 * Creates a default particle with a random location, blue color, 5 pixel size, 1 density, and no velocity.
	 */
	public Particle(int xRange, int yRange)
	{
		this.myLocation = new Location(randInt(xRange), randInt(yRange));
		this.velocity = new Vector();
		this.color = Color.blue;
		this.size = 5;
		this.density = 1;
	}
	
	/**
	*creates a particle as defined by the user
	*/
	public Particle(double x, double y, double di, double sp, 
			Color co, int si, int den)
	{
		this.myLocation = new Location(x, y);
		this.velocity = new Vector(sp, di);
		this.color = co;
		this.size = si;
		this.density = den;
	}
	
	/**
	 * Returns the x coordinate of the particle's location.
	 */
	public double getX()
	{
		return myLocation.getX();
	}
	
	/**
	 * Returns the y coordinate of the particle's location.
	 */
	public double getY()
	{
		return myLocation.getY();
	}
	
	public int getDrawX()
	{
		return (int) Math.round(myLocation.getX());
	}
	
	public int getDrawY()
	{
		return (int) Math.round(myLocation.getY());
	}
	
	/**
	 * Returns the size of the particle.
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * Handles the particle's movement.
	 */
	public void move()
	{
		myLocation.vectorMove(velocity);
		this.checkOnWall();
		//this.collisionRunner();
	}
	
	
	/**
	 * Tests to see if the particle is against a wall.  If it is, it reverses the direction of its velocity.  
	 */
	public void checkOnWall()
	{
		
		//check if particle close enough to edge or beyond the edge; if true then
		//figure out if bouncing on "floor/ceiling" or bouncing on "walls"
		//get which axis to our angle is relative to surface.
		//add or subtract twice that angle.  
		
			if(Universe.getYSize()<=this.getDrawY())
				bounceYEdge();
			else if(this.getDrawY()<=0)
				bounceYEdge();
			else if(Universe.getXSize()<=this.getDrawX())
				bounceXEdge();
			else if(this.getDrawX()<=0)
				bounceXEdge();
			else
				return;
	}
	
	public void bounceYEdge()
	{
		double alpha =2*Math.PI - velocity.getDirection();
		velocity.setDirection(alpha);
	}
	
	public void bounceXEdge()
	{
		double axis = Math.PI /2;
		if (velocity.getDirection() > Math.PI)
			axis = 3*Math.PI / 2;
		
		double alpha = axis - velocity.getDirection();
		velocity.setDirection(velocity.getDirection() + 2*alpha);
	}

	/**
	 * Provides mechanics for the particle bouncing off of a wall.
	 */
	public void bounceOffEdge()
	{
		
		
		if(yInUniverse())
			velocity.reflectX();
		if(xInUniverse())
			velocity.reflectY();
	}
	
	/**
	 * A method that returns true if the particle is within the universe and false otherwise.  It should never need to return false.
	 */
	public boolean inUniverse()
	{
		if(this.yInUniverse())
		{
			return false;
		}
		else if(xInUniverse())
		{
			
			return false;
		}
		return true;
	}
	
	/**
	 * Tests to see if the y coordinate of the particle is within the universe.
	 * @return
	 */
	public boolean yInUniverse()
	{
		//if y is within this.getSize() from either edge or beyond, return false
		if(Universe.getYSize()>=this.getDrawY()||Universe.getYSize()<=0) return false;
		return true;
	}
	
	/**
	 * Tests to see if the x coordinate of the particle is within the universe
	 */
	public boolean xInUniverse()
	{
		if(Universe.getXSize()>=this.getDrawX()||Universe.getXSize()<=0) return false;
		return true;
	}

	
	/**
	 * Generates a pseudorandom integer within a given range.
	 * @param range
	 * @return
	 */
	private static int randInt(int range)
	{
		Random randNum = new Random();
		return randNum.nextInt(range);
	}
	
	/**
	 * Returns the color of the particle.
	 * @return color
	 */
	public Color getColor()
	{
		return color;
	}	

	/**
	 * Returns the particle's density
	 * @return density
	 */
	public int getDensity()
	{
		return density;
	}
	
	/**
	 * Returns the mass of the particle
	 */
	public double getMass()
	{
		return Math.pow((double)size, 2)*Math.PI*density;	
	}

	/**
	 * Returns the particle's location.
	 * @return myLocation
	 */
	public Location getLocation() {
		return myLocation;
	}
	
	/**
	 * Returns all particles that the particle is colliding with.
	 */
	public ArrayList<Particle> getNeighboringParticles()
	{
		return this.getLocation().getParticlesWithinDistance(this.size/2);
	}
	
	/**
	 * Checks to see if the particle is currently colliding with any other particles.
	 * @return
	 */
	public boolean checkColliding()
	{
		if(this.getNeighboringParticles().size()==0) return false;
		return true;
	}
	
	/**
	 * Runs collisions.
	 */
	private void collisionRunner()
	{
		if(checkColliding()==true)
		{
			Collision.collide(this, getNeighboringParticles().get(0));
			return;
		}
	}
	
}
