package edu.grinnell.csc207;

import edu.grinnell.csc207.util.AssociativeArray;
import edu.grinnell.csc207.util.NullKeyException;
import edu.grinnell.csc207.util.KeyNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * A place for you to put your own tests (beyond the shared repo).
 *
 * @author Paden Houck
 */
public class TestsFromStudent {
  
  /**
   * Basic tests to ensure AssociativeArray can have elements added to it and that it changes appropriately
   * 
   * @throws Exception
   */
  @Test
  public void houckPadenTest1() throws Exception {
    AssociativeArray<String, String> aa = 
        new AssociativeArray<String, String>();
    aa.set("a", "A");
    assertTrue(aa.hasKey("a"),"test hasKey");
    assertEquals(1, aa.size(), "test get size");
    aa.set("b", "B");
    assertTrue(aa.hasKey("b"),"test hasKey");
    assertEquals(2, aa.size(), "test get size");
    aa.set("c", "C");
    assertTrue(aa.hasKey("c"),"test hasKey");
    assertEquals(3, aa.size(), "test get size");
    assertEquals("A", aa.get("a"), "test longer array");
    assertEquals("B", aa.get("b"), "test longer array");
    assertEquals("C", aa.get("c"), "test longer array");
  }
  
  /**
   * Basic tests to ensure AssociativeArray can have elements removed from it and that it changes appropriately.
   * 
   * @throws Exception
   */
  @Test
  public void houckPadenTest2() throws Exception {
    AssociativeArray<String, String> aa = 
        new AssociativeArray<String, String>();
    aa.set("a", "A");
    aa.set("b", "B");
    aa.set("c", "C");

    assertThrows(KeyNotFoundException.class,()-> aa.get("d"), "test invalid key");
    assertThrows(NullKeyException.class,()-> aa.set(null, "C"), "test invalid key");
    aa.remove("a");
    assertFalse(aa.hasKey("a"),"test hasKey");
    assertEquals(2, aa.size(), "test get size");
    assertThrows(KeyNotFoundException.class,()-> aa.get("a"), "test invalid key");
    
  }
  
  /**
   * Tests to ensure AssociativeArray can handle self references and nested arrays.
   * 
   * @throws Exception
   */
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

  
  /**
   * Tests to check null key errors.
   * 
   * @throws Exception
   */
  @Test
  public void houckPadenEdge2() throws Exception {
    AssociativeArray<String, String> aa = 
        new AssociativeArray<String, String>();
    aa.set("a", "A");
    aa.set("b", "B");
    aa.set("c", "C");
    aa.set("C", "c");
    assertThrows(KeyNotFoundException.class,()-> aa.get(null), "test null key");
    assertThrows(NullKeyException.class,()-> aa.set(null,"test"), "test null key");
    assertFalse(aa.hasKey(null), "test null key");
  }
} // class TestsFromSam
