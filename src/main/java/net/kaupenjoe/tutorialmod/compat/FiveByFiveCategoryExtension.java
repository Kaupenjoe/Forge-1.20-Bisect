package net.kaupenjoe.tutorialmod.compat;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.ICraftingGridHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.category.extensions.vanilla.crafting.ICraftingCategoryExtension;
import net.kaupenjoe.tutorialmod.recipe.FiveByFiveCraftingRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FiveByFiveCategoryExtension implements ICraftingCategoryExtension {
    FiveByFiveCraftingRecipe recipe;
    public FiveByFiveCategoryExtension(FiveByFiveCraftingRecipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ICraftingGridHelper craftingGridHelper, IFocusGroup focuses) {
        craftingGridHelper = new FiveByFiveCraftingGridHelper();

        List<List<ItemStack>> inputs = recipe.getIngredients().stream()
                .map(ingredient -> List.of(ingredient.getItems()))
                .toList();
        ItemStack resultItem = recipe.getResultItem(null);

        int width = getWidth();
        int height = getHeight();
        craftingGridHelper.createAndSetOutputs(builder, List.of(resultItem));
        craftingGridHelper.createAndSetInputs(builder, inputs, width, height);
    }

    @Nullable
    @Override
    public ResourceLocation getRegistryName() {
        return recipe.getId();
    }

    @Override
    public int getWidth() {
        return 5;
    }

    @Override
    public int getHeight() {
        return 5;
    }
}
