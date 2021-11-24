package atcsim.loader.navaid;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import atcsim.datatype.Altitude;
import atcsim.datatype.CoordinateWorld3D;
import atcsim.datatype.Latitude;
import atcsim.datatype.Longitude;
import atcsim.datatype.UHFFrequency;
import atcsim.datatype.VHFFrequency;
import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.A_Loader;
import atcsim.world.navigation.A_ComponentNavaid;
import atcsim.world.navigation.ComponentNavaidNDB;
import atcsim.world.navigation.ComponentNavaidVOR;

public class LoaderVOR extends A_Loader{

	public LoaderVOR(Map<String, A_ComponentNavaid<?>> navaids, OverlayNavigation overlay) {
		super(navaids, overlay);
		// TODO Auto-generated constructor stub
	}
	/* Str   double 
	 * vor1, 118,1,       51,41,34, 119,27,32, 1952
	 * id	vhf_frequency position
	 */
	@Override
	public void load(Scanner scanner) throws IOException {
		// TODO Auto-generated method stub
		if(scanner == null)
			throw new IllegalArgumentException("Scanner is null");
		
		boolean load = true;
		
		scanner.nextLine();
		String lineToRead = scanner.nextLine();
		
		
        
		while(load) 
		{
		String[] split = lineToRead.split(", ");
		
        String id = split[0];
       // System.out.println(id);
        
        String[] vFreq = split[1].split(",");
		VHFFrequency frequency2 = new VHFFrequency(Integer.parseInt(vFreq[0]),Integer.parseInt(vFreq[1]));
       // System.out.println(vFreq[0] + " " + vFreq[1]);
		
		 //used to make a latitude object
        String[] latSplit = split[2].split(",");
       // System.out.println(latSplit[0] + " " +latSplit[1]+ " " +latSplit[2]);
        Latitude latitude = new Latitude(Integer.parseInt(latSplit[0]),Integer.parseInt(latSplit[1]),Double.parseDouble(latSplit[2])); 
        
        //used to make longitude object
        String[] longSplit = split[3].split(",");
      // System.out.println(longSplit[0] + " " +longSplit[1]+ " " +longSplit[2]);
        Longitude longitude = new Longitude(Integer.parseInt(longSplit[0]),Integer.parseInt(longSplit[1]),Double.parseDouble(longSplit[2]));
           
        //since altitude only has one element in that array we just assign
        //used to make altitude object
        String altSplit = split[4];
      //  System.out.println(altSplit);
        Altitude altitude = new Altitude(Double.parseDouble(altSplit));
        
        CoordinateWorld3D position = new CoordinateWorld3D(latitude, longitude, altitude);
		ComponentNavaidVOR fix = new ComponentNavaidVOR(id, position, frequency2);//create the fix
       
        this.navaids.put(split[0].trim(), fix);
        
        //checks if there is another line to be read
        lineToRead = scanner.nextLine();
        
		//conditions needed to stop reading the file 
        // if the nextline is blank or it is empty indicating the end of a file
        if(lineToRead.isBlank() || lineToRead.isEmpty())
        		load = false;
		}//
	}

}
