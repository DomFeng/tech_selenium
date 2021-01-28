import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;


public class jsTest extends baseTest{
    @Test
    public void jsTest(){
        try {
            driver.get("https://www.12306.cn/index/");
            JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
            Thread.sleep(3000);
            jsDriver.executeScript("document.getElementById('train_date').value='2020-12-30'");
            Thread.sleep(3000);
            System.out.println(jsDriver.executeScript("return document.getElementById('train_date').value"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
