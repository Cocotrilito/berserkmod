package com.cocot.berserkmod.util;

import com.cocot.berserkmod.BerserkMod;
import com.cocot.berserkmod.items.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, BerserkMod.MOD_ID);

    public  static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    public static final RegistryObject<Item> DRAGONSLAYER = ITEMS.register("dragonslayer", DragonSlayerItem::new);
    public static final RegistryObject<Item> NORMAL_BEHELIT = ITEMS.register("normal_behelit", NormalBehelitItem::new);
    public static final RegistryObject<Item> CRIMSON_BEHELIT = ITEMS.register("crimson_behelit", CrimsonBehelitItem::new);
    public static final RegistryObject<Item> BERSERKER_HELMET = ITEMS.register("berserker_helmet", () -> new BerserkerArmorItem(EquipmentSlotType.HEAD));
    public static final RegistryObject<Item> BERSERKER_CHESTPLATE = ITEMS.register("berserker_chestplate", () -> new BerserkerArmorItem(EquipmentSlotType.CHEST));
    public static final RegistryObject<Item> BERSERKER_LEGGINGS = ITEMS.register("berserker_leggings", () -> new BerserkerArmorItem(EquipmentSlotType.LEGS));
    public static final RegistryObject<Item> BERSERKER_BOOTS = ITEMS.register("berserker_boots", () -> new BerserkerArmorItem(EquipmentSlotType.FEET));
    public static final RegistryObject<Item> BEAST_FANG = ITEMS.register("beast_fang", BeastFangItem::new);
}


