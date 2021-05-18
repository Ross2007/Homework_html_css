import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderHomePage {
    WebDriver driver;

    public HeaderHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".-active .main-nav a>img")
    private WebElement searchElementYellowTail;
    @FindBy(css = ".inner a[href$=\".com/wines/\"]")
    private WebElement searchElementWines;
    @FindBy(css = ".inner a[href$=\".com/stores/\"]")
    private WebElement searchElementToBuy;
    @FindBy(css = ".inner a[href$=\".com/cocktails/\"]")
    private WebElement searchElementCocktails;
    @FindBy(css = ".inner a[href$=\".com/our-story/\"]")
    private WebElement searchElementOurStory;
    @FindBy(css = ".inner a[href$=\".com/faqs/\"]")
    private WebElement searchElementFaqs;
    @FindBy(css = ".inner a[href$=\".com/contact/\"]")
    private WebElement searchElementContact;
    @FindBy(css = ".inner .fa.fa-globe.fa-lg")
    private WebElement searchElementLocation;
    @FindBy(css = "a.country[data-key=\"CN\"]")
    private WebElement searchElementLocationChina;

    public void waitForYellowTail() {
        (new WebDriverWait(driver, Duration.ofSeconds(2)))
                .until(ExpectedConditions.elementToBeClickable(searchElementYellowTail));
    }

    public void waitChinaUrl() {
        (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(ExpectedConditions.urlContains(".cn"));
    }

    public WebElement getElementYellowTail() {
        return searchElementYellowTail;
    }

    public WebElement getElementWines() {
        return searchElementWines;
    }

    public WebElement getElementToBuy() {
        return searchElementToBuy;
    }

    public WebElement getElementCocktails() {
        return searchElementCocktails;
    }

    public WebElement getElementOurStory() {
        return searchElementOurStory;
    }

    public WebElement getElementFaqs() {
        return searchElementFaqs;
    }

    public WebElement getElementContact() {
        return searchElementContact;
    }

    public void clickOnYellowTail() {
        searchElementYellowTail.click();
    }

    public void clickOnLocation() {
        searchElementLocation.click();
    }

    public void clickElementLocationChina() {
        searchElementLocationChina.click();
    }

    public void clickElementWhereToBuy() {
        searchElementToBuy.click();
    }

    public void clickElementCocktails() {
        searchElementCocktails.click();
    }

}