package com.cocot.berserkmod.util;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;


public class ModEventHandler {
    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event) {
        if (event.getEntity() instanceof WitherSkeletonEntity) {
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
    private static final Random RANDOM = new Random();
}
