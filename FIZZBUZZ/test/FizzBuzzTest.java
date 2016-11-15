import com.infosupport.FizzBuzz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by thom
 * On 15-11-2016.
 */
public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void init() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void checkBuzzTrue() {
        assertThat(fizzBuzz.checkBuzz(10), is(true));
    }

    @Test
    public void checkBuzzFalse() {
        assertThat(fizzBuzz.checkBuzz(4), is(false));
    }

    @Test
    public void checkFizzTrue() {
        assertThat(fizzBuzz.checkFizz(3), is(true));
    }

    @Test
    public void checFizzFalse() {
        assertThat(fizzBuzz.checkFizz(1), is(false));
    }

    @Test
    public void canGetValueOfOne() {
        assertThat(fizzBuzz.print(1), is("1"));
    }

    @Test
    public void calculateFizz() {
        assertThat(fizzBuzz.print(3), is("Fizz"));
    }

    @Test
    public void calculateBuzz() {
        assertThat(fizzBuzz.print(5), is("Buzz"));
    }

    @Test
    public void calculateFizzBuzz() {
        assertThat(fizzBuzz.print(15), is("FizzBuzz"));
    }

    @Test
    public void printAll() {
        for (int i = 0; i < 100; i++) {
            System.out.println(fizzBuzz.print(i));
        }
    }

    @Test
    public void checkReturnFour() {
        assertThat(fizzBuzz.print(4), is("Fuzz"));
    }

}
