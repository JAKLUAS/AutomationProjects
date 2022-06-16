
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class facebookTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","/Users/halildikmen/Desktop/browserDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
//        driver.findElement(By.name("email")).sendKeys("halil.dkmn@gmail.com"+ Keys.ENTER);
//        driver.findElement(By.name("pass")).sendKeys("kdhjhsajd"+ Keys.ENTER);
//
//        String expectedErrorText = "The password you’ve entered is incorrect. Forgot Password?";
//        Assert.assertTrue(driver.getPageSource().contains(expectedErrorText));

        Point location= driver.findElement(By.xpath("//img[@alt='Facebook']")).getLocation();
        System.out.println(location);
        Dimension size = driver.findElement(By.xpath("//img[@alt='Facebook']")).getSize();
        System.out.println(size);

}}
