package main.java.rps.player;

import main.java.rps.ui.RpsUi;


public class HumanPlayer extends Player{

    private RpsUi ui = null;

    public HumanPlayer(RpsUi ui, String name){
        super(name);
        this.ui = ui;
    }

    @Override
    public void chooseWeapon() {
        this.weapon = ui.getUserWeaponInput();
    }

}
