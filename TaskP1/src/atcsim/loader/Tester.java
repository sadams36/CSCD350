package atcsim.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.navaid.LoaderFix;
import atcsim.loader.navaid.LoaderNDB;
import atcsim.loader.navaid.LoaderVOR;
import atcsim.world.navigation.A_ComponentNavaid;

public class Tester {

	public static void main(String[] args) throws IOException {
		NavigationOverlayBuilder build = new NavigationOverlayBuilder();
		build.loadDefinition​("definition1.txt");
		/*
		// TODO Auto-generated method stub
		//testing the build
		//NavigationOverlayBuilder build = new NavigationOverlayBuilder();
		OverlayNavigation on = new OverlayNavigation("NAV");//not sure what string is supposed to be passed in - Samuel
		
		//reading from a file
		FileInputStream fis = new FileInputStream(new File("definition1.txt"));
		Scanner reader = new Scanner(fis);
		//Navaids will be stored in this hashmap
		HashMap<String, A_ComponentNavaid<?>> hm = new HashMap<>();
		
		LoaderFix lf = new LoaderFix(hm, on);
		lf.load(reader); //testing what line it grabs - Samuel
		
		
		LoaderNDB ndb = new LoaderNDB(hm,on);
		ndb.load(reader);
		
		LoaderVOR vor = new LoaderVOR(hm,on);
		vor.load(reader);
		
		for(Map.Entry<String, A_ComponentNavaid<?>> entry : hm.entrySet()) {
			System.out.println(entry.getKey()+ ":" + entry.getValue());
		}
		// Testing a Loader
			// Step 1: build a Map object (pass it a string and an A_ComponentNavaid<?>, unsure what these are at this point)
			// Step 2: build an OverlayNavigation object, pass it a string (the string represents an ID))
			// Step 3: pass the above two objects into the appropriate loader constructor
			// Step 4: print the new loader (assuming there's some sort of automatic toString)
	*/
	}

}
