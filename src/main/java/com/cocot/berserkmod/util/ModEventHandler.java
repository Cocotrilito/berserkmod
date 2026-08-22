package com.cocot.berserkmod.util;

import com.cocot.berserkmod.BerserkMod;
import com.cocot.berserkmod.items.ProtectionTalismanItem;
import net.minecraft.client.audio.Sound;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;

import java.util.Random;


public class ModEventHandler {
    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event) {
        if (event.getEntity() instanceof WitherSkeletonEntity) {
            System.out.println("EVENTO MUERTE");
            if (RANDOM.nextFloat() < 0.15F) {
                ItemStack fang = new ItemStack(RegistryHandler.BEAST_FANG.get());
                event.getDrops().add(new ItemEntity(event.getEntity().world,
                        event.getEntity().getPosX(),
                        event.getEntity().getPosY(),
                        event.getEntity().getPosZ(),
                        fang));
            }
        }
    }

    @SubscribeEvent
    public void onPlayerDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            if (player.inventory.hasItemStack(new ItemStack(RegistryHandler.CRIMSON_BEHELIT.get()))) {
                event.setCanceled(true);
                eclipseOverlayTicks = 1200;
                player.world.playSound(null, player.getPosition(), SoundEvents.ENTITY_WITHER_DEATH, SoundCategory.PLAYERS, 1.0F, 1.0F);
                player.setHealth(10.0F);
                player.sendMessage(new StringTextComponent(TextFormatting.DARK_RED + "A dream paid in blood"));
                player.addPotionEffect(new EffectInstance(RegistryHandler.SACRIFICE_BRAND.get(), 999999));
                ItemStack behelitStack = player.inventory.decrStackSize(player.inventory.getSlotFor(new ItemStack(RegistryHandler.CRIMSON_BEHELIT.get())), 1);

                for (int i = 0; i < 25; i++) {
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
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (player.isPotionActive(RegistryHandler.SACRIFICE_BRAND.get())) {
            if (RANDOM.nextFloat() < 0.001F && !player.world.isDaytime()) {
                for (int i = 0; i < 7; i++) {
                    if (i % 4 == 0) {
                        ZombieEntity zombie = new ZombieEntity(EntityType.ZOMBIE, player.world);
                        zombie.setPosition(player.getPosX() + i, player.getPosY(), player.getPosZ());
                        player.world.addEntity(zombie);
                    } else if (i % 4 == 1) {
                        SkeletonEntity skeleton = new SkeletonEntity(EntityType.SKELETON, player.world);
                        skeleton.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.BOW));
                        skeleton.setPosition(player.getPosX() + i, player.getPosY(), player.getPosZ());
                        player.world.addEntity(skeleton);
                    } else if (i % 4 == 2){
                        SpiderEntity spider = new SpiderEntity(EntityType.SPIDER, player.world);
                        spider.setPosition(player.getPosX() + i, player.getPosY(), player.getPosZ());
                        player.world.addEntity(spider);
                    } else {
                        VindicatorEntity vindicator = new VindicatorEntity(EntityType.VINDICATOR, player.world);
                        vindicator.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.IRON_AXE));
                        vindicator.setPosition(player.getPosX() + i, player.getPosY(), player.getPosZ());
                        player.world.addEntity(vindicator);
                    }
                }
            }
        }
        if (player.inventory.count(RegistryHandler.CRIMSON_BEHELIT.get()) > 1) {
            player.inventory.decrStackSize(player.inventory.getSlotFor(new ItemStack(RegistryHandler.CRIMSON_BEHELIT.get())), 1);
        }
    }
    @SubscribeEvent
    public void onPlayerSleep (PlayerSleepInBedEvent event) {
        PlayerEntity player = event.getPlayer();
        if (player.isPotionActive(RegistryHandler.SACRIFICE_BRAND.get())) {
            event.setCanceled(true);
        }
    }
    @SubscribeEvent
    public void onItemUseFinish (LivingEntityUseItemEvent.Finish event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            ItemStack item = event.getItem();
            if (item.getItem().equals(RegistryHandler.PROTECTION_TALISMAN.get())) {
                player.removeActivePotionEffect(RegistryHandler.SACRIFICE_BRAND.get());
                player.world.playSound(null, player.getPosition(), SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.PLAYERS, 1.0f, 1.0F);

            }

        }
    }
    @SubscribeEvent
    public void onRenderOverlay(RenderGameOverlayEvent.Post event) {
        if (eclipseOverlayTicks > 0) {
            int alpha = Math.min(180, eclipseOverlayTicks);
            int color = (alpha << 24) | 0x8B0000;
            AbstractGui.fill(0, 0, event.getWindow().getScaledWidth(), event.getWindow().getScaledHeight(),color);
            eclipseOverlayTicks--;
        }
    }
    private static final Random RANDOM = new Random();
    private static int eclipseOverlayTicks = 0;
}
