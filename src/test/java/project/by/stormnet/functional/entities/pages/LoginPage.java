package project.by.stormnet.functional.entities.pages;


public class LoginPage extends AbstractPage {
    private static String title = "//h3[text()='Already registered?']";
    private String loginField = "//input[@id='email']";
    private String passwordField = "//input[@id='passwd']";
    private String buttonSubmit = "//button[@id='SubmitLogin']";

    public static LoginPage getLoginPage(){
        LoginPage loginPage = new LoginPage();
        waitForElementVisible(getElementBy(title));
        return loginPage;
    }

    public LoginPage fillLoginField(String email){
        getElement(loginField).sendKeys(email);
        return getLoginPage();
    }

    public LoginPage fillPasswordField(String password){
        getElement(passwordField).sendKeys(password);
        return getLoginPage();
    }

    public MyAccountPage clickButtonSubmit(){
        getElement(buttonSubmit).click();
        return MyAccountPage.getMyAccountPage();
    }


}
