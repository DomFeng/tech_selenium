import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

public class jsTest extends baseTest{
    @Test
    public void jsTest(){
        driver.get("https://www.12306.cn/index/");
        javascriptExecutor jsDriver = (JavascriptExecutor)driver;
        jsDriver.executeScript("")
    }
}
