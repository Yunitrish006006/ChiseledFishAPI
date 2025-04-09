package com.chiseledbrick.fishapi.api;

import com.chiseledbrick.fishapi.ChiseledFishAPI;
import com.chiseledbrick.fishapi.FishTable;

import java.util.ArrayList;
import java.util.List;

public class FishTableRegistry {
    private static final List<FishTable> tables = new ArrayList<>();
    private static final List<FishTableProvider> providers = new ArrayList<>();


    public static void registerTable(FishTable table) {
        tables.add(table);
    }

    public static void registerTableProvider(FishTableProvider provider) {
        providers.add(provider);
        provider.addFishTables();
    }

    public static List<FishTable> getTables() {
        for (FishTableProvider provider : providers) {
            provider.addFishTables();
        }
        return tables;
    }
    public static void initializeTables() {
        ChiseledFishAPI.LOGGER.info("Loaded {} recipes", tables.size());
    }
}
