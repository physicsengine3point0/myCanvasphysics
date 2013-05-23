
public class Collision
{
	
	//this creates an object that calculates two particles
	//and returns them
	public Collision()
	{
		
	}
	
	/**
	 * Collides two particles.
	 * @param a
	 * @param b
	 */
	public static void collide(Particle a, Particle b)
	{
		Particle aTemp=twoDCollisionAonB(a, b);
		Particle bTemp=twoDCollisionBonA(a,b);
		a=aTemp;
		b=bTemp;
	}

	public static double angleBetween(Vector a, Vector b)
	{
		return Math.abs(b.getDirection()-a.getDirection());
	}
	
	/**
	 * Returns the velocity of Particle B following being hit by particle A
	 * @param A
	 * @param B
	 * @return
	 */
	public static Particle twoDCollisionAonB(Particle A, Particle B)
	{
		double directionChanged=A.velocity.direction;
		rotateVectors(A, B);
		double tempA=oneDimensionCollision(A, B);
		double tempB=oneDimensionCollision(B, A);
		A.velocity.length=tempA;
		B.velocity.length=tempB;
		A.velocity.direction=A.velocity.direction+directionChanged;
		B.velocity.direction=Vector.normalizeDirection(B.velocity.direction+directionChanged);
		return A;
	}
	
	/**
	 * Returns the velocity of particle A following a hit on particle B.
	 * @param A
	 * @param B
	 * @return
	 */
	public static Particle twoDCollisionBonA(Particle A, Particle B)
	{
		double directionChanged=A.velocity.direction;
		rotateVectors(A, B);
		double tempA=oneDimensionCollision(A, B);
		double tempB=oneDimensionCollision(B, A);
		A.velocity.length=tempA;
		B.velocity.length=tempB;
		restoreDirections(A, B, directionChanged);
		return B;
	}
	
	/**
	 * Does the reverse of rotateVectors().
	 * @param A
	 * @param B
	 * @param directionChanged
	 */
	public static void restoreDirections(Particle A, Particle B, double directionChanged)
	{
		A.velocity.direction=A.velocity.direction+directionChanged;
		B.velocity.direction=Vector.normalizeDirection(A.velocity.direction+directionChanged);
	}
	
	/**
	 * Sets the velocity of the two included particles so that the direction of A is the x direction.
	 * @param A
	 * @param B
	 */
	public static void rotateVectors(Particle A, Particle B)
	{
		double rotation=A.velocity.direction;
		B.velocity.direction=Vector.normalizeDirection(B.velocity.direction-rotation);
		A.velocity.direction=0;
	}	
	
	/**
	 * Returns the output velocity of particle A following a one dimensional collision with B.
	 * @param a
	 * @param b
	 * @return velocity
	 */
	public static double oneDimensionCollision(Particle a, Particle b)
	{
		double velocity=a.velocity.length*(a.getMass()-b.getMass())+2*b.getMass()*b.velocity.length;
		return velocity/(a.getMass()+b.getMass());
	}
	
	/**
	 * Returns a location that would be the endpoint of Vector a if a started at the origin.
	 * @param a
	 */
	public Location getEndPointFromOrigin(Vector a)
	{
		return new Location(a.getXComponent(), a.getYComponent());
	}
	
	/**
	 * Returns the dot product of given vectors.
	 * @param a
	 * @param b
	 */
	public double dotProduct(Vector a, Vector b)
	{
		return a.length*b.length*Math.cos(angleBetween(a, b));
	}
}
