import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chromeCopy {
    public static WebDriver driver;

    @BeforeAll
    public static void initData(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testDemo(){
        driver.findElement(new By.ByCssSelector(".index_service_cnt_item_title")).click();
    }
}
