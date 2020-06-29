package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.ShoppingCartPage;

public class ShoppingCartPageHelper extends AbstractHelper{
    private ShoppingCartPage shoppingCart = new ShoppingCartPage();

    public String checkGoShoppingCart(){
      return   shoppingCart.checkGoBasket();

    }

    public ShoppingCartPageHelper clickDeleteButton(){
        shoppingCart.clickDeleteButton();
        return this;
    }

    public String checkProductDeletion(){
        return   shoppingCart.checkDelete();

    }
    public ShoppingCartPageHelper clickReduceButton(){
        shoppingCart.clickReduceNumberButton();
        return this;
    }

    public String checkReduceNumberProduct(){
        return   shoppingCart.checkReduceNumberProduct();

    }



}
