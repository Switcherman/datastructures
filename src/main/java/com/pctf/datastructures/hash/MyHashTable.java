package com.pctf.datastructures.hash;

public interface MyHashTable<AnyType> {
     void insert(AnyType value);

     void remove(AnyType value);

     boolean contains(AnyType value);
     void makeEmpty();
}
