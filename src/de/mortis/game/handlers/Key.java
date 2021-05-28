package de.mortis.game.handlers;

import java.util.ArrayList;
import java.util.List;

public class Key {

    public static List<Key> keys = new ArrayList<>();

    public int presses, absorbs;
    public boolean down, clicked;

    public Key() {
        keys.add(this);
    }

    public void toggle(boolean pressed) {
        if (pressed != down) down = pressed;
        if (pressed) presses++;
    }

    public void tick() {
        if (absorbs < presses) {
            absorbs++;
            clicked = true;
        } else clicked = false;
    }

}
