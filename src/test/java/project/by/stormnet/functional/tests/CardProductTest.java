package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import project.by.stormnet.functional.entities.helpers.*;


public class CardProductTest extends AbstractTest {

    private HomePageHelper homeHelper = new HomePageHelper();
    private LoginPageHelper loginHelper = new LoginPageHelper();
    private MyAccountPageHelper myAccountHelper = new MyAccountPageHelper();
    private SearchResultPageHelper searchHelper = new SearchResultPageHelper();
    private CardProductHelper productHelper = new CardProductHelper();
    private ShoppingCartPageHelper cartHelper = new ShoppingCartPageHelper();

    private String email = "testexam@gmail.com";
    private String password = "123/*---";
    private String search = "dress";
    private String quantity = "2";
    private String title = "New comment";
    private String text = "Lorem ipsum, lorem ipsum 123456789";


    @BeforeClass
    public void prepareToTest() {
        homeHelper.goToLogin();
        loginHelper.successfulLogin(email, password);
        myAccountHelper.doSearch(search);
    }

    @Test(priority = 1, description = "Search result test")
    public void checkSearchResultTest() {
        int countPerPage = searchHelper.getSearchResultCountPerPage();
        Assert.assertTrue(countPerPage > 0, "No results were found");

    }

    @Test(priority = 2, description = "Check add item from catalog page")
    public void checkAddingGoodTest() {
        searchHelper.addToCard();
        String quantity = searchHelper.checkCard();
        Assert.assertTrue(!quantity.equals("empty"), "No products in the cart");

    }

    @Test(priority = 3, description = "Adding goods to the basket from the product card page")
    public void addProductToCardTest() {
        String expected = "Product successfully added to your shopping cart";
        searchHelper.goProductCard();
        productHelper.fillFilter(quantity);
        productHelper.addToCard();
        String actual = productHelper.checkAddingProduct();
        Assert.assertEquals(actual,expected,"Product didn't add to your shopping cart" );
    }

    @Test(priority = 3,description = "Increase the quantity of goods")
    public void changeQuantityPlusTest(){

        productHelper.changeQuantityPlus();
        productHelper.addToCard();
        String result = productHelper.checkQuantityField();
        Assert.assertTrue(!result.equals("0"),"Result equals 0");
    }

    @Test(priority = 3, description = "Reduce the quantity of goods")
    public void changeQuantityMinusTest(){

        productHelper.changeQuantityMinus();
        productHelper.addToCard();
        String result = productHelper.checkQuantityField();
        Assert.assertTrue(!result.equals("0"), "Result equals 0");
    }

    @Test(priority = 4, description = "Add to wishlist")
    public void addToWishlistTest(){
        String expected = "Added to your wishlist.";
        productHelper.addToWishlist();
        String actual = productHelper.checkAddToWishlist();
        Assert.assertEquals(actual,expected,"Didn't add to wishlist");

    }

    @Test(priority = 5, description = "Add new comment")
    public void addCommentTest(){
        String expected = "Your comment has been added and will be available once approved by a moderator";
        productHelper.sendComment(title,text);
        String actual = productHelper.checkSendComment();
        Assert.assertEquals(actual,expected,"Comment was not sent!");
    }



    @Test(priority = 6, description = "Go to shopping cart")
    public void goShoppingCartTest(){
        String expected = "Your shopping cart contains: 7 Products";
        productHelper.changeQuantityMinus();
        productHelper.addToCard();
        productHelper.goToCart();
        String actual = cartHelper.checkGoShoppingCart();
        Assert.assertEquals(actual,expected,"There are no products in the basket.");

    }

    @Test(priority = 7,description = "Change total amount")
    public void changeAmountTest(){
        String expected = "$336.92";
        cartHelper.clickReduceButton();
        String actual = cartHelper.checkReduceNumberProduct();
        Assert.assertEquals(actual,expected,"Invalid amount!");

    }

    @Test(priority = 8, description = "Delete all goods")
    public void deleteTest(){
        String expected = "Your shopping cart is empty.";
        cartHelper.clickDeleteButton();
        String actual = cartHelper.checkProductDeletion();
        Assert.assertEquals(actual,expected,"Your shopping cart isn't empty.");
    }
}
