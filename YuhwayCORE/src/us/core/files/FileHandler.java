package us.core.files;

import java.io.File;

import us.core.Core;
import us.core.files.types.Lang;
import us.core.files.types.Levels;
import us.core.files.types.Locations;
import us.core.files.types.Options;

public class FileHandler {

	public static void initFiles(Core plugin, File dataFolder) {
		
		Lang.initlang(dataFolder);
		Options.initoptions(dataFolder);
		Levels.initlevels(dataFolder);
		Locations.initlocations(dataFolder);
		
		
	}
	
}
