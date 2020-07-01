package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.MyAccountPage;

public class MyAccountPageHelper {
    private MyAccountPage myAccountPage = new MyAccountPage();

    public SearchResultPageHelper doSearch(String search){
        myAccountPage.fillSearchField(search);
        myAccountPage.clickSearchButton();
        return new SearchResultPageHelper();
    }

    public String checkSuccessfulLogin() {

        String result = myAccountPage.checkLogin();
        doLogout();
        return result;
    }

    public LoginPageHelper doLogout(){
        myAccountPage.clickLogoutButton();
        return new LoginPageHelper();
    }
}
