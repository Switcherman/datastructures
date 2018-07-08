package com.pctf.datastructures.heap;

public interface MyHeap<AnyType extends Comparable<? super AnyType>> {

    void insert(AnyType value);

    AnyType findMin();

    AnyType deleteMin();

    boolean isEmpty();

    void makeEmpty();


}
