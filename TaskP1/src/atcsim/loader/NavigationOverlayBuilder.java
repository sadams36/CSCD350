package atcsim.loader;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.navaid.LoaderAirway;
import atcsim.loader.navaid.LoaderFix;
import atcsim.loader.navaid.LoaderILS;
import atcsim.loader.navaid.LoaderNDB;
import atcsim.loader.navaid.LoaderVOR;
import atcsim.world.navigation.A_ComponentNavaid;

public class NavigationOverlayBuilder {
	//Scanner scanner;
	public NavigationOverlayBuilder() {
		// TODO Auto-generated constructor stub
		System.out.println("Executing your code");
		
	}
	/*
	 * Loads the definition file and builds the navaids by
	 * calling their appropriate loaders.(
	 */
	public OverlayNavigation loadDefinition​(java.lang.String filespec) throws java.io.IOException
	{
		FileInputStream inf = new FileInputStream(new File(filespec));
		Scanner reader = new Scanner(inf);
		
		OverlayNavigation on = new OverlayNavigation("NAV");
		HashMap<String, A_ComponentNavaid<?>> hm = new HashMap<>();
		
		LoaderFix lf = new LoaderFix(hm, on);
		lf.load(reader); 
		
		LoaderNDB ndb = new LoaderNDB(hm,on);
		ndb.load(reader);
		
		LoaderVOR vor = new LoaderVOR(hm,on);
		vor.load(reader);
		
		/* Code makes the program crash
		LoaderILS ils = new LoaderILS(hm,on);
		ils.load(reader);
		
		LoaderAirway air = new LoaderAirway(hm,on);
		air.load(reader);
		*/
		
		for(Map.Entry<String, A_ComponentNavaid<?>> entry : hm.entrySet()) {
			System.out.println(entry.getKey()+ ":" + entry.getValue());
			
		
		//test
		}
		return on;
	}
}