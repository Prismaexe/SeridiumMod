
package fr.chicodouille.seridium.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import fr.chicodouille.seridium.itemgroup.SeridiumItemGroup;
import fr.chicodouille.seridium.SeridiumodModElements;

@SeridiumodModElements.ModElement.Tag
public class SeridiumToolsShovelItem extends SeridiumodModElements.ModElement {
	@ObjectHolder("seridiumod:seridium_tools_shovel")
	public static final Item block = null;

	public SeridiumToolsShovelItem(SeridiumodModElements instance) {
		super(instance, 21);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 5000;
			}

			public float getEfficiency() {
				return 15f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 7;
			}

			public int getEnchantability() {
				return 25;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SeridiumIngotItem.block));
			}
		}, 1, -2.7999999999999998f, new Item.Properties().group(SeridiumItemGroup.tab)) {
		}.setRegistryName("seridium_tools_shovel"));
	}
}
