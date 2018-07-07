package com.pctf.datastructures.tree;

import org.omg.CORBA.Any;

public class BinaryTree<AnyType extends Comparable<? super AnyType>> {
    private BinaryNode<AnyType> root;
    private static class BinaryNode<AnyType> {
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
        BinaryNode(AnyType element){
            this(element, null, null);
        }
        BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right){
            this.left = left;
            this.right = right;
            this.element = element;
        }
    }

    public BinaryTree(){
        this.root = null;
    }

    public void makeEmpty(){
        this.root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void insert(AnyType value){
        this.root = this.insert(value, this.root);
    }

    private BinaryNode<AnyType> insert(AnyType value, BinaryNode<AnyType> node){
        if(node == null) {
            return new BinaryNode<>(value,null,null);
        }
        int compareResult = value.compareTo(node.element);
        if(compareResult > 0){// 插入值大于当前节点值,插入右节点
            node.right = insert(value, node.right);
        } else if (compareResult < 0){// 插入值小于当前节点值,插入左节点
            node.left = insert(value, node.left);
        } else {// 做一些更新操作

        }
        return node;
    }

    public void remove(AnyType t){
        this.root = this.remove(t, this.root);
    }

    private BinaryNode<AnyType> remove(AnyType value, BinaryNode<AnyType> node){
        if(node == null){
            return null;
        }
        int compareResult = value.compareTo(node.element);
        if(compareResult > 0){
            node.right = remove(value, node.right);
        } else if(compareResult < 0) {
            node.left = remove(value, node.left);
        } else if (node.left != null && node.right != null){
            node.element = findMin(node.right).element;
            node.right = remove(node.element, node.right);
        } else {
            node = node.left != null ? node.left : node.right;
        }
        return node;
    }

    public boolean contains(AnyType value){
        return this.contains(value, this.root);
    }

    public AnyType findMin(){
        if(root == null){
            throw new NullPointerException();
        }
        return this.findMin(this.root).element;
    }

    private boolean contains(AnyType value, BinaryNode<AnyType> root){
        if(root == null){
            return false;
        }
        int compareResult = value.compareTo(root.element);
        if(compareResult > 0){// 大于节点值,递归右子树
            return contains(value, root.right);
        } else if (compareResult < 0) {// 小于节点值,递归左子树
            return contains(value, root.left);
        } else {
            return true;
        }
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> node){
        if(node.left != null){
            return findMin(node.left);
        } else {
            return node;
        }
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(BinaryNode<AnyType> root) {
        if(root != null) {
            printTree(root.left);
            System.out.println(root.element);
            printTree(root.right);
        }
    }

    public int height(){
        return height(root);
    }

    private int height(BinaryNode<AnyType> root) {
        if(root == null){
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

}
