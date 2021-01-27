import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

public class InteractiveTest {
    public static WebDriver driver;
    //public static Actions actions;

    @BeforeAll
    public static void initData(){
        driver = new ChromeDriver();
        //actions = new Actions(driver);
    }

    @Test
    public void clickTest(){
        driver.get("http://sahitest.com/demo/clicks.htm");
        Actions actions = new Actions(driver);
        //单击
        actions.click(driver.findElement(By.xpath("//input[@value='click me']")));
        //双击
        actions.doubleClick(driver.findElement(By.xpath("//input[@Value='dbl click me']")));
        //右击
        actions.contextClick(driver.findElement(By.xpath("//input[@value='right click me']")));
        actions.perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void moveTest(){

        try {
            Actions actions = new Actions(driver);
            driver.get("https://www.baidu.com");
            actions.moveToElement(driver.findElement(By.id("s-usersetting-top")));
            actions.perform();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void dragTest(){
        try {
            Actions actions = new Actions(driver);
            driver.get("http://sahitest.com/demo/dragDropMooTools.htm");
            actions.dragAndDrop(driver.findElement(By.id("dragger")), driver.findElement(By.xpath("//div[@class='item'][1]"))).perform();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void keyBoardTest(){
        try {
            Actions actions = new Actions(driver);
            driver.get("http://sahitest.com/demo/label.htm");
            driver.findElements(By.xpath("//input[@type='textbox']")).get(0).sendKeys("feng");
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
            actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
            actions.keyDown(driver.findElements(By.xpath("//input[@type='textbox']")).get(1),Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void scrollTest(){
        try {
            driver.get("https://www.baidu.com");
            driver.findElement(By.id("kw")).sendKeys("霍格沃兹测试学院");
            TouchActions actions = new TouchActions(driver);
            actions.click(driver.findElement(By.id("su")));
            //将driver强转成javascript
            JavascriptExecutor js = (JavascriptExecutor)driver;
            //从页面顶部滑到页面最底部
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            Thread.sleep(3000);
            //driver.findElement(By.xpath("//a[@class='n']")).click();
            //或者
            driver.findElement(By.xpath("//*[@id='page']//a[last()]")).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
