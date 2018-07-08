package com.pctf.algorithm.sort;

public interface Sorter {

   <AnyType extends Comparable< ? super AnyType>> void sort(AnyType[] array);

}
