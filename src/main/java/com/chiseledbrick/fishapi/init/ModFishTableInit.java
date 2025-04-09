package com.chiseledbrick.fishapi.init;

import com.chiseledbrick.fishapi.ChiseledFishAPI;
import com.chiseledbrick.fishapi.FishTable;
import com.chiseledbrick.fishapi.api.FishTableProvider;
import com.chiseledbrick.fishapi.api.FishTableRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Items;


public class ModFishTableInit implements FishTableProvider {
    @Override
    public void addFishTables() {
        FishTable cod = new FishTable(Items.COD).setResultEntities(EntityType.COD);
        FishTable salmon = new FishTable(Items.SALMON).setResultEntities(EntityType.SALMON);
        FishTable pufferfish = new FishTable(Items.PUFFERFISH).setResultEntities(EntityType.PUFFERFISH);
        FishTable tropical_fish = new FishTable(Items.TROPICAL_FISH).setResultEntities(EntityType.TROPICAL_FISH);
        FishTable skeleton = new FishTable(Items.BONE)
                .setResultEntities(EntityType.SKELETON)
                .addEntityAttribute(
                        EntityType.SKELETON,
                        EntityAttributes.SCALE,
                        new EntityAttributeModifier(ChiseledFishAPI.id("random_spawn_bonus_scale"), -0.9, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                );
        FishTable fishes = new FishTable(Items.STICK)
                .setResultEntities(EntityType.COD,EntityType.SLIME)
                .addEntityAttribute(
                        EntityAttributes.GRAVITY,
                        -0.2,
                        EntityAttributeModifier.Operation.ADD_VALUE
                );

        FishTableRegistry.registerTable(cod);
        FishTableRegistry.registerTable(salmon);
        FishTableRegistry.registerTable(pufferfish);
        FishTableRegistry.registerTable(tropical_fish);
        FishTableRegistry.registerTable(skeleton);
        FishTableRegistry.registerTable(fishes);
    }
}
