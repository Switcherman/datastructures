package com.pctf.datastructures.hash;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 分离连接哈希表
 * 散列到同一个值的所有元素保留到一个表中,此处使用标准库的LinkedList实现
 * @param <AnyType>
 */
public class SeparateChainingHashTable<AnyType> implements MyHashTable<AnyType>{
    public SeparateChainingHashTable() {
        this(DEFAULT_SIZE);
    }

    public SeparateChainingHashTable(int size) {
        theList = new LinkedList[nextPrime(size)];
        for(List<AnyType> list : theList) {
            list = new ArrayList<>();
        }
    }

    @Override
    public void insert(AnyType value) {
        List<AnyType> currentList = theList[myHash(value)];
        if(!currentList.contains(value)) {
            currentList.add(value);
            if(++currentSize > theList.length){ // 此处装填因子为1
                reHash();
            }
        }
    }

    @Override
    public void remove(AnyType value) {
        List<AnyType> currentList = theList[myHash(value)];
        if(currentList.contains(value)) {
            currentList.remove(value);
            currentSize--;
        }
    }

    @Override
    public boolean contains(AnyType value) {
        List<AnyType> currentList = theList[myHash(value)];
        return currentList.contains(value);
    }

    @Override
    public void makeEmpty() {
        currentSize = 0;
        for(List<AnyType> list : theList) {
            list = new LinkedList<>();
        }
    }

    private List<AnyType>[] theList;

    private static final int DEFAULT_SIZE = 101;

    private int currentSize;

    private int myHash(AnyType value) {
        int hashVal = value.hashCode();
        hashVal %= theList.length;
        return hashVal < 0 ? theList.length + hashVal : hashVal;
    }

    private void reHash() {
        List<AnyType>[] oldList = theList;
        theList = new LinkedList[nextPrime(theList.length * 2)];
        for(int i = 0; i < theList.length; i++) {
            theList[i] = new LinkedList<>();
        }
        currentSize = 0;
        for (int i = 0; i < oldList.length; i++) {
            for(AnyType value : oldList[i]) {
                insert(value);
            }
        }
    }

    private int nextPrime(int i) {
        return isPrime(i) ? i : nextPrime(++i);
    }

    public boolean isPrime(int i) {
        if (i <= 1 || i % 2 == 0) {
            return false;
        }
        for (int j = 3; j < i; j += 2) {
            if( i % j == 0) {
                return false;
            }
        }
        return true;
    }

}
