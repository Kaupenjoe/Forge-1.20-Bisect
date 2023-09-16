package net.kaupenjoe.tutorialmod.block.entity;

import net.kaupenjoe.tutorialmod.item.ModItems;
import net.kaupenjoe.tutorialmod.recipe.KaupenFurnaceRecipe;
import net.kaupenjoe.tutorialmod.recipe.ModRecipes;
import net.kaupenjoe.tutorialmod.screen.KaupenFurnaceMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

public class KaupenFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    private Map<Item, Integer> BURN_DURATION_MAP =
            Map.of(ModItems.PEAT_BRICKS.get(), 100,
                    Items.BLAZE_POWDER, 600);

    public KaupenFurnaceBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.KAUPEN_FURNACE_BLOCK_ENTITY.get(), pPos, pBlockState, KaupenFurnaceRecipe.Type.INSTANCE);
    }

    @Override
    protected Component getDefaultName() {
        return Component.literal("Kaupen Furnace");
    }

    @Override
    protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
        return new KaupenFurnaceMenu(pContainerId, pInventory, this, this.dataAccess);
    }

    @Override
    protected int getBurnDuration(ItemStack pFuel) {
        return BURN_DURATION_MAP.getOrDefault(pFuel.getItem(), 0);
    }
}
