package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entities.helpers.ForgotPasswordPageHelper;
import project.by.stormnet.functional.entities.helpers.HomePageHelper;
import project.by.stormnet.functional.entities.helpers.LoginPageHelper;
import project.by.stormnet.functional.entities.helpers.MyAccountPageHelper;


public class LoginTest extends AbstractTest {

    private HomePageHelper homeHelper = new HomePageHelper();
    private LoginPageHelper loginHelper = new LoginPageHelper();
    private MyAccountPageHelper myAccountHelper = new MyAccountPageHelper();
    private ForgotPasswordPageHelper passwordHelper = new ForgotPasswordPageHelper();

    private String email = "testexam@gmail.com";
    private String password = "123/*---";
    private String emailError = "test@gmail.com";


    @BeforeClass
    public void prepareToTest(){
        homeHelper.goToLogin();
    }

    @Test(priority = 1)
    public void successfulLoginTest(){
        String expected = "MY ACCOUNT";
        loginHelper.successfulLogin(email,password);
        String actual = myAccountHelper.checkSuccessfulLogin();
        Assert.assertEquals(actual,expected,"Invalid login or password");

    }

    @Test(priority = 2, dataProvider = "invalidLogin")
    public void invalidLoginTest(String email){
        String expected = "There is 1 error";
        loginHelper.failedLogin(email,password);
        String actual = loginHelper.checkInvalidLoginMessage();
        Assert.assertEquals(actual,expected);
    }

    @Test(priority = 3)
    public void emailAlreadyRegisteredTest(){
        loginHelper.failedCreateAccount(emailError);
        boolean result = loginHelper.checkEmailErrorMessage();
        Assert.assertTrue(result,"Message not displaying");
    }

    @Test(priority = 4)
    public void successfulPasswordRecoveryTest(){
        loginHelper.clickForgotPassword();
        passwordHelper.successfulPasswordRecovery(email);
        boolean result = passwordHelper.checkSuccessfulPasswordRecovery();
        Assert.assertTrue(result,"Message not displaying");

    }

    @Test(priority = 5)
    public void backToLoginTest(){
        String expected = "Authentication";
        loginHelper.clickForgotPassword();
        passwordHelper.clickBackToLoginButton();
        String actual = loginHelper.checkBackToLogin();
        Assert.assertEquals(actual,expected,"Failed back to login!");
    }

    @Test(priority = 6,dataProvider = "invalidEmail")
    public void FailedPasswordRecoveryTest(String invalidEmail){
        loginHelper.clickForgotPassword();
        passwordHelper.failedPasswordRecovery(invalidEmail);
        boolean result = passwordHelper.checkFailedPasswordRecovery();
        Assert.assertTrue(result,"Message not displaying");
    }

    @DataProvider(name = "invalidLogin")
    public Object[] provideDate(){
        return new Object[][]{{"5ffffff"}, {"bla@bk.ru"},  {"newmail@mail.ru"}, {"56555555"}, {"title@"}};
    }

    @DataProvider(name = "invalidEmail")
    public Object[] invalidEmailDate(){
        return new Object[][]{{"5ffffff"}, {"@bk.ru"},  {"il.ru"}, {"56555555"}, {"title@"}};
    }

}
