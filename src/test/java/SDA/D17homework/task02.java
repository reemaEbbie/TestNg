package SDA.D17homework;
import SDA.utility.ParametrizedBrowserTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class task02 extends ParametrizedBrowserTestBase {



    @Test
    public void testAddingAndArchivingTodos() {
        // Test adding todos
        driver.get("https://vziad3.github.io/todo-app/todo-app.html");
        WebElement todo4 = driver.findElement(By.name("todo-4"));
        todo4.click();
        WebElement todo5 = driver.findElement(By.name("todo-5"));
        todo5.click();

        // Assertion for length of list after adding todos
        int size = driver.findElements(By.xpath("//*[@class = 'done-true']")).size();
        Assert.assertEquals(size, 2);

        // Assertion for presence of added todos
        boolean todo4Present = driver.findElement(By.className("done-true")).isDisplayed();
        boolean todo5Present = driver.findElement(By.className("done-true")).isDisplayed();
        Assert.assertTrue(todo4Present, "Todo4 is not present in the list.");
        Assert.assertTrue(todo5Present, "Todo5 is not present in the list.");

        // Test archiving todos
        WebElement archiveLink = driver.findElement(By.xpath("//a[.='archive']"));
        archiveLink.click();

        // Assertion for length of list after archiving todos
        Assert.assertEquals(driver.findElements(By.xpath("//span[@class=\"done-true\"]")).size(), 0);
    }
}