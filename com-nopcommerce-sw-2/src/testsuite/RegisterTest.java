package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /*
     *1. userShouldNavigateToRegisterPageSuccessfully
     * click on the ‘Register’ link
     * Verify the text ‘Register’
     */
    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        //Click on Register link
        WebElement registerLink = driver.findElement(By.className("ico-register"));
        registerLink.click();
        //Verify the text 'Register'
        String expectedText = "Register";
        WebElement actualTextElement = driver.findElement(By.className("page-title"));
        String actualText = actualTextElement.getText();
        System.out.println(actualText);
        Assert.assertEquals("Text is not displayed", expectedText, actualText);
    }

    /**
     * 2. userShouldRegisterAccountSuccessfully *
     * Click on the ‘Register’ link
     * Select gender radio button
     * Enter First name
     * Enter Last name
     * Select Day Month and Year
     * Enter Email address
     * Enter Password
     * Enter Confirm password
     * Click on REGISTER button
     * Verify the text 'Your registration completed
     */
    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //Click on the ‘Register’ link
        WebElement registerLink = driver.findElement(By.className("ico-register"));
        registerLink.click();
        //Select gender Male radio button
        WebElement genderMaleButton = driver.findElement(By.id("gender-male"));
        genderMaleButton.click();
        //Select gender Female radio button
        WebElement genderFemaleButton = driver.findElement(By.id("gender-female"));
        genderFemaleButton.click();
        //Enter First name
        driver.findElement(By.id("FirstName")).sendKeys("Ruby");
        //Enter Last name
        driver.findElement(By.id("LastName")).sendKeys("Jackson");
        //Select Day Month and Year
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("1");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("January");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1999");
        //Generate a random Email
        final String randomEmail = randomEmail();
        //Enter Email address
        driver.findElement(By.id("Email")).sendKeys(randomEmail);
        //Enter Password
        driver.findElement(By.id("Password")).sendKeys("123456");
        //Enter Confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
        //Click on REGISTER button
        driver.findElement(By.id("register-button")).click();
        //Verify the text 'Your registration completed
        String expectedMessage = "Your registration completed";
        WebElement actualTextElement = driver.findElement(By.className("result"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Text is not displayed", expectedMessage, actualMessage);
    }

    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }

    @After
    public void tearDown() {
        //close all the browser
        closeBrowser();
    }
}