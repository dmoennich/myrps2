package test.java.rps;

import main.java.rps.gamelogic.Oracle;
import main.java.rps.gamelogic.Weapon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OracleTest {

    private Weapon weapon1;
    private Weapon weapon2;
    private int expectedResult;


    public OracleTest(Weapon weapon1, Weapon weapon2, int expectedResult) {
        this.weapon1 = weapon1;
        this.weapon2 = weapon2;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {Weapon.Scissors, Weapon.Paper, 1},
                {Weapon.Paper, Weapon.Scissors, 2},
                {Weapon.Rock, Weapon.Scissors, 1},
                {Weapon.Scissors, Weapon.Rock, 2},
                {Weapon.Paper, Weapon.Rock, 1},
                {Weapon.Rock, Weapon.Paper, 2},
                {Weapon.Rock, Weapon.Rock, 0},
                {Weapon.Scissors, Weapon.Scissors, 0},
                {Weapon.Paper, Weapon.Paper, 0}
        });
    }


    @Test
    public void testPrimeNumberValidator() {
        assertEquals(expectedResult, Oracle.identWinner(weapon1, weapon2));
    }



}
