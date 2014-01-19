package test.java.rps;

import main.java.rps.gamelogic.Weapon;
import main.java.rps.ui.Cli;
import main.java.rps.ui.Identifier;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CliTest {

    // checks if all weapons are available in the cli to be selected
    @Test
    public void testWeaponSelection() throws Exception {

        Weapon[] weapons = Weapon.values();
        Identifier<String, Weapon> weaponIdentifier = Cli.getWeaponIdentifier();


        //assertEquals(weapons.length, weaponIdentifier.getIdentifiers().size());

        List<Weapon> weaponsFromCli = new ArrayList<Weapon>();
        for (String ident : weaponIdentifier.getIdentifiers()) {
            weaponsFromCli.add(weaponIdentifier.identify(ident));

        }

        for(Weapon w : weapons){
            assertTrue("Weapon " + w.name()+ " not in Cli.", weaponsFromCli.contains(w));
        }


    }


}
