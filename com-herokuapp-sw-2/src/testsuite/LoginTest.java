package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    static String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    //Before Annotation to set up baseUrl
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * 1. userShouldLoginSuccessfullyWithValidCredentials
     * * Enter “tomsmith” username
     * * Enter “SuperSecretPassword!” password
     * * Click on ‘LOGIN’ button
     * * Verify the text “Secure Area”
     */
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.className("radius")).click();
        //Verify the text “Secure Area”
        String expectedResult = "Secure Area";
        String actualResult = driver.findElement(By.xpath("//div[@class='example']//h2")).getText();
        Assert.assertEquals("It is not a Secure Area", expectedResult, actualResult);
    }

    /**
     * 2. verifyTheUsernameErrorMessage
     * * Enter “tomsmith1” username
     * * Enter “SuperSecretPassword!” password
     * * Click on ‘LOGIN’ button
     * * Verify the error message “Your username is invalid!”
     */
    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.className("radius")).click();
        //Verify the error message “Your username is invalid!”
        String expectedErrorMessage = "Your username is invalid!\n×";
        String actualMessage = driver.findElement(By.id("flash")).getText();
        Assert.assertEquals(expectedErrorMessage, actualMessage);
    }

    /**
     * 3. verifyThePasswordErrorMessage
     * * Enter “tomsmith” username
     * * Enter “SuperSecretPassword” password
     * * Click on ‘LOGIN’ button
     * * Verify the error message “Your password is invalid!”
     */
    @Test
    public void verifyThePasswordErrorMessage() {
        //Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        //Click on ‘LOGIN’ button
        driver.findElement(By.className("radius")).click();
        //Verify the error message “Your password is invalid!”
        WebElement invalidPassWor = driver.findElement(By.id("flash"));
        System.out.println(invalidPassWor.getText());
        Assert.assertEquals("Incorrect password", "Your password is invalid!\n×", invalidPassWor.getText());
    }

    @After
    //close all the browser
    public void tearDown() {
        // closeBrowser();
    }
}