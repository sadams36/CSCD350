package atcsim.loader;
import java.util.Map;
import java.util.Scanner;

import atcsim.datatype.Altitude;
import atcsim.datatype.CoordinateWorld3D;
import atcsim.datatype.Latitude;
import atcsim.datatype.Longitude;
import atcsim.datatype.UHFFrequency;
import atcsim.datatype.VHFFrequency;
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

		//what do this do?
	// add methods to read common inputs for a navaid

		//what should this do?
	
	protected void loadID(Scanner scanner) //not sure if this needs to be void or a String return type - Steven
	{
		//load the next portion of text as an ID
	}
	protected CoordinateWorld3D loadPosition(Scanner scanner)
	{
		/*
		 * load the next portion of text as a position
		 * 
		 * they *DO* have to be in this order
		 */
		
		Latitude lat = loadLatitude(scanner);
		Longitude lon = loadLongitude(scanner);
		Altitude alt = loadAltitude(scanner);
		
		return new CoordinateWorld3D(lat,lon,alt);
	}
	protected Latitude loadLatitude(Scanner scanner) 
	{
		//store variables for clarity
		int degrees;
		int minutes;
		double seconds;
		
		//load latitude
		degrees = scanner.nextInt();
		minutes = scanner.nextInt();
		seconds = scanner.nextDouble();
		return new Latitude(degrees,minutes,seconds);
	}
	protected Longitude loadLongitude(Scanner scanner) 
	{
		//store variables for clarity
		int degrees;
		int minutes;
		double seconds;
		
		//load longitude
		degrees = scanner.nextInt();
		minutes = scanner.nextInt();
		seconds = scanner.nextDouble();
		
		return new Longitude(degrees,minutes,seconds);
	}
	protected Altitude loadAltitude(Scanner scanner)//this probably doesnt need its own method but i like having it consistent - Steven
	{
		//get the next double, assuming it's altitude
		return new Altitude(scanner.nextDouble());
	}
	
	protected UHFFrequency loadUHF_Frequency(Scanner scanner) 
	{
		//load the next portion of text as a uhf_frequency
		return null;//TODO
	}
	protected VHFFrequency loadVHF_Frequency(Scanner scanner) 
	{
		//load the next portion of text as a vhf_frequency
		return null;//TODO
	}
	
}