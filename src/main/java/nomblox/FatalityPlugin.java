package nomblox;

import bstats.FatalityMetrics;
import org.bukkit.plugin.java.JavaPlugin;

public class FatalityPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        try {
            new FatalityMetrics(this, 9445);
        } catch (Exception ignored) {}
        getServer().getPluginManager().registerEvents(new FatalityListener(), this);
    }
}