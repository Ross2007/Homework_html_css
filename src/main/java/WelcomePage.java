import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WelcomePage {
    WebDriver driver;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.confirmation-checkbox")
    private WebElement searchElementText;
    @FindBy(css = "div.confirmation-checkbox")
    private WebElement searchElementCheckbox;
    @FindBy(css = ".agegate-selector-options")
    private WebElement searchElementDropdown;
    @FindBy(css = "input[value=\"Welcome\"]")
    private WebElement searchElementWelcomeBtn;

    public String getTextConfirmationCheckbox() {
        return searchElementText.getText();
    }

    public WebElement getElementCheckbox() {
        return searchElementCheckbox;
    }

    public WebElement getElementDropdown() {
        return searchElementDropdown;
    }

    public WebElement getElementWelcomeBtn() {
        return searchElementWelcomeBtn;
    }

    public void clickOnCheckBox() {
        searchElementCheckbox.click();
    }

    public void clickOnSelectLocation() {
        new Select(searchElementDropdown).selectByValue("eu");
    }

    public void clickOnWelcomeBtn() {
        searchElementWelcomeBtn.click();
    }
}