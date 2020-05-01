package us.core.startup;

import us.core.Core;
import us.core.startup.notify.notifyStartup;

public class startupHandler {

	public startupHandler(Core plugin) {

		notifyStartup.notifyServer();

	}

}
