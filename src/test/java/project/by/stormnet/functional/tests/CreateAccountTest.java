package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entities.helpers.CreateAccountPageHelper;
import project.by.stormnet.functional.entities.helpers.HomePageHelper;
import project.by.stormnet.functional.entities.helpers.LoginPageHelper;
import project.by.stormnet.functional.entities.helpers.MyAccountPageHelper;


public class CreateAccountTest extends AbstractTest {
    private HomePageHelper homeHelper = new HomePageHelper();
    private LoginPageHelper loginHelper = new LoginPageHelper();
    private CreateAccountPageHelper createHelper = new CreateAccountPageHelper();
    private MyAccountPageHelper myAccountHelper = new MyAccountPageHelper();

    private String email = "testexam@gmail.com";
    private String password = "1234";

    @Test(priority = 1, description = "Create new account")
    public void successCreateAccountTest(){
        String expected = "MY ACCOUNT";
        homeHelper.goToLogin();
        loginHelper.useRandomEmail();
        loginHelper.goToCreateAccount();
        createHelper.successCreateAccount();
        String actual = myAccountHelper.checkSuccessfulLogin();
        Assert.assertEquals(actual,expected,"Failed!");
    }

    @Test(priority = 2,description = "Create new account error")
    public void failedCreateAccountTest(){
        loginHelper.useRandomEmail();
        loginHelper.goToCreateAccount();
        createHelper.failedCreateAccount();
        boolean result = createHelper.checkErrorMessage();
        Assert.assertTrue(result,"New account was created!");
    }

    @Test(priority = 3, description = "Create new account with registered mail")
    public void createAccountWithRegisteredMailTest(){
        String expected = "An account using this email address has already been registered.";
        homeHelper.goToLogin();
        loginHelper.useRandomEmail();
        loginHelper.goToCreateAccount();
        createHelper.createAccountWithRegisteredMail(email);
        String actual = createHelper.checkErrorMessageText();
        Assert.assertEquals(actual,expected,"Failed!");
    }

    @Test(priority = 3, description = "Create account with invalid password")
    public void createAccountWithInvalidPasswordTest(){
        String expected = "passwd is invalid.";
        homeHelper.goToLogin();
        loginHelper.useRandomEmail();
        loginHelper.goToCreateAccount();
        createHelper.createAccountWithInvalidPassword(password);
        String actual = createHelper.checkErrorMessageText();
        Assert.assertEquals(actual,expected,"Failed!");
    }
}
