package com.cocot.berserkmod.items;

import com.cocot.berserkmod.BerserkMod;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import java.util.List;

public class DragonSlayerItem extends SwordItem {
    public DragonSlayerItem() {
        super(ItemTier.DIAMOND, 10, -3.2F, new Item.Properties().group(BerserkMod.TAB));
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn,
                               List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(TextFormatting.DARK_GRAY + "It was too big to be called a sword"));
        tooltip.add(new StringTextComponent(TextFormatting.DARK_GRAY + "It was more like a" + TextFormatting.GRAY + "large hunk" + TextFormatting.DARK_GRAY + " of " + TextFormatting.GRAY + "raw iron" + TextFormatting.RESET));
        super.addInformation(stack,worldIn, tooltip, flagIn);
    }

}
