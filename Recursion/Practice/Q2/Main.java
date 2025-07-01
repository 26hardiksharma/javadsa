package Recursion.Practice.Q2;

public class Main {

    static String[] digits = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};


    public static StringBuilder convertToString(int number, StringBuilder str,int digit) {
        if(digit == 0) {
            return str;
        }
        int k = number/(int)Math.pow(10, digit-1);
        str.append(digits[k]);
        str.append(" ");
        return convertToString(number%(int)Math.pow(10, digit-1), str, digit-1);
    }    

    public static void main(String[] args) {
        System.out.println(convertToString(2019,new StringBuilder("") , 4));
    }
}
