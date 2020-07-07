package project.by.stormnet.functional.entities.pages;

import io.qameta.allure.Step;

public class MyAccountPage extends AbstractPage {
    private static String title = "//h1[text()='My account']";
    private String searchField = "//input[@id='search_query_top']";
    private String searchButton = "//button[@name='submit_search']";
    private String logoutButton = "//a[@class='logout']";

    @Step("Get My Account Page")
    public static MyAccountPage getMyAccountPage() {
        MyAccountPage myAccountPage = new MyAccountPage();
        waitForElementVisible(getElementBy(title));
        return myAccountPage;
    }

    @Step("Fill search field")
    public MyAccountPage fillSearchField(String search) {
        getElement(searchField).sendKeys(search);
        return getMyAccountPage();
    }

    @Step("Click search button")
    public SearchResultPage clickSearchButton() {
        getElement(searchButton).click();
        return SearchResultPage.getSearchResultPage();
    }

    @Step("Click logout button")
    public LoginPage clickLogoutButton() {
        getElement(logoutButton).click();
        return LoginPage.getLoginPage();
    }

    @Step("Check successful login")
    public String checkLogin() {
        return getElement(title).getAttribute("innerText").trim();
    }
}
