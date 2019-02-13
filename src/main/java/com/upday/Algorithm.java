package com.upday;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Algorithm {
  
  public static Integer[] toOneDimension(Object[] objectToFlat) {
    List<Integer> result = new LinkedList<>();
    for (Object object:objectToFlat) {
      if(object instanceof Integer) {
        result.add((Integer) object);
      }else if(object instanceof Object[]){
        result.addAll(Arrays.asList(toOneDimension((Object[])object)));
      }
    }
    return result.toArray(new Integer[0]);
  }
}
