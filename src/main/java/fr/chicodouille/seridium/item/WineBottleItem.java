
package fr.chicodouille.seridium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import fr.chicodouille.seridium.itemgroup.SeridiumItemGroup;
import fr.chicodouille.seridium.SeridiumodModElements;

@SeridiumodModElements.ModElement.Tag
public class WineBottleItem extends SeridiumodModElements.ModElement {
	@ObjectHolder("seridiumod:wine_bottle")
	public static final Item block = null;

	public WineBottleItem(SeridiumodModElements instance) {
		super(instance, 93);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SeridiumItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("wine_bottle");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 32;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
