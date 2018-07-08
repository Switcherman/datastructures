package com.pctf.datastructures.heap;


public class BinaryHeap<AnyType extends Comparable<? super AnyType>> implements MyHeap<AnyType > {

    public BinaryHeap(){
        this(DEFAULT_SIZE);
    }

    public BinaryHeap(int size) {
        this.array = (AnyType[]) new Comparable[size + 1];
    }

    public BinaryHeap(AnyType[] values) {
        this.currentSize = values.length;
        this.array = (AnyType[]) new Comparable[(currentSize * 2) / 11];
        int i = 1;
        for(AnyType item : values) {
            this.array[i++] = item;
        }
        buildHeap();
    }

    @Override
    public void insert(AnyType value) {
        if(currentSize == this.array.length - 1) {
            enlargeArray(2 * this.array.length + 1);
        }
        int hole = ++currentSize;
        for(array[0] = value; value.compareTo(array[hole / 2]) < 0; hole /= 2) {
            array[hole] = array[hole / 2];
        }
        array[hole] = value;
    }

    @Override
    public AnyType findMin() {
        if(isEmpty()) {
            throw new NullPointerException();
        }
        return array[1];
    }

    @Override
    public AnyType deleteMin() {
        if(isEmpty()) {
            throw new NullPointerException();
        }
        AnyType min = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return min;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public void makeEmpty() {

    }

    private int currentSize = 0;

    private static final int DEFAULT_SIZE = 10;

    private AnyType[] array;

    private void buildHeap() {
        for(int i = currentSize / 2; i > 0; i--){
            percolateDown(i);
        }
    }

    /**
     * 下浮
     * @param hole
     */
    private void percolateDown(int hole) {
        AnyType temp = this.array[hole];
        int child;
        for(; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if(child != currentSize && this.array[child + 1].compareTo(this.array[child]) < 0) {
                child ++;
            }
            if(array[child].compareTo(temp) < 0) {
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = temp;
    }

    private void enlargeArray(int size) {
        AnyType[] oldArray = this.array;
        this.array = (AnyType[]) new Comparable[size];
        for(int i = 0; i < oldArray.length; i++) {
            this.array[i] = oldArray[i];
        }
    }
}
