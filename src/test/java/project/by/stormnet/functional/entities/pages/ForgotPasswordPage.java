package project.by.stormnet.functional.entities.pages;


import io.qameta.allure.Step;

public class ForgotPasswordPage extends AbstractPage {
    private static String title = "//h1[@class='page-subheading']";
    private String emailField = "//input[@id='email']";
    private String retrievePasswordButton = "//button[@class='btn btn-default button button-medium']";
    private String backToLoginButton = "//a[@title='Back to Login']";
    private String successMessage = "//p[@class='alert alert-success']";
    private String errorMessage = "//div[@class='alert alert-danger']";

    @Step("Get forgot password page")
    public static ForgotPasswordPage getForgotPasswordPage() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
        waitForElementVisible(getElementBy(title));
        return forgotPasswordPage;
    }

    @Step("Fill email field")
    public ForgotPasswordPage fillEmailField(String email) {
        getElement(emailField).sendKeys(email);
        return getForgotPasswordPage();
    }

    @Step("Click retrieve password button")
    public ForgotPasswordPage clickRetrievePasswordButton() {
        getElement(retrievePasswordButton).click();
        return getForgotPasswordPage();
    }

    @Step("Click retrieve password button with error")
    public void clickRetrievePasswordButtonError() {
        getElement(retrievePasswordButton).click();

    }

    @Step("Check success message")
    public boolean checkSuccessMessage() {
        waitForElementVisible(getElementBy(successMessage));
        return getElement(successMessage).isDisplayed();
    }

    @Step("Check error message")
    public boolean checkErrorMessage() {
        waitForElementVisible(getElementBy(errorMessage));
        return getElement(errorMessage).isDisplayed();
    }

    @Step("Click back to login")
    public LoginPage clickBackToLoginButton() {
        getElement(backToLoginButton).click();
        return LoginPage.getLoginPage();
    }
}
