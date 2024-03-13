package SDA.D15homework;

import SDA.utility.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class D15HW03 extends TestBase {
    @Test
    public void negativePasswordTestWithSoftAssertion() {
        SoftAssert softAssert = new SoftAssert();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Step 2: Type the username and password
        String username = "student";
        String password = "incorrectPassword123";
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        // Step 3: Click the submit button
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Step 4: Verify the error message
        WebElement errorMessage = driver.findElement(By.id("error"));
        softAssert.assertTrue(errorMessage.isDisplayed());

        softAssert.assertAll();
    }
}