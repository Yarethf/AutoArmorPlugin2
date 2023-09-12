package glizz.autoarmorplugin2;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
public final class AutoArmorPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("autoarmor").setExecutor(new AutoArmorCommandExecutor());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
