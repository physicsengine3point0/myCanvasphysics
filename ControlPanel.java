import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends Frame implements ActionListener
{
  private Choice gravityChoice;
	
	public ControlPanel()
	{
		gravityChoice=new Choice();
		gravityChoice.add("Yes");
		gravityChoice.add("No");
	}
	
	/**
	 * Returns "Yes" or "No" depending on whether the user wants gravity to be on.  This can be used with the boolean gravityOn();
	 * @return
	 */
	public String gravityResponse()
	{
		return gravityChoice.getSelectedItem();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
