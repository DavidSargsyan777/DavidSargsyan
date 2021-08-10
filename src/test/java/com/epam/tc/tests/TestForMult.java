package com.epam.tc.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.data.DataProviders;
import org.testng.annotations.Test;

public class TestForMult {
    BeforeAfter beforeAfter = new BeforeAfter();

    @Test(dataProviderClass = DataProviders.class, dataProvider = "All data", groups = {"multAndDivGroup"})
    public void testSum(double num1, double num2, double expected) {
        beforeAfter.before();
        expected = num1 * num2;
        double result = beforeAfter.calculator.mult(num1, num2);
        assertThat(result)
            .as("Multiply was wrong")
            .isEqualTo(expected);
        beforeAfter.after();
    }
}
