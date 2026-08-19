package com.cocot.berserkmod.items;

import com.cocot.berserkmod.BerserkMod;
import com.cocot.berserkmod.util.RegistryHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

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
    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) attacker;
            ItemStack helmet = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
            ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
            ItemStack leggings = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
            ItemStack boots = player.getItemStackFromSlot(EquipmentSlotType.FEET);
            if (!helmet.getItem().equals(RegistryHandler.BERSERKER_HELMET.get()) &&
                !chest.getItem().equals(RegistryHandler.BERSERKER_CHESTPLATE.get()) &&
                !leggings.getItem().equals(RegistryHandler.BERSERKER_LEGGINGS.get()) &&
                !boots.getItem().equals(RegistryHandler.BERSERKER_BOOTS.get())) {
                player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 160, 1));
                player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 160, 0));
            }
        }

    return  true;
    }
}
