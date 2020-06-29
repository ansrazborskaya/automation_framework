package project.by.stormnet.functional.entities.pages;

public class ShoppingCartPage extends AbstractPage {

    private static String titleOfCart = "//h1[@id='cart_title']";
    private String totalPrice = "//span[@id='total_price']";
    private String containsProduct = "//span[@class='heading-counter']";
    private String reduceNumberButton = "//a[@title='Subtract']";

    private String deleteButton = "//a[@title='Delete']";
    private String deleteText = "//p[@class='alert alert-warning']";

    public static ShoppingCartPage getShoppingCart(){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        waitForElementVisible(getElementBy(titleOfCart));
        return shoppingCartPage;
    }

    public String checkGoBasket(){
        waitForElementVisible(getElementBy(containsProduct));
        return getElement(containsProduct).getAttribute("innerText").trim();
    }

    public ShoppingCartPage clickReduceNumberButton(){
        waitForElementClickable(getElementBy(reduceNumberButton));
        getElement(reduceNumberButton).click();
        return getShoppingCart();
    }
    public String checkReduceNumberProduct(){
        waitForElementVisible(getElementBy(totalPrice));
        return getElement(totalPrice).getAttribute("innerText").trim();
    }
     public ShoppingCartPage clickDeleteButton(){
        waitForElementClickable(getElementBy(deleteButton));
        getElement(deleteButton).click();
        return getShoppingCart();
     }

    public String checkDelete(){
        waitForElementVisible(getElementBy(deleteText));
        return getElement(deleteText).getAttribute("innerText").trim();
    }

}
