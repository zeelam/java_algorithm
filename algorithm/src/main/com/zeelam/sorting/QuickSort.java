package com.zeelam.sorting;

public class QuickSort extends Sorting{

  @Override
  protected void sort() {
    sort(0, array.length);
  }

  private void sort(int begin, int end) {
    if (end - begin < 2) return;
    int mid = pivotIndex(begin, end);
    sort(begin, mid);
    sort(mid + 1, end);
  }

  private int pivotIndex(int begin, int end) {
    swap(begin, begin + (int)(Math.random() * (end - begin)));

    int pivotValue = array[begin];
    end--;
    while (begin < end) {
      while (begin < end) {
        if (cmpElements(pivotValue, array[end]) < 0) {
          end--;
        } else {
          array[begin++] = array[end];
          break;
        }
      }
      while (begin < end) {
        if (cmpElements(pivotValue, array[begin]) > 0) {
          begin++;
        } else {
          array[end--] = array[begin];
          break;
        }
      }
    }
    array[begin] = pivotValue;
    return begin;
  }


}
