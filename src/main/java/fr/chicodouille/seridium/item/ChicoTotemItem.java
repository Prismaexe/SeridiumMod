
package fr.chicodouille.seridium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import fr.chicodouille.seridium.itemgroup.SeridiumItemGroup;
import fr.chicodouille.seridium.SeridiumodModElements;

@SeridiumodModElements.ModElement.Tag
public class ChicoTotemItem extends SeridiumodModElements.ModElement {
	@ObjectHolder("seridiumod:chico_totem")
	public static final Item block = null;

	public ChicoTotemItem(SeridiumodModElements instance) {
		super(instance, 71);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SeridiumItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("chico_totem");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
