package com.example.bedfight.util;

import com.example.bedfight.BedFightPlugin;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;

public final class GameStartSettings {
    private final BedFightPlugin plugin;
    private final File file;
    private YamlConfiguration cfg;

    public GameStartSettings(BedFightPlugin plugin) {
        this.plugin = plugin;
        this.file = new File(plugin.getDataFolder(), "gamestart.yml");
        reload();
    }

    public void reload() {
        ConfigMerger.merge(plugin, "gamestart.yml");
        this.cfg = YamlFiles.load(file);
    }

    public int getInt(String path, int def) { return cfg.getInt(path, def); }
}
