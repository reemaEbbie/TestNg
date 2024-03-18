package SDA.tests.SmokeTest;

import SDA.utility.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class NegativeLoginTest extends TestBase {

    @Test(dataProvider = "loginData")
    public void test(String username, String password, String expectedErrorMessage) {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button#submit")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 represents the timeout in seconds
        WebElement actualErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='error']")));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualErrorMessage.isDisplayed());
        softAssert.assertEquals(actualErrorMessage.getText(), expectedErrorMessage);

        softAssert.assertAll();
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"student", "incorrectPassword", "Your password is invalid!"},
        };
    }
}