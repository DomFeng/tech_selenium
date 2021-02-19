package wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPage {
    public static WebDriver driver;

    public MainPage() {
        String url = "https://work.weixin.qq.com/wework_admin/frame";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().deleteAllCookies();

        //todo:改成从文件读取
        driver.manage().addCookie(new Cookie("wwrtx.i18n_lan", "zh"));
        driver.manage().addCookie(new Cookie("wwrtx.c_gdpr", "0"));
        driver.manage().addCookie(new Cookie("ww_rtkey", "2sjll36"));
        driver.manage().addCookie(new Cookie("wwrtx.ref", "direct"));
        driver.manage().addCookie(new Cookie("wwrtx.refid", "1122733531343178"));
        driver.manage().addCookie(new Cookie("wwrtx.vst", "DWz2WUqrFvG2ZARVgcXCsHnfROPFj9Dbov5f7Arrc0hR3zbSD-iPY9ScMpLW7WtFCytzNcsRIBoxdY7KXxEPpTpaJWlxaMp8ZCxsyE4LDL1vd97i5ymwthetSz36EvAfTfAiGSsWCcKgV5Ql0TlG0dQ-AO3hUbMIZFeighSEfHS9aFhc8C1odIHpO3PbGneDgTvyGd9PRu20AYr4y9IsDOVC89FFXu5xuCzDqMHxm8bhvl7vLMuZd-CfPQWdo413sORJKBxNOLwD7qe0J_0xYw"));
        driver.manage().addCookie(new Cookie("wwrtx.d2st", "a6445004"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "3tj64jSC-jVFq6ddCRHeRzcgeaAIMz767CrIA-rY8BcXAQknLTSPSBaDvBW8Hs57"));
        driver.manage().addCookie(new Cookie("wwrtx.ltype", "1"));
        driver.manage().addCookie(new Cookie("wxpay.corpid", "1970324938372844"));
        driver.manage().addCookie(new Cookie("wxpay.vid", "1688852047822334"));
        driver.manage().addCookie(new Cookie("wwrtx.vid", "1688852047822334"));
        driver.get(url);
    }

    public ContactPage toContact(){
        //todo:进入通讯录页面
        driver.findElement(By.cssSelector("#menu_contacts")).click();
        return new ContactPage();
    }
}
