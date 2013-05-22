import java.awt.*;
import java.awt.event.*;

public class ControlPanel extends Frame implements ActionListener
{
	private Choice gravityChoice;
	
	public ControlPanel()
	{
		gravityChoice = new Choice();
		gravityChoice.add("Yes");
		gravityChoice.add("No");
		
		Panel myPanel = new Panel();
		myPanel.setLayout(new FlowLayout());
		myPanel.add(new Label("Gravity:"));
		myPanel.add(gravityChoice);
		add(myPanel, BorderLayout.CENTER);
		
		pack();
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
		setVisible(true);
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
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub	
	}
	
}
