package com.logical.datastructures;

import java.util.EmptyStackException;

/*
Stack can be implemented using Array or Linked List

Array:
Adv: Easy to implement
DisAdv: Fixed Size

LinkedList:
Adv: Variable Size
DisAdv: Complex implementation compared to Array

*/
public class StackByArray<T> {

    private T [] arr;
    private int topOfStack;

    public StackByArray(int size) {
        this.arr = (T[]) new Object[size];
        this.topOfStack=-1;
    }

    public void push(T element) throws StackOverflowError {
        if (isStackFull())
            throw new StackOverflowError("Stack is full");
        else {
            arr[++topOfStack] = element;
        }
    }

    public T pop() throws EmptyStackException {
        if (isStackEmpty())
            throw new EmptyStackException();
        else {
            return this.arr[topOfStack--];
        }
    }

    public T peek() throws EmptyStackException {
        if (isStackEmpty())
            throw new EmptyStackException();
        else
            return this.arr[topOfStack];
    }

    public int size(){
        if (isStackEmpty()) {
            return 0;
        }
        else
            return arr.length;
    }

    public void deleteStack(){
        arr = null;
    }

    private boolean isStackFull(){
        return topOfStack == arr.length - 1;
    }

    private boolean isStackEmpty(){
        return topOfStack == -1;
    }
}



