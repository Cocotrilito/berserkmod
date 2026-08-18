package com.cocot.berserkmod.items;

import com.cocot.berserkmod.BerserkMod;
import com.cocot.berserkmod.util.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class BerserkerArmorItem extends ArmorItem {
    public BerserkerArmorItem(EquipmentSlotType slot) {
        super(ModArmorMaterial.BERSERKER, slot,
                new Item.Properties().group(BerserkMod.TAB));
    }
}
