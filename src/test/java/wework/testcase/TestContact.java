package wework.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import wework.page.MainPage;

public class TestContact {
    @Test
    public void testAddMember(){
        MainPage main = new MainPage();
        main.toContact().addMember("1","2","18101067536");
        //todo:assert
    }

    @AfterAll
    public static void tearDown(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainPage.driver.quit();
    }
}
