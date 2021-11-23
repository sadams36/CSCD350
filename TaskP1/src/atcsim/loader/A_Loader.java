package atcsim.loader;
import java.util.Map;
import java.util.Scanner;

import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.world.navigation.A_ComponentNavaid;

//template for the other loaders
public abstract class A_Loader {
	private Map<String,A_ComponentNavaid<?>> navaids;//?
	private OverlayNavigation overlay;
	public A_Loader(Map<String,A_ComponentNavaid<?>> navaids,OverlayNavigation overlay)
	{
		this.navaids = navaids;
		this.overlay = overlay;
	}
	
	//change to protected?
	public abstract void load(Scanner scanner) throws java.io.IOException;
		//what do this do?
}
