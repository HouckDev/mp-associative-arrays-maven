package edu.grinnell.csc207;

import edu.grinnell.csc207.util.AssociativeArray;
import edu.grinnell.csc207.util.NullKeyException;
import edu.grinnell.csc207.util.KeyNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import java.security.Key;
import org.junit.jupiter.api.Test;

/**
 * A place for you to put your own tests (beyond the shared repo).
 *
 * @author Paden Houck
 */
public class TestsFromStudent {
  
  @Test
  public void houckPadenTest1() throws Exception {
    AssociativeArray<String, String> aa = 
        new AssociativeArray<String, String>();
    aa.set("a", "A");
    aa.set("b", "B");
    aa.set("c", "C");
    assertEquals("A", aa.get("a"), "test longer array");
    assertEquals("B", aa.get("b"), "test longer array");
    assertEquals("C", aa.get("c"), "test longer array");
  }
  @Test
  public void houckPadenTest2() throws Exception {
    AssociativeArray<String, String> aa = 
        new AssociativeArray<String, String>();
    aa.set("a", "A");
    aa.hasKey("a");
    aa.set("b", "B");
    aa.hasKey("b");
    aa.set("c", "C");
    aa.hasKey("c");
    assertThrows(KeyNotFoundException.class,()-> aa.get("d"), "test invalid key");
    assertThrows(NullKeyException.class,()-> aa.set(null, "C"), "test invalid key");
    aa.remove("a");
    assertThrows(KeyNotFoundException.class,()-> aa.get("a"), "test invalid key");
    
  }
  @Test
  public void houckPadenEdge1() throws Exception {
    AssociativeArray<String, String> aa = 
        new AssociativeArray<String, String>();
    aa.set("a", "A");
    aa.set("b", "B");
    aa.set("c", "C");
    aa.set("C", "c");
    assertEquals("c", aa.get(aa.get("c")), "test self reference");
    
    AssociativeArray<String, AssociativeArray<String, String>> aa2 = 
        new AssociativeArray<String, AssociativeArray<String, String>>();
    aa2.set("a", aa);
    assertEquals(aa, aa2.get("a"), "test nested array");
    assertEquals("A", aa2.get("a").get("a"), "test nested array");
  }
} // class TestsFromSam
