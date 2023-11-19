package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    static String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    //Before Annotation to set up baseUrl
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * 1. userShouldNavigateToLoginPageSuccessfully *
     * Click on the ‘Sign In’ link
     * Verify the text ‘Welcome Back!’
     */
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Click on the ‘Sign In’ link
        WebElement signIn = driver.findElement(By.partialLinkText("Sign In"));
        signIn.click();
        //Verify the text ‘Welcome Back!’
        String expectedText = "Welcome Back!";
        WebElement actualText = driver.findElement(By.xpath("//h2[@class='page__heading']"));
        Assert.assertEquals("Wrong text is displayed", expectedText, actualText.getText());
    }

    /**
     * 2. verifyTheErrorMessage
     * * Click on the ‘Sign In’ link'
     * * Enter invalid username
     * * Enter invalid password
     * * Click on Login button
     * * Verify the error message ‘Invalid email or password.’
     */
    @Test
    public void verifyTheErrorMessage() {
        //Click on the ‘Sign In’ link
        driver.findElement(By.partialLinkText("Sign In")).click();
        //Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("abc2023@gamil.com");
        //Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("123456");
        //Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Verify the error message ‘Invalid email or password.’
        String expectedErrorMessage = "Invalid email or password.";
        String actualErrorMessage = driver.findElement(By.xpath("//*[@id=\"notice\"]/ul/li")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @After
    //After Annotation to close all the browser
    public void tearDown() {
        // closeBrowser();
    }
}
