package junit5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class cookiesTest {
    public static WebDriver driver;

    @Test
    public void initData(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9222");
        //复用浏览器
        //driver = new ChromeDriver(options);
        //不复用浏览器
        driver = new ChromeDriver();
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        saveCookie(driver);
        try {
            FileReader fileReader = new FileReader("cookies.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                StringTokenizer tokenizer = new StringTokenizer(line,";");
                String name = tokenizer.nextToken();
                String value = tokenizer.nextToken();
                String domain = tokenizer.nextToken();
                String path = tokenizer.nextToken();
                //把string转换为date
                Date expiry = null;
                String dt = tokenizer.nextToken();
                if(!dt.equals("null")){
                    //根据实际到期时间的位数来进行格式化 Mon Jan 18 08:00:00 CST 2038
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy" , Locale.ENGLISH);
                    expiry = sdf.parse(dt);
                }
                //吧string转换成boolean
                Boolean isSecure = Boolean.parseBoolean(tokenizer.nextToken());
                Cookie cookie = new Cookie(name,value,domain,path,expiry,isSecure);
                driver.manage().addCookie(cookie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        try {
            Thread.sleep(5000);
            //driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

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
