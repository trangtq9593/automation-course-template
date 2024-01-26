package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public abstract class BasicTestForBai19b {
    
    public static final Logger logger = LogManager.getLogger();
    protected static WebDriver driver;
    protected static ExcelUtils excel = new ExcelUtils("src\\test\\resources\\", "TestLoginFile.xlsx");
    // private String driverPath;

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void preCondition(String BaseURL) {
        // Chromedriver path
        // driverPath = "src/main/resources/WebDrivers/chromedriver.exe";
        // ChromeOptions options = new ChromeOptions();
        // System.setProperty("webdriver.chrome.driver", driverPath);
        // driver = new ChromeDriver(options);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Maximize the browser
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(BaseURL);
    }

    @DataProvider(name = "testLogin")
    public Object[][] TestDataFeed() {
        ExcelUtils excel = new ExcelUtils("src\\test\\resources\\", "TestLoginFile.xlsx");
        //Create object array 3 rows, 2 columns
        int total_row = excel.getRowCount();
        Object[][] testData = new Object[total_row-1][3];

        //Data Test
        for (int i = 1; i < total_row; i++) {
            testData[i][0] = excel.getData(i, 0);
            testData[i][1] = excel.getData(i, 1);
            testData[i][2] = excel.getData(i, 2);
        }
        return testData;
    }
    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        driver.quit();
    }
    @AfterSuite
    public void exportResult() throws Exception {
        excel.saveNewFile("src\\test\\resources\\", "TestLoginFile.xlsx");
    }
}