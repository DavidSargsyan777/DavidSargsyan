package com.epam.tc.hw4.driver;

public class WebDriverImpl implements WebDriverInj {
    @Override
    public DriverService getDriverService() {
        return new DriverManagerImpl();
    }
}
