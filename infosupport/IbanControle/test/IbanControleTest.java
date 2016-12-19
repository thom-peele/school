import com.infosupport.IbanControle;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by thom
 * On 15-11-2016.
 */
public class IbanControleTest {
    private final String testIban = "NL20INGB0001234567";
    private IbanControle ibanControle;
    private static final String[] COUNTRY_CODES = {
            "AD",
            "AE",
            "AL",
            "AO",
            "AT",
            "AZ",
            "BA",
            "BE",
            "BF",
            "BG",
            "BH",
            "BI",
            "BJ",
            "BR",
            "CG",
            "CH",
            "CI",
            "CM",
            "CR",
            "CV",
            "CY",
            "CZ",
            "DE",
            "DK",
            "DO",
            "DZ",
            "EE",
            "EG",
            "ES",
            "FI",
            "FO",
            "FR",
            "GA",
            "GB",
            "GE",
            "GI",
            "GL",
            "GR",
            "GT",
            "HR",
            "HU",
            "IE",
            "IL",
            "IR",
            "IS",
            "IT",
            "JO",
            "KW",
            "KZ",
            "LB",
            "LC",
            "LI",
            "LT",
            "LU",
            "LV",
            "MC",
            "MD",
            "ME",
            "MG",
            "MK",
            "ML",
            "MR",
            "MT",
            "MU",
            "MZ",
            "NL",
            "NO",
            "PK",
            "PL",
            "PS",
            "PT",
            "QA",
            "RO",
            "RS",
            "SA",
            "SC",
            "SE",
            "SI",
            "SK",
            "SM",
            "SN",
            "ST",
            "TL",
            "TN",
            "TR",
            "UA",
            "VG",
            "XK",
    };

    @Before
    public void setup() {

        ibanControle = new IbanControle(COUNTRY_CODES);
    }
    @Test
    public void IbanControleTest() {

    }

    @Test
    public void IbanShouldStartWithTwoLetters() {
        assertThat(ibanControle.checkIban(testIban), is(true));
    }

    @Test
    public void IbanThatNotStartWithTwoLettersIsNotValid() {
        assertThat(ibanControle.checkIban("12"), is(false));
    }

    @Test
    public void ibanThatNotStartsWithValidCountryCodeIsNotValid() {
        assertThat(ibanControle.checkIban("AA"), is(false));
    }

    @Test
    public void ibanThatStartsWithValidCountryCodeIsValid() {
        assertThat(ibanControle.checkIban(testIban), is(true));
    }

    @Test
    public void checkLengthIsValid() {
        assertThat(ibanControle.checkLength(testIban), is(true));
    }

    @Test
    public void checkControlNumbersIsNotValid() {
        assertThat(ibanControle.checkControlNumber("NLNL"), is(false));
    }

    @Test
    public void checkControlNumbersIsValid() {
        assertThat(ibanControle.checkControlNumber(testIban), is(true));
    }

    @Test
    public void checkLengthIsToLongValid() {
        assertThat(ibanControle.checkLength("NL0000000000000000000000000000000000"), is(false));
    }

    @Test
    public void checkLengthIsToShortValid() {
        assertThat(ibanControle.checkLength("NL000000000000"), is(false));
    }

    @Test
    public void getIbanIdentifitatieTest() {
        assertThat(ibanControle.getRekeningIdentificatie(testIban), is("INGB0001234567"));
    }

    @Test
    public void getIbanWithCountryCode() {
        assertThat(ibanControle.getIdentificationWithCountryAndControlCode(testIban), is("INGB0001234567NL"));
    }

    @Test
    public void getIbanAsIntegerTest() {
        assertThat(ibanControle.getIbanAsInteger(testIban), is(new BigInteger("182316110001234567232100")));
    }

    @Test
    public void computeControlNumberTest() {
        assertThat(ibanControle.computeControlNumber(testIban), is(20));
    }

}
