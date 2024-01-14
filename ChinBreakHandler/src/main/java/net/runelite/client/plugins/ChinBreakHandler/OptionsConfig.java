package net.runelite.client.plugins.ChinBreakHandler;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("chinBreakHandler")
public interface OptionsConfig extends Config {
    @ConfigSection(
            name = "Misc",
            description = "",
            position = 0
    )
    String misc = "Misc";

    @ConfigItem(
            keyName = "stopAfterBreaks",
            name = "Stop after x breaks",
            description = "Stop after a given amount of breaks (0 to disable)",
            position = 1,
            section = misc
    )
    default int stopAfterBreaks()
    {
        return 0;
    }

    @ConfigSection(
            name = "Hopping",
            description = "",
            position = 2
    )
    String hoppingTitle = "Hopping";

    @ConfigItem(
            keyName = "hop-after-break",
            name = "Hop world after break",
            description = "Hop to a different world after taking a break",
            position = 3,
            section = hoppingTitle
    )
    default boolean hopAfterBreak()
    {
        return false;
    }

    @ConfigItem(
            keyName = "american",
            name = "American",
            description = "Enable hopping to American worlds",
            position = 4,
            section = hoppingTitle
    )
    default boolean american()
    {
        return false;
    }

    @ConfigItem(
            keyName = "united-kingdom",
            name = "United kingdom",
            description = "Enable hopping to UK worlds",
            position = 5,
            section = hoppingTitle
    )
    default boolean unitedKingdom()
    {
        return false;
    }

    @ConfigItem(
            keyName = "german",
            name = "German",
            description = "Enable hopping to German worlds",
            position = 6,
            section = hoppingTitle
    )
    default boolean german()
    {
        return false;
    }

    @ConfigItem(
            keyName = "australian",
            name = "Australian",
            description = "Enable hopping to Australian worlds",
            position = 7,
            section = hoppingTitle
    )
    default boolean australian()
    {
        return false;
    }
}
