package com.cocot.berserkmod.util;

import com.cocot.berserkmod.BerserkMod;
import com.cocot.berserkmod.items.CrimsonBehelitItem;
import com.cocot.berserkmod.items.DragonSlayerItem;
import com.cocot.berserkmod.items.NormalBehelitItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, BerserkMod.MOD_ID);

    public  static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    public static final RegistryObject<Item> DRAGONSLAYER = ITEMS.register("dragonslayer", DragonSlayerItem::new);
    public static final RegistryObject<Item> NORMAL_BEHELIT = ITEMS.register("normal_behelit", NormalBehelitItem::new);
    public static final RegistryObject<Item> CRIMSON_BEHELIT = ITEMS.register("crimson_behelit", CrimsonBehelitItem::new);
}


