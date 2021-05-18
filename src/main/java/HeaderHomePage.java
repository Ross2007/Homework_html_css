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
    private WebElement YellowTail;
    @FindBy(css = ".inner a[href$=\".com/wines/\"]")
    private WebElement Wines;
    @FindBy(css = ".inner a[href$=\".com/stores/\"]")
    private WebElement ToBuy;
    @FindBy(css = ".inner a[href$=\".com/cocktails/\"]")
    private WebElement Cocktails;
    @FindBy(css = ".inner a[href$=\".com/our-story/\"]")
    private WebElement OurStory;
    @FindBy(css = ".inner a[href$=\".com/faqs/\"]")
    private WebElement Faqs;
    @FindBy(css = ".inner a[href$=\".com/contact/\"]")
    private WebElement Contact;
    @FindBy(css = ".inner .fa.fa-globe.fa-lg")
    private WebElement Location;
    @FindBy(css = "a.country[data-key=\"CN\"]")
    private WebElement LocationChina;

    public void waitForYellowTail() {
        (new WebDriverWait(driver, Duration.ofSeconds(2)))
                .until(ExpectedConditions.elementToBeClickable(YellowTail));
    }

    public void waitChinaUrl() {
        (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(ExpectedConditions.urlContains(".cn"));
    }

    public WebElement getYellowTail() {
        return YellowTail;
    }

    public WebElement getWines() {
        return Wines;
    }

    public WebElement getToBuy() {
        return ToBuy;
    }

    public WebElement getCocktails() {
        return Cocktails;
    }

    public WebElement getOurStory() {
        return OurStory;
    }

    public WebElement getFaqs() {
        return Faqs;
    }

    public WebElement getContact() {
        return Contact;
    }

    public void clickOnYellowTail() {
        YellowTail.click();
    }

    public void clickOnLocation() {
        Location.click();
    }

    public void clickLocationChina() {
        LocationChina.click();
    }

    public StoresPage clickWhereToBuy() {
        ToBuy.click();
        return new StoresPage(driver);
    }

    public CocktailsPage clickCocktails() {
        Cocktails.click();
       return new CocktailsPage(driver);
    }

}