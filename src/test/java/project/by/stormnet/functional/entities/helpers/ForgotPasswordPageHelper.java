package project.by.stormnet.functional.entities.helpers;


import project.by.stormnet.functional.entities.pages.ForgotPasswordPage;

public class ForgotPasswordPageHelper extends AbstractHelper {
    private ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    public ForgotPasswordPageHelper successfulPasswordRecovery(String email) {
        forgotPasswordPage.fillEmailField(email);
        forgotPasswordPage.clickRetrievePasswordButton();
        return this;
    }

    public ForgotPasswordPageHelper failedPasswordRecovery(String email) {
        forgotPasswordPage.fillEmailField(email);
        forgotPasswordPage.clickRetrievePasswordButtonError();
        return this;
    }

    public boolean checkSuccessfulPasswordRecovery() {
        boolean result = forgotPasswordPage.checkSuccessMessage();
        clickBackToLoginButton();
        return result;
    }

    public boolean checkFailedPasswordRecovery() {
        boolean result = forgotPasswordPage.checkErrorMessage();
        clickBackToLoginButton();
        return result;
    }


    public LoginPageHelper clickBackToLoginButton() {
        forgotPasswordPage.clickBackToLoginButton();
        return new LoginPageHelper();
    }
}
