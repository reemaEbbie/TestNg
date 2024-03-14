package SDA.D16homework;
import SDA.utility.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class task02 extends TestBase {

    @Test
    @Parameters({"username", "password"})
    public void testPositiveLogin(String username, String password) {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();

        String loggedInUrl = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertTrue(driver.getCurrentUrl().contains(loggedInUrl));

        WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(), 'Congratulations') or contains(text(), 'successfully logged in')]"));
        Assert.assertTrue(successMessage.isDisplayed());

        WebElement logoutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logoutButton.isDisplayed());
    }
}