package com.framework.tests.comparison;

import com.framework.pageObject.interaction.ComparisonList;
import com.framework.pageObject.navigation.Header;
import com.framework.pageObject.navigation.Navigation;
import com.framework.pageObject.items.SSDNotebooks;
import com.framework.tests.ProdBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareSSDLaptop extends ProdBaseTest {

    private int allParams;
    private int onlyDifferentParams;

    @Test
    public void compareSSDNotebooks() throws Exception {

        Navigation.using(driver)
                .openNotebooksCategory()
                .openSSDNotebooksPage();

        SSDNotebooks.using(driver)
                .selectComparableItem();

        Header.using(driver)
                .openComparePage();

        ComparisonList cpm = new ComparisonList(driver);
        cpm.openCompareItemList();

        allParams = cpm.getCountFromAllParam();
        cpm.openDifferencesOnlyList();
        onlyDifferentParams = cpm.getCountFromOnlyDifferentParam();

        Assert.assertEquals(allParams, onlyDifferentParams,
                "Test Failed");
    }
}
