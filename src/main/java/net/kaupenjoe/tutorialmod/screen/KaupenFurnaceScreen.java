package net.kaupenjoe.tutorialmod.screen;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.screens.recipebook.AbstractFurnaceRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class KaupenFurnaceScreen extends AbstractFurnaceScreen<KaupenFurnaceMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(TutorialMod.MOD_ID, "textures/gui/kaupen_furnace.png");

    public KaupenFurnaceScreen(KaupenFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        this(pMenu, new KaupenFurnaceRecipeBookComponent(), pPlayerInventory, pTitle, TEXTURE);
    }

    private KaupenFurnaceScreen(KaupenFurnaceMenu pMenu, AbstractFurnaceRecipeBookComponent pRecipeBookComponent,
                               Inventory pPlayerInventory, Component pTitle, ResourceLocation pTexture) {
        super(pMenu, pRecipeBookComponent, pPlayerInventory, pTitle, pTexture);
    }
}
