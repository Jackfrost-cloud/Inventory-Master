package com.inventorymaster.item;

import com.inventorymaster.InventoryMasterMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class ModItems {
    public static Item BACKPACK;

    private static Item registerItem(String name, Item item) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(InventoryMasterMod.MOD_ID, name);
        return Registry.register(BuiltInRegistries.ITEM, id, item);
    }

    public static void register() {
        InventoryMasterMod.LOGGER.info("Registering mod items for {}", InventoryMasterMod.MOD_ID);
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(InventoryMasterMod.MOD_ID, "backpack");
        BACKPACK = registerItem("backpack", new Item(new Item.Properties()
                .stacksTo(1)
                .setId(ResourceKey.create(Registries.ITEM, id))));

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {
            entries.getDisplayStacks().add(BACKPACK.getDefaultInstance());
        });
    }
}
