import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Case5 {
    @Test
    public void CheckMenuButtonLogicCloseHeader() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yellowtailwine.com/");
        WebElement searchElementText=driver.findElement(By.cssSelector("div.confirmation-checkbox"));
        searchElementText.click();
        Select searchElementDropdown=new Select(driver.findElement(By.id("agegate-selector-options")));
        searchElementDropdown.selectByValue("eu");
        WebElement searchElementWelcomeButton=driver.findElement(By.cssSelector("input[value=\"Welcome\"]"));
        searchElementWelcomeButton.click();
        WebElement searchElementMenu=driver.findElement(By.cssSelector(".fa.fa-bars>span"));
        searchElementMenu.click();
        Thread.sleep(5000);
        WebElement searchElementYellowTail=driver.findElement(By.cssSelector(".-active .main-nav a>img"));
        searchElementYellowTail.click();
        WebElement searchElementMenu2=driver.findElement(By.cssSelector(".fa.fa-bars>span"));
        Assertions.assertTrue(searchElementMenu2.isDisplayed());
        driver.quit();
        System.out.println("Success");
    }
}
