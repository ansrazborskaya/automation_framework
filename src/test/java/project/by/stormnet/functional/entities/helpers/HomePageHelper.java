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
        navigateToHomePage();
        homePage.clickLoginButton();
        return new LoginPageHelper();

    }

    public HomePageHelper doSuccessNewsletterSubscription(){
        homePage.fillNewsletterFieldRandom().clickSubmitNewsletter();
        return this;
    }

    public HomePageHelper doErrorNewsletterSubscription(String email){
        homePage.fillNewsletterField(email).clickSubmitNewsletter();
        return this;
    }

    public HomePageHelper sendEmptyEmailNewsletter(){
        homePage.clickSubmitNewsletter();
        return this;
    }

    public String checkSuccessMessage(){
       return homePage.checkSuccessMessage();
    }

    public String checkErrorMessage(){
        return homePage.checkErrorMessage();
    }

    public boolean checkVisibilityErrorMessage(){
        return homePage.visibilityErrorMessage();
    }

    public ContactPageHelper goContactUs(){
        homePage.clickContactUsButton();
        return new ContactPageHelper();
    }
}
