package org.hobsoft.docker.mavenchrome;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Parent class for browser based tests.
 *
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 1.4.1
 */
public abstract class BrowserTestParent {

    protected WebDriver driver;

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() {
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.get("https://bonigarcia.github.io/selenium-jupiter/");
        assertThat(driver.getTitle(),
                containsString("JUnit 5 extension for Selenium"));
    }

}