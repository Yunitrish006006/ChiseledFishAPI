package net.adaptor.fishing.event;

import net.adaptor.fishing.FishTable;
import net.adaptor.fishing.api.FishTableRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

import java.util.List;

public class FishingEvent {

    public static void onFishHookedUp(Entity entity, ServerWorld world) {
        if (entity.age != 0) return;
        if (entity instanceof ItemEntity item) {
            Vec3d pos = item.getPos();
            Box box = new Box(pos.add(-0.1,-0.1,-0.1),pos.add(0.1,0.1,0.1));
            List<FishingBobberEntity> fishingBobberList = item.getWorld().getEntitiesByClass(FishingBobberEntity.class,box, fishingBobberEntity -> true);
            if (fishingBobberList.isEmpty()) return;
            FishingBobberEntity fishingBobber = fishingBobberList.getFirst();
            if (fishingBobber.getPlayerOwner() == null) return;
            PlayerEntity player = fishingBobber.getPlayerOwner();

            for (FishTable fishTable: FishTableRegistry.getTables()) {
                fishTable.setUp(world,player,fishingBobber).spawnResultEntities(item);
            }

        }
    }

}
