package project.by.stormnet.functional.entities.pages;


import io.qameta.allure.Step;

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

    @Step("Get login page")
    public static LoginPage getLoginPage() {
        LoginPage loginPage = new LoginPage();
        waitForElementVisible(getElementBy(title));
        return loginPage;
    }

    @Step("Fill login field")
    public LoginPage fillLoginField(String email) {
        getElement(loginField).sendKeys(email);
        return getLoginPage();
    }

    @Step("Clear login field")
    public LoginPage clearLoginField() {
        getElement(loginField).clear();
        return getLoginPage();
    }

    @Step("Fill password field")
    public LoginPage fillPasswordField(String password) {
        getElement(passwordField).sendKeys(password);
        return getLoginPage();
    }

    @Step("Click submit button")
    public MyAccountPage clickButtonSubmit() {
        getElement(buttonSubmit).click();
        return MyAccountPage.getMyAccountPage();
    }

    @Step("Click submit button with error")
    public void clickButtonSubmitError() {
        getElement(buttonSubmit).click();

    }

    @Step("Check invalid login message")
    public String checkInvalidLoginMessage() {
        return getElement(messageError).getAttribute("innerText").trim();
    }

    @Step("Fill email field")
    public LoginPage fillEmailField(String emailError) {
        getElement(email).sendKeys(emailError);
        return getLoginPage();
    }

    @Step("Fill in the random values field email")
    public LoginPage generateRandomEmail() {
        String emailRandom = generateEmailAddress();
        getElement(email).sendKeys(emailRandom);
        return getLoginPage();
    }

    @Step("Click create account button with error")
    public void clickCreateAccountButtonError() {
        getElement(createAccountButton).click();
    }

    @Step("Check invalid email message")
    public boolean checkInvalidEmailMessage() {
        waitForElementVisible(getElementBy(createAccountMessageError));
        return getElement(createAccountMessageError).isDisplayed();
    }

    @Step("Click forgot password button")
    public ForgotPasswordPage clickForgotPassword() {
        getElement(forgotPasswordButton).click();
        return ForgotPasswordPage.getForgotPasswordPage();
    }

    @Step("Click create account button")
    public CreateAccountPage clickCreateAccountButton() {
        getElement(createAccountButton).click();
        return CreateAccountPage.getCreateAccountPage();
    }

    @Step("Check back to login page")
    public String checkBackToLogin() {
        return getElement(navigationBar).getAttribute("innerText").trim();
    }
}
