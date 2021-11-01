package com.zeelam.sorting;

public class HeapSort extends Sorting {

  private int heapSize;

  @Override
  protected void sort() {
    heapSize = array.length;
    for (int i = (heapSize >> 1) -1; i >= 0; i--) {
      siftDown(i);
    }
    while (heapSize > 1) {
      swap(0, --heapSize);
      siftDown(0);
    }
  }

  private void siftDown(int index) {
    Integer element = array[index];
    int half = heapSize >> 1;
    while (index < half) {
      int childIndex = (index << 1) + 1;
      Integer child = array[childIndex];

      int rightIndex = childIndex + 1;
      if (rightIndex < heapSize && cmpElements(array[rightIndex], child) > 0) {
        child = array[childIndex = rightIndex];
      }

      if (cmpElements(element, child) >= 0) break;

      array[index] = child;
      index = childIndex;
    }
    array[index] = element;
  }

}
