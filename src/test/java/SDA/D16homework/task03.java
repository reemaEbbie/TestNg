package SDA.D16homework;
import SDA.utility.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class task03 extends TestBase {

    @Test
    @Parameters({"username", "password"})
    public void testNegativeLogin(String username, String password) {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertFalse(driver.findElements(By.id("error")).isEmpty());

    }
}