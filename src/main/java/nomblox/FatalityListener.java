package nomblox;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class FatalityListener implements Listener {
    @EventHandler
    public void onEntityDeath(EntityDeathEvent entityDeathEvent) {
        if (entityDeathEvent.getEntity().getKiller() instanceof Player) {
            Player player = entityDeathEvent.getEntity().getKiller();
            if (player.hasPermission("fatality.blood")) {
                Location location = entityDeathEvent.getEntity().getLocation().add(0, 1, 0);
                entityDeathEvent.getEntity().getWorld().spawnParticle(Particle.BLOCK_CRACK,
                        location, 80, Material.REDSTONE_BLOCK.createBlockData());
            }
        }
    }
}