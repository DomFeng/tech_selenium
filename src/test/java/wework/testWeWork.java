package wework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class testWeWork {
    public static  WebDriver driver;
    @Test
    public void chrome() {
        String url = "https://work.weixin.qq.com/wework_admin/frame";
        driver = new ChromeDriver();
        driver.get(url);
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

}
