import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public abstract class autoProject2 {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver","/Users/halildikmen/Desktop/browserDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.name("ctl00$MainContent$username")). sendKeys("Tester" + Keys.ENTER);
        driver.findElement(By.name("ctl00$MainContent$password")). sendKeys("test" );
        driver.findElement(By.name("ctl00$MainContent$login_button")).click();

        Thread.sleep(2000);
        driver.findElement(new By.ByLinkText("Order")).click();
        Thread.sleep(2000);
        int quantity = 1 + (int) (Math.random() * 101);
        String strQuantity = String.valueOf(quantity);
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(strQuantity);
        driver.findElement(By.className("btn_dark")).click();
        Thread.sleep(2000);

        double total = Double.parseDouble(driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal")).getAttribute("value"));

        Thread.sleep(2000);

        if (quantity >= 10) {
            Assert.assertTrue(total == (quantity * 100 * 0.92));
        } else {
            Assert.assertTrue(total == (quantity * 100));
        }

        Thread.sleep(2000);
        List<String[]> customers = autoProject21.read("DATA.csv");
        String[] newCustomer = customers.get(1 + (int)Math.random()*customers.size());

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(newCustomer[0] + " " + newCustomer[1] + Keys.ENTER);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(newCustomer[3] + " " + newCustomer[2] + Keys.ENTER);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(newCustomer[4] + Keys.ENTER);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(newCustomer[5] + Keys.ENTER);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(newCustomer[6] + Keys.ENTER);
        Thread.sleep(2000);
        long AmExcard = (long) ((long) 300000000000000l + (Math.random()*99999999999999l));
        long visacard = (long) ((long) 4000000000000000l + (Math.random()*999999999999999l));
        long mastcard = (long) ((long) 5000000000000000l + (Math.random()*999999999999999l));

        String strAmExcard = String.valueOf(AmExcard);
        String strvisacard = String.valueOf(visacard);
        String strmastercard = String.valueOf(mastcard);

        int cardType = randNumber(0,3);

        if (cardType == 0){
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys( strvisacard + Keys.ENTER);
        }else if(cardType == 1){
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys( strmastercard + Keys.ENTER);
        }else if (cardType == 2){
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys( strAmExcard + Keys.ENTER);
        }
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys( "12/24" + Keys.ENTER);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

        String actual = driver.findElement(By.tagName("strong")).getText();
        String expected = "New order has been successfully added.";
        Assert.assertEquals(actual, expected);
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_logout")).click();

    }

    public static int randNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}


