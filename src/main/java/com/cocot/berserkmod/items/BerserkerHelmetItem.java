package com.cocot.berserkmod.items;

import com.cocot.berserkmod.BerserkMod;
import com.cocot.berserkmod.util.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class BerserkerHelmetItem extends ArmorItem {
    public BerserkerHelmetItem() {
        super(ModArmorMaterial.BERSERKER, EquipmentSlotType.HEAD,
            new Item.Properties().group(BerserkMod.TAB));
    }
}
