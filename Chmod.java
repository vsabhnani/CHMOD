/*
    Viren Sabhnani
    ACSL Program #1: CHMOD (Intermediate)
    12 December 2015
*/
import java.util.*;

public class Chmod {

    public static void main(String[] args) {

        String num = "";
        Scanner userInput = new Scanner(System.in);
        String contin;

        do {

            System.out.println("Enter Binary, Octal or RWX");
            num = userInput.nextLine();

            if (num.contains("1") && !(num.contains("2") || num.contains("3") || num.contains("4") || num.contains("5") || num.contains("6") || num.contains("7"))) {

                num = eliminateComma(num);
                num = addZeroes(num);
                String oct = convertToOctal(num) + " and " + rwe(num);
                System.out.println();
                System.out.println(oct);

            }
            if (num.contains("2") || num.contains("3") || num.contains("4") || num.contains("5") || num.contains("6") || num.contains("7")) {
                num = eliminateComma(num);
                String num1 = convertToBinary(num);
                num = convertToBinary(num);
                num = eliminateComma(num);
                num = addZeroes(num);
                String print = num1 + " and " + rwe(num);                
                System.out.println();
                System.out.println(print);

            }

            if (num.contains("r") || num.contains("w") || num.contains("x") || num.contains("-")) {
                num = elimateSpaces(num);
                num = stringToBinary(num);
                num = convertToOctal(num);
                System.out.println();
                System.out.println(num + " and " + convertToBinary(num));

            }
            System.out.println("Would you like to continue? (y/n)");
            contin = userInput.nextLine();
        } while (contin.equalsIgnoreCase("y"));
    }

    private static String convertToOctal(String num) {
        int dec = Integer.parseInt(num, 2);
        String octal = Integer.toOctalString(dec);
        return octal;
    }

    private static String convertToBinary(String num) {
        int dec = Integer.parseInt(num, 8);
        String binary = Integer.toBinaryString(dec);
        binary = binary.substring(0, 3) + " " + binary.substring(3, 6) + " " + binary.substring(6);
        return binary;
    }

    private static String eliminateComma(String num) {
        String newstr = "";
        for (int i = 0; i < num.length(); i++) {
            if (Character.isDigit(num.charAt(i))) {
                newstr += num.charAt(i);
            }

        }
        return newstr;
    }

    private static String addZeroes(String num) {
        if (num.length() / 3 == 0) {
            return num;
        } else if (num.length() / 3 == 2) {
            return "0" + num;

        } else if (num.length() / 3 == 1) {
            return "00" + num;
        } else {
            return num;
        }
    }

    private static String rwe(String num) {

        String firstSub = num.substring(0, 3);
        String secondSub = num.substring(3, 6);
        String thirdSub = num.substring(6);
        String rwe = "";

        for (int i = 0; i < firstSub.length(); i++) {
            if (firstSub.charAt(i) == '1') {
                if (i == 0) {
                    rwe += "r";
                }
                if (i == 1) {
                    rwe += "w";
                }
                if (i == 2) {
                    rwe += "x";
                }
            }
            if (firstSub.charAt(i) == '0') {
                if (i == 0) {
                    rwe += "-";
                }
                if (i == 1) {
                    rwe += "-";
                }
                if (i == 2) {
                    rwe += "-";
                }
            }

        }
        rwe += " ";
        for (int i = 0; i < secondSub.length(); i++) {

            if (secondSub.charAt(i) == '1') {
                if (i == 0) {
                    rwe += "r";
                }
                if (i == 1) {
                    rwe += "w";
                }
                if (i == 2) {
                    rwe += "x";
                }
            }
            if (secondSub.charAt(i) == '0') {
                if (i == 0) {
                    rwe += "-";
                }
                if (i == 1) {
                    rwe += "-";
                }
                if (i == 2) {
                    rwe += "-";
                }
            }

        }
        rwe += " ";
        for (int i = 0; i < thirdSub.length(); i++) {

            if (thirdSub.charAt(i) == '1') {
                if (i == 0) {
                    rwe += "r";
                }
                if (i == 1) {
                    rwe += "w";
                }
                if (i == 2) {
                    rwe += "x";
                }
            }
            if (thirdSub.charAt(i) == '0') {
                if (i == 0) {
                    rwe += "-";
                }
                if (i == 1) {
                    rwe += "-";
                }
                if (i == 2) {
                    rwe += "-";
                }
            }

        }
        return rwe;
    }

    private static String elimateSpaces(String num) {
        String newstr = "";
        for (int i = 0; i < num.length(); i++) {
            if (Character.isLetter(num.charAt(i)) || num.charAt(i) == '-') {
                newstr += num.charAt(i);
            }
        }
        return newstr;
    }

    private static String stringToBinary(String num) {
        String newstr = "";
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == 'r' || num.charAt(i) == 'w' || num.charAt(i) == 'x') {
                newstr += "1";
            }
            if (num.charAt(i) == '-') {
                newstr += 0;
            }
        }
        return newstr;
    }
}
