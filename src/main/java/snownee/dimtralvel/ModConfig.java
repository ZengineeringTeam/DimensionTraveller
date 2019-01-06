package snownee.dimtralvel;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = DimTravel.MODID)
@Mod.EventBusSubscriber(modid = DimTravel.MODID)
public class ModConfig
{
    private ModConfig()
    {
        throw new UnsupportedOperationException("No instance for you");
    }

    @SubscribeEvent
    public static void onConfigReload(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equals(DimTravel.MODID))
        {
            ConfigManager.sync(DimTravel.MODID, Config.Type.INSTANCE);
        }
    }

    @Config.Name("Twilight Forest")
    public static final TwilightForest TwilightForest = new TwilightForest();

    public static class TwilightForest
    {
        @Config.RangeInt(max = -2)
        public int DimensionId = -233;

        @Config.RangeInt(min = 0)
        public int TierRequired = 1;
    }
}
