package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.HomePage;

public class HomeHelper extends AbstractHelper {
    private HomePage homePage = new HomePage();

    public HomeHelper navigateToHomePage() {
        System.out.println("Navigate to 'Home' page");
        homePage.navigateToHomePage();
        return this;
    }

    public SearchHelper search(String searchKey) {
        navigateToHomePage();

        homePage.fillSearchField(searchKey)
                .clickSearchButton();
        return new SearchHelper();
    }
}
