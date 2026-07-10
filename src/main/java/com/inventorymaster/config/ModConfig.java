package com.inventorymaster.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Configuration management for Inventory Master
 */
public class ModConfig {
	private static ModConfig instance;
	private final Path configDir;
	private final Path configFile;

	// Configuration options
	public boolean enableAutoSort = true;
	public boolean enableFavoriteSlots = true;
	public boolean enableCategorization = true;
	public boolean enableSmartDeposit = true;
	public boolean enableSearchBar = true;
	public boolean enableVirtualBags = true;

	private ModConfig() {
		this.configDir = Paths.get("config/inventory-master");
		this.configFile = configDir.resolve("config.properties");
		ensureConfigDir();
	}

	public static ModConfig getInstance() {
		if (instance == null) {
			instance = new ModConfig();
			instance.load();
		}
		return instance;
	}

	/**
	 * Ensures the config directory exists
	 */
	private void ensureConfigDir() {
		try {
			Files.createDirectories(configDir);
		} catch (IOException e) {
			System.err.println("Failed to create config directory: " + e.getMessage());
		}
	}

	/**
	 * Loads configuration from file
	 */
	public void load() {
		try {
			if (Files.exists(configFile)) {
				// TODO: Parse config file and set properties
			} else {
				save();
			}
		} catch (Exception e) {
			System.err.println("Failed to load config: " + e.getMessage());
		}
	}

	/**
	 * Saves configuration to file
	 */
	public void save() {
		try {
			StringBuilder content = new StringBuilder();
			content.append("# Inventory Master Configuration\n\n");
			content.append("enableAutoSort=").append(enableAutoSort).append("\n");
			content.append("enableFavoriteSlots=").append(enableFavoriteSlots).append("\n");
			content.append("enableCategorization=").append(enableCategorization).append("\n");
			content.append("enableSmartDeposit=").append(enableSmartDeposit).append("\n");
			content.append("enableSearchBar=").append(enableSearchBar).append("\n");
			content.append("enableVirtualBags=").append(enableVirtualBags).append("\n");

			Files.write(configFile, content.toString().getBytes());
		} catch (IOException e) {
			System.err.println("Failed to save config: " + e.getMessage());
		}
	}

	/**
	 * Gets the config file path
	 */
	public Path getConfigFile() {
		return configFile;
	}

	/**
	 * Resets to defaults
	 */
	public void resetToDefaults() {
		enableAutoSort = true;
		enableFavoriteSlots = true;
		enableCategorization = true;
		enableSmartDeposit = true;
		enableSearchBar = true;
		enableVirtualBags = true;
		save();
	}
}
