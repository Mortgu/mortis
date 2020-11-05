package de.mortis.game;

import de.mortis.game.manager.GameStateManager;
import de.mortis.game.manager.GameStates;

public class Main {

    private static Main main;
    private static GameStateManager gameStateManager;

    public static void main(String[] args) {
        gameStateManager = new GameStateManager(main);
        gameStateManager.setGameState(GameStates.START);

        new Window();
    }

    public static GameStateManager getGameStateManager() {
        return gameStateManager;
    }

    public static void setGameStateManager(GameStateManager gameStateManager) {
        Main.gameStateManager = gameStateManager;
    }
}
