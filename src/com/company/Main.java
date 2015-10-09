package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        if (a >= Long.parseUnsignedLong(Integer.toBinaryString(-1), 2) || a < 0 ||
                b >= Long.parseUnsignedLong(Integer.toBinaryString(-1), 2) || b < 0) {
            throw new NumberFormatException();
        }

        int nonMatchingBits = Long.toBinaryString(a ^ b).replace("0", "").length();
        double percentMatchingBits = ((32.0 - nonMatchingBits) / 32) * 100;
        long avoidA = Long.parseUnsignedLong(Long.toBinaryString(~a).substring(32), 2);
        long avoidB = Long.parseUnsignedLong(Long.toBinaryString(~b).substring(32), 2);

        System.out.println(percentMatchingBits + "% of compatibility");
        System.out.println(a + " should avoid " + avoidA);
        System.out.println(b + " should avoid " + avoidB);
    }
}
