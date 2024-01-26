package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTestForBai19b;

public class Bai19b extends BasicTestForBai19b {
    @Test(dataProvider = "testLogin")
    public void loginTest(String TCID, String username, String pwd) throws Exception {
        try {
        //Get element
        WebElement account = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[contains(text(), 'Log in ')]"));

        account.clear();
        account.sendKeys(username);
        password.clear();
        password.sendKeys(pwd);
        btnLogin.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

        if (driver.getCurrentUrl().contains("dashboard")) {
            excel.setCellData("Pass", TCID, 3);
        }
    }
    catch (Exception e) {
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        excel.setCellData("Fail", TCID, 3);
    }

    }
}
