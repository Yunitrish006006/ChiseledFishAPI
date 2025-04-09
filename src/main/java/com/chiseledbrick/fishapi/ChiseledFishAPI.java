package com.chiseledbrick.fishapi;

import com.chiseledbrick.fishapi.api.FishTableRegistry;
import com.chiseledbrick.fishapi.event.FishingEvent;
import com.chiseledbrick.fishapi.init.ModFishTableInit;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChiseledFishAPI implements ModInitializer {
	public static final String MOD_ID = "chiseled_fish_api";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Identifier id(String name) {
		return Identifier.of(ChiseledFishAPI.MOD_ID, name);
	}

	@Override
	public void onInitialize() {
		FishTableRegistry.registerTableProvider(new ModFishTableInit());
		ServerEntityEvents.ENTITY_LOAD.register(FishingEvent::onFishHookedUp);
		FishTableRegistry.initializeTables();
	}
}