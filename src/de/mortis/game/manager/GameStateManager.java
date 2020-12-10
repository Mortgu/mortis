package de.mortis.game.manager;

import de.mortis.game.Main;
import de.mortis.game.handlers.KeyHandler;
import de.mortis.game.handlers.MouseHandler;
import de.mortis.game.manager.states.End;
import de.mortis.game.manager.states.Run;
import de.mortis.game.manager.states.Start;

import java.awt.Graphics2D;

public class GameStateManager {

    private Main main;
    private GameStates[] gameStates;
    private GameStates currentGameState;

    public GameStateManager(Main main) {
        this.main = main;
        gameStates = new GameStates[3];

        gameStates[GameStates.START] = new Start();
        gameStates[GameStates.RUN] = new Run();
        gameStates[GameStates.END] = new End();
    }

    public void setGameState(int gameStateID) {
        if(currentGameState != null)
            currentGameState.stop();
        currentGameState = gameStates[gameStateID];
        currentGameState.start();
    }

    public void stopCurrentGameState() {
        if(currentGameState != null) {
            currentGameState.stop();
            currentGameState = null;
        }
    }

    public void render(Graphics2D g) {
        Main.getGameStateManager().getCurrentGameState().render(g);
    }

    public void input(KeyHandler keyHandler, MouseHandler mouseHandler) {
        Main.getGameStateManager().getCurrentGameState().input(keyHandler, mouseHandler);
    }

    public void update() {
        Main.getGameStateManager().getCurrentGameState().update();
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public GameStates[] getGameStates() {
        return gameStates;
    }

    public void setGameStates(GameStates[] gameStates) {
        this.gameStates = gameStates;
    }

    public GameStates getCurrentGameState() {
        return currentGameState;
    }

    public void setCurrentGameState(GameStates currentGameState) {
        this.currentGameState = currentGameState;
    }
}
