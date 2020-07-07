package project.by.stormnet.functional.entities.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.Select;

public class ContactPage extends AbstractPage {

    private static String title = "//h1[@class='page-heading bottom-indent']";
    private String emailField = "//input[@id='email']";
    private String orderField = "//input[@id='id_order']";
    private String messageField = "//textarea[@id='message']";
    private String sendButton = "//button[@id='submitMessage']";
    private String errorMessage = "//div[@class='alert alert-danger']";
    private String successMessage = "//p[@class='alert alert-success']";
    private String homeButton = "//a[@class='btn btn-default button button-small'][@href='http://automationpractice.com/']";
    private String customerText = "//p[@id='desc_contact2']";
    private String webmasterText = "//p[@id='desc_contact1']";
    private String dropdawnField = "//select[@id=\"id_contact\"]";


    @Step("Get contact page")
    public static ContactPage getContactPage() {
        ContactPage contactPage = new ContactPage();
        waitForElementVisible(getElementBy(title));
        return contactPage;
    }

    @Step("Choose customer service value")
    public ContactPage clickSubjectHeadingDropdawn() {
        Select dropdawn = new Select(getElement(dropdawnField));
        dropdawn.selectByVisibleText("Customer service");
        return getContactPage();
    }

    @Step("Choose webmaster value")
    public ContactPage chooseWebmasterValue() {
        Select dropdawn = new Select(getElement(dropdawnField));
        dropdawn.selectByVisibleText("Webmaster");
        return getContactPage();
    }

    @Step("Fill email field")
    public ContactPage fillEmailField(String email) {
        waitForElementClickable(getElementBy(emailField));
        getElement(emailField).sendKeys(email);
        return getContactPage();
    }

    @Step("Clear email field")
    public ContactPage clearEmailField() {
        getElement(emailField).clear();
        return getContactPage();
    }

    @Step("Fill order field")
    public ContactPage fillOrderField(String order) {
        waitForElementClickable(getElementBy(orderField));
        getElement(orderField).sendKeys(order);
        return getContactPage();
    }

    @Step("Clear order field")
    public ContactPage clearOrderField() {
        getElement(orderField).clear();
        return getContactPage();
    }

    @Step("Fill message field")
    public ContactPage fillMessageField(String message) {
        waitForElementClickable(getElementBy(messageField));
        getElement(messageField).sendKeys(message);
        return getContactPage();
    }

    @Step("Clear message field")
    public ContactPage clearMessageField() {
        getElement(messageField).clear();
        return getContactPage();
    }

    @Step("Click send button")
    public ContactPage clickSendButton() {
        waitForElementClickable(getElementBy(sendButton));
        getElement(sendButton).click();
        return getContactPage();
    }

    @Step("Click send button with error")
    public void clickSendButtonError() {
        waitForElementClickable(getElementBy(sendButton));
        getElement(sendButton).click();
    }

    @Step("Check error message")
    public boolean checkErrorMessage() {
        return isElementVisible(getElementBy(errorMessage));
    }

    @Step("Check success message")
    public boolean checkSuccessMessage() {
        return isElementVisible(getElementBy(successMessage));
    }

    @Step("Click home button")
    public HomePage clickHomeButton() {
        getElement(homeButton).click();
        return HomePage.getHomePage();
    }

    @Step("Check customer text")
    public String checkCustomerText() {
        waitForElementVisible(getElementBy(customerText));
        return getElement(customerText).getAttribute("innerText").trim();
    }

    @Step("Check webmaster text")
    public String checkWebmasterText() {
        waitForElementVisible(getElementBy(webmasterText));
        return getElement(webmasterText).getAttribute("innerText").trim();
    }
}
