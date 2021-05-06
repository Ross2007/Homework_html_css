 import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Case4 {
    @Test
    public void CheckMenuButtonLogicOpenHeader () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yellowtailwine.com/");
        WebElement searchElementText=driver.findElement(By.cssSelector("div.confirmation-checkbox"));
        searchElementText.click();
        Select searchElementDropdown=new Select(driver.findElement(By.id("agegate-selector-options")));
        searchElementDropdown.selectByValue("eu");
        WebElement searchElementWelcomeButton=driver.findElement(By.cssSelector("input[value=\"Welcome\"]"));
        searchElementWelcomeButton.click();
        WebElement searchElementMenu=driver.findElement(By.cssSelector(".fa.fa-bars span"));
        Assertions.assertTrue(searchElementMenu.isDisplayed());
        searchElementMenu.click();
        WebElement searchElementYellowTail=driver.findElement(By.cssSelector(".-active .main-nav a>img"));
        Thread.sleep(3000);
        Assertions.assertTrue(searchElementYellowTail.isDisplayed());
        WebElement searchElementWines=driver.findElement(By.cssSelector(".inner a[href$=\".com/wines/\"]"));
        Assertions.assertTrue(searchElementWines.isDisplayed());
        WebElement searchElementToBuy=driver.findElement(By.cssSelector(".inner a[href$=\".com/stores/\"]"));
        Assertions.assertTrue(searchElementToBuy.isDisplayed());
        WebElement searchElementCocktails=driver.findElement(By.cssSelector(".inner a[href$=\".com/cocktails/\"]"));
        Assertions.assertTrue(searchElementCocktails.isDisplayed());
        WebElement searchElementOurStory=driver.findElement(By.cssSelector(".inner a[href$=\".com/our-story/\"]"));
        Assertions.assertTrue(searchElementOurStory.isDisplayed());
        WebElement searchElementFaqs=driver.findElement(By.cssSelector(".inner a[href$=\".com/faqs/\"]"));
        Assertions.assertTrue(searchElementFaqs.isDisplayed());
        WebElement searchElementContact=driver.findElement(By.cssSelector(".inner a[href$=\".com/contact/\"]"));
        Assertions.assertTrue(searchElementContact.isDisplayed());
        WebElement searchElementLanguage=driver.findElement(By.cssSelector(".inner .fa.fa-globe.fa-lg"));
        Assertions.assertTrue(searchElementLanguage.isDisplayed());
        searchElementYellowTail.click();
        WebElement searchElementMenu1=driver.findElement(By.cssSelector(".fa.fa-bars span"));
        Assertions.assertTrue(searchElementMenu1.isDisplayed());
        driver.quit();
        System.out.println("Success");
    }
}