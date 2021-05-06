import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Case1 {
    @Test
    public void CheckRequiredElementsWelcomePage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yellowtailwine.com/");
        WebElement searchElementText=driver.findElement(By.cssSelector("div.confirmation-checkbox"));
        WebElement searchElementCheckbox=driver.findElement(By.cssSelector("div.confirmation-checkbox"));
        Select searchElementDropdown=new Select(driver.findElement(By.id("agegate-selector-options")));
        WebElement searchElementWelcomeButton=driver.findElement(By.cssSelector("input[value=\"Welcome\"]"));

        Assertions.assertTrue(searchElementText.getText().contains("I am of legal drinking age in"));
        Assertions.assertTrue(searchElementCheckbox.isDisplayed());
        Assertions.assertTrue(searchElementDropdown.getFirstSelectedOption().isDisplayed());
        Assertions.assertFalse(searchElementWelcomeButton.isEnabled());

        driver.quit();
        System.out.println("Success");
    }
}