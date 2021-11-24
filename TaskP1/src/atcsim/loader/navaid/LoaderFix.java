package atcsim.loader.navaid;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.A_Loader;
import atcsim.world.navigation.A_ComponentNavaid;

public class LoaderFix extends A_Loader{

	public LoaderFix(Map<String, A_ComponentNavaid<?>> navaids, OverlayNavigation overlay) {
		super(navaids, overlay);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * fix1, 48,38,31, 116,24,29, 1949
	 * ID  , position or (longitude,latitude,altitude)
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
			System.out.println(split[0]);
						
			String[] longSplit = split[1].split(",");
			System.out.println(longSplit[0] + " " +longSplit[1]+ " " +longSplit[2]);
			
			String[] latSplit = split[2].split(",");
			System.out.println(latSplit[0] + " " +latSplit[1]+ " " +latSplit[2]);
			//since altitude only has one element in that array we just assign
			String altSplit = split[3];
			System.out.println(altSplit);
		}
		
	}

}
