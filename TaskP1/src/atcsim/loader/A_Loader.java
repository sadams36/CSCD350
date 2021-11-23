package atcsim.loader;
import java.util.Map;
import java.util.Scanner;

import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.world.navigation.A_ComponentNavaid;

//template for the other loaders
public abstract class A_Loader {
	private Map<String,A_ComponentNavaid<?>> navaids;//?
	private OverlayNavigation overlay;
	public A_Loader(Map<String,A_ComponentNavaid<?>> navaids,OverlayNavigation overlay)
	{
		/*
		 * saves the navaids sent over by NavigationOverlayBuilder
		 * so that it can be added to? - steven
		 */
		this.navaids = navaids;
		this.overlay = overlay;
	}
	
	//change to protected?
	public abstract void load(Scanner scanner) throws java.io.IOException;
		//what should this do?
	
	protected void loadID(Scanner scanner) //not sure if this needs to be void or a String return type - Steven
	{
		//load the next portion of text as an ID
	}
	protected void loadPosition(Scanner scanner) //not sure if this needs to be void or a different return type - Steven
	{
		//load the next portion of text as a position
	}
	protected void loadUHF_Frequency(Scanner scanner) //not sure if this needs to be void or a different return type - Steven
	{
		//load the next portion of text as a uhf_frequency
	}
	protected void loadVHF_Frequency(Scanner scanner) //not sure if this needs to be void or a different return type - Steven
	{
		//load the next portion of text as a vhf_frequency
	}
	
}
