package com.zeelam.sorting;

public class BubbleSort2 extends Sorting{

  @Override
  protected void sort() {
    for (int end = array.length - 1; end > 0; end--) {
      boolean sorted = true;
      for (int begin = 1; begin <= end; begin++) {
        if (cmp(begin, begin - 1) < 0) {
          swap(begin, begin - 1);
          sorted = false;
        }
      }
      if (sorted) break;
    }
  }

}
