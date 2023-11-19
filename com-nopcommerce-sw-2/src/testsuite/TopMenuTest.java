package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * 1. userShouldNavigateToComputerPageSuccessfully
     * * Click on the ‘Computers’ Tab
     * * Verify the text ‘Computers'
     */
    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //Click on the ‘Computers’ Tab
        WebElement tabComputer = driver.findElement(By.partialLinkText("Computers"));
        tabComputer.click();
        WebElement pageTitle = driver.findElement(By.className("page-title"));
        //Verify the text ‘Computers'
        String expectedPageTitle = "Computers";
        String actualPageTitle = pageTitle.getText();
        Assert.assertEquals("Incorrect tab displayed",expectedPageTitle,actualPageTitle);
    }

    /**
     * 2. userShouldNavigateToElectronicsPageSuccessfully
     * * Click on the ‘Electronics’ Tab
     * * Verify the text ‘Electronics’
     */
    @Test
    public  void userShouldNavigateToElectronicsPageSuccessfully(){
        //Click on the ‘Electronics’ Tab
        WebElement tabElectronics = driver.findElement(By.partialLinkText("Electronics"));
        tabElectronics.click();
        WebElement pageTitle = driver.findElement(By.className("page-title"));
        //Verify the text ‘Electronics’
        String expectedPageTitle = "Electronics";
        String actualPageTitle = pageTitle.getText();
        Assert.assertEquals("Incorrect tab displayed",expectedPageTitle,actualPageTitle);
    }

    /**
     * 3. userShouldNavigateToApparelPageSuccessfully
     * * Click on the ‘Apparel’ Tab
     * * Verify the text ‘Apparel’
     */
    @Test
    public void userShouldNavigateToApparelPageSuccessfully(){
        //Click on the ‘Apparel’ Tab
        WebElement tabElectronics = driver.findElement(By.partialLinkText("Apparel"));
        tabElectronics.click();
        WebElement pageTitle = driver.findElement(By.className("page-title"));
        //Verify the text ‘Apparel’
        String expectedPageTitle = "Apparel";
        String actualPageTitle = pageTitle.getText();
        Assert.assertEquals("Incorrect tab displayed",expectedPageTitle,actualPageTitle);
    }

    /**
     * 4.userShouldNavigateToDigitalDownloadsPageSuccessfully
     * * click on the ‘Digital downloads’ Tab
     * * Verify the text ‘Digital downloads’
     */
    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully(){
        //Click on the ‘Digital Downloads’ Tab
        WebElement tabElectronics = driver.findElement(By.partialLinkText("Digital downloads"));
        tabElectronics.click();
        WebElement pageTitle = driver.findElement(By.className("page-title"));
        //Verify the text ‘Digital Downloads’
        String expectedPageTitle = "Digital downloads";
        String actualPageTitle = pageTitle.getText();
        Assert.assertEquals("Incorrect tab displayed",expectedPageTitle,actualPageTitle);
    }

    /**
     * 5. userShouldNavigateToBooksPageSuccessfully
     * * Click on the ‘Books’ Tab
     * * Verify the text ‘Books’
     */
    @Test
    public void userShouldNavigateToBooksPageSuccessfully(){
        //Click on the ‘Books’ Tab
        WebElement tabBooks = driver.findElement(By.partialLinkText("Books"));
        tabBooks.click();
        WebElement pageTitle = driver.findElement(By.className("page-title"));
        //Verify the text ‘Books’
        String expectedPageTitle = "Books";
        String actualPageTitle = pageTitle.getText();
        Assert.assertEquals("Incorrect tab displayed",expectedPageTitle,actualPageTitle);
    }

    /**
     * 6. userShouldNavigateToJewelryPageSuccessfully
     * * Click on the ‘Jewelry’ Tab
     * * Verify the text ‘Jewelry’
     */
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully(){
        //Click on the ‘Jewelry’ Tab
        WebElement tabBooks = driver.findElement(By.partialLinkText("Jewelry"));
        tabBooks.click();
        WebElement pageTitle = driver.findElement(By.className("page-title"));
        //Verify the text ‘Jewelry’
        String expectedPageTitle = "Jewelry";
        String actualPageTitle = pageTitle.getText();
        Assert.assertEquals("Incorrect tab displayed",expectedPageTitle,actualPageTitle);
    }

    /**
     * 7. userShouldNavigateToGiftCardsPageSuccessfully
     * * click on the ‘Gift Cards’ Tab
     * * Verify the text ‘Gift Cards'
     */
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
        //Click on the ‘Gift Cards’ Tab
        WebElement tabBooks = driver.findElement(By.partialLinkText("Gift Cards"));
        tabBooks.click();
        WebElement pageTitle = driver.findElement(By.className("page-title"));
        //Verify the text ‘Gift Cards’
        String expectedPageTitle = "Gift Cards";
        String actualPageTitle = pageTitle.getText();
        Assert.assertEquals("Incorrect tab displayed",expectedPageTitle,actualPageTitle);
    }
    @After
    public void tearDown(){
        //Close all browser
        closeBrowser();
    }
}
