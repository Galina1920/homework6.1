package project.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import project.browser.Driver;

public class BeforeAfterSteps {
    @Before
    public void beforeStep()  {
        Driver.runDriver();
    }


    @After
    public void afterStep(){
        Driver.quitDriver();
    }
}
