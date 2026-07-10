package com.inventorymaster;

import com.inventorymaster.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InventoryMasterMod implements ModInitializer {
	public static final String MOD_ID = "inventory-master";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Inventory Master!");
		ModItems.register();
	}
}
