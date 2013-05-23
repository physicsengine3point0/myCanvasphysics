import java.awt.*;

import javax.swing.*;
public class MyCanvas extends Canvas
{  
	static Universe reality;
	final static int numParticles=2;
	final static int uniX=500;
	final static int uniY=500;
	public static ControlPanel UI;

    
	/**
	 * Constructor for MyCanvas class.  Doesn't do anything else 
	 * 
	 * 
	 */
    public MyCanvas()
    {
    }
 
    public void paint(Graphics graphics)
    {
    	
    	
    	int startTime = (int)System.nanoTime();
        Universe.timeStep();
         	
        drawBackground(graphics);
         	
        drawUniverse(graphics);
        int endTime = (int)System.nanoTime();
       // System.out.println(endTime-startTime);
         	try{

         		  Thread.sleep(10);
         		}catch(InterruptedException ex){
         		  //do stuff
         		}
         		
         	

    }
    
    private void drawBackground(Graphics graphics)
    {
		graphics.setColor(Color.GRAY);
		graphics.fillRect(0,0,Universe.xSize,Universe.ySize);
		
	}

	private void endReality(Graphics graphics) {
		graphics.fillRect(0, 0, Universe.xSize, Universe.ySize);
		
	}

	private void drawUniverse(Graphics graphics)
    {
    	for(Particle particle : Universe.matter)
    	{
    		graphics.setColor(particle.getColor());
    		int drawX = particle.getDrawX() - particle.getSize()/2;
    		int drawY = particle.getDrawY() - particle.getSize()/2;
    		
    		graphics.fillOval(drawX, drawY, particle.getSize(), particle.getSize());
    		graphics.setColor(Color.blue);
    	}
    	
	}

	public static void main(String[] args)
    {
		UI=new ControlPanel();
		new Universe(uniX, uniY);
		for(int i=0;i<numParticles;i++)
			Universe.addBBParticle();
		
		
		
        MyCanvas canvas = new MyCanvas();
        JFrame frame = new JFrame();
        frame.setSize(Universe.xSize, Universe.ySize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(canvas);
        frame.setVisible(true);
        
        for(int i=0;i<Universe.getLength();i++)
        {
        	canvas.paint(canvas.getGraphics());
        }
        canvas.endReality(canvas.getGraphics());
    }
 
    
}
