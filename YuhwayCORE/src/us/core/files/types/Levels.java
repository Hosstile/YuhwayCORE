package us.core.files.types;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

import us.core.interfaces.Messages;
import us.core.utilities.utils;

public class Levels {

	public static File levelsFile;
	public static YamlConfiguration levels;

	public static void initlevels(File dataFolder) {

		levelsFile = new File(dataFolder, "levels.yml");
		levels = YamlConfiguration.loadConfiguration(levelsFile);

		if (!(levelsFile.exists())) {
			utils.cms(Messages.prefix + "&cCreating levels.yml");
			savelevels();
		}

	}

	public static void savelevels() {
		try {
			levels.save(levelsFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
