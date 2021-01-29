import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class alertTest extends baseTest{
    @Test
    public void alertTest(){
        try {
            Actions actions = new Actions(driver);
            driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");
            driver.manage().window().maximize();
            driver.switchTo().frame("iframeResult");
            actions.dragAndDrop(driver.findElement(By.id("draggable")),driver.findElement(By.id("droppable"))).perform();
            Thread.sleep(3000);
            driver.switchTo().alert().accept();
            Thread.sleep(3000);
            driver.switchTo().parentFrame();
            System.out.println(driver.findElement(By.id("submitBTN")).getText());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
