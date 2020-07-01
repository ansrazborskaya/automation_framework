package project.by.stormnet.functional.entities.pages;

public class MyAccountPage extends AbstractPage {
    private static String title = "//h1[text()='My account']";
    private  String searchField = "//input[@id='search_query_top']";
    private  String searchButton = "//button[@name='submit_search']";
    private String logoutButton = "//a[@class='logout']";

    public static MyAccountPage getMyAccountPage(){
        MyAccountPage myAccountPage = new MyAccountPage();
        waitForElementVisible(getElementBy(title));
        return myAccountPage;
    }

    public MyAccountPage fillSearchField(String search){
        getElement(searchField).sendKeys(search);
        return getMyAccountPage();
    }

    public SearchResultPage clickSearchButton(){
        getElement(searchButton).click();
        return SearchResultPage.getSearchResultPage();
    }

    public  LoginPage clickLogoutButton(){
        getElement(logoutButton).click();
        return LoginPage.getLoginPage();
    }

    public String checkLogin(){
        return getElement(title).getAttribute("innerText").trim();
    }
}
