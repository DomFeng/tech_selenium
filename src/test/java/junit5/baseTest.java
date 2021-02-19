package junit5;

import net.bytebuddy.build.ToStringPlugin;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class baseTest {
    public static WebDriver driver;

    @BeforeAll
    public static void initData(){
        String browserName = System.getenv("browser");
        if("chrome".equals(browserName)){
            System.setProperty("webdriver.chrome.driver","C:\\selenium_driver\\ChromeDriver\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if("firefox".equals(browserName)){
            System.setProperty("webdriver.gecko.driver","C:\\selenium_driver\\geckodriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else if ("safari".equals(browserName)){
            driver = new SafariDriver();
        }
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
