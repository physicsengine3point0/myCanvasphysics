import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;


public class Universe {
	
	public static boolean gravityOn=false;
	
	static int xSize;
	static int ySize;
	
	static int time;
	
	static ArrayList<Particle> matter;
	static GravityField gravity;
	
	final static double timeStepLength=.01;

	
	/**
	 * Creates an empty universe with 500 time steps until death.
	 * @param x
	 * @param y
	 */
	public Universe(int x, int y)
	{
		Universe.xSize = x;
		Universe.ySize = y;
		Universe.time = 10000;
		Universe.matter = new ArrayList<Particle>();
		Universe.gravity = new GravityField();
	}
	
	/**
	 * Returns time
	 * @return time
	 */
	public static int getLength() {
		return time;
	}
	
	/**
	 * Adds a generic, stationary particle to the universe.
	 */
	public static void addParticle()
	{
		matter.add(new Particle(xSize, ySize));
	}
	
	
	/**
	 * Calculates the next position of each particles and handles overall movement.
	 */
	public static void timeStep()
	{
		if(gravityOn)
			gravity.calculateForces();
		
		for(int i=0;i<matter.size();i++)
			matter.get(i).move();
	}

	/**
	 * Returns the width of the universe.
	 * @return xSize
	 */
	public static int getXSize()
	{
		return xSize;
	}
	
	/**
	 * Returns the height of the universe
	 * @return ySize
	 */
	public static int getYSize()
	{
		return ySize;
	}

	/**
	 * Adds a basic blue particle to the universe.
	 */
	public static void addBBParticle() {
		matter.add(new BBParticle( (double)randInt(xSize), (double)randInt(ySize), (double)randInt(12), (double)randInt(20)*Math.PI/((double)randInt(10))));
		//matter.add(new BBParticle( (double)randInt(xSize), (double)randInt(ySize), 0, 0));
	}
	
	/**
	 * Generates a random integer within a given range.
	 * @param range
	 */
	private static int randInt(int range)
	{
		Random randNum = new Random();
		return randNum.nextInt(range);
	}
}
