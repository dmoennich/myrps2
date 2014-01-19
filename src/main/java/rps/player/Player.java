package main.java.rps.player;


import main.java.rps.gamelogic.Weapon;

public abstract class Player {

    protected String name;

    protected Weapon weapon;


    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public abstract void chooseWeapon();

    public Weapon getWeapon(){
        if(this.weapon == null){
            chooseWeapon();
        }
        return this.weapon;
    }

}
