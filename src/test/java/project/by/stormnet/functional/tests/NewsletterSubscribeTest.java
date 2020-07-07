package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entities.helpers.HomePageHelper;


public class NewsletterSubscribeTest extends AbstractTest {
    private HomePageHelper homeHelper = new HomePageHelper();

    private String registeredEmail = "testexam@gmail.com";
    private String invalidEmail = "test";

    @Test(priority = 1, description = "Success Newsletter Subscription")
    public void successNewsletterSubscriptionTest(){
        String expected = "Newsletter : You have successfully subscribed to this newsletter.";
        homeHelper.doSuccessNewsletterSubscription();
        String actual = homeHelper.checkSuccessMessage();
        Assert.assertEquals(actual,expected,"Failed subscribe!");
    }

    @Test(priority = 3, description = "Email already used")
    public void emailAlreadyUsedTest(){
        String expected = "Newsletter : This email address is already registered.";
        homeHelper.doErrorNewsletterSubscription(registeredEmail);
        String actual = homeHelper.checkErrorMessage();
        Assert.assertEquals(actual,expected,"Message not displaying");
    }

    @Test(priority = 2,description = "Send invalid email format")
    public void invalidEmailFormatTest(){
        String expected = "Newsletter : Invalid email address.";
        homeHelper.doErrorNewsletterSubscription(invalidEmail);
        String actual = homeHelper.checkErrorMessage();
        Assert.assertEquals(actual,expected,"Message not displaying");
    }

    @Test(priority = 4, description = "Send empty field")
    public void sendEmptyEmailField(){
        homeHelper.sendEmptyEmailNewsletter();
        boolean actual = homeHelper.checkVisibilityErrorMessage();
        Assert.assertTrue(actual,"Message not displaying");
    }
}
