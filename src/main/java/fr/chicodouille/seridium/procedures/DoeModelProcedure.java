package fr.chicodouille.seridium.procedures;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.util.ResourceLocation;

import fr.chicodouille.seridium.entity.DoeEntity;

//modified for 1.16.5, use at your own risk
public class DoeModelProcedure extends AnimatedGeoModel<DoeEntity.CustomEntity> {
	@Override
	public ResourceLocation getAnimationFileLocation(DoeEntity.CustomEntity entity) {
		return new ResourceLocation("seridiumod", "animations/doe.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(DoeEntity.CustomEntity entity) {
		return new ResourceLocation("seridiumod", "geo/doe.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(DoeEntity.CustomEntity entity) {
		return new ResourceLocation("seridiumod", "textures/entities/doe.png");
	}
	/**
	@Override
	public void setCustomAnimations(DoeEntity.CustomEntity animatable, int instanceId, AnimationEvent animationEvent) {
	super.setCustomAnimations(animatable, instanceId, animationEvent);
	IBone head = this.getAnimationProcessor().getBone("head");
	EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
	AnimationData manager = animatable.getFactory().getOrCreateAnimationData(instanceId);
	head.setRotationX(head.getRotationX() + extraData.headPitch * ((float) Math.PI / 180F));
	head.setRotationY(head.getRotationY() + extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
	 /** **/
}
