package project.steps;

import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import project.browser.Driver;
import project.data.CineplexPageData;
import project.pages.CineplexPage;

import java.util.List;

public class ThenSteps {
    CineplexPage cineplexPage = new CineplexPage(Driver.getDriver());

    @Then("page for specific movie is displayed and have the following specifications")
    public void getSpecificationDetails (DataTable dataTable){
        List <CineplexPageData> movieSpecification = dataTable.asList(CineplexPageData.class);

        for (CineplexPageData specificationData : movieSpecification) {
            Assert.assertEquals("specification details are equal", specificationData.getSpecification(),
                    cineplexPage.getSpecificationValueBySpecificationTitle(specificationData.getSpecificationTitle()));
        }
        for (CineplexPageData specificationData : movieSpecification) {
            System.out.println(specificationData.getSpecificationTitle() + ":" +
                    cineplexPage.getSpecificationValueBySpecificationTitle(specificationData.getSpecificationTitle()));
        }

    }
}
