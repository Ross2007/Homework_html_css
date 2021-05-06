import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstTest {
    @Test
    public void navigateToMainPage () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        By searchField = By.cssSelector(".gLFyf.gsfi");
        WebElement searchElement=driver.findElement(searchField);
        searchElement.click();
        searchElement.sendKeys("Hillel");
        searchElement.sendKeys(Keys.ENTER);
        By searchResultsSelector = By.cssSelector(".LC20lb .DKV0Md");
        List <WebElement> searchResults=driver.findElements(searchResultsSelector);
        for (WebElement item: searchResults) {
            Assertions.assertTrue(item.getText().contains("Hillel"));
        }
        driver.quit();
        System.out.println("Success");
    }
}