package atcsim.loader.navaid;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import atcsim.datatype.Altitude;
import atcsim.datatype.CoordinateWorld3D;
import atcsim.datatype.Latitude;
import atcsim.datatype.Longitude;
import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.A_Loader;
import atcsim.world.navigation.A_ComponentNavaid;
import atcsim.world.navigation.ComponentNavaidFix;

public class LoaderFix extends A_Loader{

	public LoaderFix(Map<String, A_ComponentNavaid<?>> navaids, OverlayNavigation overlay) {
		super(navaids, overlay);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * fix1, 48,38,31, 116,24,29, 1949
	 * ID  , position or (latitude,longitude,altitude)
	 */
	@Override
	public void load(Scanner scanner) throws IOException {
		// TODO Auto-generated method stub
		if(scanner == null)
			throw new IllegalArgumentException("Scanner is null");
		//load will be used to move down the file
		boolean load = true;
		
		scanner.nextLine(); // reads the header which we dont need
		String lineToRead = scanner.nextLine(); // reads the first line. Will be used to determine 
												// if the file has reached the end or has a blank line

	
			while(load)
	        {
	            //this split will have 4 sections that are based off of " ," in a line
	            String[] split = lineToRead.split(", ");
	            
	            String id = split[0];
	            //System.out.println(id);
	            
	            //used to make a latitude object
	            String[] latSplit = split[1].split(",");
	           // System.out.println(latSplit[0] + " " +latSplit[1]+ " " +latSplit[2]);
	            Latitude latitude = new Latitude(Integer.parseInt(latSplit[0]),Integer.parseInt(latSplit[1]),Double.parseDouble(latSplit[2])); 
	            
	            //used to make longitude object
	            String[] longSplit = split[2].split(",");
	         //  System.out.println(longSplit[0] + " " +longSplit[1]+ " " +longSplit[2]);
	            Longitude longitude = new Longitude(Integer.parseInt(longSplit[0]),Integer.parseInt(longSplit[1]),Double.parseDouble(longSplit[2]));
	            
	          
	            //since altitude only has one element in that array we just assign
	            //used to make altitude object
	            String altSplit = split[3];
	          //  System.out.println(altSplit);
	            Altitude altitude = new Altitude(Double.parseDouble(altSplit));
	            
	            //ComponentNavaidFix requires a CoordinateWorld3D object
	            //ComponentNavaidFix makes a navaid.
	            CoordinateWorld3D coordinate = new CoordinateWorld3D(latitude,longitude,altitude);
	            ComponentNavaidFix fix = new ComponentNavaidFix(id,coordinate); 
	            
	            this.navaids.put(split[0].trim(), fix);
	            
	            //checks if there is another line to be read
	            lineToRead = scanner.nextLine();
	            	
	            //conditions needed to stop reading the file 
	            // if the nextline is blank or it is empty indicating the end of a file
	            if(lineToRead.isBlank() || lineToRead.isEmpty())
	            		load = false;
	           //
	        }		
	}

}
