package net.kaupenjoe.tutorialmod.screen;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class FiveByFiveCraftingScreen extends AbstractContainerScreen<FiveByFiveCraftingMenu> {
    private static final ResourceLocation CRAFTING_TABLE_LOCATION = new ResourceLocation(TutorialMod.MOD_ID,
            "textures/gui/five_by_five_crafting_table.png");

    public FiveByFiveCraftingScreen(FiveByFiveCraftingMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        this.titleLabelY = 1000;
        this.inventoryLabelY = 1000;
        this.imageHeight = 192;
        super.init();
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pGuiGraphics);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        int i = this.leftPos;
        int j = (this.height - this.imageHeight) / 2;
        pGuiGraphics.blit(CRAFTING_TABLE_LOCATION, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }
}
