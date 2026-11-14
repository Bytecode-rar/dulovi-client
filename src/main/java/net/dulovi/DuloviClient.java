package net.dulovi;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

public class DuloviClient implements ClientModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("Dulovi");
    
    // Создаем переменную для бинда клавиши (по умолчанию GLFW.GLFW_KEY_RIGHT_SHIFT или GLFW.GLFW_KEY_INSERT)
    private static KeyBinding openGuiKey;

    @Override
    public void onInitializeClient() {
        LOGGER.info("Dulovi Client initializing keybinds...");

        // Регистрируем клавишу (сейчас стоит INSERT, можешь поменять на GLFW.GLFW_KEY_RIGHT_SHIFT)
        openGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.dulovi.open_gui", // Перевод / ID
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,  // <--- ЗДЕСЬ МЕНЯЕТСЯ КЛАВИША (например, GLFW.GLFW_KEY_RIGHT_SHIFT)
                "category.dulovi.general"
        ));

        // Слушаем каждый тик игры: если нажали клавишу — открываем меню
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openGuiKey.wasPressed()) {
                LOGGER.info("Open GUI key pressed!");
                // Здесь вызывается открытие твоего интерфейса (ClickGUI)
                // client.setScreen(new ClickGuiScreen());
            }
        });
    }
}
