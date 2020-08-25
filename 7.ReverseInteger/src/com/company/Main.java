package com.company;

public class Main {
    public static int reverse(int x) {
        long num = x;
        long result = 0;
        while (num != 0) {
            result= 10 * result + num % 10;
            num = num/10;
        }
        int check = (int)result;
        if ((long)check != result){
            return 0;
        }
        else{
            return check;
        }
    }

    public static void main(String[] args) {
        int num = 120;
        int result = reverse(num);
        System.out.println(result);
    }
}
