package me.usainsrht.enchgui.command;

import me.usainsrht.enchgui.EnchGUI;
import me.usainsrht.enchgui.config.MainConfig;
import me.usainsrht.enchgui.util.MessageUtil;
import me.usainsrht.enchgui.util.SoundUtil;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class EnchGUICommand extends Command {

    public EnchGUICommand(String name, String description, String usageMessage, List<String> aliases) {
        super(name, description, usageMessage, aliases);
    }

    @Override
    public boolean execute(CommandSender sender, String command, String[] args) {
        if (!sender.hasPermission(MainConfig.getCmdPerm())) {
            MessageUtil.send(sender, MainConfig.getMessage("no_permission"));
            SoundUtil.play(sender, MainConfig.getSound("no_permission"));
            return false;
        }
        if (!(sender instanceof Player)) {
            MessageUtil.send(sender, Component.text("sorry, player only."));
            return false;
        }
        if (args.length == 0) {
            MessageUtil.send(sender, MainConfig.getMessage("help"));
            SoundUtil.play(sender, MainConfig.getSound("help"));
            return false;
        }
        Player p = (Player) sender;
        if (args[0].equalsIgnoreCase("reload")) {
            EnchGUI.getInstance().reload();
            MessageUtil.send(sender, MainConfig.getMessage("reload"));
            SoundUtil.play(sender, MainConfig.getSound("reload"));
        }
        return true;
    }
}
