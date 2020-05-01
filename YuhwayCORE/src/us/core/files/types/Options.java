package us.core.files.types;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

import us.core.interfaces.Messages;
import us.core.utilities.utils;

public class Options {

	public static File optionsFile;
	public static YamlConfiguration options;

	public static void initoptions(File dataFolder) {

		optionsFile = new File(dataFolder, "options.yml");
		options = YamlConfiguration.loadConfiguration(optionsFile);

		if ((!optionsFile.exists())) {
			utils.cms(Messages.prefix + "&cCreating options.yml");
			saveoptions();
		}

	}

	public static void saveoptions() {
		try {
			options.save(optionsFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
