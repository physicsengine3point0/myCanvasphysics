
public class GravityField extends Field
{

	private final static double G = .001;
	
	public GravityField() {
		// TODO Auto-generated constructor stub
	}

	public void calculateForces()
	{
		Vector[] forces = new Vector[Universe.matter.size()];
		for(int i=0;i<forces.length;i++)
			forces[i] = new Vector();
		for(int i = 0;i<Universe.matter.size(); i++)
		{
			
			for(int j=i+1;j<Universe.matter.size();j++)
			{
				Vector force = getForce(Universe.matter.get(i), Universe.matter.get(j));
				forces[i].add(force);
				force.reverse();
				forces[j].add(force);
			}
			
			//f=ma
			//a=f/m
			//dv=a*t
			Vector dv=forces[i];
			dv.setlength( dv.getLength()/Universe.matter.get(i).getMass() * Universe.timeStepLength);
			Universe.matter.get(i).velocity.add(dv);
		}
		
		
	}

	private Vector getForce(Particle zheta, Particle theta)
	{
		double distance=zheta.getLocation().getDistanceTo(theta.getLocation());
		double angle=zheta.getLocation().getAngleTo(theta.getLocation());
		double force = G*(zheta.getMass()*theta.getMass()) / Math.pow(distance, 2);
		return new Vector(force, angle);
	}
	
	public boolean userWantsGravity()
	{
		if(MyCanvas.UI.gravityResponse().equals("Yes")) return true;
		return false;
	}
	
	
}
