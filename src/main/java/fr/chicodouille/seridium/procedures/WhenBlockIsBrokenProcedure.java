package fr.chicodouille.seridium.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;
import java.util.HashMap;

import fr.chicodouille.seridium.SeridiumodModVariables;
import fr.chicodouille.seridium.SeridiumodMod;

public class WhenBlockIsBrokenProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onBlockBreak(BlockEvent.BreakEvent event) {
			Entity entity = event.getPlayer();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("xpAmount", event.getExpToDrop());
			dependencies.put("x", event.getPos().getX());
			dependencies.put("y", event.getPos().getY());
			dependencies.put("z", event.getPos().getZ());
			dependencies.put("px", entity.getPosX());
			dependencies.put("py", entity.getPosY());
			dependencies.put("pz", entity.getPosZ());
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("blockstate", event.getState());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SeridiumodMod.LOGGER.warn("Failed to load dependency world for procedure WhenBlockIsBroken!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SeridiumodMod.LOGGER.warn("Failed to load dependency x for procedure WhenBlockIsBroken!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SeridiumodMod.LOGGER.warn("Failed to load dependency y for procedure WhenBlockIsBroken!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SeridiumodMod.LOGGER.warn("Failed to load dependency z for procedure WhenBlockIsBroken!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.OAK_LOG
				&& SeridiumodModVariables.MapVariables.get(world).levelwoodcutter >= 0) {
			SeridiumodModVariables.MapVariables.get(world).xpwoodcutter = (SeridiumodModVariables.MapVariables.get(world).xpwoodcutter + 10);
			SeridiumodModVariables.MapVariables.get(world).syncData(world);
		}
		if (SeridiumodModVariables.MapVariables.get(world).xpwoodcutter == 100
				&& SeridiumodModVariables.MapVariables.get(world).levelwoodcutter == 0) {
			SeridiumodModVariables.MapVariables.get(world).levelwoodcutter = (SeridiumodModVariables.MapVariables.get(world).levelwoodcutter + 1);
			SeridiumodModVariables.MapVariables.get(world).syncData(world);
			SeridiumodModVariables.MapVariables.get(world).xpwoodcutter = 0;
			SeridiumodModVariables.MapVariables.get(world).syncData(world);
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.IRON_INGOT));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
		}
		if (SeridiumodModVariables.MapVariables.get(world).xpwoodcutter == 250
				&& SeridiumodModVariables.MapVariables.get(world).levelwoodcutter == 1) {
			SeridiumodModVariables.MapVariables.get(world).levelwoodcutter = (SeridiumodModVariables.MapVariables.get(world).levelwoodcutter + 1);
			SeridiumodModVariables.MapVariables.get(world).syncData(world);
			if (SeridiumodModVariables.MapVariables.get(world).levelwoodcutter == 2) {
				SeridiumodModVariables.MapVariables.get(world).xpwoodcutter = 0;
				SeridiumodModVariables.MapVariables.get(world).syncData(world);
				for (int index0 = 0; index0 < (int) (5); index0++) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.IRON_INGOT));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
			}
		}
	}
}
