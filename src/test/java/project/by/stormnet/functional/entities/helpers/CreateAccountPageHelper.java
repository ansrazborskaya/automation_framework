package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.CreateAccountPage;

public class CreateAccountPageHelper {
    CreateAccountPage createAccountPage = new CreateAccountPage();

    public MyAccountPageHelper successCreateAccount(){
        createAccountPage.clickGenderButton();
        createAccountPage.fillRandomFirstNameField();
        createAccountPage.fillRandomLastNameField();
        createAccountPage.fillRandomPasswordField();
        createAccountPage.fillRandomAddressField();
        createAccountPage.fillRandomCityField();
        createAccountPage.clickStateButton();
        createAccountPage.fillRandomPostcodeField();
        createAccountPage.fillRandomMobilePhoneField();
        createAccountPage.fillRandomMyAddressField();
        createAccountPage.clickRegisterButton();
        return new MyAccountPageHelper();

    }

    public CreateAccountPageHelper failedCreateAccount(){
        createAccountPage.clickGenderButton();
        createAccountPage.fillRandomFirstNameField();
        createAccountPage.fillRandomLastNameField();
        createAccountPage.fillRandomPasswordField();
        createAccountPage.fillRandomMobilePhoneField();
        createAccountPage.fillRandomMyAddressField();
        createAccountPage.clickRegisterButtonError();
        return this;

    }

    public CreateAccountPageHelper createAccountWithRegisteredMail(String email){
        createAccountPage.clickGenderButton();
        createAccountPage.fillRandomFirstNameField();
        createAccountPage.fillRandomLastNameField();
        createAccountPage.clearEmailField();
        createAccountPage.fillEmailField(email);
        createAccountPage.fillRandomPasswordField();
        createAccountPage.fillRandomAddressField();
        createAccountPage.fillRandomCityField();
        createAccountPage.clickStateButton();
        createAccountPage.fillRandomPostcodeField();
        createAccountPage.fillRandomMobilePhoneField();
        createAccountPage.fillRandomMyAddressField();
        createAccountPage.clickRegisterButtonError();
        return this;

    }

    public CreateAccountPageHelper createAccountWithInvalidPassword(String password){
        createAccountPage.clickGenderButton();
        createAccountPage.fillRandomFirstNameField();
        createAccountPage.fillRandomLastNameField();
        createAccountPage.fillPasswordField(password);
        createAccountPage.fillRandomAddressField();
        createAccountPage.fillRandomCityField();
        createAccountPage.clickStateButton();
        createAccountPage.fillRandomPostcodeField();
        createAccountPage.fillRandomMobilePhoneField();
        createAccountPage.fillRandomMyAddressField();
        createAccountPage.clickRegisterButtonError();
        return this;
    }

    public boolean checkErrorMessage(){
        boolean result = createAccountPage.checkErrorMessage();
        clickHomePageButton();
        return result;
    }

    public String checkErrorMessageText(){
       String result = createAccountPage.checkErrorMessageText();
       clickHomePageButton();
       return result;
    }

    public HomePageHelper clickHomePageButton(){
        createAccountPage.clickHomeButton();
        return new HomePageHelper();
    }

}
