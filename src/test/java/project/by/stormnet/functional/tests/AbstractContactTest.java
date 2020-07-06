package project.by.stormnet.functional.tests;

import org.testng.annotations.*;
import project.by.stormnet.functional.entities.helpers.AbstractHelper;

public class AbstractContactTest {
   AbstractHelper abstractHelper;
    @BeforeTest
    public void setUp(){
        abstractHelper = new AbstractHelper();
        abstractHelper.openBrowser();
        abstractHelper.open();
    }

    @AfterTest
    public void close(){
        abstractHelper.quit();
    }


}
