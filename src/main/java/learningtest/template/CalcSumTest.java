package learningtest.template;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class CalcSumTest {
    @Test
    public void sumOfNumbers() throws IOException{
        Calculator calculator = new Calculator();
        int sum = calculator.calcSum(getClass().getResource("numbers.txt").getPath());
        assertEquals(10,sum);
    }
}
