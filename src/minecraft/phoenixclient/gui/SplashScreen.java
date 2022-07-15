package phoenixclient.gui;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiImage;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.ResourceLocation;

public class SplashScreen {

	private static final int max = 7;
	private static int progress = 0;
	private static String current = "";
	private static ResourceLocation splash;
	private static UnicodeFontRenderer ufr;
	
	public static void update() {
		if (Minecraft.getMinecraft() == null || Minecraft.getMinecraft().getLanguageManager() == null) {
			return;
		}
		
		drawSplash(Minecraft.getMinecraft().getTextureManager());
	}
	
	public static void setProgress(int givenProgress, String givenText) {
		
		progress = givenProgress;
		current = givenText;
		update();
	}
	
	public static void drawSplash(TextureManager tm) {
		
		ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
		int scaleFactor = scaledResolution.getScaleFactor();
		
		Framebuffer frameBuffer = new Framebuffer(scaledResolution.getScaledWidth() * scaleFactor, scaledResolution.getScaledHeight() * scaleFactor, true);
	
		frameBuffer.bindFramebuffer(false);
		
		GlStateManager.matrixMode(GL11.GL_PROJECTION);
		GlStateManager.loadIdentity();
		GlStateManager.ortho(0.0F, (double) scaledResolution.getScaledWidth(), (double) scaledResolution.getScaledHeight(), 0.0D, 1000.0D, 3000.0D);
		GlStateManager.matrixMode(GL11.GL_MODELVIEW);
		
		GlStateManager.loadIdentity();
		GlStateManager.translate(0.0F, 0.0F, -2000.0F);
		GlStateManager.disableLighting();
		GlStateManager.disableFog();
		GlStateManager.disableDepth();
		GlStateManager.enableTexture2D();
		
		if (splash == null) {
			splash = new ResourceLocation("client/background.png");
		}
		tm.bindTexture(splash);
		GlStateManager.resetColor();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		
		Gui.drawScaledCustomSizeModalRect(0, 0, 0, 0, 1920, 1080, scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight(), 1920, 1080);
		
		GuiImage.DrawImage(scaledResolution.getScaledWidth() / 2 - 65, scaledResolution.getScaledHeight() / 2 - 90, 120, 120, "client/ui/logo.png");
		
		drawProgress();
		frameBuffer.unbindFramebuffer();
		frameBuffer.framebufferRender(scaledResolution.getScaledWidth() * scaleFactor, scaledResolution.getScaledHeight() * scaleFactor);
		
		GlStateManager.enableAlpha();
		GlStateManager.alphaFunc(516, 0.1F);
		
		Minecraft.getMinecraft().updateDisplay();
	}
	
	private static void drawProgress() {
		
		if (Minecraft.getMinecraft().gameSettings == null || Minecraft.getMinecraft().getTextureManager() == null) {
			return;
		}
		
		if (ufr == null) {
			UnicodeFontRenderer.getFontOnPC("Arial", 20);
		}
		UnicodeFontRenderer.getFontOnPC("Arial", 20);
		ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
		double nProgress = (double) progress;
		double calc = (nProgress / max) * (sr.getScaledWidth() / 2) + (sr.getScaledWidth() / 2 / 2);
		
		GlStateManager.resetColor();
		resetTextureState();
		
		ufr.drawString(current, sr.getScaledWidth() / 2 - (ufr.getStringWidth(current) / 2), sr.getScaledHeight() / 2 + 90, 0xFFFFFFFF);
		String step = progress + "/" + max;
		
		GlStateManager.resetColor();
		resetTextureState();
		
		// Background Bar
		Gui.drawRect((sr.getScaledWidth() / 2) - (sr.getScaledWidth() / 2 / 2), sr.getScaledHeight() / 2 + 30, (sr.getScaledWidth() / 2) + (sr.getScaledWidth() / 2 / 2), sr.getScaledHeight() / 2 + 22, new Color(34, 35, 39, 255).getRGB());
		// Progress Bar
		Gui.drawRect((sr.getScaledWidth() / 2) - (sr.getScaledWidth() / 2 / 2), sr.getScaledHeight() / 2 + 30, (int) calc, sr.getScaledHeight() / 2 + 22, new Color(0, 170, 0, 255).getRGB());
	}
	
	private static void resetTextureState() {
		 
		GlStateManager.textureState[GlStateManager.activeTextureUnit].textureName = -1;
		
	}
}
