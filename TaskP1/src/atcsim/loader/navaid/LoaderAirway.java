package atcsim.loader.navaid;
import java.util.Map;

import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.A_Loader;
import atcsim.world.navigation.A_ComponentNavaid;

public class LoaderAirway extends A_Loader{

	public LoaderAirway(Map<String, A_ComponentNavaid<?>> navaids, OverlayNavigation overlay) {
		/*
		 * saves the navaids sent over by NavigationOverlayBuilder
		 */
		
		super(navaids, overlay);
		// TODO Auto-generated constructor stub
	}
	
	public void load(java.util.Scanner scanner) throws java.io.IOException 
	{
		/*
		 * uses the given scanner to load variables into this loader's navaids map.
		 */
		
	}
}
