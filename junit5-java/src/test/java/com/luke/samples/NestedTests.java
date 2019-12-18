package com.luke.samples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Nested Test")
public class NestedTests {

    Stack<Integer> stack;

    @Test
    @DisplayName("Stack 생성 테스트")
    void newStackTest() {
        new Stack<>();
    }

    @Nested
    @DisplayName("Stack 생성 후 테스트")
    class afterNewStack {

        @BeforeEach
        void newStack() {
            stack = new Stack<>();
        }

        @Test
        @DisplayName("Empty 테스트")
        void isEmpty() {
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("Empty 상태일 때 Pop 하는 경우 EmptyStackException 예외 테스트")
        void throwsEmptyStackExceptionWhenPopped() {
            assertThrows(EmptyStackException.class, stack::pop);
        }

        @Test
        @DisplayName("Empty 상태일 때 Peek 하는 경우 EmptyStackException 예외 테스트")
        void throwsEmptyStackExceptionWhenPeeked() {
            assertThrows(EmptyStackException.class, stack::peek);
        }

        @Nested
        @DisplayName("Push 후 테스트")
        class afterPushing {

            Integer number = 1234;

            @BeforeEach
            void pushNumber() {
                stack.push(number);
            }

            @Test
            @DisplayName("Empty 테스트")
            void isNotEmpty() {
                assertFalse(stack::isEmpty);
            }

            @Test
            @DisplayName("Pop 후 Empty 테스트")
            void returnNumberWhenPopped() {
                assertEquals(number, stack.pop());
                assertTrue(stack.isEmpty());
            }

            @Test
            @DisplayName("Peek 후 Empty 테스트")
            void returnNumberWhenPeeked() {
                assertEquals(number, stack.peek());
                assertFalse(stack.isEmpty());
            }
        }
    }
}
