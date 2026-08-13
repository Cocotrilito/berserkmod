package com.cocot.berserkmod.items;

import com.cocot.berserkmod.BerserkMod;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class CrimsonBehelitItem extends Item {
    public CrimsonBehelitItem() {
        super(new Item.Properties().group(BerserkMod.TAB).maxStackSize(1).rarity(Rarity.EPIC));
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(TextFormatting.DARK_RED + "It stirs when the fate contracts."));
        tooltip.add(new StringTextComponent(TextFormatting.GRAY + "" + TextFormatting.ITALIC + "The Eclipse Remembers your name"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}
