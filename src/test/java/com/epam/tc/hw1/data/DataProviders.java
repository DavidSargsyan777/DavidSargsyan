package com.epam.tc.hw1.data;

import org.testng.annotations.DataProvider;

public class DataProviders {
    double expectedResult;

    @DataProvider(name = "All data")
    public Object[][] allData() {
        return new Object[][] {{1, 2, expectedResult}, {3, 2, expectedResult}, {78, 1, expectedResult},
            {14, 0, expectedResult}};
    }
}
