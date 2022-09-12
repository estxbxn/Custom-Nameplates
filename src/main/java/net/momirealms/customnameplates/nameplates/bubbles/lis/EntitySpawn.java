/*
 *  Copyright (C) <2022> <XiaoMoMi>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.momirealms.customnameplates.nameplates.bubbles.lis;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import net.momirealms.customnameplates.CustomNameplates;
import net.momirealms.customnameplates.nameplates.bubbles.BBPacketsHandle;

public class EntitySpawn extends PacketAdapter {

    private final BBPacketsHandle handler;

    public EntitySpawn(BBPacketsHandle handler) {
        super(CustomNameplates.instance, ListenerPriority.HIGHEST, PacketType.Play.Server.NAMED_ENTITY_SPAWN);
        this.handler = handler;
    }

    public synchronized void onPacketSending(PacketEvent event) {
        handler.onEntitySpawn(event.getPlayer(), event.getPacket().getIntegers().read(0));
    }
}
