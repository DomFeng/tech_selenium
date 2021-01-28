import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class uploadTest extends baseTest{

    @Test
    public void uploadTest(){
        try {
            driver.get("https://www.baidu.com");
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//span[@class='soutu-btn']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@class='upload-pic']")).sendKeys("C:\\Users\\FENG.LAPTOP-A6J84O42\\Pictures\\Saved Pictures\\timg.jpg");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
