package phoenixclient.ui.clickgui.comp;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import phoenixclient.hud.mod.HudMod;
import phoenixclient.util.font.FontUtil;
import phoenixclient.util.font.MinecraftFontRenderer;

public class ModButton extends GuiButton{
	HudMod m;

	public ModButton(int buttonId, int x, int y, HudMod m, String buttonText) {
		super(buttonId, x, y, buttonText);
		this.m = m;
	}
	

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		MinecraftFontRenderer fontrenderer = FontUtil.normal;
        mc.getTextureManager().bindTexture(buttonTextures);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
        int i = this.getHoverState(this.hovered);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.blendFunc(770, 771);
		Gui.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, -1);
		this.mouseDragged(mc, mouseX, mouseY);
        int j = 14737632;

        if (!this.enabled)
        {
            j = 10526880;
        }
        else if (this.hovered)
        {
            j = 16777120;
        }

        fontrenderer.drawCenteredString(this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, getColor());
	}
	
	
	int getColor() {
		if (m.isEnabled()) {
			return new Color(0,255,0,255).getRGB();
		} else {
			return new Color(255,0,0,255).getRGB();
		}
	}


	
	

}
