package fr.chicodouille.seridium.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;

import java.util.Random;
import java.util.Map;

import fr.chicodouille.seridium.SeridiumodMod;

public class VigneBlockIsPlacedByProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SeridiumodMod.LOGGER.warn("Failed to load dependency world for procedure VigneBlockIsPlacedBy!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SeridiumodMod.LOGGER.warn("Failed to load dependency x for procedure VigneBlockIsPlacedBy!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SeridiumodMod.LOGGER.warn("Failed to load dependency y for procedure VigneBlockIsPlacedBy!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SeridiumodMod.LOGGER.warn("Failed to load dependency z for procedure VigneBlockIsPlacedBy!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		world.getPendingBlockTicks().scheduleTick(new BlockPos(x, y, z), world.getBlockState(new BlockPos(x, y, z)).getBlock(),
				(int) (MathHelper.nextDouble(new Random(), 100, 1000)));
	}
}
