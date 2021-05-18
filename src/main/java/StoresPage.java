import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StoresPage {
    WebDriver driver;

    public StoresPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "locationName")
    private WebElement LocationNameField;
    @FindBy(css = ".search-submit")
    private WebElement ConfirmBtn;
    @FindBy(css = ".results[style=\"display: block;\"]")
    private WebElement Results;

    public void enterStoreLocation() {
        LocationNameField.sendKeys("Sydney");
    }

    public void clickConfirmBtn() {
        ConfirmBtn.click();
    }

    public WebElement getResults() {
        return Results;
    }

    public void waitForResults() {
        (new WebDriverWait(driver, Duration.ofSeconds(2)))
                .until(ExpectedConditions.visibilityOf(Results));
    }
}