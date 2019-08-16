package com.learn.app.Login.guru99Headless;

import com.learn.app.guru99.BaseClass.TestBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

//public class loginGuru99Headless extends TestBaseClass {
public class loginGuru99Headless extends TestBaseClass{

    @Test
    public void headlessLoginChrome() {
//        Below code will get called from TestBase class
//        Selected Driver is Headless
        /*System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setHeadless(true);
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);*/
        driver.get("http://demo.guru99.com/V4/index.php");
        System.out.println("Latest Title: " + driver.getTitle());
    }

    /*@Test
    public void headlessLoginFirefox() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.setHeadless(true);
        firefoxOptions.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        driver.get("http://demo.guru99.com/v4/index.php");
        System.out.println("Firefox Browser app Title : " + driver.getTitle());
    }*/
}
