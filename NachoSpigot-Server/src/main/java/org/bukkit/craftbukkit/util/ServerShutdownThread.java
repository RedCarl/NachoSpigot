package org.bukkit.craftbukkit.util;

import net.minecraft.server.ExceptionWorldConflict;
import net.minecraft.server.MinecraftServer;
import org.spigotmc.AsyncCatcher;

public class ServerShutdownThread extends Thread {
    private final MinecraftServer server;

    public ServerShutdownThread(MinecraftServer server) {
        this.server = server;
    }

    @Override
    public void run() {
        try {
            // Paper start - try to shutdown on main
            server.safeShutdown();
            for (int i = 1000; i > 0 && !server.hasStopped(); i -= 100) {
                Thread.sleep(100);
            }
            if (server.hasStopped()) {
                while (!server.hasFullyShutdown) Thread.sleep(1000);
                return;
            }
            // Looks stalled, close async
            AsyncCatcher.enabled = false;
            server.stop();
            while (!server.hasFullyShutdown) Thread.sleep(1000);
            // Paper end
        } catch (ExceptionWorldConflict | InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            try {
                server.reader.getTerminal().restore();
            } catch (Exception e) {
            }
        }
    }
}
