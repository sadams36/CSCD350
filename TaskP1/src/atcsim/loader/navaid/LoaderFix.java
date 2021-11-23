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
		
		while(!(scanner.nextLine().isEmpty()))
		{
			System.out.println(scanner.nextLine());//testing line grab for fix
		}
	}

}
