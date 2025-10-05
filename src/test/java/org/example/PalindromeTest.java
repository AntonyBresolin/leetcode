package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    @Test
    void isPalindrome_should_true() {
        int palindromoINT = 212;
        assertTrue(Palindrome.isPalindrome(palindromoINT));
    }

    @Test
    void isPalindrome_should_false() {
        int palindromoINT = 2121;
        assertFalse(Palindrome.isPalindrome(palindromoINT));
    }

    @Test
    void isPalindrome_should_false_less_zero() {
        int palindromoINT = -2;
        assertFalse(Palindrome.isPalindrome(palindromoINT));
    }

}