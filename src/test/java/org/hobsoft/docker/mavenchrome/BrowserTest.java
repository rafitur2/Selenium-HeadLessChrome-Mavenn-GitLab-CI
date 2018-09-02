
package org.hobsoft.docker.mavenchrome;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hobsoft.docker.mavenchrome.BrowserTestParent;

public class BrowserTest extends BrowserTestParent {

    private static WebDriver driver;
    

    @BeforeClass
    public static void setupClass() {
    	System.setProperty("wdm.proxy", "http://genproxy.corp.amdocs.com:8080");
    	ChromeDriverManager.getInstance().setup();
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);

    }

    @Before
    public void setupTest() {

    }


    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
        // Your test code here
    	driver.get("http://www.google.com");
    }

}