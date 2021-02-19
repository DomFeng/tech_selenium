package wework.page;
import org.openqa.selenium.By;

public class ContactPage {
    By addMember = By.linkText("添加成员");
    By username = By.name("username");
    public ContactPage addMember(String username, String acctid, String mobile){
        //todo;
        while(MainPage.driver.findElements(this.username).size()==0){
            MainPage.driver.findElement(addMember).click();
        }
        MainPage.driver.findElement(this.username).sendKeys("1");
        MainPage.driver.findElement(By.name("acctid")).sendKeys("1");
        MainPage.driver.findElement(By.name("mobile")).sendKeys("18101067536");
        MainPage.driver.findElement(By.cssSelector(".js_btn_save")).click();
        return this;
    }
}
