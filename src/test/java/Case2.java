import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Case2 {
    @Test
    public void CheckNavigateToMainPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yellowtailwine.com/");
        WebElement searchElementText=driver.findElement(By.cssSelector("div.confirmation-checkbox"));
        searchElementText.click();
        Select searchElementDropdown=new Select(driver.findElement(By.id("agegate-selector-options")));
        searchElementDropdown.selectByValue("eu");
        WebElement searchElementWelcomeButton=driver.findElement(By.cssSelector("input[value=\"Welcome\"]"));
        searchElementWelcomeButton.click();
        Thread.sleep(2000);
        driver.quit();
        System.out.println("Success");
    }
}