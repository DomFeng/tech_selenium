package wework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import wework.page.ContactPage;
import wework.page.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        String username = contact.addMember("1","1","18101067536").testSearch("1").getUserName();
        //断言 是否查询到新增的用户
        assertEquals(username,"1");
    }

    @Test
    public void testSearch(){
        contact.testSearch("1").testDelete();
    }

    @Test
    public void testImportFromFile(){
        contact.importFromFile("C:\\Users\\FENG.LAPTOP-A6J84O42\\IdeaProjects\\tech_selenium\\src\\main\\resources\\通讯录批量导入模板.xlsx");
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
