package project.steps;

import cucumber.api.java.en.Given;
import project.browser.Driver;
import project.pages.CineplexPage;

public class GivenSteps {
    CineplexPage cineplexPage = new CineplexPage(Driver.getDriver());

    @Given("user is at {string} page")
    public void userOpenLink(String pageLink){
        Driver.getDriver().get(pageLink);
    }

    @Given("user select {string} category from menu bar")
    public void userSelectCategory (String categoryName) {
        cineplexPage.getMenuCategoryByName(categoryName).click();

    }
}
