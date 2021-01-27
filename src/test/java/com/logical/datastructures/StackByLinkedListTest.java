package com.logical.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class StackByLinkedListTest {
    StackByLinkedList<String> stack=null;

    @BeforeEach
    void setUp() {
        stack = new StackByLinkedList<>();
    }

    @Test
    void stackSize_emptyStack() {
        assertEquals(0, stack.size());
    }

    @Test
    @DisplayName("Stack size should be 2 after inserting 2 elements")
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
    void stackPeek_withNoElements() {
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }

    @Test
    void stackPush_withOneElements() {
        stack.push("Jack");
        assertEquals("Jack", stack.peek());
        assertEquals("Jack", stack.pop());
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
