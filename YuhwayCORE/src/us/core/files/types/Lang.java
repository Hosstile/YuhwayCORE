package us.core.files.types;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

import us.core.interfaces.Messages;
import us.core.utilities.utils;

public class Lang {

	public static File langFile;
	public static YamlConfiguration lang;

	public static void initlang(File dataFolder) {

		langFile = new File(dataFolder, "lang.yml");
		lang = YamlConfiguration.loadConfiguration(langFile);

		if (!(langFile.exists())) {
			utils.cms(Messages.prefix + "&cCreating lang.yml");
			savelang();
		}

	}

	public static void savelang() {
		try {
			lang.save(langFile);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
