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
    private WebElement searchElementMenu;
    @FindBy(css = ".content.animation-screen.-one>h2")
    private WebElement searchElementLargeWelcome;
    @FindBy(css = ".content.animation-screen.-one p.header-sub-copy")
    private WebElement searchElementLargeSecondString;
    @FindBy(css = ".content.animation-screen.-one [aria-label]")
    private WebElement searchElementFindWine;
    @FindBy(css = ".primary-footer")
    private WebElement searchElementFooter;

    public WebElement getElementMenu() {
        return searchElementMenu;
    }

    public WebElement getElementLargeWelcome() {
        return searchElementLargeWelcome;
    }

    public WebElement getElementLargeSecondString() {
        return searchElementLargeSecondString;
    }

    public WebElement getElementFindWine() {
        return searchElementFindWine;
    }

    public WebElement getElementFooter() {
        return searchElementFooter;
    }

    public void clickOnMenu() {
        searchElementMenu.click();
    }
}