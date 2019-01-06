package snownee.dimtralvel;

import org.apache.logging.log4j.Logger;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import twilightforest.TFConfig;

@Mod(
        modid = DimTravel.MODID, name = DimTravel.NAME, version = "@VERSION_INJECT@", dependencies = "required-after:galacticraftcore;required-after:twilightforest"
)
public class DimTravel
{
    public static final String MODID = "dimtravel";
    public static final String NAME = "Dimension Traveller";

    private static Logger logger;

    public static Planet planetTwilightForest;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        planetTwilightForest = new Planet("twilightforest");
        planetTwilightForest.setParentSolarSystem(GalacticraftCore.solarSystemSol);
        planetTwilightForest.setTierRequired(ModConfig.TwilightForest.TierRequired);
        planetTwilightForest.setRingColorRGB(0.1F, 0.9F, 0.6F);
        planetTwilightForest.setPhaseShift(0.8F);
        planetTwilightForest.setDimensionInfo(ModConfig.TwilightForest.DimensionId, WorldProviderTwilightForestWrapper.class);
        planetTwilightForest.setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(3.00F, 3.00F));
        planetTwilightForest.setRelativeOrbitTime(100F);
        planetTwilightForest.setBodyIcon(new ResourceLocation(MODID, "textures/gui/planets/tf.png"));
        GalaxyRegistry.registerPlanet(planetTwilightForest);
        GalacticraftRegistry.registerTeleportType(WorldProviderTwilightForestWrapper.class, new TeleportTypeTwilightForest());
        GalacticraftRegistry.registerRocketGui(WorldProviderTwilightForestWrapper.class, new ResourceLocation(MODID, "textures/gui/rocket_gui_tf.png"));
    }

    @EventHandler
    public void complete(FMLPostInitializationEvent event)
    {
        TFConfig.dimension.dimensionID = ModConfig.TwilightForest.DimensionId;

        TFConfig.adminOnlyPortals = true;
        TFConfig.allowPortalsInOtherDimensions = false;
        TFConfig.disablePortalCreation = true;
    }
}
