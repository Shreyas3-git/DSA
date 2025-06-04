package com.example.dsa_practice2025.string;

public class ImplementAtoi
{
    public static void main(String[] args) {
        System.out.println(myAtoi("-123"));
    }


    public static int myAtoi(String s) {
        /**
         *  algorithm:
         *  declare i init 0
         *  iterate and skip all whitespaces
         *  check i == s.length
         *  return 0
         *  declare sign init 1
         *  check current char '-'
         *  sign = -1
         *  i++
         *  otherwise
         *  i++
         *  declare long result
         *  iterate till i < n and current char is digit
         *  result = result * 10 + currentchar - '0
         *  check result*sign > int_max value
         *      return int_max
         *  check result*sign < int_minvalue
         *      return int_minvalue
         *  i++
         *  end loop
         *  return cast it to int result * sign
         */
        int i = 0;
        while(i < s.length() && s.charAt(i) == ' ')
            i++;
        if(i == s.length())
            return 0;
        int sign;
        if(i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else {
            sign = 1;
            i++;
        }
        long result = 0;
        while(i < s.length() && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            if((result*sign) > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if((result*sign) < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            i++;
        }
        return (int) result*sign;
    }
}
