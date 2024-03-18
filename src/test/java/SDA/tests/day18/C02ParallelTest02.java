package SDA.tests.day18;
import SDA.utility.TestBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class C02ParallelTest02 extends TestBase {

    @Test
    public void test01(){
        new ChromeDriver().get("https://www.clarusway.com");

    }
    @Test
    public void test02(){
        new ChromeDriver().get("https://www.ebay.com");
    }
    @Test
    public void test03(){
        new ChromeDriver().get("https://www.linkedin.com");
    }
    @Test
    public void test04(){
        new ChromeDriver().get("https://www.google.com");
    }
}