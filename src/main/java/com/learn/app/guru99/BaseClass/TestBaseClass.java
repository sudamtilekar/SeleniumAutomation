package com.learn.app.guru99.BaseClass;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBaseClass {

    public static WebDriver driver;
    public static Properties properties;
    public static Logger logger;

    public TestBaseClass() {
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/configuration.properties");
            properties = new Properties();
            try {
                properties.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @BeforeClass
    public void setUp() {
//        Chrome Browser call
        if (properties.getProperty("browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
//            Headless Chrome Browser call
        } else if (properties.getProperty("browser").equals("chromeHeadless")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.setHeadless(true);
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
//            driver = new ChromeDriver();
        }
//      Firefox browser call
        else if (properties.getProperty("browser").equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (properties.getProperty("browser").equals("remotechrome")) {
            DesiredCapabilities capability = DesiredCapabilities.chrome();
            try {
                driver = new RemoteWebDriver(new URL("http://10.144.40.70:5555/wd/hub"), capability);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        logger = Logger.getLogger("ebanking");
        PropertyConfigurator.configure("log4j.properties");


        driver.manage().window().maximize();
        logger.info("Browser Maximized");
        driver.get(properties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
//        driver.quit();
    }
}
