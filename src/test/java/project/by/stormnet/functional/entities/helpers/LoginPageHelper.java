package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.LoginPage;

public class LoginPageHelper extends AbstractHelper {
    private LoginPage loginPage = new LoginPage();

    public MyAccountPageHelper successfulLogin(String email, String password) {
        loginPage.fillLoginField(email);
        loginPage.fillPasswordField(password);
        loginPage.clickButtonSubmit();
        return new MyAccountPageHelper();
    }

    public LoginPageHelper failedLogin(String email, String password) {
        loginPage.fillLoginField(email);
        loginPage.fillPasswordField(password);
        loginPage.clickButtonSubmitError();
        return this;
    }

    public String checkInvalidLoginMessage() {
        String result = loginPage.checkInvalidLoginMessage();
        clearLoginField();
        return result;
    }

    private LoginPageHelper clearLoginField() {
        loginPage.clearLoginField();
        return this;
    }

    public LoginPageHelper failedCreateAccount(String email){
        loginPage.fillEmailField(email);
        loginPage.clickCreateAccountButtonError();
        return this;
    }

    public boolean checkEmailErrorMessage(){
        return loginPage.checkInvalidEmailMessage();
    }

    public ForgotPasswordPageHelper clickForgotPassword(){
        loginPage.clickForgotPassword();
        return new ForgotPasswordPageHelper();
    }

    public LoginPageHelper useRandomEmail(){
        loginPage.generateRandomEmail();
        return this;
    }

    public CreateAccountPageHelper goToCreateAccount(){
        loginPage.clickCreateAccountButton();
        return new CreateAccountPageHelper();
    }

    public String checkBackToLogin(){
        return loginPage.checkBackToLogin();
    }

}
