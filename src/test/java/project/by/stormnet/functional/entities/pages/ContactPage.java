package project.by.stormnet.functional.entities.pages;

public class ContactPage extends AbstractPage{

    private static String title = "//h1[@class='page-heading bottom-indent']";
    private String customerValueDropdawn = "//div[@class='selector']/select/option[@value='2']";
    private String webmasterValueDropdawn = "//div[@class='selector']/select/option[@value='1']";
    private String emailField = "//input[@id='email']";
    private String orderField = "//input[@id='id_order']";
    private String messageField = "//textarea[@id='message']";
    private String sendButton = "//button[@id='submitMessage']";
    private String errorMessage = "//div[@class='alert alert-danger']";
    private String successMessage = "//p[@class='alert alert-success']";
    private String homeButton = "//a[@class='btn btn-default button button-small'][@href='http://automationpractice.com/']";
    private String customerText = "//p[@id='desc_contact2']";
    private String webmasterText = "//p[@id='desc_contact1']";



    public static ContactPage getContactPage() {
        ContactPage contactPage = new ContactPage();
        waitForElementVisible(getElementBy(title));
        return contactPage;
    }

    public ContactPage clickSubjectHeadingDropdawn(){
        waitForElementClickable(getElementBy(customerValueDropdawn));
        getElement(customerValueDropdawn).click();
        return getContactPage();
    }
    public ContactPage chooseWebmasterValue(){
        waitForElementClickable(getElementBy(webmasterValueDropdawn));
        getElement(webmasterValueDropdawn).click();
       return getContactPage();
    }


    public ContactPage fillEmailField(String email){
        waitForElementClickable(getElementBy(emailField));
        getElement(emailField).sendKeys(email);
        return getContactPage();
    }

    public ContactPage clearEmailField(){
        getElement(emailField).clear();
        return getContactPage();
    }

    public ContactPage fillOrderField(String order){
        waitForElementClickable(getElementBy(orderField));
        getElement(orderField).sendKeys(order);
        return getContactPage();
    }

    public ContactPage clearOrderField(){
        getElement(orderField).clear();
        return getContactPage();
    }

    public ContactPage fillMessageField(String message){
        waitForElementClickable(getElementBy(messageField));
        getElement(messageField).sendKeys(message);
        return getContactPage();
    }

    public ContactPage clearMessageField(){
        getElement(messageField).clear();
        return getContactPage();
    }

    public ContactPage clickSendButton(){
        waitForElementClickable(getElementBy(sendButton));
        getElement(sendButton).click();
        return getContactPage();
    }

    public void clickSendButtonError(){
        waitForElementClickable(getElementBy(sendButton));
        getElement(sendButton).click();

    }

    public boolean checkErrorMessage(){
        return isElementVisible(getElementBy(errorMessage));
    }

    public boolean checkSuccessMessage(){
        return isElementVisible(getElementBy(successMessage));
    }

    public HomePage clickHomeButton(){
        getElement(homeButton).click();
        return  HomePage.getHomePage();
    }

    public String checkCustomerText(){
        waitForElementVisible(getElementBy(customerText));
        return getElement(customerText).getAttribute("innerText").trim();

    }

    public String checkWebmasterText(){
        waitForElementVisible(getElementBy(webmasterText));
        return getElement(webmasterText).getAttribute("innerText").trim();

    }



}
