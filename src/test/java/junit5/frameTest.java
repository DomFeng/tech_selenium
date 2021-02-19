package junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class frameTest {
    public static WebDriver driver;

    @BeforeAll
    public static void initdata(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void frameTest(){
        driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");
        driver.switchTo().frame("iframeResult");
        System.out.println(driver.findElement(By.id("draggable")).getText());
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.id("submitBTN")).getText());
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
