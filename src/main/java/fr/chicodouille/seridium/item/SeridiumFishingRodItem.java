
package fr.chicodouille.seridium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.FishingRodItem;

import fr.chicodouille.seridium.itemgroup.SeridiumItemGroup;
import fr.chicodouille.seridium.SeridiumodModElements;

@SeridiumodModElements.ModElement.Tag
public class SeridiumFishingRodItem extends SeridiumodModElements.ModElement {
	@ObjectHolder("seridiumod:seridium_fishing_rod")
	public static final Item block = null;

	public SeridiumFishingRodItem(SeridiumodModElements instance) {
		super(instance, 103);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemToolCustom() {
		}.setRegistryName("seridium_fishing_rod"));
	}

	private static class ItemToolCustom extends FishingRodItem {
		protected ItemToolCustom() {
			super(new Item.Properties().group(SeridiumItemGroup.tab).maxDamage(1500));
		}

		@Override
		public int getItemEnchantability() {
			return 24;
		}

		@Override
		public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
			Item repairItem = repair.getItem();
			return repairItem == SeridiumIngotItem.block

			;
		}
	}
}
