
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class facebookTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","/Users/halildikmen/Desktop/browserDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.name("email")).sendKeys("halil.dkmn@gmail.com"+ Keys.ENTER);
        driver.findElement(By.name("pass")).sendKeys("kdhjhsajd"+ Keys.ENTER);

        String expectedErrorText = "The password you’ve entered is incorrect. Forgot Password?";
        Assert.assertTrue(driver.getPageSource().contains(expectedErrorText));



}}
