import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".fa.fa-bars")
    private WebElement Menu;
    @FindBy(css = ".content.animation-screen.-one>h2")
    private WebElement LargeWelcome;
    @FindBy(css = ".content.animation-screen.-one p.header-sub-copy")
    private WebElement LargeSecondString;
    @FindBy(css = ".content.animation-screen.-one [aria-label]")
    private WebElement FindWine;
    @FindBy(css = ".primary-footer")
    private WebElement Footer;
    @FindBy (css = ".animationOne")
    private WebElement HomePageIdentificator;

    public WebElement getHomePageIdentificator() {return HomePageIdentificator;}

    public WebElement getMenu() {
        return Menu;
    }

    public WebElement getLargeWelcome() {
        return LargeWelcome;
    }

    public WebElement getLargeSecondString() {
        return LargeSecondString;
    }

    public WebElement getFindWine() {
        return FindWine;
    }

    public WebElement getFooter() {
        return Footer;
    }

    public HeaderHomePage clickOnMenu() {
        Menu.click();
        return new HeaderHomePage(driver);
    }
}