package com.cocot.berserkmod.util;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;


import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {
    BERSERKER("berserkmod:berserker", 40, new int[]{3, 6, 8, 3}, 10,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F,
            () -> Ingredient.fromItems(Items.NETHER_STAR));
    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};

    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantabilty;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;

    ModArmorMaterial(String name,int maxDamageFactor, int[] damageReductionAmountArray,
                     int enchantabilty, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial){
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantabilty = enchantabilty;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
    }


    @Override
    public int getDurability(EquipmentSlotType equipmentSlotType) {
        return MAX_DAMAGE_ARRAY[equipmentSlotType.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType equipmentSlotType) {
        return this.damageReductionAmountArray[equipmentSlotType.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantabilty;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }
}
