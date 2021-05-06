import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Case8 {
    @Test
    public void CheckWhereToBuy() throws InterruptedException {
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
        WebElement searchElementMenu=driver.findElement(By.cssSelector(".fa.fa-bars>span"));
        searchElementMenu.click();
        Thread.sleep(2000);
        WebElement searchElementToBuy=driver.findElement(By.cssSelector(".inner a[href$=\".com/stores/\"]"));
        searchElementToBuy.click();
        Thread.sleep(2000);
        WebElement searchElementLocationName=driver.findElement(By.id("locationName"));
        searchElementLocationName.sendKeys("Sydney");
        WebElement searchElementConfirmBtn=driver.findElement(By.cssSelector(".search-submit"));
        searchElementConfirmBtn.click();
        Thread.sleep(3000);
        WebElement searchElementResults=driver.findElement(By.cssSelector(".results[style=\"display: block;\"]"));
        Assertions.assertTrue(searchElementResults.isDisplayed());

        driver.quit();
        System.out.println("Success");
    }
}
