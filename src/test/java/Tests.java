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
        String pathToChromeDriver = "/home/user/Документы/Rossclasswork/src/test/resources/chromedriver";
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
    public void CheckRequiredElementsWelcomePage() {
        WelcomePage welcomePage = new WelcomePage(driver);
        Assertions.assertTrue(welcomePage.getTextConfirmationCheckbox().contains("I am of legal drinking age in"));
        Assertions.assertTrue(welcomePage.getElementCheckbox().isDisplayed());
        Assertions.assertTrue(welcomePage.getElementDropdown().isDisplayed());
        Assertions.assertFalse(welcomePage.getElementWelcomeBtn().isEnabled());
    }

    //Case2
    @Test
    public void CheckNavigateToMainPage() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.clickOnCheckBox();
        welcomePage.clickOnSelectLocation();
        welcomePage.clickOnWelcomeBtn();
    }

    //Case3
    @Test
    public void CheckRequiredElementsDisplayed() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.clickOnCheckBox();
        welcomePage.clickOnSelectLocation();
        welcomePage.clickOnWelcomeBtn();
        HomePage homePage = new HomePage(driver);
        Assertions.assertTrue(homePage.getElementMenu().isDisplayed());
        Assertions.assertTrue(homePage.getElementLargeWelcome().isDisplayed());
        Assertions.assertTrue(homePage.getElementLargeSecondString().isDisplayed());
        Assertions.assertTrue(homePage.getElementFindWine().isDisplayed());
        Assertions.assertTrue(homePage.getElementFooter().isDisplayed());

    }

    //Case4
    @Test
    public void CheckMenuButtonLogicOpenHeader() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.clickOnCheckBox();
        welcomePage.clickOnSelectLocation();
        welcomePage.clickOnWelcomeBtn();
        HomePage homePage = new HomePage(driver);
        Assertions.assertTrue(homePage.getElementMenu().isDisplayed());
        homePage.clickOnMenu();
        HeaderHomePage headerHomePage = new HeaderHomePage(driver);
        headerHomePage.waitForYellowTail();
        Assertions.assertTrue(headerHomePage.getElementYellowTail().isDisplayed());
        Assertions.assertTrue(headerHomePage.getElementWines().isDisplayed());
        Assertions.assertTrue(headerHomePage.getElementToBuy().isDisplayed());
        Assertions.assertTrue(headerHomePage.getElementCocktails().isDisplayed());
        Assertions.assertTrue(headerHomePage.getElementOurStory().isDisplayed());
        Assertions.assertTrue(headerHomePage.getElementFaqs().isDisplayed());
        Assertions.assertTrue(headerHomePage.getElementContact().isDisplayed());
        headerHomePage.clickOnYellowTail();
        Assertions.assertTrue(homePage.getElementMenu().isDisplayed());
    }

    //Case5
    @Test
    public void CheckMenuButtonLogicCloseHeader() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.clickOnCheckBox();
        welcomePage.clickOnSelectLocation();
        welcomePage.clickOnWelcomeBtn();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMenu();
        HeaderHomePage headerHomePage = new HeaderHomePage(driver);
        headerHomePage.waitForYellowTail();
        headerHomePage.clickOnYellowTail();
        Assertions.assertTrue(homePage.getElementMenu().isDisplayed());
    }

    //Case6
    @Test
    public void CheckGlobalNavLogic() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.clickOnCheckBox();
        welcomePage.clickOnSelectLocation();
        welcomePage.clickOnWelcomeBtn();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMenu();
        HeaderHomePage headerHomePage = new HeaderHomePage(driver);
        headerHomePage.clickOnLocation();
        headerHomePage.clickElementLocationChina();
        headerHomePage.waitChinaUrl();
        Assertions.assertTrue(driver.getCurrentUrl().contains(".cn"));

    }

    //Case8
    @Test
    public void CheckWhereToBuy() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.clickOnCheckBox();
        welcomePage.clickOnSelectLocation();
        welcomePage.clickOnWelcomeBtn();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMenu();
        HeaderHomePage headerHomePage = new HeaderHomePage(driver);
        headerHomePage.clickElementWhereToBuy();
        StoresPage storesPage = new StoresPage(driver);
        storesPage.enterStoreLocation();
        storesPage.clickCofirmBtn();
        storesPage.waitForResults();
        Assertions.assertTrue(storesPage.getElementResults().isDisplayed());
    }

    //Case9
    @Test
    public void CheckCocktailsSelectOneWine() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.clickOnCheckBox();
        welcomePage.clickOnSelectLocation();
        welcomePage.clickOnWelcomeBtn();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMenu();
        HeaderHomePage headerHomePage = new HeaderHomePage(driver);
        headerHomePage.clickElementCocktails();
        CocktailsPage cocktailsPage = new CocktailsPage(driver);
        cocktailsPage.clickElementDropdownWines();
        cocktailsPage.clickElementRedWineCocktails();
        for (WebElement item : cocktailsPage.getElementCocktailsResults()) {
            Assertions.assertTrue(item.isDisplayed());
            Assertions.assertEquals(7, cocktailsPage.getElementCocktailsResults().size());
        }
    }

    //Case10
    @Test
    public void CheckCocktailsNavigateCocktailRecipePage() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.clickOnCheckBox();
        welcomePage.clickOnSelectLocation();
        welcomePage.clickOnWelcomeBtn();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMenu();
        HeaderHomePage headerHomePage = new HeaderHomePage(driver);
        headerHomePage.clickElementCocktails();
        CocktailsPage cocktailsPage = new CocktailsPage(driver);
        Actions builder = new Actions(driver);
        builder.moveToElement(cocktailsPage.getElementCocktailsRaspberryRose()).build().perform();
        cocktailsPage.clickElementCocktailsRaspberryRose();
        Assertions.assertTrue(driver.getPageSource().contains("Ingredients"));
    }

    //Case11
    @Test
    public void CheckCocktailsSelectSeveralWines() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.clickOnCheckBox();
        welcomePage.clickOnSelectLocation();
        welcomePage.clickOnWelcomeBtn();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMenu();
        HeaderHomePage headerHomePage = new HeaderHomePage(driver);
        headerHomePage.clickElementCocktails();
        CocktailsPage cocktailsPage = new CocktailsPage(driver);
        cocktailsPage.clickElementDropdownWines();
        cocktailsPage.clickElementRedWineCocktails();
        cocktailsPage.clickElementSparklingWineCocktails();
        Assertions.assertTrue(cocktailsPage.getElementDropdownWines().getText().contains("Multiple"));
        for (WebElement item : cocktailsPage.getElementCocktailsResults2()) {
            Assertions.assertTrue(item.isDisplayed());
            Assertions.assertEquals(18, cocktailsPage.getElementCocktailsResults2().size());
        }
    }
}