package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.ContactPage;

public class ContactPageHelper extends AbstractHelper{
   private ContactPage contactPage = new ContactPage();

   public ContactPageHelper checkMandatoryFieldEmail(String order,String message){
       contactPage.clickSubjectHeadingDropdawn();
       contactPage.fillOrderField(order);
       contactPage.fillMessageField(message);
       contactPage.clickSendButtonError();
       return this;
   }

    public ContactPageHelper checkMandatoryFieldOrder(String email,String message){
        contactPage.clickSubjectHeadingDropdawn();
        contactPage.fillEmailField(email);
        contactPage.fillMessageField(message);
        contactPage.clickSendButtonError();
        return this;
    }

    public ContactPageHelper checkMandatoryFieldMessage(String email,String order){
        contactPage.clickSubjectHeadingDropdawn();
        contactPage.fillEmailField(email);
        contactPage.fillOrderField(order);
        contactPage.clickSendButtonError();
        return this;
    }

    public ContactPageHelper successSendMessage(String email,String order,String message){
        contactPage.clickSubjectHeadingDropdawn();
        contactPage.fillEmailField(email);
        contactPage.fillOrderField(order);
        contactPage.fillMessageField(message);
        contactPage.clickSendButton();
        return this;
    }
    public ContactPageHelper chooseCustomerValue(){
        contactPage.clickSubjectHeadingDropdawn();
        return this;
    }

    public ContactPageHelper chooseWebmasterValue(){
        contactPage.chooseWebmasterValue();
        return this;
    }


    public boolean checkSuccessMessage(){
        boolean result = contactPage.checkSuccessMessage();
        clickHomeButton();
        return result;
    }

   public boolean checkErrorMessageMandatoryEmail(){
       boolean result = contactPage.checkErrorMessage();
       contactPage.clearOrderField();
       contactPage.clearMessageField();
       return result;
   }

    public boolean checkMessageOptionalOrder(){
        boolean result = contactPage.checkSuccessMessage();
        clickHomeButton();
        return result;
    }

    public boolean checkErrorMessageMandatoryMessage(){
        boolean result = contactPage.checkErrorMessage();
        contactPage.clearEmailField();
        contactPage.clearOrderField();
        return result;
    }

    public HomePageHelper clickHomeButton(){
       contactPage.clickHomeButton();
       return new  HomePageHelper();
    }

    public String checkVisibleCustomerText(){
       return contactPage.checkCustomerText();
    }

    public String checkVisibleWebmasterText(){
        return contactPage.checkWebmasterText();
    }
}
