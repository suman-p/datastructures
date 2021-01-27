package com.logical.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class StackByArrayTest {
    StackByArray<String> stack=null;

    @BeforeEach
    void setUp() {
        stack = new StackByArray<String>(2);
    }

    @Test
    void stackSize_emptyStack() {
        assertEquals(0, stack.size());
    }

    @Test
    void stackSize_withTwoElements() {
        stack.push("Jack");
        stack.push("Jill");
        assertEquals(2, stack.size());
    }

    @Test
    void stackPeek_withOneElements() {
        stack.push("Jack");
        assertEquals("Jack", stack.peek());
    }

    @Test
    void stackDelete() {
        stack.deleteStack();
        assertEquals(0, stack.size());
    }

    @Test
    void stackPeek_withNoElements() throws EmptyStackException {
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }

    @Test
    void stackPush_withOneElements() {
        stack.push("Jack");
        assertEquals("Jack", stack.peek());
        assertEquals("Jack", stack.pop());
    }

    @Test
    void stackPush_moreThanSize() {
        stack.push("Jack");
        stack.push("Jill");
        assertThrows(StackOverflowError.class, () -> stack.push("John"));
    }

    @Test
    void stackPop_oneElement() {
        stack.push("Jack");
        assertEquals("Jack", stack.pop());
    }

    @Test
    void stackPop_noElements() {
        stack.push("Jack");
        stack.push("Jill");
        stack.pop();
        stack.pop();
        assertThrows(EmptyStackException.class, ()-> stack.pop());
    }
}
