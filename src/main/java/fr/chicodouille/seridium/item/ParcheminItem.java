
package fr.chicodouille.seridium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import fr.chicodouille.seridium.itemgroup.SeridiumItemGroup;
import fr.chicodouille.seridium.SeridiumodModElements;

@SeridiumodModElements.ModElement.Tag
public class ParcheminItem extends SeridiumodModElements.ModElement {
	@ObjectHolder("seridiumod:parchemin")
	public static final Item block = null;

	public ParcheminItem(SeridiumodModElements instance) {
		super(instance, 95);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SeridiumItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("parchemin");
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
