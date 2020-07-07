package project.by.stormnet.functional.entities.pages;

import io.qameta.allure.Step;

public class CardProduct extends AbstractPage {

    private static String imageDress = "//img[@id='bigpic']";
    private String quantityField = "//input[@id='quantity_wanted']";
    private String quantityPlus = "//a[@class='btn btn-default button-plus product_quantity_up']";
    private String quantityMinus = "//a[@class='btn btn-default button-minus product_quantity_down']";
    private String checkQuantity = "//span[@id='layer_cart_product_quantity']";
    private String dropdownSize = "//div[@id='uniform-group_1']";
    private String sizeDress = "//option[@title='M']";
    private String pinkColor = "//a[@name='Pink']";
    private String buttonSubmit = "//button[@name='Submit']";
    private String closeCartWindowButton = "//span[@title='Close window']";
    private String wishlistButton = "//a[@id='wishlist_button']";
    private String wishlistAdd = "//p[@class='fancybox-error']";
    private String checkoutButton = "//a[@title='Proceed to checkout']";
    private String title = "//div[@class='layer_cart_product col-xs-12 col-md-6']/h2";
    private String closeButton = "//a[@title='Close']";
    private String reviewButton = "//a[@id='new_comment_tab_btn']";
    private String reviewTitle = "//input[@id='comment_title']";
    private String commentText = "//textarea[@id='content']";
    private String sendButton = "//button[@id='submitNewMessage']";
    private String successComment = "//p[contains(text(),'comment has been added')]";
    private String okButton = "//span[text()='OK']";


    @Step("Get product card page")
    public static CardProduct getCardProduct() {
        CardProduct cardProduct = new CardProduct();
        waitForElementVisible(getElementBy(imageDress));
        return cardProduct;
    }

    @Step("Clear quantity field")
    public CardProduct clearQuantityField() {
        getElement(quantityField).clear();
        return getCardProduct();
    }

    @Step("Fill quantity field")
    public CardProduct fillQuantityField(String quantity) {
        clearQuantityField();
        getElement(quantityField).sendKeys(quantity);
        return getCardProduct();
    }

    @Step("Check quantity field")
    public String checkQuantityField() {
        return getElement(checkQuantity).getAttribute("innerText").trim();
    }

    @Step("CLick plus button")
    public CardProduct clickQuantityPlus() {
        waitForElementClickable(getElementBy(quantityPlus));
        getElement(quantityPlus).click();
        return getCardProduct();
    }

    @Step("Click minus button")
    public CardProduct clickQuantityMinus() {
        waitForElementClickable(getElementBy(quantityMinus));
        getElement(quantityMinus).click();
        return getCardProduct();
    }

    @Step("Click dropdown")
    public CardProduct clickDropdown() {
        getElement(dropdownSize).click();
        return getCardProduct();
    }

    @Step("Choose size")
    public CardProduct chooseSize() {
        getElement(sizeDress).click();
        return getCardProduct();
    }

    @Step("Choose color")
    public CardProduct chooseColor() {
        getElement(pinkColor).click();
        return getCardProduct();
    }

    @Step("Click submit button")
    public CardProduct clickSubmitButton() {
        waitForElementClickable(getElementBy(buttonSubmit));
        getElement(buttonSubmit).click();
        return getCardProduct();
    }

    @Step("Check adding product")
    public String checkAddingProduct() {

        return getElement(title).getAttribute("innerText").trim();
    }

    @Step("Add to wishlist")
    public CardProduct addWishlist() {
        waitForElementClickable(getElementBy(wishlistButton));
        getElement(wishlistButton).click();
        return getCardProduct();
    }

    @Step("Check successful adding to wishlist")
    public String checkWishlistAdd() {
        waitForElementVisible(getElementBy(wishlistAdd));
        return getElement(wishlistAdd).getAttribute("innerText").trim();
    }

    @Step("Click close button")
    public CardProduct clickCloseButton() {
        waitForElementClickable(getElementBy(closeButton));
        getElement(closeButton).click();
        return getCardProduct();
    }

    @Step("Click close window button")
    public CardProduct clickCloseWindowButton() {
        waitForElementClickable(getElementBy(closeCartWindowButton));
        getElement(closeCartWindowButton).click();
        return getCardProduct();
    }

    @Step("Click review button")
    public CardProduct clickReviewButton() {
        waitForElementClickable(getElementBy(reviewButton));
        getElement(reviewButton).click();
        return getCardProduct();
    }

    @Step("Fill title field")
    public CardProduct fillReviewTitleField(String title) {
        getElement(reviewTitle).sendKeys(title);
        return getCardProduct();
    }

    @Step("Fill text field")
    public CardProduct fillReviewTextField(String text) {
        getElement(commentText).sendKeys(text);
        return getCardProduct();
    }

    @Step("Click send button")
    public CardProduct clickSendButton() {
        getElement(sendButton).click();
        return getCardProduct();
    }

    @Step("Check comment")
    public String checkComment() {
        waitForElementVisible(getElementBy(successComment));
        return getElement(successComment).getAttribute("innerText").trim();
    }

    @Step("Click ok button")
    public CardProduct clickOkButton() {
        waitForElementClickable(getElementBy(okButton));
        getElement(okButton).click();
        return getCardProduct();
    }

    @Step("Click proceed checkout button")
    public ShoppingCartPage clickProceedCheckoutButton() {
        waitForElementClickable(getElementBy(checkoutButton));
        getElement(checkoutButton).click();
        return ShoppingCartPage.getShoppingCart();
    }
}
