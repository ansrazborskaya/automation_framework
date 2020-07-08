package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.CardProduct;

public class CardProductHelper extends AbstractHelper {
    private CardProduct cardProduct = new CardProduct();

    public CardProductHelper fillFilter(String quantity) {
        cardProduct.fillQuantityField(quantity);
        cardProduct.clickDropdown();
        cardProduct.chooseColor();
        cardProduct.chooseSize();
        return this;
    }

    public CardProductHelper addToCard() {
        cardProduct.clickSubmitButton();

        return this;
    }

    public String checkAddingProduct() {

        String result = cardProduct.checkAddingProduct();
        closeAddToCartWindow();
        return result;
    }

    public CardProductHelper addToWishlist() {
        cardProduct.addWishlist();
        return this;
    }

    public String checkAddToWishlist() {

        String result = cardProduct.checkWishlistAdd();
        closeWishlistWindow();
        return result;
    }

    public CardProductHelper changeQuantityPlus() {
        cardProduct.clickQuantityPlus();
        return this;
    }

    public CardProductHelper changeQuantityMinus() {
        cardProduct.clickQuantityMinus();
        return this;
    }

    public String checkQuantityField() {
        String result = cardProduct.checkQuantityField();
        closeAddToCartWindow();
        return result;
    }

    public boolean closeWishlistWindow() {
        cardProduct.clickCloseButton();
        return true;
    }

    public CardProductHelper closeAddToCartWindow() {
        cardProduct.clickCloseWindowButton();
        return this;
    }

    public CardProductHelper sendComment(String title, String text) {
        cardProduct.clickReviewButton();
        cardProduct.fillReviewTitleField(title);
        cardProduct.fillReviewTextField(text);
        cardProduct.clickSendButton();
        return this;
    }

    public String checkSendComment() {
        String result = cardProduct.checkComment();
        closeCommentWindow();
        return result;
    }

    public CardProductHelper closeCommentWindow() {
        cardProduct.clickOkButton();
        return this;
    }


    public ShoppingCartPageHelper goToCart() {
        cardProduct.clickProceedCheckoutButton();
        return new ShoppingCartPageHelper();
    }

}
