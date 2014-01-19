package main.java.rps.ui;


import main.java.rps.gamelogic.GameMode;
import main.java.rps.gamelogic.RpsGame;
import main.java.rps.gamelogic.Weapon;

public interface RpsUi {


    public boolean playAnotherRound();

    public Weapon getUserWeaponInput();


    public GameMode getGameModeToPlay();


    public void displayResult(RpsGame game);

}
