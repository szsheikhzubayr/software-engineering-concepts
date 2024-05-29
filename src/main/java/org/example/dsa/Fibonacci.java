package org.example.dsa;

public class Fibonacci {
    public static int fib(int n){
        if(n<=1)
            return n;

        int fib = 1, prevFib = 1;

        for (int i = 2; i < n; i++){
            int temp = fib;
            fib+= prevFib;
            prevFib = temp;
        }

        return fib;
    }

    public static void main(String[] args) {
        System.out.println(fib(7));
    }
}
