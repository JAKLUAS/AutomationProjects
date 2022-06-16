import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class diceWarmUpTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","/Users/halildikmen/Desktop/browserDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.dice.com/");

        driver.findElement(By.id("typeaheadInput")).sendKeys("SDET");
        driver.findElement(By.id("google-location-search")).sendKeys("Washington, DC, USA"+ Keys.ENTER);
        driver.findElement(By.id("submitSearch-button")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//a[@data-cy='card-title-link']"));
        Assert.assertEquals(20,elements.size());

        for(WebElement element:elements){
            Assert.assertTrue(element.getText().contains(("SDET")));
        }
        elements.get(elements.size()-1).click();
        Assert.assertTrue(driver.getTitle().contains(("SDET")));
        driver.quit();






}}
