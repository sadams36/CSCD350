package atcsim.loader.navaid;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import atcsim.datatype.Altitude;
import atcsim.datatype.AngleNavigational;
import atcsim.datatype.CoordinateWorld3D;
import atcsim.datatype.Distance;
import atcsim.datatype.VHFFrequency;
import atcsim.graphics.view.navigation.OverlayNavigation;
import atcsim.loader.A_Loader;
import atcsim.world.navigation.A_ComponentNavaid;
import atcsim.world.navigation.ComponentNavaidILS;
import atcsim.world.navigation.NavaidILSBeaconDescriptor;

public class LoaderILS extends A_Loader{

	public LoaderILS(Map<String, A_ComponentNavaid<?>> navaids, OverlayNavigation overlay) {
		super(navaids, overlay);
	}

	@Override
	public void load(Scanner scanner) throws IOException {
		/*
		 * load 'em in bois
		 */
		String id = loadID(scanner);
        VHFFrequency vfreq = loadVHF_Frequency(scanner);
        CoordinateWorld3D position = loadPosition(scanner);
        AngleNavigational azim = loadAzimuth(scanner);
        NavaidILSBeaconDescriptor beaconA = loadBeacon(scanner);
        NavaidILSBeaconDescriptor beaconB = loadBeacon(scanner);
        NavaidILSBeaconDescriptor beaconC = loadBeacon(scanner);
        //yes they are in a different order in the constructor, its just like that okay?
        ComponentNavaidILS navILS = new ComponentNavaidILS(id,position,azim,vfreq,beaconA,beaconB,beaconC);
        navaids.put(id, navILS);
	}
	private AngleNavigational loadAzimuth(Scanner scanner) {
		/*
		 * scans in an Azimuth
		 */
		double angle = scanner.nextDouble();
		return new AngleNavigational(angle);
	}
	private NavaidILSBeaconDescriptor loadBeacon(Scanner scanner) {
		/*
		 * scans in a beacon
		 */
		double distDouble = scanner.nextDouble();
		double altDouble = scanner.nextDouble();
		Distance dist = new Distance(distDouble);
		Altitude alt = new Altitude(altDouble);
		
		return new NavaidILSBeaconDescriptor(dist,alt);
	}
}
