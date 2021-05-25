package odogo.whendb.util;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.file.FileConfiguration;

import odogo.whendb.WhenDayBreaks;

public class Configuration {

	private WhenDayBreaks plugin;
	public Configuration(WhenDayBreaks plugin) {
		this.plugin = plugin;
		configType = new HashMap<>();
	}

	private Map<ConfigTypes, String> configType;

	public void reload() {
		FileConfiguration config = plugin.getConfig();

		for(ConfigTypes types : ConfigTypes.values())
			configType.put(types, config.get(types.getConfigPath()).toString());
	}

	public void save() {
		FileConfiguration config = plugin.getConfig();

		for(ConfigTypes types : ConfigTypes.values())
			config.set(types.getConfigPath(), configType.get(types));

		plugin.saveConfig();
	}

	public enum ConfigTypes {
		affected_world,

		// CATEGORY Sunlight
		starting_damage, starting_seconds, min_seconds, max_damage,

		// CATEGORY Blocks
		allow_all_glass, allow_black_glass,

		// CATEGORY Helmet
		helmet_active, share_same_starting,
		helm_starting_damage, helm_starting_seconds,
		unbreaking_affectiveness,

		// CATEGORY Healing
		deny_nat_regen, deny_heal_from_gapple, deny_healing_potions,
		medkits_allowed, medkits_usage_time, medkits_health_grant, medkits_revokes_bleeding, medkits_pauses_bleeding,
		bandages_allowed, bandages_usage_time, bandages_health_grants, bandages_revokes_bleeding, bandages_pauses_bleeding,

		// CATEGORY Daylight Cycle
		changed, clocks_tell_time, day_time, night_time,

		// CATEGORY Sleeping
		allowed_anytime, time_between_each, progression, sleepy,
		damaged_allowed, damaged_health_grant, damaged_hunger_revoke, damaged_bleeding_reduction,

		// CATEGORY Additional Items
		curing_seeds, cured_rotten_flesh, cooked_cured_rotten_flesh, cooked_bread, smoked_bread,

		// CATEGORY Events - its-safe-for-now
		isfn_name, isfn_chance,

		// CATEGORY sun-deadly-laser
		sdl_name, sdl_chance,

		// CATEGORY sender-somewhere
		ssw_name, ssw_chance;

		private String configPath;
		ConfigTypes(String configPath) { this.configPath = configPath; }
		public String getConfigPath() { return configPath; }
	}
}
