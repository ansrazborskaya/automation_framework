package project.by.stormnet.functional.entities.pages;


public class ForgotPasswordPage extends AbstractPage {
    private static String title = "//h1[@class='page-subheading']";
    private String emailField = "//input[@id='email']";
    private String retrievePasswordButton = "//button[@class='btn btn-default button button-medium']";
    private String backToLoginButton = "//a[@title='Back to Login']";
    private String successMessage = "//p[@class='alert alert-success']";
    private String errorMessage = "//div[@class='alert alert-danger']";

    public static ForgotPasswordPage getForgotPasswordPage(){
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
        waitForElementVisible(getElementBy(title));
        return forgotPasswordPage;
    }

    public ForgotPasswordPage fillEmailField(String email){
        getElement(emailField).sendKeys(email);
        return getForgotPasswordPage();
    }


    public ForgotPasswordPage clickRetrievePasswordButton(){
        getElement(retrievePasswordButton).click();
        return getForgotPasswordPage();
    }

    public void clickRetrievePasswordButtonError(){
        getElement(retrievePasswordButton).click();

    }

    public boolean checkSuccessMessage(){
        waitForElementVisible(getElementBy(successMessage));
        return getElement(successMessage).isDisplayed();
    }

    public boolean checkErrorMessage(){
        waitForElementVisible(getElementBy(errorMessage));
        return getElement(errorMessage).isDisplayed();
    }

    public LoginPage clickBackToLoginButton(){
        getElement(backToLoginButton).click();
        return LoginPage.getLoginPage();
    }


}
