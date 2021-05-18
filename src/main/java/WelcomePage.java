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
    private WebElement Text;
    @FindBy(css = "div.confirmation-checkbox")
    private WebElement Checkbox;
    @FindBy(css = ".agegate-selector-options")
    private WebElement Dropdown;
    @FindBy(css = "input[value=\"Welcome\"]")
    private WebElement WelcomeBtn;

    public String getTextConfirmationCheckbox() {
        return Text.getText();
    }

    public WebElement getCheckbox() {
        return Checkbox;
    }

    public WebElement getDropdown() {
        return Dropdown;
    }

    public WebElement getWelcomeBtn() {
        return WelcomeBtn;
    }

    public HomePage clickBtnsToEnterOnHomePage() {
        Checkbox.click();
        new Select(Dropdown).selectByValue("eu");
        WelcomeBtn.click();
        return new HomePage(driver);
    }
}