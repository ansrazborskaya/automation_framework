package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import project.by.stormnet.functional.entities.helpers.AbstractHelper;
import project.by.stormnet.functional.entities.helpers.ContactPageHelper;
import project.by.stormnet.functional.entities.helpers.HomePageHelper;

public class ContactPageTest extends AbstractTest {
    private HomePageHelper homeHelper = new HomePageHelper();
    private ContactPageHelper contactHelper = new ContactPageHelper();


    private String param;
    private String order = "22";
    private String email = "testexam@gmail.com";

    @DataProvider
    public static Object[][] messageProvider() {
        return new Object[][]{{"new"}, {"prepare"}, {"1254"}};
    }

    @Factory(dataProvider = "messageProvider")
    public ContactPageTest(String param) {
        this.param = param;
    }

    @BeforeClass
    public void prepareToTest() {
        homeHelper.goContactUs();
    }

    @Test(priority = 1, description = "Webmaster text test")
    public void checkWebmasterTextTest() {
        String expected = "If a technical problem occurs on this website";
        contactHelper.chooseWebmasterValue();
        String actual = contactHelper.checkVisibleWebmasterText();
        Assert.assertEquals(actual,expected, "Message not displaying");
    }


    @Test(priority = 2, description = "Check mandatory field Email")
    public void checkMandatoryFieldEmailTest() {
        contactHelper.checkMandatoryFieldEmail(order, param);
        boolean result = contactHelper.checkErrorMessageMandatoryEmail();
        Assert.assertTrue(result, "Message not displaying");
    }

    @Test(priority = 2,description = "Customer text test")
    public void checkCustomerTextTest() {
        String expected = "For any question about a product, an order";
        contactHelper.chooseCustomerValue();
        String actual = contactHelper.checkVisibleCustomerText();
        Assert.assertEquals(actual,expected, "Message not displaying");
    }

    @Test(priority = 4, description = "Check optional field order")
    public void checkOptionalFieldOrderTest() {
        homeHelper.goContactUs();
        contactHelper.checkMandatoryFieldOrder(email, param);
        boolean result = contactHelper.checkMessageOptionalOrder();
        Assert.assertTrue(result, "Message not displaying");
    }

    @Test(priority = 3, description = "Check mandatory field Message")
    public void checkMandatoryFieldMessageTest() {
        contactHelper.checkMandatoryFieldMessage(email, param);
        boolean result = contactHelper.checkErrorMessageMandatoryMessage();
        Assert.assertTrue(result, "Message not displaying");
    }

    @Test(priority = 5, description = "Success send message")
    public void successSendMessageTest() {
        homeHelper.goContactUs();
        contactHelper.successSendMessage(email,order, param);
        boolean result = contactHelper.checkSuccessMessage();
        Assert.assertTrue(result, "Message not displaying");
    }
}
