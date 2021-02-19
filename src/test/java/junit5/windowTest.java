package junit5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class windowTest {
    public static WebDriver driver;

    @BeforeAll
    public static void initData(){
        driver = new ChromeDriver();
        //隐式等待3s
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void switchWindowTest(){
        try {
            driver.get("https://www.baidu.com");
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//*[@id='u1']/a[@name='tj_login']")).click();
            //百度首页的窗口句柄
            String baiduWin = driver.getWindowHandle();
            driver.findElement(By.xpath("//a[@class='pass-reglink pass-link']")).click();
            for(String win:driver.getWindowHandles()){
                if(!win.equals(baiduWin)){
                    driver.switchTo().window(win);
                    driver.findElement(By.id("TANGRAM__PSP_4__userName")).sendKeys("feng12345104");
                    driver.findElement(By.id("TANGRAM__PSP_4__phone")).sendKeys("18101011111");
                    driver.findElement(By.id("TANGRAM__PSP_4__password")).sendKeys("feng1234");
                    driver.findElement(By.id("TANGRAM__PSP_4__verifyCodeSend")).click();
                    driver.findElement(By.id("TANGRAM__PSP_4__verifyCode")).sendKeys("qwer");
                    driver.findElement(By.id("TANGRAM__PSP_4__isAgree")).click();
                    driver.switchTo().window(baiduWin);
                    driver.findElement(By.id("TANGRAM__PSP_11__footerULoginBtn")).click();
                    driver.findElement(By.id("TANGRAM__PSP_11__userName")).sendKeys("18101011111");
                    driver.findElement(By.id("TANGRAM__PSP_11__password")).sendKeys("feng1234");
                    Thread.sleep(3000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
