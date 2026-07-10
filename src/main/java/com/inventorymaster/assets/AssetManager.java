package com.inventorymaster.assets;

import com.inventorymaster.InventoryMasterMod;

/**
 * Manages asset loading and caching for Inventory Master
 */
public class AssetManager {
	private static AssetManager instance;

	private AssetManager() {}

	public static AssetManager getInstance() {
		if (instance == null) {
			instance = new AssetManager();
		}
		return instance;
	}

	/**
	 * Gets a texture identifier string for an asset
	 */
	public String getTexture(String path) {
		return InventoryMasterMod.MOD_ID + ":textures/" + path;
	}

	/**
	 * Gets a GUI texture identifier
	 */
	public String getGuiTexture(String name) {
		return getTexture("gui/" + name);
	}

	/**
	 * Gets a button texture
	 */
	public String getButtonTexture(String buttonName) {
		return getGuiTexture("buttons/" + buttonName + ".png");
	}

	/**
	 * Gets a category tab texture
	 */
	public String getCategoryTabTexture(String categoryName) {
		return getGuiTexture("tabs/" + categoryName + "_tab.png");
	}

	/**
	 * Gets the mod icon texture
	 */
	public String getModIcon() {
		return InventoryMasterMod.MOD_ID + ":icon.png";
	}

	/**
	 * Pre-loads all common button textures
	 */
	public void preloadAllButtonTextures() {
		InventoryMasterMod.LOGGER.info("Pre-loading button textures");
	}

	/**
	 * Pre-loads all category tab textures
	 */
	public void preloadAllCategoryTextures() {
		InventoryMasterMod.LOGGER.info("Pre-loading category textures");
	}
}
