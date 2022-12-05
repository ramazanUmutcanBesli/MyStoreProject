package com.mystore.base;
import com.mystore.actiondriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class BaseClass {
    public static Properties prop;
    public static WebDriver driver;
    public static Action action;
    @BeforeTest
    public void loadConfig() {
        try {
            prop =new Properties();
            System.out.println("super constructor invoked");
            FileInputStream ip =new FileInputStream(
                    System.getProperty("user.dir")+ "\\Configuration\\config.properties");
            prop.load(ip);
            System.out.println("driver"+ driver);

        } catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void launchApp(){
        WebDriverManager.chromedriver().setup();
        String browserName= prop.getProperty("browser");
        if (browserName.contains("Chrome")){
            driver=new ChromeDriver();
        } else if (browserName.contains("FireFox")) {
            driver=new FirefoxDriver();
        } else if (browserName.contains("IE")) {
            driver=new InternetExplorerDriver();
        }
        action.implicitWait(driver,10);
        action.pageLoadTimeOut(driver,30);
        driver.get(prop.getProperty("url"));
    }
}
