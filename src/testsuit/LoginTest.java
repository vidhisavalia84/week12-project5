package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void browserSetup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigatedToLoginPageSuccessfully() {
        clickOnElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']/a"));
        String expectedMessage = "Welcome Back!";
        String actualMessage = getTextFromElement(By.xpath("//h1[@class='page__heading']"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        clickOnElement(By.xpath("//li[@class=\"header__nav-item header__nav-sign-in\"]/a"));
        sendTextToElement(By.id("user[email]"), "Admin123@gmail.com");
        sendTextToElement(By.id("user[password]"), "abc123");
        clickOnElement(By.xpath("//input[@type='submit']"));
        String expectedMessage = "Invalid email or password.";
        String actualMessage = getTextFromElement(By.xpath("//li[@class='form-error__list-item']"));
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @After
    public void tearDown() {
        //  closeBrowser();
    }
}
