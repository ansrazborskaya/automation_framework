package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.LoginPage;

public class LoginPageHelper extends AbstractHelper{
    private LoginPage loginPage = new LoginPage();

    public MyAccountPageHelper successfulLogin(String email, String password){
        loginPage.fillLoginField(email);
        loginPage.fillPasswordField(password);
        loginPage.clickButtonSubmit();
        return new MyAccountPageHelper();
    }
}
