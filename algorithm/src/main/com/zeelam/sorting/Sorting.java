package com.zeelam.sorting;

import java.text.DecimalFormat;

public abstract class Sorting implements Comparable<Sorting> {
  protected Integer[] array;
  private int cmpCount;
  private int swapCount;
  private long time;
  private final DecimalFormat fmt = new DecimalFormat("#.00");

  private String numberString(int number) {
    if (number < 10000) return "" + number;
    if (number < 1000000) return fmt.format(number / 1000.0) + "Thousand";
    if (number < 100000000) return fmt.format(number / 1000000.0) + "Million";
    return fmt.format(number / 1000000000.0) + "Billion";
  }

  public void sort(Integer[] array) {
    if (array == null || array.length < 2) return;
    this.array = array;
    long begin = System.currentTimeMillis();
    sort();
    time = System.currentTimeMillis() - begin;
  }

  @Override
  public int compareTo(Sorting obj) {
    return (int)(time - obj.time);
  }

  protected abstract void sort();

  protected int cmp(int i1, int i2) {
    cmpCount++;
    return array[i1] - array[i2];
  }

  protected int cmpElements(Integer v1, Integer v2) {
    cmpCount++;
    return v1 - v2;
  }

  protected void swap(int i1, int i2) {
    swapCount++;
    int tmp = array[i1];
    array[i2] = array[i1];
    array[i1] = tmp;
  }

  @Override
  public String toString() {
    String timeStr = "耗时： " + (time / 1000.0) + "s(" + time + "ms)";
    String compareCountStr = "比较: " + numberString(cmpCount);
    String swapCountStr = "交换: " + numberString(swapCount);
    return "[" + getClass().getSimpleName() +"] \n"
           + timeStr + " \t"
           + compareCountStr + " \t"
           + swapCountStr + " \n"
           + "---------------------------------------------------------------";
  }
}
