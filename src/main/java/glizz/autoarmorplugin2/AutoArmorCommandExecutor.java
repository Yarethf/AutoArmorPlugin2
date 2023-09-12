package glizz.autoarmorplugin2;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

public class AutoArmorCommandExecutor implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED+"Glizzy"+ChatColor.WHITE+"Core" + " "+ChatColor.DARK_GRAY+"»" +" "+ChatColor.RED+"Este comando solo puede ser ejecutado por un jugador.");
                return true;
            }

            Player player = (Player) sender;
            if (!player.hasPermission("autoarmor.use")) {
                player.sendMessage(ChatColor.RED+"Glizzy"+ChatColor.WHITE+"Core" + " "+ChatColor.DARK_GRAY+"»" +" "+ChatColor.RED+"No tienes permiso para usar este comando.");
                return true;
            }
            // Verifica si el jugador ya tiene alguna pieza de armadura equipada
            if (player.getInventory().getHelmet() != null || player.getInventory().getChestplate() != null ||
                    player.getInventory().getLeggings() != null || player.getInventory().getBoots() != null) {
                sender.sendMessage(ChatColor.RED+"Glizzy"+ChatColor.WHITE+"Core" + " "+ChatColor.DARK_GRAY+"»" +" "+ChatColor.RED+"Ya tienes una armadura equipada. Quita la armadura actual antes de usar este comando.");
                return true;
            }

            ItemStack[] inventoryContents = player.getInventory().getContents();

            // Variable para rastrear si se encontró alguna pieza de armadura
            boolean foundArmor = false;

            // Itera a través del inventario del jugador y busca armadura válida
            for (int i = 0; i < inventoryContents.length; i++) {
                ItemStack item = inventoryContents[i];
                if (item != null && isArmor(item.getType())) {
                    // Encuentra una pieza de armadura válida, equipo al jugador y elimina del inventario
                    equipArmor(player, item, i);
                    foundArmor = true;
                }
            }

            if (foundArmor) {
                sender.sendMessage(ChatColor.RED+"Glizzy"+ChatColor.WHITE+"Core" + " "+ChatColor.DARK_GRAY+"»" +" "+ChatColor.RED+"¡Tu armadura ha sido equipada automáticamente!");
            } else {
                sender.sendMessage(ChatColor.RED+"Glizzy"+ChatColor.WHITE+"Core" + " "+ChatColor.DARK_GRAY+"»" +" "+ChatColor.RED+"No tienes suficiente armadura en tu inventario.");
            }

            return true;
        }

        // Método para verificar si un material es una pieza de armadura
        private boolean isArmor(Material material) {
            switch (material) {
                case DIAMOND_HELMET:
                case DIAMOND_CHESTPLATE:
                case DIAMOND_LEGGINGS:
                case DIAMOND_BOOTS:
                case IRON_HELMET:
                case IRON_CHESTPLATE:
                case IRON_LEGGINGS:
                case IRON_BOOTS:
                case GOLD_HELMET:
                case GOLD_CHESTPLATE:
                case GOLD_LEGGINGS:
                case GOLD_BOOTS:
                case CHAINMAIL_HELMET:
                case CHAINMAIL_CHESTPLATE:
                case CHAINMAIL_LEGGINGS:
                case CHAINMAIL_BOOTS:
                case LEATHER_HELMET:
                case LEATHER_CHESTPLATE:
                case LEATHER_LEGGINGS:
                case LEATHER_BOOTS:
                    return true;
                default:
                    return false;
            }
        }

    // Método para equipar una pieza de armadura al jugador y eliminarla del inventario
    private void equipArmor(Player player, ItemStack armor, int slot) {
        Material armorType = armor.getType();
        player.getInventory().setItem(slot, null); // Elimina la pieza de armadura del inventario

        // Determina la ranura de armadura correspondiente y equipa
        if (armorType == Material.DIAMOND_HELMET) {
            player.getInventory().setHelmet(armor);
        } else if (armorType == Material.DIAMOND_CHESTPLATE) {
            player.getInventory().setChestplate(armor);
        } else if (armorType == Material.DIAMOND_LEGGINGS) {
            player.getInventory().setLeggings(armor);
        } else if (armorType == Material.DIAMOND_BOOTS) {
            player.getInventory().setBoots(armor);
        }
        if (armorType == Material.GOLD_HELMET) {
            player.getInventory().setHelmet(armor);
        } else if (armorType == Material.GOLD_CHESTPLATE) {
            player.getInventory().setChestplate(armor);
        } else if (armorType == Material.GOLD_LEGGINGS) {
            player.getInventory().setLeggings(armor);
        } else if (armorType == Material.GOLD_BOOTS) {
            player.getInventory().setBoots(armor);
        }
        if (armorType == Material.LEATHER_HELMET) {
            player.getInventory().setHelmet(armor);
        } else if (armorType == Material.LEATHER_CHESTPLATE) {
            player.getInventory().setChestplate(armor);
        } else if (armorType == Material.LEATHER_LEGGINGS) {
            player.getInventory().setLeggings(armor);
        } else if (armorType == Material.LEATHER_BOOTS) {
            player.getInventory().setBoots(armor);
        }
    }
}