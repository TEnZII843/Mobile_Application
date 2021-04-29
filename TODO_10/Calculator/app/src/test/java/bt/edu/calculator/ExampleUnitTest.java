package bt.edu.calculator;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class ExampleUnitTest {

    private Calculator Calc;

    @Before
    public void Setup(){
        Calc = new Calculator();
    }
    //To test the add() by adding two +ve number.
    @Test
    public void add_twoPositive() {
        double result = Calc.add(1d,2d);
        assertThat(result,(equalTo(3d)));

    }
    //To test the add() by adding one +ve and -ve number.
    @Test
    public void add_negative_and_positive() {
        double result = Calc.add(-1d,2d);
        assertThat(result,(equalTo(1d)));

    }
    //To add two decimal numbers
    @Test
    public void add_two_decimal() {
        double result = Calc.add(2.222d,1.111d);
        assertThat(result,(closeTo(3.333d,0.001d)));

    }
    //To test the sub() by subtracting two number.
    @Test
    public void subTwoNumbers() {
        double result = Calc.sub(2d,1d);
        assertThat(result,(equalTo(1d)));

    }
    //To test the sub() where the given calculation results in a negative number.
    @Test
    public void subWorksWithNegativeResults() {
        double result = Calc.sub(-1d,2d);
        assertThat(result,(equalTo(-3d)));
    }
    //To tests the mul() method.
    @Test
    public void mulTwoNumbers() {
        double result = Calc.mul(1d,2d);
        assertThat(result,(equalTo(2d)));
    }
    //To tests the mul() method with at least one argument as zero.
    @Test
    public void mulTwoNumbersZero() {
        double result = Calc.mul(0d,2d);
        assertThat(result,(equalTo(0d)));
    }
    //To tests the div() method with two non-zero arguments.
    @Test
    public void divTwoNumbers() {
        double result = Calc.div(4d,2d);
        assertThat(result,(equalTo(2d)));
    }
    //To tests the div() method with a double dividend and zero as the divider.
    @Test
    public void divTwoNumbersZero() {
        double result = Calc.div(4d,0d);
        assertThat(result,(equalTo(Double.POSITIVE_INFINITY)));
    }

}