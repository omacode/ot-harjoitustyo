package domain;

import org.junit.Test;
import static org.junit.Assert.*;
import trainingapp.domain.Player;

public class PlayerTest {
    
    @Test
    public void equalWhenSameUsername() {
        Player p1 = new Player("tester1", "tim1", "Tim S");
        Player p2 = new Player("tester1", "tim1", "Tim S");
        assertTrue(p1.equals(p2));
    }
    
    @Test
    public void notEqualWhenDifferentUsername() {
        Player p1 = new Player("tester1", "tim1", "Tim S");
        Player p2 = new Player("tester2", "tim1", "Tim S");
        assertFalse(p1.equals(p2));
    }
    
    @Test
    public void notEqualWhenDifferentPassword() {
        Player p1 = new Player("tester1", "tim1", "Tim S");
        Player p2 = new Player("tester1", "tim2", "Tim S");
        assertFalse(p1.equals(p2));
    }
    
    @Test
    public void notEqualWhenDifferentName() {
        Player p1 = new Player("tester1", "tim1", "Tim S");
        Player p2 = new Player("tester1", "tim1", "Tim O");
        assertFalse(p1.equals(p2));
    }
    
    @Test
    public void notEqualWhenDifferentType() {
        Player p = new Player("tester1", "tim1", "Tim S");
        Object o = new Object();
        assertFalse(p.equals(o));
    }
    
    @Test
    public void equalWhenSameObject() {
        Player p = new Player("tester1", "tim1", "Tim S");
        assertTrue(p.equals(p));
    }
    
    @Test
    public void notEqualWhenObjectIsNull() {
        Player p = new Player("tester1", "tim1", "Tim S");
        assertFalse(p.equals(null));
    }    
}
