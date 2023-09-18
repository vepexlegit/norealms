package de.vepexlegit.norealms;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = NoRealms.MODID, version = NoRealms.VERSION)
public class NoRealms {
    public static final String MODID = "norealms";
    public static final String VERSION = "1.0";

    public NoRealms() {
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("DIRT BLOCK >> " + Blocks.dirt.getUnlocalizedName());
    }

    @SubscribeEvent
    public void onGuiMainMenuInit(GuiScreenEvent.InitGuiEvent.Post event) {
        if (event.gui instanceof GuiMainMenu) {
            for (GuiButton button : event.buttonList) {
                if (button.id == 14) {
                    event.buttonList.remove(button);
                    break;
                }
            }
        }
        if (event.gui instanceof GuiMainMenu) {
            GuiButton modsButton = null;
            for (GuiButton button : event.buttonList) {
                if (button.id == 6) {
                    modsButton = button;
                    break;
                }
            }
            if (modsButton != null) {
                event.buttonList.remove(modsButton);

                int x = modsButton.width / 2 + 242;
                int y = modsButton.height + 170;

                modsButton.xPosition = x;
                modsButton.yPosition = y;

                event.buttonList.add(modsButton);
            }
        }
    }
}
