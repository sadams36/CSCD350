package atcsim.loader.navaid;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import atcsim.datatype.Altitude;
import atcsim.datatype.CoordinateWorld3D;
import atcsim.datatype.Latitude;
import atcsim.datatype.Longitude;
import atcsim.datatype.UHFFrequency;
import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.A_Loader;
import atcsim.world.navigation.A_ComponentNavaid;
import atcsim.world.navigation.ComponentNavaidFix;
import atcsim.world.navigation.ComponentNavaidNDB;

public class LoaderNDB extends A_Loader{

	public LoaderNDB(Map<String, A_ComponentNavaid<?>> navaids, OverlayNavigation overlay) {
		super(navaids, overlay);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void load(Scanner scanner) throws IOException {
		// TODO Auto-generated method stub
		if(scanner == null)
			throw new IllegalArgumentException("Scanner is null");
		
		boolean load = true;
		
		scanner.nextLine();
		String lineToRead = scanner.nextLine();
		
		/*
		 * ndb1, 320,           48,38,31, 116,24,29, 1949
		 * id    uhf_frequency, poistion
		 */
		while(load)
			{
            //this split will have 5 sections that are based off of " ," in a line
            String[] split = lineToRead.split(", ");
            
            String id = split[0];
         //   System.out.println(id);
            
            String uFreq = split[1];
			UHFFrequency frequency = new UHFFrequency(Integer.parseInt(uFreq));
        //    System.out.println(uFreq);
            
          //used to make a latitude object
            String[] latSplit = split[2].split(",");
         //   System.out.println(latSplit[0] + " " +latSplit[1]+ " " +latSplit[2]);
            Latitude latitude = new Latitude(Integer.parseInt(latSplit[0]),Integer.parseInt(latSplit[1]),Double.parseDouble(latSplit[2])); 
            
            //used to make longitude object
            String[] longSplit = split[3].split(",");
      //      System.out.println(longSplit[0] + " " +longSplit[1]+ " " +longSplit[2]);
            Longitude longitude = new Longitude(Integer.parseInt(longSplit[0]),Integer.parseInt(longSplit[1]),Double.parseDouble(longSplit[2]));
               
            //since altitude only has one element in that array we just assign
            //used to make altitude object
            String altSplit = split[4];
	   //     System.out.println(altSplit);
	        Altitude altitude = new Altitude(Double.parseDouble(altSplit));
	            
	        
	        CoordinateWorld3D position = new CoordinateWorld3D(latitude, longitude, altitude);
			ComponentNavaidNDB fix = new ComponentNavaidNDB(id, position, frequency);//create the fix
	       
            this.navaids.put(split[0].trim(), fix);
            
            //checks if there is another line to be read
            lineToRead = scanner.nextLine();
            
			//conditions needed to stop reading the file 
            // if the nextline is blank or it is empty indicating the end of a file
            if(lineToRead.isBlank() || lineToRead.isEmpty())
            		load = false;
        }
		
	}

}
