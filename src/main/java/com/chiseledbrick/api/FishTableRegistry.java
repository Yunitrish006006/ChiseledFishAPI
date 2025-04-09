package net.adaptor.fishing.api;

import net.adaptor.fishing.FishTable;
import net.adaptor.fishing.Main;

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
        Main.LOGGER.info("Loaded {} recipes", tables.size());
    }
}
