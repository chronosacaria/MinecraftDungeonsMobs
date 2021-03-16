package chronosacaria.mcdm.client.renderer.entities.zombies;

import chronosacaria.mcdm.client.renderer.entities.models.FrozenZombieModel;
import chronosacaria.mcdm.entities.zombies.FrozenZombieEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieBaseEntityRenderer;

@Environment(EnvType.CLIENT)
public class FrozenZombieRenderer extends ZombieBaseEntityRenderer<FrozenZombieEntity, FrozenZombieModel<FrozenZombieEntity>> {
    protected FrozenZombieRenderer(EntityRendererFactory.Context ctx, FrozenZombieModel<FrozenZombieEntity> bodyModel, FrozenZombieModel<FrozenZombieEntity> legsArmorModel, FrozenZombieModel<FrozenZombieEntity> bodyArmorModel) {
        super(ctx, EntityModeLay, legsArmorModel, bodyArmorModel);
    }
}
