package org.example;

public class Lesson12junit5 {

    public static long getFactorial(long number) {
        if (number <= 1) return 1;
        else return number * getFactorial(number - 1);
    }
}