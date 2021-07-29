package com.study.problems;

class AddStrings {

    public static void main(String[] args) {
        System.out.println(addStrings("45678", "1233"));
    }

    public static String addStrings(String num1, String num2) {

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        boolean addTen = false;
        int i = 0;
        char x = 'x';
        StringBuilder sb = new StringBuilder();

        while(true) {

            char c1 = x;
            char c2 = x;

            if(i < num1.length()) {
                c1 = num1.charAt(i);
            }
            if(i < num2.length()) {
                c2 = num2.charAt(i);
            }

            if(!addTen && (c1 == x || c2 == x)) {

                if(c1 == x && c2 == x) {
                    // do nothing
                } else if (c1 == x) {
                    sb.append(num2.substring(i));
                } else {
                    sb.append(num1.substring(i));
                }
                break;

            } else {
                int i1 = c1 == x ? 0 : Character.getNumericValue(c1);
                int i2 = c2 == x ? 0 : Character.getNumericValue(c2);

                int sum = i1 + i2;

                if(addTen) {
                    sum += 1;
                    addTen = false;
                }

                if(sum >= 10) {
                    addTen = true;
                }

                sb.append(sum % 10);
                i++;
            }
        }

        return sb.reverse().toString();
    }
}
