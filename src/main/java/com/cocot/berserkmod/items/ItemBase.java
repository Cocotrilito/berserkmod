package com.cocot.berserkmod.items;

import com.cocot.berserkmod.BerserkMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase() {
        super(new Item.Properties().group(BerserkMod.TAB));
    }
}