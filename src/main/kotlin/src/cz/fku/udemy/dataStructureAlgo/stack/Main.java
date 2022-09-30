package cz.fku.udemy.dataStructureAlgo.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {
        Deque<Character> stackL = new LinkedList<>();
        Deque<Character> stackR = new LinkedList<>();

        char[] charArray = string.toCharArray();

        for (char c : charArray) {
            if (doNotSkip(c))
                stackL.push(Character.toLowerCase(c));
        }


        for (char c : charArray) {
            if (doNotSkip(c)) {
                if(Character.toLowerCase(c) != stackL.pop()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printStack(Deque<Character> stack) {
        for (Character c : stack){
            System.out.print(c);
        }
        System.out.println();
    }

    private static boolean doNotSkip(char c) {
        return c != ' ' &&
                c != '?' &&
                c != '\'' &&
                c != '.';
    }
}
