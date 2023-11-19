package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ForgotPasswordTest extends BaseTest {
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    //Before Annotation to set up baseUrl
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * 1. userShouldNavigateToForgotPasswordPageSuccessfully
     * * Click on the ‘Forgot your password’ link
     * * Verify the text ‘Reset Password’
     */
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        //Click on the 'Forgot your password'
        driver.findElement(By.className("orangehrm-login-forgot-header")).click();

        //Verify the text 'Reset Password'
        String expectedResult = "Reset Password";
        String actualResult = driver.findElement(By.xpath("//button[@type='submit']")).getText();
    }
    @After
    //After Annotation to close all the browser
    public void tearDown(){
        //closeBrowser();
    }
}
