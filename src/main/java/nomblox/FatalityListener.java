/*
 * Fatality
 * Copyright (C) 2020 Nejc Korošec and Simon Jureša
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

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
        if (entityDeathEvent.getEntity().getKiller() != null) {
            Player player = entityDeathEvent.getEntity().getKiller();
            if (player.hasPermission("fatality.blood")) {
                Location location = entityDeathEvent.getEntity().getLocation().add(0, 1, 0);
                entityDeathEvent.getEntity().getWorld().spawnParticle(Particle.BLOCK_CRACK,
                        location, 80, Material.REDSTONE_BLOCK.createBlockData());
            }
        }
    }
}