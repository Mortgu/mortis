package de.mortis.game.UI;

public class Health {

    public int HealthToBar(int current_health, int health) {
        return (current_health / 225) * health;
    }

}
