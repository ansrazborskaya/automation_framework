package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.HomePage;
import project.by.stormnet.functional.entities.pages.LoginPage;

public class HomePageHelper extends AbstractHelper {
    private HomePage homePage = new HomePage();

    public HomePageHelper navigateToHomePage() {
        System.out.println("Navigate to 'Home' page");
        homePage.navigateToHomePage();
        return this;
    }

    public LoginPageHelper goToLogin(){
        //navigateToHomePage();
        homePage.clickLoginButton();
        return new LoginPageHelper();


    }
}
