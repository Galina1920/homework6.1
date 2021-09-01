package project.steps;

import cucumber.api.java.en.When;
import project.actions.CommonActions;
import project.browser.Driver;
import project.pages.CineplexPage;

public class WhenSteps {

    CommonActions commonActions = new CommonActions();
    CineplexPage cineplexPage = new CineplexPage(Driver.getDriver());

    @When("user select {string} movie from list")
    public void userSelectMovieFromList (String movieName){
        commonActions.waitUntilElementDisplayed(cineplexPage.getMovieByName(movieName));
        commonActions.moveToElement(cineplexPage.getMovieByName(movieName));
        cineplexPage.getMovieByName(movieName).click();

    }
}
