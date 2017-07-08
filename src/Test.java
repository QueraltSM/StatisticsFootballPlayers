import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

public class Test {
    private static CU c;
    private static Attacker attacker1;
    private static Defender defender1;
    private static Goalkeeper goalkeeper1;

    @Before
    public void initialization(){
        c = new CU();
        attacker1 = new Attacker("Lolo", 8);
        defender1 = new Defender("Martin",5);
        goalkeeper1 = new Goalkeeper("Pepe",1);

        c.addPlayer(attacker1);
        c.addPlayer(defender1);

    }


    @After
    public void finalization(){
        System.out.println("Test was successful!");
    }


    @org.junit.Test
    public void addPlayerTest() {
        c.addPlayer(goalkeeper1);
        c.addPlayer(goalkeeper1);

        assertEquals(c.getList().toString(), "[" + attacker1.toString() + ", " + defender1.toString() +
                ", " + goalkeeper1.toString() + "]");

    }

    @org.junit.Test
    public void newGoalTest() {
        c.newGoal(attacker1.getNumber());
        c.newGoal(defender1.getNumber());
        c.newGoal(attacker1.getNumber());
        c.setOrder(1);
        assertEquals(c.getList().toString(), "["+ attacker1.toString() + ", " + defender1.toString() + "]");
    }


    @org.junit.Test
    public void newPassTest() {
        c.passSuccessfully(defender1.getNumber());
        assertTrue(defender1.getPasses() == 1);
    }

    @org.junit.Test
    public void newStopTest() {
        assertFalse(c.newStop(attacker1.getNumber()));
        c.addPlayer(goalkeeper1);
        c.newStop(goalkeeper1.getNumber());
        assertTrue(goalkeeper1.getStops() == 1);
    }

    @org.junit.Test
    public void newRecuperationTest() {
        c.newRecuperation(defender1.getNumber());
        assertTrue(defender1.getRecuperations() == 1);
        c.addPlayer(goalkeeper1);
        assertFalse(c.newRecuperation(goalkeeper1.getNumber()));
    }


    @org.junit.Test
    public void showDataTest() {
        assertEquals(c.showData(defender1.getNumber()), defender1.toString());
        assertTrue(c.showData(12).equals(""));
    }

    public static void main(String[] args) {

    }
}