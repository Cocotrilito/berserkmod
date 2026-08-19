package com.cocot.berserkmod.items;

import com.cocot.berserkmod.BerserkMod;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BeastFangItem extends Item {
    public BeastFangItem() {super(new Item.Properties().group(BerserkMod.TAB)); }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(TextFormatting.DARK_RED + "It mends your bones with iron, and your soul with wrath."));
        super.addInformation(stack, worldIn, tooltip, flagIn);

    }
}
