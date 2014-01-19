package main.java.rps.gamelogic;


import main.java.rps.player.Player;

public class RpsGame {

    private Player player1;
    private Player player2;

    private Player winner = null;
    private Player loser = null;


    public RpsGame(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }


    public void play(){
        player1.chooseWeapon();
        player2.chooseWeapon();
        Weapon w1 = player1.getWeapon();
        Weapon w2 = player2.getWeapon();
        int result = Oracle.identWinner(w1, w2);

        if(result == 1){
            this.winner = player1;
            this.loser = player2;
        }else if(result == 2){
            this.winner = player2;
            this.loser = player1;
        }

    }

    public Player getLoser() throws NoPlayerException {
        if(this.loser != null){
            return loser;
        }else {
            throw new NoPlayerException();
        }
    }

    public Player getWinner() throws NoPlayerException{
       if(this.winner != null){
           return winner;
       }else {
           throw new NoPlayerException();
       }
    }



}
