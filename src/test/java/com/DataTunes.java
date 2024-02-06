package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class DataTunes extends BasicTest {


    @Test()
    public void loginTest() throws Exception {
        // Launch website
        String url = "http://52.199.154.24/account";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}
