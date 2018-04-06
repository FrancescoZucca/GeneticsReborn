package com.theundertaker11.geneticsreborn.keybinds;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.input.Keyboard;


public class KeybindHandler {

    public static KeyBinding keybindDragonsBreath;
    public static KeyBinding keybindTeleport;
    
    public static void init() {
    	keybindDragonsBreath = new KeyBinding("Dragons Breath", Keyboard.KEY_H, "Genetics Reborn");
        ClientRegistry.registerKeyBinding(keybindDragonsBreath);
        keybindTeleport = new KeyBinding("Teleport", Keyboard.KEY_G, "Genetics Reborn");
        ClientRegistry.registerKeyBinding(keybindTeleport);
    }

}
