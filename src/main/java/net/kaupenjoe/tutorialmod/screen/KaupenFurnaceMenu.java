package net.kaupenjoe.tutorialmod.screen;

import net.kaupenjoe.tutorialmod.recipe.KaupenFurnaceRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.ItemStack;

public class KaupenFurnaceMenu extends AbstractFurnaceMenu {
    public KaupenFurnaceMenu(int id, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(id, inventory);
    }

    public KaupenFurnaceMenu(int pContainerId, Inventory pPlayerInventory, Container container, ContainerData data) {
        super(ModMenuTypes.KAUPEN_FURNACE_MENU.get(), KaupenFurnaceRecipe.Type.INSTANCE, RecipeBookType.FURNACE, pContainerId, pPlayerInventory, container, data);
    }

    public KaupenFurnaceMenu(int id, Inventory inventory) {
        super(ModMenuTypes.KAUPEN_FURNACE_MENU.get(), KaupenFurnaceRecipe.Type.INSTANCE, RecipeBookType.FURNACE, id, inventory);
    }

    @Override
    protected boolean isFuel(ItemStack pStack) {
        return true;
    }
}
