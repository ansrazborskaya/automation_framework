package project.by.stormnet.functional.entities.pages;


public class LoginPage extends AbstractPage {
    private static String title = "//h3[text()='Already registered?']";
    private String loginField = "//input[@id='email']";
    private String passwordField = "//input[@id='passwd']";
    private String buttonSubmit = "//button[@id='SubmitLogin']";
    private String email = "//input[@id='email_create']";
    private String createAccountButton = "//button[@id='SubmitCreate']";
    private String forgotPasswordButton = "//a[@href='http://automationpractice.com/index.php?controller=password']";
    private String messageError = "//p[text()='There is 1 error']";
    private String createAccountMessageError = "//div[@id='create_account_error']/ol/li";
    private String navigationBar = "//span[@class='navigation_page']";

    public static LoginPage getLoginPage(){
        LoginPage loginPage = new LoginPage();
        waitForElementVisible(getElementBy(title));
        return loginPage;
    }

    public LoginPage fillLoginField(String email){
        getElement(loginField).sendKeys(email);
        return getLoginPage();
    }

    public LoginPage clearLoginField(){
        getElement(loginField).clear();
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

    public void clickButtonSubmitError(){
        getElement(buttonSubmit).click();

    }

    public String checkInvalidLoginMessage(){

        return getElement(messageError).getAttribute("innerText").trim();
    }

    public LoginPage fillEmailField(String emailError){
        getElement(email).sendKeys(emailError);
        return getLoginPage();
    }

    public LoginPage generateRandomEmail(){
        String emailRandom = generateEmailAddress();
       getElement(email).sendKeys(emailRandom);
       return getLoginPage();

    }


    public void clickCreateAccountButtonError(){
        getElement(createAccountButton).click();
    }

    public boolean checkInvalidEmailMessage(){
        waitForElementVisible(getElementBy(createAccountMessageError));
        return getElement(createAccountMessageError).isDisplayed();
    }
    public ForgotPasswordPage clickForgotPassword(){
        getElement(forgotPasswordButton).click();
        return ForgotPasswordPage.getForgotPasswordPage();
    }

    public CreateAccountPage clickCreateAccountButton(){
        getElement(createAccountButton).click();
        return CreateAccountPage.getCreateAccountPage();
    }

    public String checkBackToLogin(){
        return getElement(navigationBar).getAttribute("innerText").trim();
    }

}
