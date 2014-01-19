package main.java.rps.gamelogic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Oracle {


    private static Map<Weapon,Set<Weapon>> rulez = null;


    /**
     * the game rules
     * key = winner weapon, value set = loser weapon(s)
     */
    static {

        // use set for loser weapons to enable extension to more complex RPS variants
        rulez = new HashMap<Weapon,Set<Weapon>>();

        addRule(Weapon.Scissors, Weapon.Paper);
        addRule(Weapon.Paper, Weapon.Rock);
        addRule(Weapon.Rock, Weapon.Scissors);

    }


    private static void addRule(Weapon weapon, Weapon... loserWeapons){

        Set<Weapon> loserWeaponsSet = new HashSet<Weapon>();
        for(Weapon w : loserWeapons){
            loserWeaponsSet.add(w);
        }
        rulez.put(weapon, loserWeaponsSet);

    }


    /**
     *
     * @param w1
     * @param w2
     * @return 1=winner is weapon 1;2=winner is weapon 2; 0 = draw
     */
    public static int identWinner(Weapon w1, Weapon w2){

        if(rulez.get(w1).contains(w2)){
            return 1;
        }else if(rulez.get(w2).contains(w1)){
            return 2;
        }else {
            return 0;
        }

    }


}
