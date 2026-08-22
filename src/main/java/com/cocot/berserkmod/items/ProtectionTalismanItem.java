package com.cocot.berserkmod.items;

import com.cocot.berserkmod.BerserkMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class ProtectionTalismanItem extends Item {
    public ProtectionTalismanItem() { super(new Item.Properties().group(BerserkMod.TAB).food(new Food.Builder().build()));


    }
}
