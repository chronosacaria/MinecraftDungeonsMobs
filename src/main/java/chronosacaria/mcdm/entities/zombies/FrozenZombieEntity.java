package chronosacaria.mcdm.entities.zombies;

import chronosacaria.mcdm.entities.MCDMBaseZombieEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;

public class FrozenZombieEntity extends MCDMBaseZombieEntity implements RangedAttackMob {


    public FrozenZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    public FrozenZombieEntity(World world) {
        super(world);
    }

    protected void initCustomGoals(){
        this.goalSelector.add(2, new ProjectileAttackGoal(this, 1.0D, 20, 15.0F));
        this.goalSelector.add(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::canBreakDoors));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D));
        this.targetSelector.add(1, (new RevengeGoal(this)).setGroupRevenge(ZombifiedPiglinEntity.class));
        this.targetSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new FollowTargetGoal<>(this, MerchantEntity.class, false));
        this.targetSelector.add(3, new FollowTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.add(5, new FollowTargetGoal<>(this, TurtleEntity.class, 10, true, false, TurtleEntity.BABY_TURTLE_ON_LAND_FILTER));
    }

    @Override
    public void attack(LivingEntity target, float pullProgress) {
        SnowballEntity snowballEntity = new SnowballEntity(this.world, this);
        double adjustedEyeY = target.getEyeY() - 1.1D;
        double xDiff = target.getX() - this.getX();
        double yDiff = adjustedEyeY - snowballEntity.getY();
        double zDiff = target.getZ() - this.getZ();
        float f = MathHelper.sqrt(xDiff * xDiff + zDiff * zDiff) * 0.2F;
        snowballEntity.setVelocity(xDiff, yDiff + (double) f, zDiff, 1.6F, 12.0F);
        this.playSound(SoundEvents.ENTITY_SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.world.spawnEntity(snowballEntity);

    }
}
