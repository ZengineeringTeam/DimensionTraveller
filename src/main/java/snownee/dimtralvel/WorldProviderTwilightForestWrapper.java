package snownee.dimtralvel;

import java.util.Collections;
import java.util.List;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.world.EnumAtmosphericGas;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import twilightforest.world.WorldProviderTwilightForest;

public class WorldProviderTwilightForestWrapper extends WorldProviderTwilightForest implements IGalacticraftWorldProvider
{
    public WorldProviderTwilightForestWrapper()
    {
        setDimension(ModConfig.TwilightForest.DimensionId);
    }

    @Override
    public float getGravity()
    {
        return 0.04F;
    }

    @Override
    public float getArrowGravity()
    {
        return 0;
    }

    @Override
    public double getMeteorFrequency()
    {
        return 1;
    }

    @Override
    public double getFuelUsageMultiplier()
    {
        return 1;
    }

    @Override
    public boolean canSpaceshipTierPass(int tier)
    {
        return true;
    }

    @Override
    public float getFallDamageModifier()
    {
        return 1;
    }

    @Override
    public boolean hasNoAtmosphere()
    {
        return false;
    }

    @Override
    public float getSoundVolReductionAmount()
    {
        return 1;
    }

    @Override
    public boolean hasBreathableAtmosphere()
    {
        return true;
    }

    @Override
    public boolean netherPortalsOperational()
    {
        return false;
    }

    @Override
    public boolean isGasPresent(EnumAtmosphericGas gas)
    {
        return gas == EnumAtmosphericGas.OXYGEN || gas == EnumAtmosphericGas.CO2 || gas == EnumAtmosphericGas.WATER;
    }

    @Override
    public float getThermalLevelModifier()
    {
        return 0;
    }

    @Override
    public float getWindLevel()
    {
        return 0;
    }

    @Override
    public float getSolarSize()
    {
        return 1;
    }

    @Override
    public CelestialBody getCelestialBody()
    {
        return DimTravel.planetTwilightForest;
    }

    @Override
    public boolean shouldDisablePrecipitation()
    {
        return false;
    }

    @Override
    public boolean shouldCorrodeArmor()
    {
        return true;
    }

    @Override
    public int getDungeonSpacing()
    {
        return 0;
    }

    @Override
    public ResourceLocation getDungeonChestType()
    {
        return null;
    }

    @Override
    public List<Block> getSurfaceBlocks()
    {
        return Collections.EMPTY_LIST;
    }

}
