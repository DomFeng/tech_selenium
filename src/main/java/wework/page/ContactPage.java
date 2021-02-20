package wework.page;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends BasePage{
    By addMember = By.linkText("添加成员");
    By username = By.name("username");
    By delete = By.cssSelector(".js_del_member");

    public ContactPage(RemoteWebDriver driver) {
        //继承父类driver
        super(driver);
    }

    public ContactPage addMember(String username, String acctid, String mobile){
        //todo;
        while(driver.findElements(this.username).size()==0){
            click(addMember);
//            driver.findElement(addMember).click();
        }
        sendkeys(this.username,username);
        sendkeys(By.name("acctid"),acctid);
        sendkeys(By.name("mobile"),mobile);
//        driver.findElement(this.username).sendKeys(username);
//        driver.findElement(By.name("acctid")).sendKeys(acctid);
//        driver.findElement(By.name("mobile")).sendKeys(mobile);
        click(By.cssSelector(".js_btn_save"));
//        driver.findElement(By.cssSelector(".js_btn_save")).click();
        return this;
    }

    public ContactPage testSearch(String keyword){
        sendkeys(By.id("memberSearchInput"),keyword);
//        driver.findElement(By.id("memberSearchInput")).sendKeys(keyword);
        return this;
    }

    public ContactPage testDelete(){
        click(delete);
        click(By.linkText("确认"));
        click(By.id("clearMemberSearchInput"));
//        driver.findElement(delete).click();
//        driver.findElement(By.linkText("确认")).click();
//        driver.findElement(By.id("clearMemberSearchInput")).click();
        return this;
    }
}
