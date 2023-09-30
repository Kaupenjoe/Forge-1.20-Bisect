package net.kaupenjoe.tutorialmod.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IVanillaCategoryExtensionRegistration;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.recipe.FiveByFiveCraftingRecipe;
import net.kaupenjoe.tutorialmod.recipe.KaupenFurnaceRecipe;
import net.kaupenjoe.tutorialmod.screen.FiveByFiveCraftingScreen;
import net.kaupenjoe.tutorialmod.screen.KaupenFurnaceScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEITutorialModPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(TutorialMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new KaupenFurnaceRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));

        // registration.addRecipeCategories(new FiveByFiveRecipeCategory(
        //         registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<KaupenFurnaceRecipe> kaupenFurnaceRecipe = recipeManager.getAllRecipesFor(KaupenFurnaceRecipe.Type.INSTANCE);
        registration.addRecipes(KaupenFurnaceRecipeCategory.KAUPEN_FURNACE_TYPE, kaupenFurnaceRecipe);

        // List<FiveByFiveCraftingRecipe> fiveByFiveRecipe = recipeManager.getAllRecipesFor(FiveByFiveCraftingRecipe.Type.INSTANCE);
        // registration.addRecipes(FiveByFiveRecipeCategory.FIVE_BY_FIVE, fiveByFiveRecipe);

    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(KaupenFurnaceScreen.class, 60, 30, 20, 30,
                KaupenFurnaceRecipeCategory.KAUPEN_FURNACE_TYPE);

        // registration.addRecipeClickArea(FiveByFiveCraftingScreen.class, 90, 50, 20, 30,
        //         FiveByFiveRecipeCategory.FIVE_BY_FIVE);
    }
}
