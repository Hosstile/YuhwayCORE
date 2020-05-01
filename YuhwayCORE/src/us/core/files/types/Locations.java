package us.core.files.types;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

import us.core.interfaces.Messages;
import us.core.utilities.utils;

public class Locations {

	public static File locationsFile;
	public static YamlConfiguration locations;

	public static void initlocations(File dataFolder) {

		locationsFile = new File(dataFolder, "locations.yml");
		locations = YamlConfiguration.loadConfiguration(locationsFile);

		if ((!locationsFile.exists())) {
			utils.cms(Messages.prefix + "&cCreating locations.yml");
			savelocations();
		}

	}

	public static void savelocations() {
		try {
			locations.save(locationsFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
