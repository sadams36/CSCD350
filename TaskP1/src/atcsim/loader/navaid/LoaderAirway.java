package atcsim.loader.navaid;
import java.util.Map;
import java.util.Scanner;

import atcsim.datatype.CoordinateWorld3D;
import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.A_Loader;
import atcsim.support.Assert;
import atcsim.world.navigation.A_ComponentNavaid;
import atcsim.world.navigation.ComponentNavaidAirway;

public class LoaderAirway extends A_Loader{

	public LoaderAirway(Map<String, A_ComponentNavaid<?>> navaids, OverlayNavigation overlay) {
		super(navaids, overlay);

	}
	
	public void load(java.util.Scanner scanner) throws java.io.IOException 
	{
		/*
		 * uses the given scanner to load variables into this loader's navaids map.
		 */
		Assert.nonnull(scanner,"Scanner is null");
		
		ComponentNavaidAirway airway;//store the airway to return
		
		String id = loadID(scanner);//store id of the airway
		
		
		String type = loadAirwayType(scanner);//choose which type of airway
		switch(type) {
		case "CC":{
			//coordinate to coordinate
			CoordinateWorld3D pointA = loadPosition(scanner);
			CoordinateWorld3D pointB = loadPosition(scanner);
			
			//make the airway
			airway = new ComponentNavaidAirway(id,pointA,pointB);
			break;
			}
		case "NC":{
			//navaid to coordinate
			String stringA = loadID(scanner);
			CoordinateWorld3D pointB = loadPosition(scanner);
			
			//get navaid from the navaids map
			A_ComponentNavaid navA = navaids.get(stringA);
			
			//make the airway
			airway = new ComponentNavaidAirway(id,navA,pointB);
			break;
			}
		case "NN":{
			//navaid to navaid
			String stringA = loadID(scanner);
			String stringB = loadID(scanner);
			
			//get navaid from the navaids map
			A_ComponentNavaid navA = navaids.get(stringA);
			A_ComponentNavaid navB = navaids.get(stringA);
			
			//make the airway
			airway = new ComponentNavaidAirway(id,navA,navB);
			break;
			}
		default:
			throw new IllegalArgumentException("Error scanning in Airway");
		}
	}
	private String loadAirwayType(Scanner scanner) {
		/*
		 * scan what type of airway this will be from the file
		 */
		//scan until next comma like loadID
		return null; //TODO
	}
}
