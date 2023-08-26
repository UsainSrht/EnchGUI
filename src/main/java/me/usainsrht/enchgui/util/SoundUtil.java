package me.usainsrht.enchgui.util;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import org.bukkit.configuration.ConfigurationSection;

import java.util.Collection;

public class SoundUtil {

    public static Sound getSoundFromYaml(ConfigurationSection config) {
        Sound.Builder builder = Sound.sound();
        if (config.isSet("name")) {
            builder = builder.type(Key.key(config.getString("name")));
        }
        if (config.isSet("source")) {
            builder = builder.source(Sound.Source.valueOf(config.getString("source")));
        }
        if (config.isSet("volume")) {
            builder = builder.volume((float) config.getDouble("volume"));
        }
        if (config.isSet("pitch")) {
            builder = builder.pitch((float) config.getDouble("pitch"));
        }
        return builder.build();
    }

    public static Sound getSoundFromString(String string) {
        String[] separated = string.split(",");
        Sound.Builder builder = Sound.sound();
        if (separated.length > 0) {
            builder = builder.type(Key.key(separated[0]));
            if (separated.length > 1) {
                builder = builder.volume(Float.parseFloat(separated[1]));
                if (separated.length > 2) {
                    builder = builder.pitch(Float.parseFloat(separated[2]));
                    if (separated.length > 3) {
                        builder = builder.source(Sound.Source.valueOf(separated[3]));
                    }
                }
            }
        }
        return builder.build();
    }

    public static void play(Collection<Audience> audiences, Collection<Sound> sounds) {
        for (Audience audience : audiences) {
            for (Sound sound : sounds) {
                play(audience, sound);
            }
        }
    }

    public static void play(Collection<Audience> audiences, Sound sound) {
        for (Audience audience : audiences) {
            play(audience, sound);
        }
    }

    public static void play(Audience audience, Collection<Sound> sounds) {
        for (Sound sound : sounds) {
            play(audience, sound);
        }
    }

    public static void play(Audience audience, Sound sound) {
        audience.playSound(sound);
    }

}
