import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Tests {
    WebDriver driver;

    @BeforeEach
    public void before() {
        String basicUrl = "https://www.yellowtailwine.com/";
        String pathToChromeDriver = "src/test/resources/chromedriver";
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        driver = new ChromeDriver();
        driver.get(basicUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    //Case1
    @Test
    public void requiredElementsWelcomePageTest() {
        WelcomePage welcomePage = new WelcomePage(driver);
        Assertions.assertTrue(welcomePage.getTextConfirmationCheckbox().contains("I am of legal drinking age in"));
        Assertions.assertTrue(welcomePage.getCheckbox().isDisplayed());
        Assertions.assertTrue(welcomePage.getDropdown().isDisplayed());
        Assertions.assertFalse(welcomePage.getWelcomeBtn().isEnabled());
    }

    //Case2
    @Test
    public void navigateToMainPageTest() {
        WelcomePage welcomePage = new WelcomePage(driver);
        HomePage homePage=welcomePage.clickBtnsToEnterOnHomePage();
        Assertions.assertTrue(homePage.getHomePageIdentificator().isDisplayed());
    }

    //Case3
    @Test
    public void requiredElementsDisplayedTest() {
        WelcomePage welcomePage = new WelcomePage(driver);
        HomePage homePage = welcomePage.clickBtnsToEnterOnHomePage();
        Assertions.assertTrue(homePage.getMenu().isDisplayed());
        Assertions.assertTrue(homePage.getLargeWelcome().isDisplayed());
        Assertions.assertTrue(homePage.getLargeSecondString().isDisplayed());
        Assertions.assertTrue(homePage.getFindWine().isDisplayed());
        Assertions.assertTrue(homePage.getFooter().isDisplayed());

    }

    //Case4
    @Test
    public void menuButtonLogicOpenHeaderTest() {
        WelcomePage welcomePage = new WelcomePage(driver);
        HomePage homePage = welcomePage.clickBtnsToEnterOnHomePage();
        Assertions.assertTrue(homePage.getMenu().isDisplayed());
        HeaderHomePage headerHomePage = homePage.clickOnMenu();
        headerHomePage.waitForYellowTail();
        Assertions.assertTrue(headerHomePage.getYellowTail().isDisplayed());
        Assertions.assertTrue(headerHomePage.getWines().isDisplayed());
        Assertions.assertTrue(headerHomePage.getToBuy().isDisplayed());
        Assertions.assertTrue(headerHomePage.getCocktails().isDisplayed());
        Assertions.assertTrue(headerHomePage.getOurStory().isDisplayed());
        Assertions.assertTrue(headerHomePage.getFaqs().isDisplayed());
        Assertions.assertTrue(headerHomePage.getContact().isDisplayed());
        headerHomePage.clickOnYellowTail();
        Assertions.assertTrue(homePage.getMenu().isDisplayed());
    }

    //Case5
    @Test
    public void menuButtonLogicCloseHeaderTest() {
        WelcomePage welcomePage = new WelcomePage(driver);
        HomePage homePage = welcomePage.clickBtnsToEnterOnHomePage();
        HeaderHomePage headerHomePage = homePage.clickOnMenu();
        headerHomePage.waitForYellowTail();
        headerHomePage.clickOnYellowTail();
        Assertions.assertTrue(homePage.getMenu().isDisplayed());
    }

    //Case6
    @Test
    public void globalNavLogicTest() {
        WelcomePage welcomePage = new WelcomePage(driver);
        HomePage homePage = welcomePage.clickBtnsToEnterOnHomePage();
        HeaderHomePage headerHomePage = homePage.clickOnMenu();
        headerHomePage.clickOnLocation();
        headerHomePage.clickLocationChina();
        headerHomePage.waitChinaUrl();
        Assertions.assertTrue(driver.getCurrentUrl().contains(".cn"));

    }

    //Case8
    @Test
    public void whereToBuyTest() {
        WelcomePage welcomePage = new WelcomePage(driver);
        HomePage homePage = welcomePage.clickBtnsToEnterOnHomePage();
        HeaderHomePage headerHomePage = homePage.clickOnMenu();
        StoresPage storesPage = headerHomePage.clickWhereToBuy();
        storesPage.enterStoreLocation();
        storesPage.clickConfirmBtn();
        storesPage.waitForResults();
        Assertions.assertTrue(storesPage.getResults().isDisplayed());
    }

    //Case9
    @Test
    public void cocktailsSelectOneWineTest() {
        WelcomePage welcomePage = new WelcomePage(driver);
        HomePage homePage = welcomePage.clickBtnsToEnterOnHomePage();
        HeaderHomePage headerHomePage = homePage.clickOnMenu();
        CocktailsPage cocktailsPage = headerHomePage.clickCocktails();
        cocktailsPage.clickRedWineCocktails();
        for (WebElement item : cocktailsPage.getCocktailsResults()) {
            Assertions.assertTrue(item.isDisplayed());
            Assertions.assertEquals(7, cocktailsPage.getCocktailsResults().size());
        }
    }

    //Case10
    @Test
    public void cocktailsNavigateCocktailRecipePageTest() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(driver);
        HomePage homePage = welcomePage.clickBtnsToEnterOnHomePage();
        HeaderHomePage headerHomePage = homePage.clickOnMenu();
        CocktailsPage cocktailsPage = headerHomePage.clickCocktails();
        cocktailsPage.scrollToElement();
        cocktailsPage.clickCocktailsRaspberryRose();
        Assertions.assertTrue(driver.getPageSource().contains("Ingredients"));
    }

    //Case11
    @Test
    public void cocktailsSelectSeveralWinesTest() {
        WelcomePage welcomePage = new WelcomePage(driver);
        HomePage homePage = welcomePage.clickBtnsToEnterOnHomePage();
        HeaderHomePage headerHomePage = homePage.clickOnMenu();
        CocktailsPage cocktailsPage = headerHomePage.clickCocktails();
        cocktailsPage.clickRedWineCocktails();
        cocktailsPage.clickSparklingWineCocktails();
        Assertions.assertTrue(cocktailsPage.getDropdownWines().getText().contains("Multiple"));
        for (WebElement item : cocktailsPage.getCocktailsResults()) {
            Assertions.assertTrue(item.isDisplayed());
            Assertions.assertEquals(18, cocktailsPage.getCocktailsResults().size());
        }
    }
}