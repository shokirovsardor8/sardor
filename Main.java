
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int x = 100;
        System.out.printf("Printing simple integer: x = %d\n", x);

        // this will print it upto 2 decimal places
        System.out.printf("Formatted with precison: PI = %.2f\n", Math.PI);

        float n = 5.2f;

        // automatically appends zero to the rightmost part of decimal
        System.out.printf("Formatted to specific width: n = %.4f\n", n);

        n = 2324435.3f;

        // here number is formatted from right margin and occupies a
        // width of 20 characters
        System.out.printf("Formatted to right margin: n = %20.4f\n", n);
    }






    public static void numberToText() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Butun son kiriting: ");
        String num = scanner.nextLine();
        num = fillWithZero(num);

        String[] numArrStr = strToArr(num);
        String[] numArrText = strToArr(num);

        for (int i = 0; i < numArrStr.length; i++) {
            numArrText[i] = threeRoomToText(numArrStr[i]);
            if (!numArrStr[i].equals("000")) {
                numArrText[i] += placeValue(i);
            }
        }
        String numberToText = arrToStr(numArrText);
        System.out.println(numberToText);

    }

    public static String arrToStr(String[] numStr) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numStr.length; i++) {
            s.append(numStr[numStr.length - i - 1]);
        }
        return s.toString();
    }

    public static String placeValue(int i) {
        String s = "";
        switch (i) {
            case 0:
                s = "";
                break;
            case 1:
                s = "ming ";
                break;
            case 2:
                s = "million ";
                break;
            case 3:
                s = "milliard ";
                break;
            case 4:
                s = "trillion ";
                break;
            case 5:
                s = "kvadrillion ";
        }
        return s;
    }

    public static String fillWithZero(String num) {
        if (num.length() % 3 == 1) {
            num = "00".concat(num);
        }
        if (num.length() % 3 == 2) {
            num = "0".concat(num);
        }
        return num;
    }

    public static String singular(int n) {
        switch (n) {
            case 1:
                return "bir ";
            case 2:
                return "ikki ";
            case 3:
                return "uch ";
            case 4:
                return "to'rt ";
            case 5:
                return "besh ";
            case 6:
                return "olti ";
            case 7:
                return "yetti ";
            case 8:
                return "sakkiz ";
            case 9:
                return "to'qqiz ";
        }
        return "";
    }

    public static String decimal(int n) {
        switch (n) {
            case 1:
                return "o'n ";
            case 2:
                return "yigirma ";
            case 3:
                return "o'ttiz ";
            case 4:
                return "qirq ";
            case 5:
                return "ellik ";
            case 6:
                return "oltmish ";
            case 7:
                return "yetmish ";
            case 8:
                return "sakson ";
            case 9:
                return "to'qson ";
        }
        return "";
    }

    public static String[] strToArr(String num) {
        String[] numArr = new String[num.length() / 3];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = num.substring(num.length() - i * 3 - 3, num.length() - i * 3);
        }
        return numArr;
    }

    public static String threeRoomToText(String num3) {
        String s = "";
        s += singular(Integer.parseInt(num3.substring(0, 1)));
        if (Integer.parseInt(num3.substring(0, 1)) != 0) {
            s += "yuz ";
        }
        s += decimal(Integer.parseInt(num3.substring(1, 2)));
        s += singular(Integer.parseInt(num3.substring(2, 3)));
        return s;
    }

}
