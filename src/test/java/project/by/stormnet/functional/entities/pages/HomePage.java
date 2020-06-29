package project.by.stormnet.functional.entities.pages;

public class HomePage extends AbstractPage {
    private static String logo = "//img[@class='logo img-responsive']";
    private String loginButton = "//a[@class='login']";



    public static HomePage getHomePage() {
        HomePage homePage = new HomePage();
        waitForElementVisible(getElementBy(logo));
        return homePage;
    }

    public HomePage navigateToHomePage() {
        openUrl(baseUrl);
        return getHomePage();
    }

    public LoginPage clickLoginButton() {
        getElement(loginButton).click();
        return LoginPage.getLoginPage();
    }
}
