package de.vepexlegit.norealms;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = NoRealms.MODID, name = NoRealms.NAME, version = NoRealms.VERSION)
public class NoRealms {
    public static final String MODID = "norealms";
    public static final String NAME = "NoRealms";
    public static final String VERSION = "1.0";

    public NoRealms() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    @SubscribeEvent
    public void onGuiMainMenuInit(GuiScreenEvent.InitGuiEvent.Post event) {
        if (event.getGui() instanceof GuiMainMenu) {
            for (GuiButton button : event.getButtonList()) {
                if (button.id == 14) {
                    event.getButtonList().remove(button);
                    break;
                }
            }
        }
        if (event.getGui() instanceof GuiMainMenu) {
            GuiButton modsButton = null;
            for (GuiButton button : event.getButtonList()) {
                if (button.id == 6) {
                    modsButton = button;
                    break;
                }
            }
            if (modsButton != null) {
                event.getButtonList().remove(modsButton);

                int x = modsButton.width / 2 + 242;
                int y = modsButton.height + 170;

                modsButton.x = x;
                modsButton.y = y;

                event.getButtonList().add(modsButton);
            }
        }
    }
}
