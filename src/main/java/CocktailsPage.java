import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CocktailsPage {
    WebDriver driver;

    public CocktailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".selected")
    private WebElement searchElementDropdownWines;
    @FindBy(css = "[data-value=\"red\"]")
    private WebElement searchElementRedWineCocktails;
    @FindBy(css = ".tile.recipe-tile[data-types=\"red\"]")
    private List<WebElement> cocktailsResults;
    @FindBy(css = ".tile.recipe-tile[data-types=\"red\"], .tile.recipe-tile[data-types=\"bubbles\"]")
    private List<WebElement> cocktailsResults2;
    @FindBy(css = "[href=\"raspberry-rose\"]")
    private WebElement searchElementCocktailsRaspberryRose;
    @FindBy(css = "[data-value=\"bubbles\"]")
    private WebElement searchElementSparklingWineCocktails;

    public void clickElementDropdownWines() {
        searchElementDropdownWines.click();
    }

    public void clickElementRedWineCocktails() {
        searchElementRedWineCocktails.click();
    }

    public List<WebElement> getElementCocktailsResults() {
        return cocktailsResults;
    }

    public List<WebElement> getElementCocktailsResults2() {
        return cocktailsResults2;
    }

    public void clickElementCocktailsRaspberryRose() {
        searchElementCocktailsRaspberryRose.click();
    }

    public WebElement getElementCocktailsRaspberryRose() {
        return searchElementCocktailsRaspberryRose;
    }

    public void clickElementSparklingWineCocktails() {
        searchElementSparklingWineCocktails.click();
    }

    public WebElement getElementDropdownWines() {
        return searchElementDropdownWines;
    }
}