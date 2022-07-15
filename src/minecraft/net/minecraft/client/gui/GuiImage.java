package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class GuiImage {

	public static void DrawImage(int x, int y, int w, int h, String texture) {
		
		ResourceLocation resource = new ResourceLocation(texture);
		Minecraft.getMinecraft().getTextureManager().bindTexture(resource);
		
		Gui.drawModalRectWithCustomSizedTexture(x, y, 0, 0, w, h, w, h);
	}
	
}
