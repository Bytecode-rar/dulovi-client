package net.dulovi;

import net.fabricmc.api.ClientModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DuloviClient implements ClientModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("Dulovi");
    public static final String NAME = "Dulovi Client";

    @Override
    public void onInitializeClient() {
        LOGGER.info("Dulovi Client for Minecraft 1.21.1 is initializing...");
    }
}
