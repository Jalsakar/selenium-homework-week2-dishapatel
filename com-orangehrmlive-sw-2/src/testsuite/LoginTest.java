package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    //Before Annotation to set up baseUrl
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * 1. userShouldLoginSuccessfullyWithValidCredentials
     * * Enter “Admin” username
     * * Enter “admin123 password
     * * Click on ‘LOGIN’ button
     * * Verify the ‘Dashboard’ text is display
     */
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter "Admin" username
        WebElement adminUsername = driver.findElement(By.name("username"));
        adminUsername.sendKeys("Admin");
        // Enter “admin123 password
        driver.findElement(By.name("password")).sendKeys("admin123");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Verify the ‘Dashboard’ text is display
        String expectedResult = "Dashboard";
        String actualResult = driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']")).getText();
        Assert.assertEquals("Incorrect text is displayed", expectedResult, actualResult);
    }

    @After
    // After Annotation to close all the browser
    public void tearDown() {
        closeBrowser();
    }
}
