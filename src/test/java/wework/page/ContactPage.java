package wework.page;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ContactPage {
    By addMember = By.linkText("添加成员");
    By username = By.name("username");
    By delete = By.cssSelector(".js_del_member");
    public ContactPage addMember(String username, String acctid, String mobile){
        //todo;
        while(MainPage.driver.findElements(this.username).size()==0){
            MainPage.driver.findElement(addMember).click();
        }
        MainPage.driver.findElement(this.username).sendKeys(username);
        MainPage.driver.findElement(By.name("acctid")).sendKeys(acctid);
        MainPage.driver.findElement(By.name("mobile")).sendKeys(mobile);
        MainPage.driver.findElement(By.cssSelector(".js_btn_save")).click();
        return this;
    }

    public ContactPage testSearch(String keyword){
        MainPage.driver.findElement(By.id("memberSearchInput")).sendKeys(keyword);
        new WebDriverWait(MainPage.driver,10)
                .until(ExpectedConditions.elementToBeClickable(delete));
        return this;
    }

    public ContactPage testDelete(){
        MainPage.driver.findElement(delete).click();
        MainPage.driver.findElement(By.linkText("确认")).click();
        MainPage.driver.findElement(By.id("clearMemberSearchInput")).click();
        return this;
    }
}
