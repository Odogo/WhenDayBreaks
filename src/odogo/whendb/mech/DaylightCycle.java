package odogo.whendb.mech;

import org.bukkit.scheduler.BukkitRunnable;

import odogo.whendb.WhenDayBreaks;

public class DaylightCycle extends BukkitRunnable {

	private WhenDayBreaks plugin;

	// Options / Settings (in seconds)
	private static final int DAY = 15 * 60;
	private static final int NIGHT = 15 * 60;

	public DaylightCycle(WhenDayBreaks plugin) {
		this.plugin = plugin;
	}

	private boolean day = true;
	private int time = 0;

	@Override public void run() {
		if(day && time >= DAY) {



			time = 0;
			day = false;

		} else if(!day && time >= NIGHT) {

		}
	}

	public synchronized void startCycle() {
		runTaskTimer(plugin, 0, 20L);
	}
}
