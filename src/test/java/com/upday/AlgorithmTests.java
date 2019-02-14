package com.upday;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AlgorithmTests {
  @Test
  public void singleDimensionArrayTest() {
    assertEquals(
        "Test single dimension array",
        10,
        Algorithm.toOneDimension(new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }).length);
  }

  @Test
  public void multipleDimensionTest() {
    Integer arraySize = 100;
    assertEquals(
        "Test multidimensional dimension array",
        arraySize,
        Algorithm.toOneDimension(getUnflattenAlgorithm(arraySize)));
  }
  
  @Test
  public void arrayWithNullValuesTest() {
    assertEquals(
        "Test with array with null values",
        9,
        Algorithm.toOneDimension(new Object[] { 1, null, 2, 3, new Object[] {null,4},5, 6, 7, 8, 9 }).length);
  }
  
  @Test
  public void emptyArrayTest() {
    assertEquals(
        "Test with array empty",
        0,
        Algorithm.toOneDimension(new Object[] {}).length);
  }

  private Object[] getUnflattenAlgorithm(Integer size) {
    Object[] array = new Object[size.intValue()];
    for (int i = 0; i < size; i++) {
      if (i % 2 == 0) {
        array[i] = new Object[] { i };
      } else if (i % 3 == 0) {
        array[i] = new Object[] { new Object[] { 1 } };
      } else {
        array[i] = i;
      }
      array[i] = i;
    }
    return array;
  }

}
