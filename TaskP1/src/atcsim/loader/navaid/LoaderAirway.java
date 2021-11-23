package atcsim.loader.navaid;
import java.util.Map;
import java.util.Scanner;

import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.A_Loader;
import atcsim.world.navigation.A_ComponentNavaid;

public class LoaderAirway extends A_Loader{

	public LoaderAirway(Map<String, A_ComponentNavaid<?>> navaids, OverlayNavigation overlay) {
		super(navaids, overlay);

	}
	
	public void load(java.util.Scanner scanner) throws java.io.IOException 
	{
		/*
		 * uses the given scanner to load variables into this loader's navaids map.
		 */
	}
	private void loadAirwayType(Scanner scanner) {
		/*
		 * scan what type of airway this will be from the file
		 */
	}
}
