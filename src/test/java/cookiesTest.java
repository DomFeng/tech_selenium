import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class cookiesTest {
    public static WebDriver driver;

    @BeforeAll
    public static void initData(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        driver = new ChromeDriver(options);
    }

    @Test
    public void saveCookie(WebDriver driver){
        //cookies处理
        try {
            FileWriter fileWriter = new FileWriter("cookies.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //循环遍历，每次只取一条cookie进行处理
            for (Cookie cookie : driver.manage().getCookies()){
                //获取所有cookie内容
                cookie.getName();
                cookie.getValue();
                cookie.getDomain();
                cookie.getPath();
                cookie.getExpiry();
                cookie.isSecure();
                //进行保存
                bufferedWriter.write(cookie.getName()+";"+
                        cookie.getValue()+";"+
                        cookie.getDomain()+";"+
                        cookie.getPath()+";"+
                        cookie.getExpiry()+";"+
                        cookie.isSecure());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
