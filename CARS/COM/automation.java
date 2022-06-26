package CARS.COM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class automation {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/halildikmen/Desktop/browserDrivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));

        driver.get("https://www.cars.com/");

        WebElement newUsed = driver.findElement(By.id("make-model-search-stocktype"));

        Select select = new Select(newUsed);

        WebElement firstSelectedOption = select.getFirstSelectedOption();

        Assert.assertEquals(firstSelectedOption.getText(), "New & used cars");

        Thread.sleep(2000);

        List<WebElement> options = select.getOptions();

        List<String> newUsed1 = new ArrayList<>();

        for (WebElement option : options) {
            newUsed1.add(option.getText());

        }

        select.selectByValue("used");

        new Select(driver.findElement(By.id("makes"))).selectByVisibleText("Tesla");

        Select select1 = new Select(driver.findElement(By.id("models")));

        List<WebElement> options1 = select1.getOptions();

        List<String> TeslaModels = new ArrayList<>();

        for (WebElement webElement : options1) {
            TeslaModels.add(webElement.getText());

        }

        select1.selectByValue("tesla-model_s");

        new Select(driver.findElement(By.id("make-model-max-price"))).selectByValue("100000");

        new Select(driver.findElement(By.id("make-model-maximum-distance"))).selectByValue("50");

        Thread.sleep(2000);

        driver.findElement(By.id("make-model-zip")).clear();

        driver.findElement(By.id("make-model-zip")).sendKeys("22182" + Keys.ENTER);

        Thread.sleep(2000);

        List<WebElement> elements = driver.findElements(By.xpath("// a[@class = 'vehicle-card-link js-gallery-click-link']"));

        Assert.assertEquals(19, elements.size());

        Thread.sleep(2000);

        WebElement element1 = driver.findElement(By.id("sort-dropdown"));
        Select selection = new Select(element1);
        selection.selectByValue("list_price");

        Thread.sleep(2000);
        List<WebElement> elements1 = driver.findElements(By.xpath("//span[@class='primary-price']"));

        double priceSelected = 0.0;
        for (WebElement count : elements1) {
            Assert.assertTrue(Double.parseDouble(count.getText().replaceAll("[$,]", " ")) >= priceSelected);
            priceSelected = Double.parseDouble(count.getText().replaceAll("[$,]", " "));

        }

        selection.selectByValue("mileage_desc");

        Thread.sleep(2000);
        List<WebElement> elements2 = driver.findElements(By.xpath("//div[@class='mileage'][contains(text(),' mi.')]"));

        long milesSelected = 1000000000;
        for (WebElement webElement : elements2) {
            Assert.assertTrue(Long.parseLong(webElement.getText().replaceAll("[$,mi. ]", "")) < milesSelected);
            milesSelected = (Long.parseLong(webElement.getText().replaceAll("[$,mi. ]", "")));
//            System.out.println(milesSelected);
        }

        selection.selectByValue("distance");

        Thread.sleep(2000);
        List<WebElement> elements3 = driver.findElements(By.xpath("//div[@data-qa='miles-from-user']"));

        int zipSelected = 0;
        for (WebElement webElement : elements3) {
            Assert.assertTrue(Integer.parseInt(webElement.getText().substring(0, 4).replaceAll("[$,mi. ]", "")) >= zipSelected);
            zipSelected = (Integer.parseInt(webElement.getText().substring(0, 4).replaceAll("[$,mi. ]", "")));
//            System.out.println(zipSelected);
        }

        selection.selectByValue("year");
//
        Thread.sleep(2000);
        List<WebElement> elements4 = driver.findElements(By.xpath("//h2[@class='title'] "));

        int yearSelected = 0;
        for (WebElement webElement : elements4) {

            Assert.assertTrue(Integer.parseInt(webElement.getText().substring(0, 5).replaceAll("[$,mi. ]", "")) >= yearSelected);
            yearSelected = (Integer.parseInt(webElement.getText().substring(0, 5).replaceAll("[$,mi. ]", "")));
//            System.out.println(yearSelected);


        }
        driver.close();
    }
}