package project.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CineplexPage {

    private WebDriver driver;

    @FindBy(xpath = "//ul[contains(@id, 'main-menu')]")
    private WebElement menu;

    @FindBy(xpath = "//div[contains(@id, 'block_now')]")
    private WebElement movieList;

    //div[contains(@id, 'block_now')]  blocul cu filme acum
    //div[contains(@class, 'movies_blcks')] FIECARE BLOCK DE FILM ACUM SI IN CURIND
    //div[contains(@class, 'movies_fimls_item')] fiecare film in parte acum si in curind
    //div[contains(@class, 'overlay_content')] tot textul fiecarui film acum si in curind
    //h3[contains(@class, 'overlay__title')] doar titlul filmului

    @FindBy(xpath = "//li[contains(@class, 'film_movies_info_item')]//span")
    private List<WebElement> movieSpecifications;

    //ul[contains(@class, 'film_movies_info')]
    //li[contains(@class, 'film_movies_info_item')]//span  - tot containerul cu detalii
    //li[contains(@class, 'film_movies_info_item')]//span//h5  - specificationTitle
    //li[contains(@class, 'film_movies_info_item')]//span//p - specification


    public CineplexPage(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver1, this);
    }

    public List<WebElement> getMenuCategories() {
        return menu.findElements(By.tagName("li"));
    }

    public WebElement getMenuCategoryByName(String categoryName) {
        return getMenuCategories().stream()
                .filter(element -> element.findElement(By.tagName("a")).getText().equalsIgnoreCase(categoryName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Such category does not exists - " + categoryName));
    }



    public List<WebElement> getMovieList(){
        return movieList.findElements(By.xpath("//div[contains(@class, 'overlay_content')]"));
    }

    public WebElement getMovieByName(String movieName){
        return getMovieList().stream()
                .filter(element -> element.findElement(By.tagName("h3")).getText().equalsIgnoreCase(movieName))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Such movie does not exists - " + movieName));
    }



    public String getSpecificationValueBySpecificationTitle(String specificationTitle) {
        WebElement specification = movieSpecifications.stream()
                .filter(element -> element.findElement(By.tagName("h5")).getText().equals(specificationTitle))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Such specification title does not exist - " + specificationTitle));

        return specification.findElement(By.tagName("p")).getText();
    }

}