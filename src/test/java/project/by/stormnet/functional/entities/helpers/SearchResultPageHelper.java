package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.SearchResultPage;

public class SearchResultPageHelper {
    private SearchResultPage searchResultPage = new SearchResultPage();

    public int getSearchResultCountPerPage() {
        return searchResultPage.getResultsSizePerPage();
    }

    public SearchResultPageHelper addToCard() {
        searchResultPage.clickAddToCardButton();
        searchResultPage.clickContinueShoppingButton();
        searchResultPage.checkCard();
        return this;
    }

    public String checkCard() {
        return searchResultPage.checkCard();
    }

    public CardProductHelper goProductCard() {
        searchResultPage.clickCardProductButton();
        return new CardProductHelper();
    }

}
