package chronosacaria.mcdm.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import chronosacaria.mcdm.entities.zombies.*;

public class EntityTypesInit {
    public static final String FROZEN_ZOMBIE_REGISTRY_NAME = "frozen_zombie";

    public static EntityType<FrozenZombieEntity> FROZEN_ZOMBIE_REGISTRY_OBJECT;

    public static void init(){
        FROZEN_ZOMBIE_REGISTRY_NAME = RegisterHelper.registerEntity(FROZEN_ZOMBIE_REGISTRY_OBJECT,
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FrozenZombieEntity::new)
                        .dimensions(EntityDimensions.fixed(EntityType.ZOMBIE.getWidth(), EntityType.ZOMBIE.getHeight()))
                        .trackRangeBlocks(64)
                        .trackedUpdateRate(3)
                        .build());
    }
}
