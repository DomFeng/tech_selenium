package wework.page;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {
    By addMember = By.linkText("添加成员");
    By username = By.name("username");
    By delete = By.cssSelector(".js_del_member");
    RemoteWebDriver driver;

    public ContactPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public ContactPage addMember(String username, String acctid, String mobile){
        //todo;
        while(driver.findElements(this.username).size()==0){
            driver.findElement(addMember).click();
        }
        driver.findElement(this.username).sendKeys(username);
        driver.findElement(By.name("acctid")).sendKeys(acctid);
        driver.findElement(By.name("mobile")).sendKeys(mobile);
        driver.findElement(By.cssSelector(".js_btn_save")).click();
        return this;
    }

    public ContactPage testSearch(String keyword){
        driver.findElement(By.id("memberSearchInput")).sendKeys(keyword);
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(delete));
        return this;
    }

    public ContactPage testDelete(){
        driver.findElement(delete).click();
        driver.findElement(By.linkText("确认")).click();
        driver.findElement(By.id("clearMemberSearchInput")).click();
        return this;
    }
}
