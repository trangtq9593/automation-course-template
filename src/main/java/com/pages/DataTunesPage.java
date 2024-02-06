package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DataTunesPage extends BasePage {
    protected WebDriver driver;


    public DataTunesPage(WebDriver driver) {
        super(driver);
    }

    By createBtn = By.xpath("//*[@class=\"mb-2 mr-2 btn-icon btn btn-primary color-white\"]");
    By companyName = By.xpath("//input[@name=\"name\"]");
    By aproachable = By.id("is_approached");
    By saleStatus = By.id("sale_status_id");
    By confirmBtn = By.xpath("//*[@class=\"mb-2 mr-2 btn-icon btn btn-primary color-white\" and @value=\"確認する\"]");

    public void clickCreateBtn() {
        waitAndFind(createBtn).click();
    }

    public void inputCPNName(String value) {
        waitAndFind(companyName);
    }

    public void clickConfirmBtn() {
        waitAndFind(confirmBtn).click();
    }


}