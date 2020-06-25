package project.by.stormnet.functional.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import project.by.stormnet.functional.entities.helpers.HomeHelper;

public class LamodaTest {
    private HomeHelper homeHelper = new HomeHelper();
    private String searchKey = "jeans";


    @Test
    public void performSearch(){
        int countPerPage = homeHelper.search(searchKey).getSearchResultCountPerPage();
        Assert.assertTrue(countPerPage > 0, "No results were found");
    }

    @Test
    public void performSearchFailes(){
        int countPerPage = homeHelper.search(searchKey).getSearchResultCountPerPage();
        Assert.assertTrue(countPerPage < 0, "No results were found");
    }

    @Test
    public void performSearchSkip(){
        int countPerPage = homeHelper.search(searchKey).getSearchResultCountPerPage();
        Assert.assertTrue(countPerPage > 0, "No results were found");
        throw new SkipException("Skipping this exception");
    }

    @AfterClass
    public void tearDown(){
        homeHelper.quit();
    }
}
