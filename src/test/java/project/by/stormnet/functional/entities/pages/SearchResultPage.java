package project.by.stormnet.functional.entities.pages;

public class SearchResultPage extends AbstractPage{
    private static String title = "//span[(@class='heading-counter') and contains(text(),'results')] ";
    private String searchResult = "//div[@class='product-container']";
    private String addToCardButton = "//a[contains(@title,'Add to cart') and contains(@data-id-product,'5')]";
    private String forMousePlace = "//img[@class='replace-2x img-responsive'][@src='http://automationpractice.com/img/p/1/2/12-home_default.jpg']";

    private String image = "//div/img[@src='http://automationpractice.com/img/p/1/2/12-home_default.jpg']";
    private String continueShoppingButton = "//span[@title='Continue shopping']";
    private String checkCard = "//span[@class='ajax_cart_quantity']";
    private String cardProductButton = "//div[@class='button-container']/a[@href='http://automationpractice.com/index.php?id_product=4&controller=product&search_query=dress&results=7']";
    private String forMouseProductButton = "//img[@src='http://automationpractice.com/img/p/1/0/10-home_default.jpg']";

    public static SearchResultPage getSearchResultPage(){
        SearchResultPage searchResultPage = new SearchResultPage();
        waitForElementVisible(getElementBy(title));
        return searchResultPage;
    }

    public int getResultsSizePerPage(){
        return getElements(searchResult).size();
    }

    public SearchResultPage clickAddToCardButton(){
        placeCursor(forMousePlace);
        waitForElementClickable(getElementBy(addToCardButton));
        getElement(addToCardButton).click();
        return getSearchResultPage();
    }

    public SearchResultPage clickContinueShoppingButton(){
        waitForElementClickable(getElementBy(image));
        getElement(continueShoppingButton).click();
        return getSearchResultPage();
    }

    public String checkCard(){
        System.out.println(getElement(checkCard).getText());
        return getElement(checkCard).getText();
    }

    public CardProduct clickCardProductButton(){
        placeCursor(forMouseProductButton);
        waitForElementClickable(getElementBy(cardProductButton));
        getElement(cardProductButton).click();
        return CardProduct.getCardProduct();
    }




}
