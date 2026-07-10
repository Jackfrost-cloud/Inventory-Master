package com.inventorymaster.item;

import com.inventorymaster.InventoryMasterMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;

public class BackpackItem extends Item {
    public BackpackItem(Properties settings) {
        super(settings);
    }

    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable("item.inventory-master.backpack");
    }

    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(InventoryMasterMod.MOD_ID, "backpack");
}
