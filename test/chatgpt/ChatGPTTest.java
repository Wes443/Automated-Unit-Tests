// ChatGPT-generated tests for Stack.java
// Uses JUnit 5 (jupiter)

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChatGPTTest {

    @Test
    @DisplayName("New stack is empty with size 0 and not full")
    void newStackState() {
        Stack s = new Stack(3);
        assertTrue(s.isEmpty(), "New stack should be empty");
        assertEquals(0, s.size(), "New stack size should be 0");
        assertFalse(s.isFull(), "New stack should not be full");
    }

    @Test
    @DisplayName("Push up to capacity makes stack full")
    void pushToCapacity() {
        Stack s = new Stack(2);
        s.push(1);
        assertFalse(s.isFull());
        s.push(2);
        assertTrue(s.isFull(), "Stack should be full after pushing capacity elements");
        assertEquals(2, s.size());
    }

    @Test
    @DisplayName("Push beyond capacity throws IllegalStateException")
    void pushOverflow() {
        Stack s = new Stack(1);
        s.push(42);
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> s.push(7));
        assertEquals("Stack is full", ex.getMessage());
        assertEquals(1, s.size(), "Size should remain at capacity after failed push");
    }

    @Test
    @DisplayName("Pop returns last pushed value and decreases size (LIFO)")
    void popLifo() {
        Stack s = new Stack(5);
        s.push(10);
        s.push(20);
        s.push(30);
        assertEquals(30, s.pop());
        assertEquals(20, s.pop());
        assertEquals(1, s.size());
        assertFalse(s.isEmpty());
        assertEquals(10, s.pop());
        assertTrue(s.isEmpty(), "Stack should be empty after popping all elements");
    }

    @Test
    @DisplayName("Popping from empty stack throws IllegalStateException")
    void popUnderflow() {
        Stack s = new Stack(2);
        IllegalStateException ex = assertThrows(IllegalStateException.class, s::pop);
        assertEquals("Stack is empty", ex.getMessage());
    }

    @Test
    @DisplayName("Peek returns top without removing")
    void peekDoesNotRemove() {
        Stack s = new Stack(3);
        s.push(5);
        s.push(9);
        assertEquals(9, s.peek());
        assertEquals(2, s.size(), "Peek must not remove the element");
        assertEquals(9, s.peek(), "Consecutive peeks should return the same top");
    }

    @Test
    @DisplayName("Peeking from empty stack throws IllegalStateException")
    void peekUnderflow() {
        Stack s = new Stack(1);
        IllegalStateException ex = assertThrows(IllegalStateException.class, s::peek);
        assertEquals("Stack is empty", ex.getMessage());
    }
}
