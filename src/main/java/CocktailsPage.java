import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    private WebElement DropdownWines;
    @FindBy(css = "[data-value=\"red\"]")
    private WebElement RedWineCocktails;
    @FindBy(css = ".grid filter-grid recipes")
    private List<WebElement> cocktailsResults;
    @FindBy(css = "[href=\"raspberry-rose\"]")
    private WebElement CocktailsRaspberryRose;
    @FindBy(css = "[data-value=\"bubbles\"]")
    private WebElement SparklingWineCocktails;

    public void clickRedWineCocktails() {
        DropdownWines.click();
        RedWineCocktails.click();
    }

    public List<WebElement> getCocktailsResults() {
        return cocktailsResults;
    }

    public void clickCocktailsRaspberryRose() {
        CocktailsRaspberryRose.click();
    }


    public void clickSparklingWineCocktails() {
        SparklingWineCocktails.click();
    }

    public WebElement getDropdownWines() {
        return DropdownWines;
    }
    public void scrollToElement ()
    { Actions builder = new Actions(driver);
        builder.moveToElement(CocktailsRaspberryRose).build().perform();
    }
}