package wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

//将高频方法封装到父类中，子类继承使用
public class BasePage {
    RemoteWebDriver driver;
    WebDriverWait wait;

    public BasePage() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
    }

    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    public void quit() {
        driver.quit();
    }

    //将元素点击进行封装
    public void click(By by){
        //todo：异常处理
        //判断元素可点击
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    //将赋值进行封装
    public void sendkeys(By by,String contant){
        //判断元素可视化
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(contant);
    }

    //将上传进行封装
    public void upload(By by,String path){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).sendKeys(path);
    }
}
