package com.pctf.datastructures.hash;

public class QuadraticProbingHashTable<AnyType> implements MyHashTable<AnyType>{
    public QuadraticProbingHashTable() {
        this(DEFAULT_SIZE);
    }

    public QuadraticProbingHashTable(int size) {
        allocateArray(size);
        makeEmpty();
    }


    @Override
    public void insert(AnyType value) {
        int position = findPosition(value);
        if(isActive(position)) {
            return;
        }
        this.array[position] = new HashEntry<>(value);
        currentSize ++;
        if (currentSize > array.length / 2) {
            reHash();
        }
    }

    @Override
    public void remove(AnyType value) {
        int position = findPosition(value);
        if(isActive(position)) {
            this.array[position].isActive = false;
        }
    }

    @Override
    public boolean contains(AnyType value) {
        return isActive(findPosition(value));
    }

    @Override
    public void makeEmpty() {
        for(int i = 0; i < this.array.length; i++) {
            this.array[i] = null;
        }
    }

    private static class HashEntry<AnyType> {
        boolean isActive;
        AnyType value;
        HashEntry(AnyType value) {
            this(value, true);
        }
        HashEntry(AnyType value, boolean isActive) {
            this.value = value;
            this.isActive = isActive;
        }
    }

    private HashEntry<AnyType>[] array;

    private int currentSize;

    private static final int DEFAULT_SIZE = 101;

    private void allocateArray(int size) {
        this.array = new HashEntry[nextPrime(size)];
    }

    private boolean isActive(int postion) {
        return array[postion] != null && array[postion].isActive;
    }

    private int findPosition(AnyType value) {
        int offSet = 1;
        int currentPosition = myHash(value);
        while (array[currentPosition] != null && !array[currentPosition].value.equals(value)) {
            currentPosition += offSet;
            offSet += 2;
            if(currentPosition >= array.length) {
                currentPosition -= array.length;
            }
        }
        return currentPosition;
    }

    private void reHash() {
        HashEntry<AnyType>[] oldArray = this.array;
        allocateArray(nextPrime(oldArray.length * 2));
        currentSize = 0;
        for(int i = 0; i < oldArray.length; i++) {
            if(oldArray[i] != null && oldArray[i].isActive) {
                insert(oldArray[i].value);
            }
        }
    }

    private int myHash(AnyType value) {
        int hashValue = value.hashCode() % array.length;
        return hashValue < 0 ? hashValue : array.length + hashValue;
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
