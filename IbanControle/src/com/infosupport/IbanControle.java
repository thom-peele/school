package com.infosupport;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by thom
 * On 15-11-2016.
 */
public class IbanControle {
    private String[] validCountryCodes;

    public IbanControle(String[] validCountryCodes) {
        this.validCountryCodes = validCountryCodes;
    }

    public boolean checkIban(String iban) {
        if (Character.isAlphabetic(iban.charAt(0)) && Character.isAlphabetic(iban.charAt(1))) {
            if (Arrays.asList(validCountryCodes).contains(iban.substring(0, 2))) {
                return true;
            }
        }
        return false;
    }


    public boolean checkLength(String iban) {
        if (iban.length() <= 34 && iban.length() > 14) {
            return true;
        }
        return false;
    }

    public Boolean checkControlNumber(String iban) {
        if (Character.isDigit(iban.charAt(2)) && Character.isDigit(iban.charAt(3))) {
            return true;
        }
        return false;
    }

    public String getRekeningIdentificatie(String iban) {
        return iban.substring(4);
    }

    public String getIdentificationWithCountryAndControlCode(String iban) {
        return getRekeningIdentificatie(iban) + iban.charAt(0) + iban.charAt(1);
    }

    public BigInteger getIbanAsInteger(String iban) {
        iban = getIdentificationWithCountryAndControlCode(iban);
        StringBuilder newIban = new StringBuilder();
        for (int i = 0; i < iban.length(); i++) {
            int tmp = Character.getNumericValue(iban.charAt(i));
            if (-1 >= tmp) {

            }
            newIban.append(tmp);
        }
        return new BigInteger(newIban.append("00").toString());
    }

    public int computeControlNumber(String iban) {
        return 98 - (getIbanAsInteger(iban).mod(new BigInteger("97")).intValue());
    }
}
