package io.annot8.examples.processors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumbersSettingsTest {
  @Test
  public void test(){
    NumbersSettings ns = new NumbersSettings(5);
    assertEquals(5, ns.getMinDigits());
    assertTrue(ns.validate());
  }

  @Test
  public void testInvalid(){
    NumbersSettings ns = new NumbersSettings(-3);
    assertFalse(ns.validate());
  }
}
