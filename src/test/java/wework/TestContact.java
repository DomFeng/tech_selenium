package wework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import wework.page.ContactPage;
import wework.page.MainPage;

public class TestContact {
    public static MainPage main;
    public static ContactPage contact;

    @BeforeAll
    public static void beforeAll(){
        main = new MainPage();
        contact = main.toContact();
    }

    @Test
    public void testAddMember(){
        contact.addMember("1","1","18101067536");
    }

    @Test
    public void testSearch(){
        contact.testSearch("1").testDelete();
    }

    @AfterAll
    public static void tearDown(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        contact.quit();
    }
}
