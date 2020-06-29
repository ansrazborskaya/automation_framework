package project.by.stormnet.functional.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import project.by.stormnet.functional.entities.helpers.AbstractHelper;

public class BaseTest {

    AbstractHelper abstractHelper;

    @BeforeClass
    public void setUp(){
        abstractHelper = new AbstractHelper();
        abstractHelper.open();
    }

    @AfterClass
    public void close(){
        abstractHelper.quit();
    }

}
