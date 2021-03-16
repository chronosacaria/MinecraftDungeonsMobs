package chronosacaria.mcdm.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

import java.util.Random;

public class MCDMBaseZombieEntity extends ZombieEntity {
     private int lastBlink = 0;
     private int nextBlinkInterval = new Random().nextInt(760) + 60;
     private int remainingTick = 0;
     private int internalBlinkTick = 0;

     public MCDMBaseZombieEntity(EntityType<? extends ZombieEntity> entityType, World world){
         super(entityType, world);
     }

     public MCDMBaseZombieEntity(World world){
         super(world);
     }

     public static DefaultAttributeContainer.Builder createZombieAttributes(){
         return HostileEntity.createHostileAttributes()
                 .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0D)
                 .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23D)
                 .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0D)
                 .add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS);
     }

     @Override
    public void tickMovement(){
         super.tickMovement();
         if (this.remainingTick > 0){
             --this.remainingTick;
         }
         if (this.internalBlinkTick == (this.lastBlink + this.nextBlinkInterval)){
             this.lastBlink = this.internalBlinkTick;
             this.nextBlinkInterval = new Random().nextInt(740) + 60;
             this.remainingTick = 4;
         }
         ++this.internalBlinkTick;
     }

     public int getBlinkRemainingTicks(){
         return this.remainingTick;
     }
}
