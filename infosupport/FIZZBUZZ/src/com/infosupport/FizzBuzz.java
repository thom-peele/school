package com.infosupport;

/**
 * Created by thom
 * On 15-11-2016.
 */
public class FizzBuzz {
    public String print(final int fizzBuzzInput) {
        String returnString = "";
        if(!checkFizz(fizzBuzzInput) && !checkBuzz(fizzBuzzInput)) {
            returnString = extraCheck(fizzBuzzInput);
            if (!returnString.equals("")) {
                return returnString;
            }
            return Integer.toString(fizzBuzzInput);
        } else {
            if(checkFizz(fizzBuzzInput)) {
                returnString += "Fizz";
            }
            if(checkBuzz(fizzBuzzInput)) {
                returnString += "Buzz";
            }
            return returnString;
        }
    }

    public String extraCheck(int fizzBuzzIndex) {
        char[] chars = Integer.toString(fizzBuzzIndex).toCharArray();
        String returnString = "";
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '4') {
                returnString += "Fuzz";
            }
            if(chars[i] == '7') {
                returnString += "Bizz";
            }
        }
        return returnString;
    }

    public boolean checkBuzz(int fizzBuzzIndex) {
        return fizzBuzzIndex % 5 == 0;
    }

    public boolean checkFizz(int fizzBuzzIndex) {
        return fizzBuzzIndex % 3 == 0;
    }
}
