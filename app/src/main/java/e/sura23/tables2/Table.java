package e.sura23.tables2;

/**
 * Created by SURA23 on 7/7/2018.
 */

public class Table {

    static int multiply = 2;
    static int result;

    static String numberTwoTable(int position) {
        switch (position) {
            case 0:
                result = multiply * 1;
                return multiply + " *  1 = " + result;
            case 1:
                result = multiply * 2;
                return multiply + " *  2 = " + result;
            case 2:
                result = multiply * 3;
                return multiply + " *  3 = " + result;
            case 3:
                result = multiply * 4;
                return multiply + " *  4 = " + result;
            case 4:
                result = multiply * 5;
                return multiply + " *  5 = " + result;
            case 5:
                result = multiply * 6;
                return multiply + " *  6 = " + result;
            case 6:
                result = multiply * 7;
                return multiply + " *  7 = " + result;
            case 7:
                result = multiply * 8;
                return multiply + " *  8 = " + result;
            case 8:
                result = multiply * 9;
                return multiply + " *  9 = " + result;
            case 9:
                result = multiply * 10;
                return multiply + " *  10 = " + result;
            case 10:
                result = multiply * 11;
                return multiply + " *  11 = " + result;
            case 11:
                result = multiply * 12;
                return multiply + " *  12 = " + result;
            case 12:
                result = multiply * 13;
                return multiply + " *  13 = " + result;
            case 13:
                result = multiply * 14;
                return multiply + " *  14 = " + result;
            case 14:
                result = multiply * 15;
                return multiply + " *  15 = " + result;

            default:
                return "Table";
        }
    }

    static String textTwoTable() {
        int number = result;
        String text;

        final String[] ones = {
                "",
                "One",
                "Two",
                "Three",
                "Four",
                "Five",
                "Six",
                "Seven",
                "Eight",
                "Nine",
                "Ten",
                "Eleven",
                "Twelve",
                "Thirteen",
                "Fourteen",
                "Fifteen",
                "Sixteen",
                "Seventeen",
                "Eighteen",
                "Nineteen",
        };

        final String[] Tens = {

                "",
                "Ten",
                "Twenty",
                "Thirty",
                "Forty",
                "Fifty",
                "sixty",
                "Seventy",
                "Eighty",
                "Ninety",
        };

        if ((number % 100) < 20) {
            text = ones[number % 1000];
            number /= 100;
        } else {
            text = ones[number % 10];
            number /= 10;
            text = Tens[number % 10] + text;
            number /= 10;
        }
        if (number == 0) {
            return text;
        }
        return ones[number] + "Hundred" + text;
    }


}
