package SDA.tests.SmokeTest;
import SDA.utility.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PositiveLoginTest extends TestBase {

    @Test
    public void test() {

        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement (By.id ("username")).sendKeys(  "student");
        driver.findElement(By.name("password")).sendKeys("Password123");
        driver.findElement(By.cssSelector("button#submit")).click();

        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals (actualUrl, expectedUrl, "Actual page url is not the same as expected");

        WebElement successMessage = driver.findElement (By. tagName ("strong"));
        String expectedMessage = "Congratulations student. You successfully logged in!";
        String actualMessage = successMessage. getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage),"Actual message does not contain expected message. InActual Message: " + actualMessage + "InExpected Message: " + expectedMessage);

        WebElement logoutButton = driver. findElement (By.linkText ("Log out"));
        Assert.assertTrue ((logoutButton.isDisplayed()), "Log Out button is not visible");

    }
}

