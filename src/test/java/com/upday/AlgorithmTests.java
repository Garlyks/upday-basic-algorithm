package com.upday;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AlgorithmTests {
  @Test
  public void algorithmTest() {
    // [[1,2,[3]],4] -> [1,2,3,4].
    Object[] input1 = { new Object[] { 1, 2, new Object[] { 3 } }, 4 };
    Integer[] output1 = Algorithm.toOneDimension(input1);
    assertEquals(4, output1.length);

    // [9,[8,7],6,5,[[[[4,3,[2,1]]]
    Object[] input2 = { 9, new Object[] { 8, 7 }, 6, 5,
        new Object[] { new Object[] { new Object[] { 4, 3, new Object[] { 2, 1 } } } } };
    Integer[] output2 = Algorithm.toOneDimension(input2);
    assertEquals(9, output2.length);
    
    Object[] input3 = { 9, new Object[] { 8, 8 }, 8, 8};
    Integer[] output3 = Algorithm.toOneDimension(input3);
    assertEquals(5, output3.length);
  }

  @Test
  public void algorithmBigSizeOnly3levelsTest() {
    Long size = 100000l; 
    Object[] array = new Object[size.intValue()];
    long time = System.currentTimeMillis();
    for (int i = 0; i < size; i++) {
      if(i%2 == 0) {
        array[i] = new Object[] {i};
      }else if(i%3==0) {
        array[i] = new Object[] {new Object[] {1}};
      }else {
        array[i] = i;
      }
      array[i] = i;
    }
    long duration = System.currentTimeMillis()-time;
    System.out.println("Creation "+duration);
    time = System.currentTimeMillis();
    Integer[] output = Algorithm.toOneDimension(array);
    duration = System.currentTimeMillis()-time;
    System.out.println("Process:  "+duration);
    System.out.println(output.length);
    
    assertEquals(size, output.length, 0);
  }

}
