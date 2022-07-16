package phoenixclient.ui.mainmenu;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import phoenixclient.util.font.FontUtil;
import phoenixclient.util.font.MinecraftFontRenderer;

public class MainMenuButton extends GuiButton{

	public MainMenuButton(int buttonId, int x, int y, String buttonText) {
		super(buttonId, x, y, buttonText);
		// TODO Auto-generated constructor stub
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
		Gui.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, new Color(170,170,170,40).getRGB());
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

        fontrenderer.drawCenteredString(this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, j);
	}
	

}
