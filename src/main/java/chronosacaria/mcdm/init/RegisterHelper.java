package chronosacaria.mcdm.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

import static chronosacaria.mcdm.Mcdm.MOD_ID;

public class RegisterHelper {
    public static Map<EntityModelLayer, TexturedModelData> MCDM_MODEL_LAYERS = new HashMap<>();

    public static <T extends Entity> EntityType<T> registerEntity(String registryName, EntityType<T> entityType) {
        return Registry.register(Registry.ENTITY_TYPE, new Identifier(MOD_ID, registryName), entityType);
    }

    public static void registerEntityAttributes(EntityType<? extends LivingEntity> entityType,
                                                DefaultAttributeContainer.Builder attributes) {
        FabricDefaultAttributeRegistry.register(entityType, attributes);
    }

    public static EntityModelLayer registerEntityModelLayer(String registryName, TexturedModelData modelPart){
        EntityModelLayer entityModelLayer = new EntityModelLayer(new Identifier(MOD_ID, registryName), "main");
        MCDM_MODEL_LAYERS.put(entityModelLayer, modelPart);
        return entityModelLayer;
    }
}
