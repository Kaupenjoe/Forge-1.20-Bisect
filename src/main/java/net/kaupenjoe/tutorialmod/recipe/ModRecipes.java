package net.kaupenjoe.tutorialmod.recipe;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, TutorialMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<FiveByFiveCraftingRecipe>> FIVE_BY_FIVE_CRAFTING =
            SERIALIZERS.register("five_by_five_crafting", FiveByFiveCraftingRecipe.Serializer::new);

    public static final RegistryObject<RecipeSerializer<KaupenFurnaceRecipe>> KAUPEN_FURNACE_RECIPE =
            SERIALIZERS.register("kaupen_furnace", () -> KaupenFurnaceRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
