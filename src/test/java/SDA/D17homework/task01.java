package SDA.D17homework;
import SDA.utility.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/*
Open the site: http://opencart.abstracta.us/index.php?route=account/login
Login with that credentials
Email: clarusway@gmail.com
Password: 123456789
*/

public class task01 extends TestBase {

    By emailId = By.id("input-email");
    By passwordId = By.id("input-password");
    By buttonCssSelector1 = By.cssSelector("input[type='submit']");
    By searchBarName = By.name("search");
    By buttonCssSelector2 = By.cssSelector("button[type='button'][class='btn btn-default btn-lg']");



    @Test(dataProvider = "searchQueries")
    public void searchProduct(String searchQuery) {
        //Open the site: http://opencart.abstracta.us/index.php?route=account/login
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

        // Login with that credentials
        driver.findElement(emailId).sendKeys("clarusway@gmail.com");
        driver.findElement(passwordId).sendKeys("123456789");
        driver.findElement(buttonCssSelector1).click();

        // Search for the product
        driver.findElement(searchBarName).sendKeys(searchQuery);
        driver.findElement(buttonCssSelector2).click();

        // Add verification steps as needed
    }

    @DataProvider(name = "searchQueries")
    public Object[][] searchQueriesProvider() {
        return new Object[][]{
                {"Mac"},
                {"iPad"},
                {"Samsung"}
        };
    }
}