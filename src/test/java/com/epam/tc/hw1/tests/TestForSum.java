package com.epam.tc.hw1.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.data.DataProviders;
import org.testng.annotations.Test;

public class TestForSum {

    BeforeAfter beforeAfter = new BeforeAfter();


    @Test(dataProviderClass = DataProviders.class, dataProvider = "All data", groups = {"sumAndSubGroup"})
    public void testSum(double num1, double num2, double expected) {
        beforeAfter.before();
        expected = num1 + num2;
        double result = beforeAfter.calculator.sum(num1, num2);
        assertThat(result)
            .as("Addition was wrong")
            .isEqualTo(expected);
        beforeAfter.after();
    }
}
