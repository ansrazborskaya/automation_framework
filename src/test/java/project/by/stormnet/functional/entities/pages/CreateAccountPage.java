package project.by.stormnet.functional.entities.pages;


import io.qameta.allure.Step;

public class CreateAccountPage extends AbstractPage {

    private static String title = "//h1[@class='page-heading']";
    private String genderButton = "//label[@for='id_gender2']";
    private String firstNameField = "//input[@name='customer_firstname']";
    private String lastNameField = "//input[@id='customer_lastname']";
    private String emailField = "//input[@id='email']";
    private String passwordField = "//input[@type='password']";
    private String addressField = "//input[@id='address1']";
    private String cityField = "//input[@id='city']";
    private String stateField = "//select[@name='id_state']/option[@value='1']";
    private String postcodeField = "//input[@id='postcode']";
    private String mobilePhoneField = "//input[@id='phone_mobile']";
    private String myAddressField = "//input[@id='alias']";
    private String registerButton = "//button[@id='submitAccount']";
    private String errorMessage = "//div[@class='alert alert-danger']";
    private String errorMessageText = "//div[@class='alert alert-danger']/ol/li";
    private String homeButton = "//a[@class='home']";

    @Step("Get create account page")
    public static CreateAccountPage getCreateAccountPage() {
        CreateAccountPage createAccountPage = new CreateAccountPage();
        waitForElementVisible(getElementBy(title));
        return createAccountPage;
    }

    @Step("Click gender button")
    public CreateAccountPage clickGenderButton() {
        waitForElementClickable(getElementBy(genderButton));
        getElement(genderButton).click();
        return getCreateAccountPage();
    }

    @Step("Fill random FirstName Field")
    public CreateAccountPage fillRandomFirstNameField() {
        String firstName = generateRandomValue();
        getElement(firstNameField).sendKeys(firstName);
        return getCreateAccountPage();
    }

    @Step("Fill random LastName Field")
    public CreateAccountPage fillRandomLastNameField() {
        String lastName = generateRandomValue();
        getElement(lastNameField).sendKeys(lastName);
        return getCreateAccountPage();
    }

    @Step("Fill random password Field")
    public CreateAccountPage fillRandomPasswordField() {
        String password = generateRandomValue();
        getElement(passwordField).sendKeys(password);
        return getCreateAccountPage();
    }

    @Step("Fill password Field")
    public CreateAccountPage fillPasswordField(String password) {
        getElement(passwordField).sendKeys(password);
        return getCreateAccountPage();
    }

    @Step("Fill email Field")
    public CreateAccountPage fillEmailField(String email) {
        getElement(emailField).sendKeys(email);
        return getCreateAccountPage();
    }

    @Step("Clear password Field")
    public CreateAccountPage clearEmailField() {
        getElement(emailField).clear();
        return getCreateAccountPage();
    }

    @Step("Fill random address Field")
    public CreateAccountPage fillRandomAddressField() {
        String address = generateRandomValue();
        getElement(addressField).sendKeys(address);
        return getCreateAccountPage();
    }

    @Step("Fill random city Field")
    public CreateAccountPage fillRandomCityField() {
        String city = generateRandomValue();
        getElement(cityField).sendKeys(city);
        return getCreateAccountPage();
    }

    @Step("Click state button")
    public CreateAccountPage clickStateButton() {
        getElement(stateField).click();
        return getCreateAccountPage();
    }

    @Step("Fill random postcode Field")
    public CreateAccountPage fillRandomPostcodeField() {
        String postcode = generateRandomPostcode();
        getElement(postcodeField).sendKeys(postcode);
        return getCreateAccountPage();
    }

    @Step("Fill random mobile phone Field")
    public CreateAccountPage fillRandomMobilePhoneField() {
        String phone = generateRandomPhone();
        getElement(mobilePhoneField).sendKeys(phone);
        return getCreateAccountPage();
    }

    @Step("Fill random MyAddress Field")
    public CreateAccountPage fillRandomMyAddressField() {
        String myAddress = generateRandomValue();
        getElement(myAddressField).sendKeys(myAddress);
        return getCreateAccountPage();
    }

    @Step("CLick register button")
    public MyAccountPage clickRegisterButton() {
        getElement(registerButton).click();
        return MyAccountPage.getMyAccountPage();
    }

    @Step("Check error message visibility")
    public boolean checkErrorMessage() {
        return isElementVisible(getElementBy(errorMessage));
    }

    @Step("Check error message text")
    public String checkErrorMessageText() {
        return getElement(errorMessageText).getAttribute("innerText").trim();
    }

    @Step("Click register button with error")
    public void clickRegisterButtonError() {
        getElement(registerButton).click();
    }

    @Step("Click home button")
    public HomePage clickHomeButton() {
        getElement(homeButton).click();
        return new HomePage().getHomePage();
    }
}
