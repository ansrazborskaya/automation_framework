package project.by.stormnet.functional.entities.pages;

public class HomePage extends AbstractPage {
    private static String logo = "//img[@class='logo img-responsive']";
    private String loginButton = "//a[@class='login']";
    private String contactUsButton = "//a[@title='Contact Us']";
    private String newsletterField = "//input[@id='newsletter-input']";
    private String submitNewsletter = "//button[@name='submitNewsletter']";
    private String successMessage = "//p[@class='alert alert-success']";
    private String errorMessage = "//p[@class='alert alert-danger']";



    public static HomePage getHomePage() {
        HomePage homePage = new HomePage();
        waitForElementVisible(getElementBy(logo));
        return homePage;
    }

    public HomePage navigateToHomePage() {
        openUrl(baseUrl);
        return getHomePage();
    }

    public HomePage fillNewsletterFieldRandom(){
        String emailRandom = generateEmailAddress();
        getElement(newsletterField).sendKeys(emailRandom);
        return getHomePage();
    }

    public HomePage fillNewsletterField(String email){
        getElement(newsletterField).sendKeys(email);
        return getHomePage();
    }

    public HomePage clickSubmitNewsletter(){
        getElement(submitNewsletter).click();
        return getHomePage();
    }

    public LoginPage clickLoginButton() {
        getElement(loginButton).click();
        return LoginPage.getLoginPage();
    }

    public ContactPage clickContactUsButton(){
        getElement(contactUsButton).click();
        return ContactPage.getContactPage();
    }

    public String checkSuccessMessage(){
        waitForElementVisible(getElementBy(successMessage));
        return getElement(successMessage).getAttribute("innerText").trim();
    }

    public String checkErrorMessage(){
        waitForElementVisible(getElementBy(errorMessage));
        return getElement(errorMessage).getAttribute("innerText").trim();
    }

    public boolean visibilityErrorMessage(){
        waitForElementVisible(getElementBy(errorMessage));
        return isElementVisible(getElementBy(errorMessage));
    }



}
