package com.piggyplugins;

import com.example.EthanApiPlugin.EthanApiPlugin;
import com.example.PacketUtils.PacketUtilsPlugin;
import com.example.PrayerFlicker.EthanPrayerFlickerPlugin;
import com.piggyplugins.ItemCombiner.ItemCombinerPlugin;
import com.piggyplugins.LeftClickBlackJack.LeftClickBlackJackPlugin;
import com.piggyplugins.PiggyUtils.PiggyUtilsPlugin;
import com.piggyplugins.RooftopAgility.RooftopAgilityPlugin;
import com.piggyplugins.SixHourLog.SixHourLogPlugin;
import com.polyplugins.AutoBoner.AutoBonerPlugin;
import com.wigglydonplugins.AutoCrafting.AutoCraftingPlugin;
import com.wigglydonplugins.AutoHerblore.AutoHerblorePlugin;
import com.wigglydonplugins.AutoVardorvis.AutoVardorvisPlugin;
import com.wigglydonplugins.autoVorkath.AutoVorkathPlugin;
import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;
import net.runelite.client.plugins.ChinBreakHandler.ChinBreakHandlerPlugin;
import net.runelite.client.plugins.betterprofiles.BetterProfilesPlugin;

public class PluginTester {
    public static void main(String[] args) {
        try {
            ExternalPluginManager.loadBuiltin(EthanApiPlugin.class, PacketUtilsPlugin.class,
                    PiggyUtilsPlugin.class, // Don't remove these
                    EthanPrayerFlickerPlugin.class,
                    AutoVardorvisPlugin.class,
                    AutoVorkathPlugin.class,
                    AutoCraftingPlugin.class,
                    AutoHerblorePlugin.class,
                    RooftopAgilityPlugin.class,
                    SixHourLogPlugin.class
            );
            RuneLite.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}