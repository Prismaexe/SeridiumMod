// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports

public static class Modelcustom_model extends EntityModel<Entity> {
	private final ModelRenderer base;
	private final ModelRenderer eyes;
	private final ModelRenderer cube_r1;

	public Modelcustom_model() {
		texWidth = 32;
		texHeight = 32;

		base = new ModelRenderer(this);
		base.setPos(0.0F, 23.9833F, 0.0F);
		base.texOffs(0, 8).addBox(-1.0F, -4.9833F, -2.0F, 2.0F, 4.0F, 4.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(-1.0F, -1.9833F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		base.texOffs(0, 0).addBox(-1.5F, -0.9833F, -3.0F, 3.0F, 1.0F, 7.0F, 0.0F, false);

		eyes = new ModelRenderer(this);
		eyes.setPos(0.0F, -0.9497F, -2.4706F);
		base.addChild(eyes);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(-1.0F, -1.65F, -0.7F);
		eyes.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.3927F, 0.0F, 0.0F);
		cube_r1.texOffs(0, 4).addBox(-0.25F, -0.25F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		cube_r1.texOffs(0, 2).addBox(-0.25F, -1.25F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.texOffs(2, 5).addBox(1.25F, -0.25F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		cube_r1.texOffs(3, 3).addBox(1.25F, -1.25F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}