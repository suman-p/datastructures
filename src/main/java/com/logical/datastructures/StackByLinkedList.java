package com.logical.datastructures;

import com.physical.datastructures.SingleLinkedList;

import java.util.EmptyStackException;

public class StackByLinkedList<T> {
    SingleLinkedList<T> singleLinkedList;

    public StackByLinkedList() {
        this.singleLinkedList = new SingleLinkedList<>();
    }

    private boolean isStackEmpty(){
        return singleLinkedList.getHead() == null;
    }

    public void push(T element){
        singleLinkedList.insert(element, 0);
    }

    public T pop(){
        if (isStackEmpty())
            throw new EmptyStackException();
        else {
            T value = singleLinkedList.getHead().getValue();
            singleLinkedList.delete(0);
            return value;
        }
    }

    public T peek(){
        if (isStackEmpty())
            throw new EmptyStackException();
        else {
            return singleLinkedList.getHead().getValue();
        }
    }

    public int size(){
        if (isStackEmpty()) {
            return 0;
        }
        else
            return singleLinkedList.getSize();
    }
}
