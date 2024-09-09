package com.piggyplugins;

import com.example.EthanApiPlugin.EthanApiPlugin;
import com.example.PacketUtils.PacketUtilsPlugin;
import com.example.PrayerFlicker.EthanPrayerFlickerPlugin;
import com.piggyplugins.ItemCombiner.ItemCombinerPlugin;
import com.piggyplugins.LeftClickBlackJack.LeftClickBlackJackPlugin;
import com.piggyplugins.PiggyUtils.PiggyUtilsPlugin;
import com.polyplugins.AutoBoner.AutoBonerPlugin;
import com.wigglydonplugins.AutoVardorvis.AutoVardorvisPlugin;
import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;
import net.runelite.client.plugins.ChinBreakHandler.ChinBreakHandlerPlugin;
import net.runelite.client.plugins.betterprofiles.BetterProfilesPlugin;

public class PluginTester {
    public static void main(String[] args) {
        try {
            ExternalPluginManager.loadBuiltin(EthanApiPlugin.class, PacketUtilsPlugin.class,
                    PiggyUtilsPlugin.class, // Don't remove these
                    AutoBonerPlugin.class, EthanPrayerFlickerPlugin.class, LeftClickBlackJackPlugin.class, ItemCombinerPlugin.class,
                    AutoVardorvisPlugin.class
            );
            RuneLite.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}