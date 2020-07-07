package project.by.stormnet.functional.entities.pages;

import io.qameta.allure.Step;

public class HomePage extends AbstractPage {
    private static String logo = "//img[@class='logo img-responsive']";
    private String loginButton = "//a[@class='login']";
    private String contactUsButton = "//a[@title='Contact Us']";
    private String newsletterField = "//input[@id='newsletter-input']";
    private String submitNewsletter = "//button[@name='submitNewsletter']";
    private String successMessage = "//p[@class='alert alert-success']";
    private String errorMessage = "//p[@class='alert alert-danger']";


    @Step("Get home page")
    public static HomePage getHomePage() {
        HomePage homePage = new HomePage();
        waitForElementVisible(getElementBy(logo));
        return homePage;
    }

    @Step("Navigate to home page")
    public HomePage navigateToHomePage() {
        openUrl(baseUrl);
        return getHomePage();
    }

    @Step("Fill in the random values field Newsletter")
    public HomePage fillNewsletterFieldRandom() {
        String emailRandom = generateEmailAddress();
        getElement(newsletterField).sendKeys(emailRandom);
        return getHomePage();
    }

    @Step("Fill newsletter field")
    public HomePage fillNewsletterField(String email) {
        getElement(newsletterField).sendKeys(email);
        return getHomePage();
    }

    @Step("Click submit newsletter button")
    public HomePage clickSubmitNewsletter() {
        getElement(submitNewsletter).click();
        return getHomePage();
    }

    @Step("Click login button")
    public LoginPage clickLoginButton() {
        getElement(loginButton).click();
        return LoginPage.getLoginPage();
    }

    @Step("Click contactUs button")
    public ContactPage clickContactUsButton() {
        getElement(contactUsButton).click();
        return ContactPage.getContactPage();
    }

    @Step("Сheck success message")
    public String checkSuccessMessage() {
        waitForElementVisible(getElementBy(successMessage));
        return getElement(successMessage).getAttribute("innerText").trim();
    }

    @Step("Check error message")
    public String checkErrorMessage() {
        waitForElementVisible(getElementBy(errorMessage));
        return getElement(errorMessage).getAttribute("innerText").trim();
    }

    @Step("Check visibility error message")
    public boolean visibilityErrorMessage() {
        waitForElementVisible(getElementBy(errorMessage));
        return isElementVisible(getElementBy(errorMessage));
    }
}
