package project.by.stormnet.functional.entities.helpers;

import project.by.stormnet.functional.entities.pages.AbstractPage;

public class AbstractHelper {

    AbstractPage abstractPage;

    public void openBrowser() {
        abstractPage = new AbstractPage();
        abstractPage.openBrowser();
    }

    public void open() {
        abstractPage.getDriver();
        abstractPage.openUrl(abstractPage.baseUrl);
    }


    public void quit() {
        abstractPage.getDriver().quit();

    }
}
