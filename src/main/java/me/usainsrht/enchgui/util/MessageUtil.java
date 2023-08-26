package me.usainsrht.enchgui.util;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;

import java.util.Collection;

public class MessageUtil {

    public static void send(Collection<Audience> audiences, Collection<Component> components) {
        for (Audience audience : audiences) {
            for (Component component : components) {
                send(audience, component);
            }
        }
    }

    public static void send(Collection<Audience> audiences, Component component) {
        for (Audience audience : audiences) {
            send(audience, component);
        }
    }

    public static void send(Audience audience, Collection<Component> components) {
        for (Component component : components) {
            send(audience, component);
        }
    }

    public static void send(Audience audience, Component component) {
        audience.sendMessage(component);
    }
}
