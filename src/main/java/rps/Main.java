package main.java.rps;

import main.java.rps.gamelogic.GameMode;
import main.java.rps.gamelogic.RpsGame;
import main.java.rps.player.ComputerPlayer;
import main.java.rps.player.HumanPlayer;
import main.java.rps.player.Player;
import main.java.rps.ui.Cli;

public class Main {


    public static void main(String[] args) {

        Cli cli = new Cli();

        Player player1 = new ComputerPlayer("Cpu1");

        do {

            Player player2 = null;

            GameMode gameMode = cli.getGameModeToPlay();

            switch (gameMode) {
                case CpuVsCpu:
                    player2 = new ComputerPlayer("Cpu2");
                    break;
                case PlayerVsCpu:
                    player2 = new HumanPlayer(cli, "Human");
                    break;

                default:
                    throw new RuntimeException("Game mode " + gameMode + " not supported");
            }

            RpsGame game = new RpsGame(player1, player2);
            game.play();

            cli.displayResult(game);


        } while (cli.playAnotherRound());


    }

}
