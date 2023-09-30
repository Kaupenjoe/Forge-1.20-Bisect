package net.kaupenjoe.tutorialmod.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.recipe.FiveByFiveCraftingRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

// NON FUNCTIONING!
public class FiveByFiveRecipeCategory implements IRecipeCategory<FiveByFiveCraftingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(TutorialMod.MOD_ID, "five_by_five_crafting");
    public static final ResourceLocation TEXTURE = new ResourceLocation(TutorialMod.MOD_ID,
            "textures/gui/five_by_five_crafting_table.png");

    public static final RecipeType<FiveByFiveCraftingRecipe> FIVE_BY_FIVE =
            new RecipeType<>(UID, FiveByFiveCraftingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public FiveByFiveRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.FIVE_BY_FIVE_CRAFTING.get()));
    }


    @Override
    public RecipeType<FiveByFiveCraftingRecipe> getRecipeType() {
        return FIVE_BY_FIVE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Five by Five Crafting");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
        public IDrawable getIcon() {
            return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FiveByFiveCraftingRecipe recipe, IFocusGroup focuses) {
        for(int i = 0; i < 5; ++i) {
            for(int j = 0; j < 5; ++j) {
                builder.addSlot(RecipeIngredientRole.INPUT, 12 + j * 18, 11 + i * 18).addIngredients(recipe.getIngredients().get(j + i * 5));
            }
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, 141, 48).addItemStack(recipe.getResultItem(null));
    }
}
