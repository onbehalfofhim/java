package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumbersToWords {
    private static final String[] ones = new String[]{"", "one ", "two ", "three ", "four ", "five ",
            "six ", "seven ", "eight ", "nine "};
    private static final String[] teens = new String[]{"", "eleven ", "twelve ", "thirteen ", "fourteen ",
            "fifteen ", "sixteen ", "seventeen ", "eighteen ", "nineteen "};
    private static final String[] tens = new String[]{"", "ten", "twenty ", "thirty ", "fourty ", "fifty ",
            "sixty ", "seventy ", "eighty ", "ninety "};
    private static final String[] orders = new String[]{"", "thousand ", "million ", "billion ",
            "billiard ", "trillion "};

    public static String toString(long n) {
        boolean negative = false;
        if (n < 0) {
            negative = true;
            n *= -1;
        }

        List<String> result = new ArrayList<>();

        if (n != 0) {
            int ord = 0;
            int e = (int) n % 10;
            int d = (int) n / 10 % 10;
            ;
            int sot = (int) n / 100 % 10;

            do {
                if (d != 1) {
                    if ((e != 0) || (d != 0) || (sot != 0)) {
                        result.add(orders[ord]);
                        result.add(ones[e]);
                        result.add(tens[d]);
                    }
                } else {
                    if (e == 0) {
                        result.add(tens[d]);
                    } else {
                        result.add(orders[ord]);
                        result.add(teens[e]);
                    }
                }

                if (sot != 0) {
                    result.add("hundred ");
                    result.add(ones[sot]);
                }

                n = n / 1000;
                e = (int) n % 10;
                d = (int) n / 10 % 10;
                sot = (int) n / 100 % 10;
                ++ord;
            } while (n != 0);
        } else {
            result.add("zero");
        }

        if (negative) {
            result.add("minus ");
        }

        StringBuilder res = new StringBuilder("");
        for (int i = result.size(); i > 0; --i) {
            res.append(result.get(i - 1));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number: ");
        long n = input.nextLong();

        String s = toString(n);

        System.out.println(s);
    }
}
