package project.by.stormnet.functional.entities.pages;

public class MyAccountPage extends AbstractPage {
    private static String title = "//h1[text()='My account']";
    private static String searchField = "//input[@id='search_query_top']";
    private static String searchButton = "//button[@name='submit_search']";

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
}
