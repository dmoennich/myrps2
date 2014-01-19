package main.java.rps.ui;

import main.java.rps.gamelogic.GameMode;
import main.java.rps.gamelogic.RpsGame;
import main.java.rps.gamelogic.Weapon;
import main.java.rps.gamelogic.NoPlayerException;
import main.java.rps.player.Player;

import java.util.Scanner;

/**
 * Command line interface for RPS Main.
 */
public class Cli implements RpsUi{

    private Scanner scanner = new Scanner(System.in);

    private static Identifier<String, Weapon> weaponIdentifier = new Identifier<String, Weapon>();

    private static Identifier<String, GameMode> gameModeIdentifier = new Identifier<String, GameMode>();

    private static Identifier<String, Boolean> newRoundIdentifier = new Identifier<String, Boolean>();

    static {

        weaponIdentifier.addIdentifier("paper", Weapon.Paper);
        weaponIdentifier.addIdentifier("rock", Weapon.Rock);
        weaponIdentifier.addIdentifier("scissors", Weapon.Scissors);

        gameModeIdentifier.addIdentifier("human", GameMode.PlayerVsCpu);
        gameModeIdentifier.addIdentifier("cpu", GameMode.CpuVsCpu);

        newRoundIdentifier.addIdentifier("no", false);
        newRoundIdentifier.addIdentifier("yes", true);
    }


    public static Identifier<String, Weapon> getWeaponIdentifier(){
        return weaponIdentifier;
    }

    private void printMessage(String message){
        System.out.println(message);
    }


    @Override
    public boolean playAnotherRound() {
        printMessage("Play another round?");
        return this.getInput(newRoundIdentifier);
    }

    public Weapon getUserWeaponInput() {
        return this.getInput(weaponIdentifier);
    }


    public GameMode getGameModeToPlay() {
        return this.getInput(gameModeIdentifier);
    }

    public void displayResult(RpsGame game) {
        try {
            Player winner = game.getWinner();
            Player loser = game.getLoser();
            printMessage(winner.getName() + " with " + winner.getWeapon().name() + " wins against " + loser.getName() + " with " + loser.getWeapon() + ".");
        } catch (NoPlayerException e) {
            printMessage("Draw!");
        }
    }

    private <O> O getInput(Identifier<String, O> identifier){
        boolean invalidInput = true;
        O object = null;
        do {
            try {
                displayValidInputs(identifier);
                String input = scanner.nextLine();
                object = identifier.identify(input);
                invalidInput = false;
            } catch (UnknownIdentifierException e) {
                printMessage(e.getMessage() + ", please try again.");
            }
        } while (invalidInput);

        return object;
    }


    private void displayValidInputs(Identifier<String, ?> identifier){
        printMessage("Valid inputs: ");
        for(String input : identifier.getIdentifiers()){
            printMessage("-" + input);
        }
    }



}
