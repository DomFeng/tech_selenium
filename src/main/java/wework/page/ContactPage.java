package wework.page;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

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

    public String getUserName(){
        return driver.findElement(By.cssSelector(".member_display_cover_detail_name")).getText();
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

    public ContactPage importFromFile(String path){
        System.out.println(path);
        //转换变量的编码
        String path_utf = "";
        try {
            path_utf = URLDecoder.decode(path,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        click(By.cssSelector(".ww_operationBar:nth-child(1) .ww_btn_PartDropdown_left"));
        click(By.linkText("文件导入"));
        //直接赋值弹窗的文件路径
        upload(By.name("file"), path_utf);
        //driver.findElement(By.name("file")).sendKeys("C:\\Users\\FENG.LAPTOP-A6J84O42\\IdeaProjects\\tech_selenium\\src\\main\\resources\\通讯录批量导入模板.xlsx");
        click(By.linkText("确认导入"));
        click(By.xpath("//*[@id=\"reloadContact\"]"));
        return this;
    }
}
