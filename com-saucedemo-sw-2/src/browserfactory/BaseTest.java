package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
        //Setup Browser - Launch the browser
        static String browser = "Chrome";
        public static WebDriver driver;
        public void openBrowser(String baseUrl){
            if (browser.equalsIgnoreCase("Chrome")){
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("FireFox")) {
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("Edge")) {
                driver = new EdgeDriver();
            }else{
                System.out.println("Wrong Browser name");
            }
            //Open the Url into Browser
            driver.get(baseUrl);
            // Maximise the Browser
            driver.manage().window().maximize();
            // We give implicit wait to driver
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
        public void closeBrowser(){
            //close all the browser
            driver.quit();
        }
}