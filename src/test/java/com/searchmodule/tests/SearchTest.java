package com.searchmodule.tests;

import com.searchmodule.pages.SearchPage;
import com.tests.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseClass {

    @Test
    @Parameters({"Keyword"})
    public void search(String keyword){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.doSearch(keyword);
        searchPage.goToVideos();
        int count = searchPage.allVideos();
        Assert.assertTrue(count > 0);
    }

}
