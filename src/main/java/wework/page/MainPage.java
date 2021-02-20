package wework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage{

    public MainPage() {
        //继承父类对象
        super();
        String url = "https://work.weixin.qq.com/wework_admin/frame";
        driver.get(url);
        driver.manage().deleteAllCookies();

        //todo:改成从文件读取
        driver.manage().addCookie(new Cookie("cookie: wwrtx.i18n_lan", "zh"));
        driver.manage().addCookie(new Cookie("wwrtx.c_gdpr", "0"));
        driver.manage().addCookie(new Cookie("wwrtx.ref", "direct"));
        driver.manage().addCookie(new Cookie("wwrtx.refid", "1122733531343178"));
        driver.manage().addCookie(new Cookie("wwrtx.ltype", "1"));
        driver.manage().addCookie(new Cookie("wxpay.corpid", "1970324938372844"));
        driver.manage().addCookie(new Cookie("wxpay.vid", "1688852047822334"));
        driver.manage().addCookie(new Cookie("wwrtx.vid", "1688852047822334"));
        driver.manage().addCookie(new Cookie("ptui_loginuin", "453850253"));
        driver.manage().addCookie(new Cookie("pt_sms_phone", "181******35"));
        driver.manage().addCookie(new Cookie("uin", "o0453850253"));
        driver.manage().addCookie(new Cookie("skey", "^@Tx53OypCS"));
        driver.manage().addCookie(new Cookie("RK", "zcAYC+NPVl"));
        driver.manage().addCookie(new Cookie("ptcz", "37b94148c2210384bb1e7d57528f1a0d64c87f172dab799aa8d63286c4ba371d"));
        driver.manage().addCookie(new Cookie("ww_rtkey", "5u6v883"));
        driver.manage().addCookie(new Cookie("wwrtx.vst", "BiGMstdLgRh3AqYyTM5-3KzyISNSELBSMiktdL9ZIozvJQHf7avCdfOJSuFDe9LjONTuP1v_7iNxtbvuyTaaxmOU287E3enxC8z4O0QMJDmyisFc38HPxkSrbYzH1rwtjRKon61rq-7AZMl7WxsgKSHs_17RDVVu4L85hASiMUriN_y4eD0-4uoLTsVeZNeCMzFP2T1Xb5MF_c1553jMRvGMp54RWO1IZvSY3rnF9rllFDRJa3du-StM45FF4XfAsm5Tb1E5V628CFuDw58MfA"));
        driver.manage().addCookie(new Cookie("wwrtx.d2st", "a8724241"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "3tj64jSC-jVFq6ddCRHeR9-a1g_LvrgzLkmNTwp7Pg2h02DZcGxed8UYUmitBUgX"));
        driver.get(url);
    }

    public ContactPage toContact(){
        //todo:进入通讯录页面
        click(By.cssSelector("#menu_contacts"));
        //driver.findElement(By.cssSelector("#menu_contacts")).click();
        return new ContactPage(driver);
    }

}
