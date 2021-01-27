import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AiceTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void initData(){
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,5);
    }

    @Test
    public void login(){
        driver.get("https://home.testing-studio.com");
        //点击登录
        driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        //清除历史输入，输入用户名
        driver.findElement(By.id("login-account-name")).clear();
        driver.findElement(By.id("login-account-name")).sendKeys("domfeng");
        //清除历史输入，输入密码
        driver.findElement(By.id("login-account-password")).clear();
        driver.findElement(By.id("login-account-password")).sendKeys("feng0518");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void timeSleepTest(){
        driver.get("https://home.testing-studio.com");
        try {
            Thread.sleep(5000);
            driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void waitTest(){
        driver.get("https://home.testing-studio.com");
        //driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'登录')]")));
        element.click();
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }


}
