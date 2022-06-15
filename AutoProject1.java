import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

import static io.netty.util.internal.SystemPropertyUtil.contains;


public class AutoProject1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","/Users/halildikmen/Desktop/browserDrivers/chromedriver");
         WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.get("http://qa-duotify.us-east-2.elasticbeanstalk.com/register.php");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Welcome to Duotify!";
        Assert.assertEquals(actualTitle, expectedTitle);

        Thread.sleep(2000);

        driver.findElement(By.id("hideLogin")). click();

        String rand = "";
        char ch = '0';

        for (int i = 0; i<5; i++){
            ch = (char) (97 + (int)(Math.random()*26));
            rand += ch;
        }

        driver.findElement(By.id("username")). sendKeys(rand + Keys.ENTER);

        String rand1 = "";
        char ch1 = '0';

        for (int i = 0; i<5; i++){
            ch1 = (char) (97 + (int)(Math.random()*26));
            rand1 += ch1;
        }

        driver.findElement(By.id("firstName")). sendKeys(rand1 + Keys.ENTER);

        String rand2 = "";
        char ch2 = '0';

        for (int i = 0; i<5; i++){
            ch2 = (char) (97 + (int)(Math.random()*26));
            rand2 += ch2;
        }

        driver.findElement(By.id("lastName")). sendKeys(rand2 + Keys.ENTER);

        String rand3 = "";
        char ch3 = '0';

        for (int i = 0; i<5; i++){
            ch3 = (char) (97 + (int)(Math.random()*26));
            rand3 += ch3;
        }

        driver.findElement(By.id("email")). sendKeys(rand3 + "@gmail.com" + Keys.ENTER);

        driver.findElement(By.id("email2")). sendKeys(rand3 + "@gmail.com" + Keys.ENTER);

        String rand4 = "";
        int ch4 = '0';

        for (int i = 0; i<10; i++){
            ch4 = (int) (97 + (int)(Math.random()*26));
            rand4 += ch4;
        }

        driver.findElement(By.id("password")). sendKeys(rand4 + Keys.ENTER);

        driver.findElement(By.id("password2")). sendKeys(rand4);

        driver.findElement(By.name("registerButton")). click();

        Thread.sleep(2000);

        Assert.assertFalse(contains("http://qa-duotify.us-east-2.elasticbeanstalk.com/browse.php?"), driver.getCurrentUrl());

        Thread.sleep(2000);

        Assert.assertFalse(contains(rand1), driver.findElement(By.id("nameFirstAndLast")).getText());

        Thread.sleep(2000);

        Assert.assertFalse(contains(rand2), driver.findElement(By.id("nameFirstAndLast")).getText());

        Thread.sleep(2000);

        driver.findElement(By.id("nameFirstAndLast")). click();

        Thread.sleep(2000);

        Assert.assertFalse(contains(rand1), driver.findElement(By.tagName("h1")).getText());

        Thread.sleep(2000);

        Assert.assertFalse(contains(rand2), driver.findElement(By.tagName("h1")).getText());

        Thread.sleep(2000);

        driver.findElement(By.id("rafael")). click();

        Thread.sleep(2000);

        Assert.assertFalse(contains(" http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php"), driver.getCurrentUrl());

        driver.findElement(By.id("loginUsername")). sendKeys(rand+ Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("loginPassword")). sendKeys(rand4);

        Thread.sleep(2000);

        driver.findElement(By.name("loginButton")). click();

        Assert.assertFalse(contains(" You Might Also Like"), driver.findElement(By.tagName("h1")).getText());

        Thread.sleep(2000);

        driver.findElement(By.id("nameFirstAndLast")). click();

        driver.findElement(By.id("rafael")). click();

        driver.quit();



    }
}
