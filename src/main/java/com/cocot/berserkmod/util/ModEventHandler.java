package com.cocot.berserkmod.util;

import com.cocot.berserkmod.BerserkMod;
import net.minecraft.client.audio.Sound;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;


public class ModEventHandler {
    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event) {
        if (event.getEntity() instanceof WitherSkeletonEntity) {
            System.out.println("EVENTO MUERTE");
            if (RANDOM.nextFloat() < 0.9F) {
                ItemStack fang = new ItemStack(RegistryHandler.BEAST_FANG.get());
                event.getDrops().add(new ItemEntity(event.getEntity().world,
                        event.getEntity().getPosX(),
                        event.getEntity().getPosY(),
                        event.getEntity().getPosZ(),
                        fang));
            }
        }
    }
    private static final Random RANDOM = new Random();

    @SubscribeEvent
    public void onPlayerDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            if (player.inventory.hasItemStack(new ItemStack(RegistryHandler.CRIMSON_BEHELIT.get()))) {
                event.setCanceled(true);
                player.world.playSound(null, player.getPosition(), SoundEvents.ENTITY_WITHER_DEATH, SoundCategory.PLAYERS, 1.0F, 1.0F);
                player.setHealth(10.0F);
                player.sendMessage(new StringTextComponent(TextFormatting.DARK_RED + "A dream paid in blood"));
                player.addPotionEffect(new EffectInstance(RegistryHandler.SACRIFICE_BRAND.get(), 999999));
                ItemStack behelitStack = player.inventory.decrStackSize(player.inventory.getSlotFor(new ItemStack(RegistryHandler.CRIMSON_BEHELIT.get())), 1);

                for (int i = 0; i < 12; i++) {
                    if (i % 2 == 0) {
                        ZombieEntity zombie = new ZombieEntity(EntityType.ZOMBIE, player.world);
                        zombie.setPosition(player.getPosX() + i, player.getPosY(), player.getPosZ());
                        player.world.addEntity(zombie);
                    } else {
                        SkeletonEntity skeleton = new SkeletonEntity(EntityType.SKELETON, player.world);
                        skeleton.setPosition(player.getPosX() + i, player.getPosY(), player.getPosZ());
                        player.world.addEntity(skeleton);
                    }

                }
            }

        }

    }
}
