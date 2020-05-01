package us.core.autosave;

import us.core.Core;
import us.core.autosave.autosaver.autosaver;

public class AutoSave {
	
	public AutoSave(Core plugin) {
		autosaver.saver(plugin);
	}

}
