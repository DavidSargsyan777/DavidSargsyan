package com.epam.tc.hw5.cucumber.steps;

import io.cucumber.java.en.Given;

public class GivenStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openJdiGitHubPage() {
        homePage.openPage();
    }

    @Given("I login as user 'Roman Iovlev'")
    public void loginUser() {
        indexPage.openLogin().login();
    }
}
