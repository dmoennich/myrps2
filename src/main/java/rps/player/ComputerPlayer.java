package main.java.rps.player;

import main.java.rps.gamelogic.Weapon;

public class ComputerPlayer extends Player{


    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public void chooseWeapon() {
        Weapon[] weapons = Weapon.values();
        int weaponCount = weapons.length;
        int selectedWeaponIndex = (int)(Math.random() * (weaponCount));
        this.weapon = weapons[selectedWeaponIndex];
    }

}
