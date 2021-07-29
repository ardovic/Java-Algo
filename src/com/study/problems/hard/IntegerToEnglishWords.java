package com.study.problems.hard;

public class IntegerToEnglishWords {

    static String[] ones = new String[]{"One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
    static String[] teens = new String[]{"Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    static String[] twenties = new String[]{"Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};

    static String zero = "Zero";
    static String hundred = "Hundred ";
    static String thousand = "Thousand ";
    static String million = "Million ";
    static String billion = "Billion ";

    public static void main(String[] args) {
        System.out.println(numberToWords(Integer.MAX_VALUE));
        System.out.println(numberToWords(0));
        System.out.println(numberToWords(1231));
        System.out.println(numberToWords(1000010));
        System.out.println(numberToWords(99999999));
    }

    public static String numberToWords(int num) {
        if (num == 0) return zero;

        StringBuilder sb = new StringBuilder();

        processParts(sb, num / 1_000_000_000, billion);
        processParts(sb, num / 1_000_000, million);
        processParts(sb, num / 1_000, thousand);
        processParts(sb, num, null);

        return sb.toString().trim();
    }

    public static void processParts(StringBuilder sb, int input, String name) {
        int threeDigit = input % 1_000;

        if (threeDigit > 0) {

            if (threeDigit >= 100) {
                sb.append(ones[(threeDigit / 100) - 1]);
                sb.append(hundred);
            }

            if (threeDigit % 100 >= 20) {
                sb.append(twenties[((threeDigit % 100) / 10) - 2]);

                if (threeDigit % 10 != 0) {
                    sb.append(ones[(threeDigit % 10) - 1]);
                }

            } else if (threeDigit % 100 < 20 && threeDigit % 100 >= 10) {
                sb.append(teens[(threeDigit % 100) - 10]);
            } else if (threeDigit % 100 < 10 && threeDigit % 100 > 0) {
                sb.append(ones[(threeDigit % 100) - 1]);
            }

            if (name != null) {
                sb.append(name);
            }
        }
    }
}
