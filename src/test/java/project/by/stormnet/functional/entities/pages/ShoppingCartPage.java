package project.by.stormnet.functional.entities.pages;

import io.qameta.allure.Step;

public class ShoppingCartPage extends AbstractPage {

    private static String titleOfCart = "//h1[@id='cart_title']";
    private String totalPrice = "//span[@id='total_price']";
    private String containsProduct = "//span[@class='heading-counter']";
    private String reduceNumberButton = "//a[@title='Subtract']";

    private String deleteButton = "//a[@title='Delete']";
    private String deleteText = "//p[@class='alert alert-warning']";

    @Step("Get shopping cart")
    public static ShoppingCartPage getShoppingCart() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        waitForElementVisible(getElementBy(titleOfCart));
        return shoppingCartPage;
    }

    @Step("Check go to basket")
    public String checkGoBasket() {
        waitForElementVisible(getElementBy(containsProduct));
        return getElement(containsProduct).getAttribute("innerText").trim();
    }

    @Step("Click reduce number button")
    public ShoppingCartPage clickReduceNumberButton() {
        waitForElementClickable(getElementBy(reduceNumberButton));
        getElement(reduceNumberButton).click();
        return getShoppingCart();
    }

    @Step("Check reduce number button")
    public String checkReduceNumberProduct() {
        waitForElementVisible(getElementBy(totalPrice));
        return getElement(totalPrice).getAttribute("innerText").trim();
    }

    @Step("CLick delete button")
    public ShoppingCartPage clickDeleteButton() {
        waitForElementClickable(getElementBy(deleteButton));
        getElement(deleteButton).click();
        return getShoppingCart();
    }

    @Step("Check delete")
    public String checkDelete() {
        waitForElementVisible(getElementBy(deleteText));
        return getElement(deleteText).getAttribute("innerText").trim();
    }
}
