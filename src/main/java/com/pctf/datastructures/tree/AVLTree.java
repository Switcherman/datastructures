package com.pctf.datastructures.tree;

public class AVLTree<AnyType extends Comparable<? super AnyType>> {
    private static class AVLNode<AnyType> {
        AnyType element;
        AVLNode<AnyType> left;
        AVLNode<AnyType> right;
        int height;
        AVLNode(AnyType value){
           this(value, null, null);
        }
        AVLNode(AnyType value, AVLNode<AnyType> left, AVLNode<AnyType> right){
            this.element = value;
            this.right = right;
            this.left = left;
            this.height = 0;
        }
    }

    private AVLNode<AnyType> root;

    private static final int ALLOWED_IMBALANCE = 1;

    private int height(AVLNode<AnyType> node){
        return node == null ? -1 : node.height;
    }

    private AVLNode<AnyType> insert(AnyType value, AVLNode<AnyType> node){
        if (node == null) {
            return new AVLNode<AnyType>(value, null, null);
        }
        int compareResult = value.compareTo(node.element);
        if(compareResult > 0){
            node.right = insert(value, node.right);
        } else if(compareResult < 0){
            node.left = insert(value, node.left);
        }
        return balance(node);
    }

    private AVLNode<AnyType> balance(AVLNode<AnyType> node) {
        if(node == null){
            return null;
        }
        if(height(node.left) - height(node.right) > ALLOWED_IMBALANCE){
            if(height(node.left.left) - height(node.left.right) >= ALLOWED_IMBALANCE){
                rotatedWithLeftChild(node);
            } else {
                doubleWithLeftChild(node);
            }
        } else if(height(node.right) - height(node.left) > ALLOWED_IMBALANCE){
            if(height(node.right.right) - height(node.right.left) >= ALLOWED_IMBALANCE){
                rotatedWithRightChild(node);
            } else{
                doubleWithRightChild(node);
            }
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    private AVLNode<AnyType> remove(AnyType value, AVLNode<AnyType> node){
        if(node ==null){
            return node;
        }
        int compareResult = value.compareTo(node.element);
        if(compareResult > 0){
            node.right = remove(value, node.right);
        }else if (compareResult < 0){
            node.left = remove(value, node.left);
        } else if(node.left != null && node.right != null){
            node.element = findMin(node.right).element;
            node.right = remove(node.element, node.right);
        } else {
            node = node.left == null ? node.left : node.right;
        }
        return balance(node);
    }

    private AVLNode<AnyType> findMin(AVLNode<AnyType> node){
        if(node.left != null){
            return findMin(node.left);
        } else {
            return node;
        }
    }

    private AVLNode<AnyType> rotatedWithLeftChild(AVLNode<AnyType> k2){
        AVLNode<AnyType> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private AVLNode<AnyType> rotatedWithRightChild(AVLNode<AnyType> k2){
        AVLNode<AnyType> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private AVLNode<AnyType> doubleWithLeftChild(AVLNode<AnyType> k3){
        k3.left = rotatedWithRightChild(k3.right);
        return rotatedWithLeftChild(k3);
    }

    private AVLNode<AnyType> doubleWithRightChild(AVLNode<AnyType> k3){
        k3.right = rotatedWithLeftChild(k3.left);
        return rotatedWithRightChild(k3);
    }

}
